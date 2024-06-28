package br.com.nthing.item;

import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.DELETE;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.PUT;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.QueryParam;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

import java.util.List;

@Path("exerciseitems")
public class ExerciseItemResource {

    @Inject
    ExerciseItemService exerciseItemService;

    @GET
    @Path("list")
    @Produces(MediaType.APPLICATION_JSON)
    @Transactional
    public Response get() {
        List<ExerciseItem> exerciseItems = exerciseItemService.listAll();
        return Response.ok(exerciseItems).build();
    }

    @GET
    @Path("findid")
    @Produces(MediaType.APPLICATION_JSON)
    @Transactional
    public Response findById(@QueryParam("id") Long id) {
        ExerciseItem exerciseItem = exerciseItemService.findById(id);
        if (exerciseItem != null) {
            return Response.status(Response.Status.OK).entity(exerciseItem).build();
        }
        return Response.status(Response.Status.NOT_FOUND).build();

    }


    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    @Transactional
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
    @Transactional
    public Response updateExerciseItem(@QueryParam("idSequence") Long idSequence, ExerciseItem exerciseItem) {
        exerciseItem.setIdSequence(idSequence);
        ExerciseItem exItem = exerciseItemService.findById(idSequence);
        if (exItem == null) {
            return Response.status(Response.Status.NOT_FOUND).entity("Exercício não encontrado").build();
        }
        exerciseItemService.updateItem(exerciseItem);
        return Response.status(Response.Status.OK).entity(exerciseItem).build();
    }

    @DELETE
    @Path("delete")
    @Transactional
    public Response deleteExerciseItem(@QueryParam("idSequence") Long idSequence) {
        exerciseItemService.deleteItem(idSequence);
        return Response.status(Response.Status.NO_CONTENT).build();
    }

}
