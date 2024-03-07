package br.com.nthing.item;

import java.util.List;

public interface IExerciseItemService {

    ExerciseItem findById(Long id);

    ExerciseItem insertItem(ExerciseItem newItem);

    void updateItem(ExerciseItem exerciseItem);

    void deleteItem(Long idSequence);

    List<ExerciseItem> listAll();
}
