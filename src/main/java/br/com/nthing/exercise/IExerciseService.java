package br.com.nthing.exercise;

import java.util.List;

public interface IExerciseService {

    public Exercise createNewExercise(Exercise exer);
    public Exercise alterExercise(Exercise exer);
    public void deleteExercise();
    public List<Exercise> listAll();
    public List<Exercise> searchByKeyword(String key);

}
