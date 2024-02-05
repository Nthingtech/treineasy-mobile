package br.com.nthing.exercise;

import jakarta.inject.Inject;
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
       if (exercise != null) {
           return Response.status(Response.Status.OK).entity(exercise).build();
       }
       return Response.status(Response.Status.NOT_FOUND).build();
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
       if (!exercises.isEmpty()) {
           return Response.status(Response.Status.OK).entity(exercises).build(); //search exercise or muscle group
       }
       return Response.status(Response.Status.NOT_FOUND).build();
   }

    @GET
    @Path("exercise/{keyexercise}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response findKeywordExercise(@PathParam("keyexercise") String keyexercise) {
        List<Exercise> exercises = exerciseService.searchByKeywordExercise(keyexercise);
        if (!exercises.isEmpty()) {
            return Response.status(Response.Status.OK).entity(exercises).build();
        }
        return Response.status(Response.Status.NOT_FOUND).build(); //search exercise
    }

    @GET
    @Path("muscle/{keymuscle}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response findKeywordMuscle(@PathParam("keymuscle") String keyemuscle) {
        List<Exercise> exercises = exerciseService.searchByKeywordMuscleGroup(keyemuscle);
        if (!exercises.isEmpty()) {
            return Response.status(Response.Status.OK).entity(exercises).build();
        }
        return Response.status(Response.Status.NOT_FOUND).build(); //search muscle
    }

   @POST
   @Consumes(MediaType.APPLICATION_JSON)
   @Produces(MediaType.APPLICATION_JSON)
   public Response createExercise(Exercise exercise) {
       Exercise exer = exerciseService.createNewExercise(exercise);
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
       Exercise foundExercise = exerciseService.findById(id);
       if (foundExercise == null){
           return Response.status(Response.Status.NOT_FOUND).entity("Exercício não encontrado").build();
       }
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
