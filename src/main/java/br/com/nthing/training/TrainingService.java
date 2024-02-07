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

    @Transactional
    public Training createNewTraining(Training trai) {
        trainingRepository.persist(trai);
        return trai;
    }

    @Transactional
    public Training alterTraining(Long id, Training trai) {
        return null;
    }

    @Transactional
    public void deleteTraining() {
    }

    @Transactional
    public Training closeTraining(Long id) {
        Training training = trainingRepository.findById(id);
        training.setStatus(TrainingStatus.CONCLUDED);
        trainingRepository.persist(training);
        return training;
    }

    @Transactional
    public Training findById(Long id) {
        return trainingRepository.findById(id);
    }
    

    @Transactional
    public List<Training> listAll() {
        return trainingRepository.listAll();
    }

}