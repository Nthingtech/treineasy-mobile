package br.com.nthing.exercise;

import jakarta.inject.Inject;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.PUT;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;

import java.util.List;

@Path("/exercises")
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

   @PUT
   @Consumes(MediaType.APPLICATION_JSON)
   @Produces(MediaType.APPLICATION_JSON)
   public Exercise updateExercise(@PathParam("id") Long id, Exercise exercise) {
       return  exerciseService.alterExercise(id, exercise);
   }

}
