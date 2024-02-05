package br.com.nthing.training;

import java.util.List;

public interface ITrainingService {

    Training createNewTraining(Training trai);
    Training alterTraining(Long id, Training trai);
    void deleteTraining();
    Training closeTraining(Long id);
    Training findById(Long id);
    List<Training> listAll();

}