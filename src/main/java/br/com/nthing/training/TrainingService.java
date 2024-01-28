package br.com.nthing.training;

import br.com.nthing.training.enums.TrainingStatus;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;

import java.util.List;



@ApplicationScoped
public class TrainingService implements ITrainingService {

    @Inject
    private TrainingRepository trainingRepository;

    public Training createNewTraining(Training trai) {
        trainingRepository.persist(trai);
        return trai;
    }

    public Training alterTraining(Long id, Training trai) {
        return null;
    }

    public void deleteTraining() {
    }

    public Training closeTraining(Long id) {
        Training training = trainingRepository.findById(id);
        training.setStatus(TrainingStatus.CONCLUDED);
        trainingRepository.persist(training);
        return training;
    }

    public Training findById(Long id) {
        return trainingRepository.findById(id);
    }


    public List<Training> listAll() {
        return trainingRepository.listAll();
    }

}