package br.com.nthing.exercise;

import jakarta.inject.Inject;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;

import java.util.List;

@Path("/exercise")
public class ExerciseResource {

/*
   @Inject
   ExerciseRepository exerciseRepository; // TODO REMOVER APÓS INSERIR O METODO GET PARA LISTAR NO SERVICE
*/

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



}
