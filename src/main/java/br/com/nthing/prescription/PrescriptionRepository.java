package br.com.nthing.prescription;

import io.quarkus.hibernate.orm.panache.PanacheRepository;
import io.quarkus.panache.common.Parameters;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.persistence.EntityManager;

import java.util.List;

@ApplicationScoped
public class PrescriptionRepository implements PanacheRepository<Prescription> {

    @Inject
    EntityManager em;

    public List<Prescription> findKeywordPrescription(String keyword) {
        return list("lower(namePrescription) like lower (?1)", "%" + keyword + "%");
    }

    public int updatePrescritption(Prescription prescription) {
        return update("UPDATE Prescription p SET p.namePrescription = :namePrescription WHERE p.id = :id",
                Parameters.with("namePrescription", prescription.getNamePrescription())
                        .and("id", prescription.getId()));
    }


}
