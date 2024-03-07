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
    public void updateItem(ExerciseItem exerciseItem) {
        exerciseItemRepository.updateExerciseItem(exerciseItem);
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