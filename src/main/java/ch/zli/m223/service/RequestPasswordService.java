package ch.zli.m223.service;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;

@ApplicationScoped
public class RequestPasswordService {
    @Inject
    UserService userService;

    public String createRequest(String email) {
        return userService.findByEmail(email).get().getPassword();
    }

}
