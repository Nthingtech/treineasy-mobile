package br.com.nthing.training;

import br.com.nthing.training.enums.TrainingStatus;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

import static io.quarkus.hibernate.orm.panache.PanacheEntityBase.persist;


@ApplicationScoped
public class TrainingService implements ITrainingService {

    @Inject
    private TrainingRepository trainingRepository;

    @Override
    @Transactional
    public Training createNewTraining(Training trai) {
        trainingRepository.persist(trai);
        return trai;
    }

    @Override
    @Transactional
    public Training alterTraining(Long id, Training training) {
        Training entity = findById(id);
        if (entity == null) {
            throw new RuntimeException("Treino não encontrado");//TODO MAKE EQUAL EXERCISEITEMSERVICE
        }
        persist(entity);
        return entity;
    }

    @Override
    @Transactional
    public void deleteTraining(Long id) {
        trainingRepository.deleteById(id);
    }

    @Override
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
        /*training.setStatus(TrainingStatus.CONCLUDED);
        training.setConcludedAt(LocalDateTime.now());
        training.concludeTraining();*/
        trainingRepository.persist(training);
        return training; //TODO SUM TRAINING CONCLUDED
    }

    @Override
    @Transactional
    public Training findById(Long id) {
        return trainingRepository.findById(id);
    }


    @Override
    @Transactional
    public List<Training> listAll() {
        return trainingRepository.listAll();
    }

    @Override
    @Transactional
    public List<Training> searchByKeywordTraining(String keytrai) {
        return trainingRepository.findByKeywordTraining(keytrai);
    }


}