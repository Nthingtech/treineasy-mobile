package br.com.nthing.item;

import java.util.List;

public interface IExerciseItemService {

    ExerciseItem insertItem(ExerciseItem newItem);

    ExerciseItem updateItem(ExerciseItem update);

    public void deleteItem(Long idSequence);

    public List<ExerciseItem> listAll();
}
