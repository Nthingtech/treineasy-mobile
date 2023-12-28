package br.com.nthing.exercise;

import io.quarkus.hibernate.orm.panache.PanacheRepository;
import jakarta.enterprise.context.ApplicationScoped;

import java.util.List;

@ApplicationScoped
public class ExerciseRepository implements PanacheRepository<Exercise> {

    public List<Exercise> findByKeyword(String keyword) {
        return list("name_exercise like ?1 or muscle_group like ?1", "%" + keyword + "%");//Todo excluir
    }

    public List<Exercise> findByKeywordExercise(String keyword) {
        return list("name_exercise like ?1", "%" + keyword + "%");
    }

    public List<Exercise> findByKeywordMuscleGroup(String keyword) {
        return list("muscle_group like ?1", "%" + keyword + "%");
    }

    public Exercise findByExercise(String exercise) {
        return  find("name_exercise", exercise).firstResult();
    }

}
//TODO VIDEO 3 ---> 18:48