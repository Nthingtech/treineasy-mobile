package br.com.nthing.training;

import io.quarkus.hibernate.orm.panache.PanacheRepository;
import jakarta.enterprise.context.ApplicationScoped;

import java.util.List;

@ApplicationScoped
public class TrainingRepository implements PanacheRepository<Training> {

    //TODO Usar o update nativo do panache para teste
    public List<Training> findByKeywordTraining(String keyword) {
        return list("lower(nameTraining) like lower(?1)", "%" + keyword + "%");
    }

}
