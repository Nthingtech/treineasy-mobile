package br.com.nthing.exercise;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;

import java.util.List;

@ApplicationScoped
public class ExerciseService implements IExerciseService {

    @Inject
    private ExerciseRepository exerciseRepository;

    @Override
    public Exercise createNewExercise(Exercise exer) {
        if (exer.getExercise() == null || exer.getExercise().isEmpty())
            return null;
        exerciseRepository.persist(exer);
        return exer;
    }

    @Override
    public Exercise alterExercise(Long id, Exercise exercise) {
        Exercise entity = findById(id);
        if (entity == null) {
            throw new RuntimeException("Exercício não encontrado");
        }

        entity.setExercise(exercise.getExercise());
        entity.setMachineNumber(exercise.getMachineNumber());
        entity.setMuscleGroup(exercise.getMuscleGroup());
        entity.setVideoUri(exercise.getVideoUri());
        exerciseRepository.persist(entity);
        return entity;
    }



    @Override
    public void deleteExercise(Long id) {
        exerciseRepository.deleteById(id);
    }

    @Override
    public Exercise findById(Long id) {
        return exerciseRepository.findById(id);
    }

    @Override
    public List<Exercise> listAll() {
        return exerciseRepository.listAll();
    }

    @Override
    public List<Exercise> searchByKeywordExercise(String keyexer) {
        return exerciseRepository.findByKeywordExercise(keyexer);
    }

    @Override
    public List<Exercise> searchByKeywordMuscleGroup(String keymusc) {
        return exerciseRepository.findByKeywordMuscleGroup(keymusc);
    }


    @Override
    public List<Exercise> getByKeyword(String keyword) {
        return exerciseRepository.findByKeyword(keyword);
    }


}
