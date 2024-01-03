package br.com.nthing.exercise;

import io.quarkus.test.InjectMock;
import io.quarkus.test.junit.QuarkusTest;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

@QuarkusTest
public class ExerciseTests {

    /*@InjectMock
    private ExerciseService service;*/

    @InjectMock
    private Exercise exer;

    @InjectMock
    private  ExerciseRepository repo;

    @Test
    public void  shouldRegisterExercise() {
        Mockito.doNothing().when(repo).persist(exer);
        Assertions.assertNotNull(exer.getId());

    }

    @Test
    public void shouldFindId() {}

    @Test
    public void shouldNotFindId() {}

    @Test
    public void shouldReturnListWithKeywordExercise() {}

    @Test
    public void shouldReturnListWithKeywordMuscleGroup() {}


}


