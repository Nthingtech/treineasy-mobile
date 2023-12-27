package br.com.nthing.exercise;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;

import java.util.List;

@ApplicationScoped
public class ExerciseService implements IExerciseService {

    @Inject
    private ExerciseRepository exerciseRepository;

    @Transactional
    public Exercise createNewExercise(Exercise exer) {
        exerciseRepository.persist(exer);
        return exer;
    }

    @Transactional
    public Exercise alterExercise(Exercise exer) {
        return null;
    }

    @Transactional
    public void deleteExercise() {

    }

    @Transactional
    public Exercise findById(Integer id) {
        return null;
    }

    @Transactional
    public Exercise findByExercise(String exercise) {
        return exerciseRepository.findByExercise(exercise);
    }

    @Transactional
    public List<Exercise> listAll() {
        return null;
    }

    @Transactional
    public List<Exercise> searchByKeyword(String key) {//TODO DELETAR CASO getByKeyWord funcione
        return null;
    }

    @Transactional
    public List<Exercise> getByKeyword(String keyword) {
        return exerciseRepository.findByKeyword(keyword);
    }

}
