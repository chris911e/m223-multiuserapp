package ch.zli.m223.controller;

import java.util.List;

// import javax.annotation.security.PermitAll;
import javax.annotation.security.RolesAllowed;
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

import ch.zli.m223.model.Booking;
import ch.zli.m223.service.BookingService;

@Path("/booking")
@RolesAllowed({ "User", "Admin" })
@Tag(name = "Booking", description = "Handling of booking")
public class BookingController {

    @Inject
    BookingService bookingService;

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Operation(summary = "Index all booking.", description = "Returns a list of all booking.")
    public List<Booking> index() {
        return bookingService.findAll();
    }

    @Path("/status/{id}")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Operation(summary = "Index booking by ID.", description = "Returns a single booking by its id.")
    public Booking get(@PathParam("id") Long id) {
        return bookingService.getBooking(id);
    }

    @POST
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    @Operation(summary = "Creates a new booking.", description = "Creates a new boking and returns the newly added booking.")
    public Booking create(@Valid Booking booking) {
        return bookingService.createBooking(booking);
    }

    @Path("/delete/{id}")
    @DELETE
    @Operation(summary = "Deletes a booking.", description = "Deletes a booking by its id.")
    public void delete(@PathParam("id") Long id) {
        bookingService.deleteBooking(id);

    }

    @Path("/put/{id}")
    @PUT
    @Operation(summary = "Updates a booking.", description = "Updates a booking by its id.")
    public Booking update(@PathParam("id") Long id, @Valid Booking entry) {
        return bookingService.updateBooking(id, entry);
    }

}
