package br.com.nthing.training;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;

import java.util.List;

@ApplicationScoped
public class TrainingService {

    @Inject
    private TrainingRepository trainingRepository;

    public Training createNewTraining(Training trai ) {
        trainingRepository.persist(trai);
        return trai;
    }

    public void deleteTraining(Integer id) {

    }

    public void closeTraining(Integer id) {

    }

    public void findById(Integer id) {

    }

    public Training updateTraining(Training train) {
        return null;
    }

    public List<Training> listAll() {
        return null;
    }

    public List<Training> searchByKeyword(String key) {
        return null;
    }
}
