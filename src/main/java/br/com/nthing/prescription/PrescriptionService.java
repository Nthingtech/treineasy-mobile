package br.com.nthing.prescription;

import br.com.nthing.training.Training;
import br.com.nthing.training.TrainingRepository;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.persistence.PrePersist;
import jakarta.persistence.PreUpdate;


@ApplicationScoped
public class PrescriptionService {

    @Inject
    PrescriptionRepository prescriptionRepository;

    @Inject
    TrainingRepository trainingRepository;

    @PrePersist //TODO
    @PreUpdate
    public void totalPrescription(Prescription prescription) {
        int totalTraining = prescription.getTrainings().stream()
                .mapToInt(Training::getTotalTraining)
                .sum();
        prescription.setTotalPrescription(totalTraining);
    }

}
