package br.com.nthing.exercise;

import io.quarkus.hibernate.orm.panache.PanacheRepository;
import jakarta.enterprise.context.ApplicationScoped;

import java.util.List;

@ApplicationScoped
public class ExerciseRepository implements PanacheRepository<Exercise> {

    public List<Exercise> findByKeyword(String keyword) {
        return list("exercise like ?1 or muscleGroup like ?1", "%" + keyword + "%");
    }

}
