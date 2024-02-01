package br.com.nthing.item;

public interface IExerciseItemService {

    ExerciseItem insertItem(ExerciseItem newItem);

    ExerciseItem updateItem(ExerciseItem update);

    public void deleteItem(Long idSequence);
}
