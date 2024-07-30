package br.com.nthing.training;

import br.com.nthing.training.enums.TrainingStatus;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;


@ApplicationScoped
public class TrainingService  {

    @Inject
    private TrainingRepository trainingRepository;


    @Transactional
    public Training createNewTraining(Training trai) {
        trainingRepository.persist(trai);
        return trai;
    }


    @Transactional
    public void alterTraining(Training training) {
        trainingRepository.updateTrainingRepository(training);
    }


    @Transactional
    public void deleteTraining(Long id) {
        trainingRepository.deleteById(id);
    }

    @Transactional
    public Training closeTraining(Long id) {
        Training training = trainingRepository.findById(id);
        if (training == null) {
           throw new RuntimeException("Treino não encontrado");
        }

        LocalDateTime now = LocalDateTime.now();
        LocalDate today = now.toLocalDate();

        if (training.getStatus() != TrainingStatus.CONCLUDED) {
            if (training.getConcludedAt() != null && training.getConcludedAt().toLocalDate().equals(today)) {
                throw new IllegalStateException("Treino já realizado hoje!");
            } else {
                training.setStatus(TrainingStatus.CONCLUDED);
                training.setConcludedAt(now);
                training.setTotalConcludedTraining((training.getTotalConcludedTraining() != null ? training.getTotalConcludedTraining() : 0) + 1);
            }

        }
        trainingRepository.persist(training);
        return training; //TODO SUM TRAINING CONCLUDED
    }

    @Transactional
    public Training findById(Long id) {
        return trainingRepository.findById(id);
    }

    @Transactional
    public List<Training> listAll() {
        return trainingRepository.listAll();
    }

    @Transactional
    public List<Training> searchByKeywordTraining(String keytrai) {
        return trainingRepository.findByKeywordTraining(keytrai);
    }


}