package br.com.nthing.exercise;

import java.util.List;

public interface IExerciseService {

     Exercise createNewExercise(Exercise exer);
     void updateExercise(Exercise exercise);
     void deleteExercise(Long id);
     Exercise findById(Long id);
     /*Exercise findByExercise(String exercise);*/
     List<Exercise> listAll();
     List<Exercise> searchByKeywordExercise(String key);
     List<Exercise> searchByKeywordMuscleGroup(String key);
     List<Exercise> getByKeyword(String keyword);
}
