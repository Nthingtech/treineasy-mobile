package br.com.nthing.training;

import io.quarkus.hibernate.orm.panache.PanacheRepository;
import io.quarkus.panache.common.Parameters;
import jakarta.enterprise.context.ApplicationScoped;

import java.util.List;

@ApplicationScoped
public class TrainingRepository implements PanacheRepository<Training> {


    public List<Training> findByKeywordTraining(String keyword) {
        return list("lower(nameTraining) like lower(?1)", "%" + keyword + "%");
    }

    public int updateTrainingRepository( Training training) {
        return update("UPDATE Training t SET t.nameTraining = :nameTraining, t.totalTraining = :totalTraining WHERE t.id = :id",
                Parameters.with("nameTraining", training.getNameTraining())
                        .and("totalTraining", training.getTotalTraining())
                        .and("id", training.getId()));
    }



}
