package br.com.nthing.training;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;

import java.util.List;

@ApplicationScoped
public class TrainingService implements ITrainingService {

    @Inject
    private TrainingRepository trainingRepository;

    public Training createNewTraining(Training trai ) {
        trainingRepository.persist(trai);
        return trai;
    }

    public Training alterTraining(Training trai) {
        return null;
    }

    public void deleteTraining() {
    }

    public void closeTraining(Integer id) {

    }

    public Training findById(Integer id) {
    return null;
    }

    public Training updateTraining(Training train) {
        trainingRepository.persist(train);//todo procurar solução para dar update da forma correta
        return null;
    }

    public List<Training> listAll() {
        return null;
    }

    public List<Training> searchByKeyword(String key) {
        return null;
    }

    public List<Training> getByKeyword(String key) {
        return null;
    }
}
