package br.com.nthing.user.client;

import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.QueryParam;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

public class ClientResource {

    @Inject
    ClientService clientService;


    @GET
    @Path("findById")
    @Produces(MediaType.APPLICATION_JSON)
    @Transactional
    public Response findById(@QueryParam("id") Long id) {
        Client client = clientService.findById(id);
        if (client != null) {
            return Response.status(Response.Status.OK).entity(client).build();
        }

        return Response.status(Response.Status.NOT_FOUND).build();
    }



}
