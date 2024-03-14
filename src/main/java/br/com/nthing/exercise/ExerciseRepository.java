package br.com.nthing.exercise;

import io.quarkus.hibernate.orm.panache.PanacheRepository;
import io.quarkus.panache.common.Parameters;
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

    public int updateParamRootExercise(Exercise exercise) { //TODO TEST UPDATE
        return update("UPDATE Exercise e SET e.exercise = :exercise, e.machineNumber = :machineNumber, e.muscleGroup = :muscleGroup, e.videoUri = :videoUri WHERE e.id = :id",
                Parameters.with("exercise", exercise.getExercise())
                        .and("machineNumber", exercise.getMachineNumber())
                        .and( "muscleGroup", exercise.getMuscleGroup())
                        .and("videoUri", exercise.getVideoUri())
                        .and("id", exercise.getId()));
    }



}
