package br.com.nthing.training;

import io.quarkus.hibernate.orm.panache.PanacheRepository;
import jakarta.enterprise.context.ApplicationScoped;

import java.util.List;

@ApplicationScoped
public class TrainingRepository implements PanacheRepository<Training> {

    //TODO Usar o update nativo do panache para teste
    public List<Training> findByKeywordTraining(String keyword) {
        return list("lower(training) like lower(?1)", "%" + keyword + "%");
    }

    public void updateTraining(Long id, Training training) {
        Training entity = findById(id);
        if (entity == null) {
            throw new RuntimeException("Treino não encontrado");
        }

        String query = "UPDATE Training SET training = :nameTraining, totalTraining = :totalTraining, concludedAt = :concludedAt, status = :status, WHERE id = :id";
        update(query, training.getNameTraining()); //TODO
    }

}
