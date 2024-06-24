package br.com.nthing.prescription;

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

@Path("prescriptions")
public class PrescriptionResource {

    @Inject
    PrescriptionService prescriptionService;

    @GET
    @Path("/listprescription")
    @Produces(MediaType.APPLICATION_JSON)
    public Response get() {
        List<Prescription> prescriptions = prescriptionService.listAll();
        return Response.ok(prescriptions).build();
    }

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

    @PUT
    @Path("update")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response updatePrescription(@QueryParam("id") Long id, Prescription prescription) {
        prescription.setId(id);
        Prescription foundPrescription = prescriptionService.findById(id);
        if (foundPrescription == null){
            return Response.status(Response.Status.NOT_FOUND).entity("Prescrição não encontrada").build();
        }
        prescriptionService.updatePrescription(prescription);
        return Response.status(Response.Status.OK).entity(prescription).build();
    }

    @DELETE
    @Path("delete")
    public Response deletePrescription(@QueryParam("id") Long id) {
        prescriptionService.deletePrescription(id);
        return Response.status(Response.Status.NO_CONTENT).build();
    }

    public Response searchPrescName(@PathParam("keypresc") String keypresc) {
        List<Prescription> prescriptions = prescriptionService.searchByKeywordPrescription(keypresc );
        if (!prescriptions.isEmpty()) {
            return Response.status(Response.Status.OK).entity(prescriptions).build();
        }
        return Response.status(Response.Status.NOT_FOUND).build();
    }

}
