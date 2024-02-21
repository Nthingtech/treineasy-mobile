package br.com.nthing.training;

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

@Path("trainings")
public class TrainingResource {

    @Inject
    TrainingService trainingService;

    @GET
    @Path("/listtraining")
    @Produces(MediaType.APPLICATION_JSON)
    public Response get() {
        List<Training> trainings = trainingService.listAll();
        return Response.ok(trainings).build();
    }

    @GET
    @Path("training/{keytrai}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response findKeywordTraining(@PathParam("keytrai") String keytrai) {
        List<Training> trainings = trainingService.searchByKeywordTraining(keytrai);
        if (!trainings.isEmpty()) {
            return Response.status(Response.Status.OK).entity(trainings).build();
        }
        return Response.status(Response.Status.NOT_FOUND).build();
    }

    @GET
    @Path("findById")
    @Produces(MediaType.APPLICATION_JSON)
    public Response findById(@QueryParam("id") Long id) {
        Training training = trainingService.findById(id);
        if (training != null) {
            return Response.status(Response.Status.OK).entity(training).build();
        }
        return  Response.status(Response.Status.NOT_FOUND).build();
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

    @PUT
    @Path("update")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response updateTraining(@QueryParam("id") Long id, Training training) {
        Training foundTraining = trainingService.findById(id);
        if(foundTraining == null){
            return Response.status(Response.Status.NOT_FOUND).entity("Treino não encontrado").build();
        }
        trainingService.alterTraining(id,training);
        return Response.status(Response.Status.OK).entity(training).build();
    }

    @PUT
    @Path("closetraining")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response closeTraining(@QueryParam("id") Long id, Training training) {
        Training foundTraining = trainingService.findById(id);
        if(foundTraining == null) {
            return Response.status(Response.Status.NOT_FOUND).entity("Treino não encontrado").build();
        }
        trainingService.closeTraining(id);//todo
        return Response.status(Response.Status.OK).entity(training).build();

    }


    @DELETE
    @Path("delete")
    public Response deleteTraining(@QueryParam("id") Long id) {
        trainingService.deleteTraining(id);
        return Response.status(Response.Status.NO_CONTENT).build();
    }

}
