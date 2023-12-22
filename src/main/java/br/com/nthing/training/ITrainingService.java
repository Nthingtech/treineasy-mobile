package br.com.nthing.training;

import java.util.List;

public interface ITrainingService {

Training createNewTraining(Training trai);
Training alterTraining(Training trai);
void  deleteTraining();
Training findById(Integer id);
List<Training> listAll();
List<Training> searchByKeyword(String key);
List<Training> getByKeyword(String keyword);
}
