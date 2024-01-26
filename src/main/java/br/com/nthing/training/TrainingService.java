package br.com.nthing.training;

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

    public void closeTraining(Long id) {

    }

    public Training findById(Long id) {
        return null;
    }


    public List<Training> listAll() {
        return null;
    }

    public List<Training> searchByKeyword(String key) {
        return null;
    }

}