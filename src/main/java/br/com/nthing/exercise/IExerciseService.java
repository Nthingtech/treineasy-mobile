package br.com.nthing.exercise;

import java.util.List;

public interface IExerciseService {

    public Exercise createNewExercise(Exercise exer);
    public Exercise alterExercise(Long id, Exercise exer);
    public void deleteExercise(Long id); //public void deleteExercise(Long id, Exercise exer);
    public Exercise findById(Long id);
    public Exercise findByExercise(String exercise);
    public List<Exercise> listAll();
    public List<Exercise> searchByKeywordExercise(String key);
    public List<Exercise> searchByKeywordMuscleGroup(String key);
    public List<Exercise> getByKeyword(String keyword);
}
