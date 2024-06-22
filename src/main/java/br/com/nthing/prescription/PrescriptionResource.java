package br.com.nthing.prescription;

import jakarta.inject.Inject;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.QueryParam;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

@Path("prescriptions")
public class PrescriptionResource {

    @Inject
    PrescriptionService prescriptionService;

    @GET
    @Path("findById")
    @Produces(MediaType.APPLICATION_JSON)
    public Response findById(@QueryParam("id") Long id) {
        Prescription prescription = prescriptionService.findById(id);
        if (prescription != null) {
            return Response.status(Response.Status.FOUND).entity(prescription).build();
        }
        return Response.status(Response.Status.NOT_FOUND).build();
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response createPrescription(Prescription prescription) {
        Prescription prescript = prescriptionService.createPrescription(prescription);
        if (prescript != null) {
            return Response.status(Response.Status.CREATED).entity(prescription).build();
        }
        return Response.status(Response.Status.BAD_REQUEST).build();
    }


}
