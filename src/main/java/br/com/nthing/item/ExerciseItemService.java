package br.com.nthing.item;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;

@ApplicationScoped
public class ExerciseItemService {

    @Inject
    ExerciseItemRepository exerciseItemRepository;

    public ExerciseItem insertItem(ExerciseItem newItem) {
        exerciseItemRepository.persist(newItem);
        return newItem ;
    }

    public ExerciseItem updateItem(ExerciseItem update) {
        exerciseItemRepository.persist(update);
        return update; //TODO Teste update
    }

    public void deleteItem(Integer idSequence) {
        exerciseItemRepository.delete(idSequence);
    }
}
