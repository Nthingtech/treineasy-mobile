package br.com.nthing.exercise;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;

import java.util.List;

import static io.quarkus.hibernate.orm.panache.PanacheEntityBase.persist;

@ApplicationScoped
public class ExerciseService implements IExerciseService {

    @Inject
    private ExerciseRepository exerciseRepository;

    @Override
    @Transactional
    public Exercise createNewExercise(Exercise exer) {
        if (exer.getExercise() == null || exer.getExercise().isEmpty())
            return null;
        exerciseRepository.persist(exer);
        return exer;
    }

    @Override
    @Transactional
    public Exercise alterExercise(Long id, Exercise exercise) {
        Exercise entity = findById(id);
        if (entity == null) {
            throw new RuntimeException("Exercício não encontrado");
        }

        entity.setExercise(exercise.getExercise());
        entity.setMachineNumber(exercise.getMachineNumber());
        entity.setMuscleGroup(exercise.getMuscleGroup());
        entity.setVideoUri(exercise.getVideoUri());
        persist(entity);
        return entity;
    }


    @Override
    @Transactional
    public void deleteExercise(Long id) {
        exerciseRepository.deleteById(id);
    }

    @Override
    @Transactional
    public Exercise findById(Long id) {
        return exerciseRepository.findById(id);
    }

    @Override
    @Transactional
    public List<Exercise> listAll() {
        return exerciseRepository.listAll();
    }

    @Override
    @Transactional
    public List<Exercise> searchByKeywordExercise(String keyexer) {
        return exerciseRepository.findByKeywordExercise(keyexer);
    }

    @Override
    @Transactional
    public List<Exercise> searchByKeywordMuscleGroup(String keymusc) {
        return exerciseRepository.findByKeywordMuscleGroup(keymusc);
    }


    @Override
    @Transactional
    public List<Exercise> getByKeyword(String keyword) {
        return exerciseRepository.findByKeyword(keyword);
    }


}
