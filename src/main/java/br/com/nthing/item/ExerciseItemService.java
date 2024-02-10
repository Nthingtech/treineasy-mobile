package br.com.nthing.item;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;

@ApplicationScoped
public class ExerciseItemService {

    @Inject
    ExerciseItemRepository exerciseItemRepository;

    @Transactional
    public ExerciseItem insertItem(ExerciseItem newItem) {
        exerciseItemRepository.persist(newItem);
        return newItem ;
    }

    @Transactional
    public ExerciseItem updateItem(ExerciseItem update) {
        exerciseItemRepository.persist(update);
        return update;
    }

    @Transactional
    public void deleteItem(Long idSequence) {
        exerciseItemRepository.delete(idSequence);
    }
}
//TODO REFACTOR METHODS