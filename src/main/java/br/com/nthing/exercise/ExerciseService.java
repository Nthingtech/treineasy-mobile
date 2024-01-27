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

    @Transactional
    public Exercise createNewExercise(Exercise exer) {
        if (exer.getExercise() == null || exer.getExercise().isEmpty())
            return null;
        exerciseRepository.persist(exer);
        return exer;
    }

    /*@Transactional
    public Exercise alterExercise(Long id, Exercise exer) {
        return exerciseRepository.updateExercise(id, exer);
    }*/

    /*@Transactional
    public Exercise alterExercise(Long id, Exercise exer) {
        return exerciseRepository.updateExercise(id, exer);
    }*/
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

    @Transactional
    public void deleteExercise(Long id) {
        exerciseRepository.deleteById(id);
    }

    @Transactional
    public Exercise findById(Long id) {
        return exerciseRepository.findById(id);
    }

    /*@Transactional
    public Exercise findByExercise(String exercise) {
        return exerciseRepository.findByExercise(exercise);
    }*/

    @Transactional
    public List<Exercise> listAll() {
        return exerciseRepository.listAll();
    }

    @Transactional
    public List<Exercise> searchByKeywordExercise(String keyexer) {
        return exerciseRepository.findByKeywordExercise(keyexer);
    }

    @Transactional
    public List<Exercise> searchByKeywordMuscleGroup(String keymusc) {
        return exerciseRepository.findByKeywordMuscleGroup(keymusc);
    }


    @Transactional
    public List<Exercise> getByKeyword(String keyword) {
        return exerciseRepository.findByKeyword(keyword);
    }


}
