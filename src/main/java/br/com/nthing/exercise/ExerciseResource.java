package br.com.nthing.exercise;

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

@Path("exercises")
public class ExerciseResource {

   @Inject
   ExerciseService exerciseService;

   @GET
   @Path("findById")
   @Produces(MediaType.APPLICATION_JSON)
   public Response findById(@QueryParam("id") Long id){
       Exercise exercise = exerciseService.findById(id);
       return Response.status(Response.Status.OK).entity(exercise).build();
   }

    @GET
    @Path("list")
    @Produces(MediaType.APPLICATION_JSON)
    public Response get(){
        List<Exercise> exercises = exerciseService.listAll();
        return Response.ok(exercises).build();
    }

   @GET
   @Path("{keyword}")
   @Produces(MediaType.APPLICATION_JSON)
   public Response findKeyword(@PathParam("keyword") String keyword) {
       List<Exercise> exercises = exerciseService.getByKeyword(keyword);
       return Response.ok(exercises).build(); //TODO TESTE KEYWORD
   }

   @POST
   @Transactional
   @Consumes(MediaType.APPLICATION_JSON)
   @Produces(MediaType.APPLICATION_JSON)
   public Response createExercise(Exercise exercise) {
       Exercise exer = exerciseService.createNewExercise(exercise);
       //return Response.created(URI.create("/create/" + exercise.getId())).build();
       if (exer != null) {
           return Response.status(Response.Status.CREATED).entity(exercise).build();
       }
       return Response.status(Response.Status.BAD_REQUEST).build();
   }

    @PUT
    @Path("update")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response updateExercise(@QueryParam("id") Long id, Exercise exercise) {
        exerciseService.alterExercise(id, exercise);
        return Response.status(Response.Status.OK).build();
    }

   @DELETE
   @Path("delete")
   public Response deleteExercise(@QueryParam("id") Long id) {
        exerciseService.deleteExercise(id);
        return Response.status(Response.Status.NO_CONTENT).build();
   }


}
