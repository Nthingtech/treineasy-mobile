package br.com.nthing.exercise;

import io.quarkus.hibernate.orm.panache.PanacheRepository;
import jakarta.enterprise.context.ApplicationScoped;

import java.util.List;

@ApplicationScoped
public class ExerciseRepository implements PanacheRepository<Exercise> {


    public List<Exercise> findByKeyword(String keyword) {
        return list("lower(exercise) like lower(?1) or lower(muscleGroup) like lower(?1)", "%" + keyword + "%");
    }

    public List<Exercise> findByKeywordExercise(String keyword) {
        return list("lower(exercise) like lower(?1)", "%" + keyword + "%");
    }

    public List<Exercise> findByKeywordMuscleGroup(String keyword) {
        return list("lower(muscleGroup) like lower(?1)", "%" + keyword + "%");
    }
}
