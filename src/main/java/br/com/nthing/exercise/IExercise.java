package br.com.nthing.exercise;

import java.util.List;

public interface IExercise {

    public Exercise createNewExercise(Exercise exer);
    public Exercise alterExercise(Exercise exer);
    public void deleteExercise();
    public Exercise findById(Integer id);
    public List<Exercise> listAll();
    public List<Exercise> searchByKeyword(String Key);
    public List<Exercise> getByKeyword(String keyWord);
}
