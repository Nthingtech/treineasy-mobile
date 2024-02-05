package br.com.nthing.training;

import jakarta.inject.Inject;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

import java.util.List;

@Path("/training")
public class TrainingResource {

    @Inject
    TrainingService trainingService;

    @GET
    @Path("/listtraining")
    @Produces(MediaType.APPLICATION_JSON)
    public List<Training> get() {
        return trainingService.listAll();
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response createTraining(Training training) {
        Training trai = trainingService.createNewTraining(training);
        if (trai != null) {
            return Response.status(Response.Status.CREATED).entity(training).build();
        }
        return Response.status(Response.Status.BAD_REQUEST).build();
    }
}
