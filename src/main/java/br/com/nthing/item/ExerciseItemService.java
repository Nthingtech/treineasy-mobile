package br.com.nthing.item;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;

import java.util.List;

@ApplicationScoped
public class ExerciseItemService implements IExerciseItemService {

    @Inject
    ExerciseItemRepository exerciseItemRepository;

    @Override
    public ExerciseItem findById(Long id) {
        return exerciseItemRepository.findById(id);
    }

    @Override
    public ExerciseItem insertItem(ExerciseItem newItem) {
        exerciseItemRepository.persist(newItem);
        return newItem ;
    }

    @Override
    public ExerciseItem updateItem(Long id, ExerciseItem update) {
        ExerciseItem entity = findById(id);
        if (entity == null) {
            throw new RuntimeException("Exercício não encontrado");
        }

        //entity.setIdSequence(update.getIdSequence());
        entity.setSeriesNumber(update.getSeriesNumber());
        entity.setMeasurementType(update.getMeasurementType());
        entity.setRest(update.getRest());
        entity.setConcluded(update.getConcluded());
        entity.setNote(update.getNote());
        exerciseItemRepository.persist(entity);
        return update;
    }

    @Override
    public void deleteItem(Long idSequence) {
        exerciseItemRepository.deleteById(idSequence);
    }

    @Override
    public List<ExerciseItem> listAll() {
        return exerciseItemRepository.listAll();
    }
}
//TODO REFACTOR METHODS