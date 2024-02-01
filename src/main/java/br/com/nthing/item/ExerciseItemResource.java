package br.com.nthing.item;

import jakarta.inject.Inject;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.DELETE;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.PUT;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.QueryParam;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

@Path("exerciseitem")
public class ExerciseItemResource {

    @Inject
    ExerciseItemService exerciseItemService;

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response insertExerciseItem(ExerciseItem exerciseItem) {
        ExerciseItem item = exerciseItemService.insertItem(exerciseItem);
        if (item != null) {
            return Response.status(Response.Status.CREATED).entity(exerciseItem).build();
        }
        return Response.status(Response.Status.BAD_REQUEST).build();
    }

    @PUT
    @Path("update")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response updateExerciseItem(@QueryParam("idSequence") Long idSequence, ExerciseItem exerciseItem) {
        exerciseItem.setIdSequence(idSequence);
        ExerciseItem exItem = exerciseItemService.updateItem(exerciseItem);
        if (exItem != null) {
            return Response.status(Response.Status.OK).build();
        }
        return Response.status(Response.Status.NOT_FOUND).entity("Exercícios não encontrado").build();
    }

    @DELETE
    @Path("delete")
    public Response deleteExerciseItem(@QueryParam("idSequence")Long idSequence) {
        exerciseItemService.deleteItem(idSequence);
        return Response.status(Response.Status.NO_CONTENT).build();
    }
}
