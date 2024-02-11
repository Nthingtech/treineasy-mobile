package br.com.nthing.item;

import io.quarkus.hibernate.orm.panache.PanacheRepository;
import jakarta.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class ExerciseItemRepository implements PanacheRepository<ExerciseItem> {

}
