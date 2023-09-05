package ch.zli.m223.controller;

import java.util.List;

import javax.annotation.security.PermitAll;
import javax.annotation.security.RolesAllowed;
// import javax.annotation.security.RolesAllowed;
import javax.inject.Inject;
import javax.validation.Valid;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.eclipse.microprofile.openapi.annotations.Operation;
import org.eclipse.microprofile.openapi.annotations.tags.Tag;

import ch.zli.m223.model.User;
import ch.zli.m223.service.UserService;

@Path("/users")
@RolesAllowed({ "User", "Admin" })
@Tag(name = "Users", description = "Handling of Users")
public class UserController {

    @Inject
    UserService userService;

    @GET
    @RolesAllowed("Admin")
    @Produces(MediaType.APPLICATION_JSON)
    @Operation(summary = "Index all users.", description = "Returns a list of all users.")
    public List<User> index() {
        return userService.findAll();
    }

    @Path("/{id}")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Operation(summary = "Index User by ID.", description = "Returns a single User by its id.")
    public User get(@PathParam("id") Long id) {
        return userService.getUser(id);
    }

    @POST
    @PermitAll
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    @Operation(summary = "Creates a new User.", description = "Creates a new User and returns the newly added User.")
    public User create(@Valid User user) {
        return userService.createUser(user);
    }

    @Path("/delete/{id}")
    @DELETE
    @Operation(summary = "Deletes a user.", description = "Deletes a user by its id.")
    public void delete(@PathParam("id") Long id) {
        userService.deleteUser(id);
    }

    @Path("/put/{id}")
    @PUT
    @Operation(summary = "Updates a user.", description = "Updates a user by its id.")
    public User update(@PathParam("id") Long id, @Valid User user) {
        return userService.updateUser(id, user);
    }

}
