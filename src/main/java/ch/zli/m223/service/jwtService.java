package ch.zli.m223.service;

import java.time.Duration;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Optional;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.ws.rs.core.NewCookie;
import javax.ws.rs.core.Response;

import ch.zli.m223.model.User;
import io.smallrye.jwt.build.Jwt;

@ApplicationScoped
public class jwtService {

  @Inject
  UserService userService;

  public Response generateJWT(User user) {
    Optional<User> info = userService.findByEmail(user.getE_mail());

    try {
      if (info.isPresent() && info.get().getPassword().equals(user.getPassword())) {
        String token = Jwt
            .issuer("https://m223_multiuserapp.example.com")
            .upn(user.getE_mail())
            .groups(new HashSet<>(Arrays.asList("User", "Admin", "Banned")))
            .expiresIn(Duration.ofHours(1))
            .sign();
        return Response
            .ok(info.get())
            .cookie(new NewCookie("m223_multiuserapp", token))
            .header("Authorization", "Bearer " + token)
            .build();
      }
    } catch (Exception e) {
      System.err.println(e);
    }

    return Response.status(Response.Status.FORBIDDEN).build();
    // if condition output true but still doesnt build token
  }
}
