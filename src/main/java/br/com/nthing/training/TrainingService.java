package br.com.nthing.training;

import br.com.nthing.training.enums.TrainingStatus;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;

import java.util.List;


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
    public Training alterTraining(Long id, Training trai) {
        return null;
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
        training.setStatus(TrainingStatus.CONCLUDED);
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