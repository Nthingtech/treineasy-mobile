package br.com.nthing.prescription;

import java.time.LocalDateTime;

public record PrescriptionDTO(Long id, String namePrescription, LocalDateTime concludedAt, LocalDateTime startPrescription,
                              Integer totalPrescription, Integer completeWorkouts) {
}
