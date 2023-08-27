package br.com.nthing.training;

import io.quarkus.hibernate.orm.panache.PanacheRepository;
import jakarta.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class TrainingRepository implements PanacheRepository<Training> {
}
