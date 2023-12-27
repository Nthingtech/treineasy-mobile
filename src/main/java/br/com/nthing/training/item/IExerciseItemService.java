package br.com.nthing.training.item;

public interface IExerciseItemService {

    ExerciseItem insertItem(ExerciseItem newItem);

    ExerciseItem updateItem(ExerciseItem update);

    public void deleteItem(Integer idSequence);
}
