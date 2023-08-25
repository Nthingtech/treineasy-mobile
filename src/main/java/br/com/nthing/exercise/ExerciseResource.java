package br.com.nthing.exercise;

import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;

import java.util.List;

@Path("/exercise")
public class ExerciseResource {

    @GET
    @Path("list")
    @Produces(MediaType.APPLICATION_JSON)
    public List<Exercise> get(){
        return Exercise.listAll();
    }
}
