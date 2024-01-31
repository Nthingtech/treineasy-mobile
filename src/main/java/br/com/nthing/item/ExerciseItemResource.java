package br.com.nthing.item;

import jakarta.inject.Inject;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
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

}
