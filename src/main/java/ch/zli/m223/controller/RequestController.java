package ch.zli.m223.controller;

import javax.annotation.security.PermitAll;
// import javax.annotation.security.PermitAll;
import javax.inject.Inject;
import javax.validation.Valid;
import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.eclipse.microprofile.openapi.annotations.Operation;
import org.eclipse.microprofile.openapi.annotations.tags.Tag;

import ch.zli.m223.service.RequestPasswordService;

@Path("/requestPassword")
@PermitAll
@Tag(name = "Requests password", description = "Handles Requests of users who forgot their passwords.")
public class RequestController {

    @Inject
    RequestPasswordService requestPasswordService;

    @POST
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    @Operation(summary = "Creates a new Request.", description = "Creates a new request and returns the newly added request.")
    public String create(@Valid String email) {
        return requestPasswordService.createRequest(email);
    }

}
