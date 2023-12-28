package br.com.nthing.exercise;

import java.util.List;

public interface IExerciseService {

    Exercise createNewExercise(Exercise exer);
    Exercise alterExercise(Exercise exer);
    void deleteExercise();
    Exercise findById(Long id);
    List<Exercise> listAll();
    List<Exercise> searchByKeywordExercise(String key);
    List<Exercise> searchByKeywordMuscleGroup(String key);
    List<Exercise> getByKeyword(String keyWord);
}
