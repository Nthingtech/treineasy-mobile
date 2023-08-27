package br.com.nthing.training;

import jakarta.inject.Inject;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;

import java.util.List;

@Path("/training")
public class TrainingResource {

    @Inject
    TrainingRepository trainingRepository;

    @GET
    @Path("/listtraining")
    @Produces(MediaType.APPLICATION_JSON)
    public List<Training> get() {
        return trainingRepository.listAll();
    }
}
