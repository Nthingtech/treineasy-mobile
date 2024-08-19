package br.com.nthing.training;

import br.com.nthing.training.enums.TrainingStatus;

import java.time.LocalDateTime;

public record TrainingDTO(Long id, String nameTraining, Integer totalTraining, LocalDateTime concludedAt,
                          TrainingStatus status, Integer totalConcludedTraining) {
}
