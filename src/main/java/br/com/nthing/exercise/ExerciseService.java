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
    public Exercise alterExercise(Long id, Exercise exer) {
        return exerciseRepository.updateExercise(id, exer);
    }

    @Transactional
    public void deleteExercise(Exercise exer) {
        exerciseRepository.delete(exer);
    }

    @Transactional
    public Exercise findById(Long id) {
        return exerciseRepository.findById(id);
    }

    @Transactional
    public Exercise findByExercise(String exercise) {
        return exerciseRepository.findByExercise(exercise);
    }

    @Transactional
    public List<Exercise> listAll() {
        return exerciseRepository.listAll();
    }

    @Transactional
    public List<Exercise> searchByKeywordExercise(String key) {
        return exerciseRepository.findByKeywordExercise(key);//todo
    }

    @Transactional
    public List<Exercise> searchByKeywordMuscleGroup(String key) {
        return exerciseRepository.findByKeywordMuscleGroup(key);
    }


    @Transactional
    public List<Exercise> getByKeyword(String keyword) {
        return exerciseRepository.findByKeyword(keyword);
    }


}
