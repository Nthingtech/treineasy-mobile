package br.com.nthing.prescription;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;

import java.util.List;


@ApplicationScoped
public class PrescriptionService implements IPrescriptionService {

    @Inject
    PrescriptionRepository prescriptionRepository;

    @Override
    @Transactional
    public Prescription findById(Long id) {
        return prescriptionRepository.findById(id);
    }

    @Override
    @Transactional
    public Prescription createPrescription(Prescription newPrescription) {
            prescriptionRepository.persist(newPrescription);
            return newPrescription;
    }

    @Override
    @Transactional
    public void updatePrescription(Prescription prescription) {
        prescriptionRepository.updatePrescritption(prescription);
    }

    @Transactional
    @Override
    public void deletePrescription(Long id) {
        prescriptionRepository.deleteById(id);
    }

   /* @PrePersist //TODO
    @PreUpdate
    @Transactional
    @Override
    public void totalPrescription(Prescription prescription) {
        int totalTraining = prescription.getTrainings().stream()
                .mapToInt(Training::getTotalTraining)
                .sum();
        prescription.setTotalPrescription(totalTraining); //TODO COMMIT FOR TEST IN ENTITY
    }*/

    @Override
    @Transactional
    public List<Prescription> listAll() {
        return prescriptionRepository.listAll();
    }

    @Override
    @Transactional
    public List<Prescription> searchByKeywordPrescription(String keypresc) {
        return prescriptionRepository.findKeywordPrescription(keypresc);
    }



}
