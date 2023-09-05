package br.com.nthing.exercise;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;

import java.util.List;

@ApplicationScoped
public class ExerciseService {

    @Inject
    private ExerciseRepository exerciseRepository;

    @Transactional
    public Exercise createNewExercise(Exercise exer) {
        exerciseRepository.persist(exer);
        return exer;
    }


    public Exercise alterExercise(Exercise exer) {
        return null;
    }


    public void deleteExercise() {

    }


    public List<Exercise> listAll() {
        return null;
    }


    public List<Exercise> searchByKeyword(String key) {
        return null;
    }

}
