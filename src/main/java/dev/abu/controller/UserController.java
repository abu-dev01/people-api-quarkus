package dev.abu.controller;

import dev.abu.controller.domain.User;
import dev.abu.controller.service.UserService;
import jakarta.transaction.Transactional;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.Response;

import java.util.UUID;

@Path("/users")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService){
        this.userService = userService;
    }

    @POST
    @Transactional
    public Response createUser(User user){
        return Response.status(
                Response.Status.CREATED)
                .entity(userService.createUser(user))
                .build();
    }

    @GET
    public Response findAllUsers(@QueryParam("page") @DefaultValue("0") Integer page,
                                 @QueryParam("pageSize") @DefaultValue("2") Integer pageSize){
        return Response.ok(userService.findAllUsers(page, pageSize)).build();
    }

    @GET
    @Path("/{id}")
    public Response findUserById(@PathParam("id") UUID id){
        return Response.ok(userService.findUserById(id)).build();
    }

    @PUT
    @Path("/{id}")
    @Transactional
    public Response updateUser(@PathParam("id") UUID id, User user){
        return Response.ok(userService.updateUser(id, user)).build();
    }
}
