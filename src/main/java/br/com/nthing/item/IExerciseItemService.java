package br.com.nthing.item;

import java.util.List;

public interface IExerciseItemService {

    ExerciseItem findById(Long id);

    ExerciseItem insertItem(ExerciseItem newItem);

    ExerciseItem updateItem(Long id, ExerciseItem update);

    void deleteItem(Long idSequence);

    List<ExerciseItem> listAll();
}
