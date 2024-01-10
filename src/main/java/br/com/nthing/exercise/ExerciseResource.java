package br.com.nthing.exercise;

import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.PUT;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

import java.net.URI;
import java.util.List;

@Path("exercises")
public class ExerciseResource {

   @Inject
   ExerciseService exerciseService;


   @GET
   @Path("/list")
   @Produces(MediaType.APPLICATION_JSON)
   public List<Exercise> get(){
       return exerciseService.listAll();
   }

   @GET
   @Path("{keyword}")
   @Produces(MediaType.APPLICATION_JSON)
   public List<Exercise> findKeyword(@PathParam("keyword") String keyword) {
       return exerciseService.getByKeyword(keyword); //TODO TESTE KEYWORD
   }

   @POST
   @Transactional
   @Consumes(MediaType.APPLICATION_JSON)
   @Produces(MediaType.APPLICATION_JSON)
   public Response createExercise(Exercise exercise) {
       exerciseService.createNewExercise(exercise);
       return Response.created(URI.create("/create/" + exercise.getId())).build();
   }

   @PUT
   @Path("/update")
   @Consumes(MediaType.APPLICATION_JSON)
   @Produces(MediaType.APPLICATION_JSON)
   public Exercise updateExercise(@PathParam("id") Long id, Exercise exercise) {
       return  exerciseService.alterExercise(id, exercise);
   }

}
