package br.com.nthing.prescription;

import br.com.nthing.training.TrainingDTO;
import br.com.nthing.user.client.ClientDTO;

import java.time.LocalDateTime;
import java.util.Set;

public record PrescriptionDTO(Long id, String namePrescription, LocalDateTime concludedAt, LocalDateTime startPrescription,
                              Integer totalPrescription, Integer completedWorkouts, ClientDTO client, Set<TrainingDTO> trainings) {
}
