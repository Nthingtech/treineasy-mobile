package br.com.nthing.exercise;

import java.util.List;

public interface IExerciseService {

    Exercise createNewExercise(Exercise exer);
    Exercise alterExercise(Exercise exer);
    void deleteExercise();
    Exercise findById(Integer id);
    List<Exercise> listAll();
    List<Exercise> searchByKeyword(String key);
    List<Exercise> getByKeyword(String keyWord);
}
