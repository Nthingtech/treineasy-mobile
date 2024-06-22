package br.com.nthing.prescription;

import br.com.nthing.training.Training;
import br.com.nthing.training.TrainingRepository;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.persistence.PrePersist;
import jakarta.persistence.PreUpdate;
import jakarta.transaction.Transactional;

import java.util.List;


@ApplicationScoped
public class PrescriptionService implements IPrescriptionService {

    @Inject
    PrescriptionRepository prescriptionRepository;

    @Inject
    TrainingRepository trainingRepository;


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
    public void updatePrescription(Prescription prescription) {

    }

    @Override
    public void deletePrescription(Long idSequence) {

    }

    @PrePersist //TODO
    @PreUpdate
    @Transactional
    @Override
    public void totalPrescription(Prescription prescription) {
        int totalTraining = prescription.getTrainings().stream()
                .mapToInt(Training::getTotalTraining)
                .sum();
        prescription.setTotalPrescription(totalTraining);
    }

    @Override
    public List<Prescription> listAll() {
        return List.of();
    }

}
