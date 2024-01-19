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
        if (exer.getExercise() == null || exer.getExercise().length() == 0)
            return null;
        exerciseRepository.persist(exer);
        return exer;
    }

    @Transactional
    public Exercise alterExercise(Long id, Exercise exer) {
        return exerciseRepository.updateExercise(id, exer);
    }

    @Transactional
    public void deleteExercise(Long id) {
        exerciseRepository.deleteById(id);
    }

    @Transactional
    public Exercise findById(Long id) {
        return exerciseRepository.findById(id);
    }

    @Transactional
    public Exercise findByExercise(String exercise) {
        exercise = exercise.toLowerCase();
        return exerciseRepository.findByExercise(exercise);
    }

    @Transactional
    public List<Exercise> listAll() {
        return exerciseRepository.listAll();
    }

    @Transactional
    public List<Exercise> searchByKeywordExercise(String key) {
        key = key.toLowerCase();
        return exerciseRepository.findByKeywordExercise(key);//todo
    }

    @Transactional
    public List<Exercise> searchByKeywordMuscleGroup(String key) {
        key = key.toLowerCase();
        return exerciseRepository.findByKeywordMuscleGroup(key);
    }


    @Transactional
    public List<Exercise> getByKeyword(String keyword) {
        keyword = keyword.toLowerCase();
        return exerciseRepository.findByKeyword(keyword);
    }


}
