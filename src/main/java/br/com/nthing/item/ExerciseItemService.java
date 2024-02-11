package br.com.nthing.item;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;

import java.util.List;

@ApplicationScoped
public class ExerciseItemService implements IExerciseItemService {

    @Inject
    ExerciseItemRepository exerciseItemRepository;

    @Override
    @Transactional
    public ExerciseItem insertItem(ExerciseItem newItem) {
        exerciseItemRepository.persist(newItem);
        return newItem ;
    }

    @Override
    @Transactional
    public ExerciseItem updateItem(ExerciseItem update) {
        exerciseItemRepository.persist(update);
        return update;
    }

    @Override
    @Transactional
    public void deleteItem(Long idSequence) {
        exerciseItemRepository.deleteById(idSequence);
    }

    @Override
    @Transactional
    public List<ExerciseItem> listAll() {
        return exerciseItemRepository.listAll();
    }
}
//TODO REFACTOR METHODS