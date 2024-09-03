package br.com.nthing.training.dtos;

import br.com.nthing.training.enums.TrainingStatus;

import java.time.LocalDateTime;

public record TrainingByPrescriptionDTO(Long id, String nameTraining, Integer totalTraining, LocalDateTime concludedAt,
                                        TrainingStatus status, Integer totalConcludedTraining) {
}
