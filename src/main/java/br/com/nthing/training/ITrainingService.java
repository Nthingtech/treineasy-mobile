package br.com.nthing.training;

import java.util.List;

public interface ITrainingService {

    Training createNewTraining(Training trai);
    void alterTraining(Training trai);

    void deleteTraining(Long id);
    Training closeTraining(Long id);
    Training findById(Long id);
    List<Training> listAll();

    List<Training> searchByKeywordTraining(String keytrai);
}
