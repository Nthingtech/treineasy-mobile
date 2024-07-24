package br.com.nthing.user.client;

import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.DELETE;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.PUT;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.QueryParam;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

import java.util.List;

@Path("clients")
public class ClientResource {

    @Inject
    ClientService clientService;


    @GET
    @Path("findById")
    @Produces(MediaType.APPLICATION_JSON)
    @Transactional
    public Response findById(@QueryParam("id") Long id) { //TODO TEST @PathParam
        ClientDTO clientDTO = clientService.findById(id);
        if (clientDTO != null) {
            return Response.status(Response.Status.OK).entity(clientDTO).build();
        }

        return Response.status(Response.Status.NOT_FOUND).build();
    }

    @GET
    @Path("list")
    @Produces(MediaType.APPLICATION_JSON)
    @Transactional
    public Response listClient() {
        List<ClientDTO> clientsDTO = clientService.listAll();
        return Response.status(Response.Status.OK).entity(clientsDTO).build();
    }

    @GET
    @Path("name/{keyClient}")
    @Produces(MediaType.APPLICATION_JSON)
    @Transactional
    public Response findClientByName(@PathParam("keyClient") String keyClient) {
        List<ClientDTO> clientsDTO = clientService.searchByKeywordClient(keyClient); //todo
        if (!clientsDTO.isEmpty()) {
            return Response.status(Response.Status.OK).entity(clientsDTO).build();
        }
        return Response.status(Response.Status.NOT_FOUND).build();
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    @Transactional
    @Path("create")
    public Response createClient(ClientDTO clientDTO){
        ClientDTO createClientDto = clientService.createClient(clientDTO);
        return Response.status(Response.Status.CREATED).entity(createClientDto).build();
    }

    @PUT
    @Path("update")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    @Transactional
    public Response updateClient(@QueryParam("id") Long id, ClientDTO clientDTO) {
        ClientDTO foundClientDto = clientService.findById(id);

        clientService.updateClient(clientDTO);
        return Response.status(Response.Status.OK).entity(clientDTO).build();
    }

    @DELETE
    @Transactional
    @Path("delete")
    public Response deleteClient(@QueryParam("id") Long id) {
        clientService.deleteClient(id);
        return Response.status(Response.Status.NO_CONTENT).build();
    }

}
