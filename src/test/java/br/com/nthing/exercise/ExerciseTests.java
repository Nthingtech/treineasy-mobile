package br.com.nthing.exercise;

import io.quarkus.test.junit.QuarkusTest;
import jakarta.inject.Inject;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.util.ArrayList;

@QuarkusTest
public class ExerciseTests {


    @Inject
    private static ExerciseService service;
    private static Long idFound = 1L;
    private static Long idNotFound = 100L;
    private static Exercise newExercise;
    private static Exercise createdExercise;

    private static ArrayList<Exercise> exercisesList;

    @BeforeAll
    public static void setup() {
        System.out.println("CONFIG TESTE");
        newExercise = new Exercise();
        newExercise.setExercise("Cadeira Extensora");
        newExercise.setMuscleGroup("Quadríceps");
        newExercise.setMachineNumber(14);
        newExercise.setVideoUri("https://google.com");

        createdExercise = new Exercise();
        createdExercise.setExercise("Cadeira Extensora");
        createdExercise.setId(1L);
        createdExercise.setMuscleGroup("Quadríceps");
        createdExercise.setMachineNumber(14);
        createdExercise.setVideoUri("https://google.com");

        service = Mockito.mock(ExerciseService.class);
        Mockito.when(service.createNewExercise(newExercise)).thenReturn(new Exercise());
        Mockito.when(service.findById(idFound)).thenReturn(createdExercise);
        //TODO CRIAR NOTFIND ID RETURN NULL
        Mockito.when(service.searchByKeywordMuscleGroup("Q")).thenReturn(new ArrayList<Exercise>());
        Mockito.when(service.searchByKeywordExercise("Q")).thenReturn(new ArrayList<Exercise>());
        Mockito.when(service.getByKeyword("Q")).thenReturn(new ArrayList<Exercise>());
        Mockito.when(service.listAll()).thenReturn(new ArrayList<Exercise>());
        Mockito.when(service.alterExercise(1L, createdExercise)).thenReturn(createdExercise);
        Mockito.when(service.searchByKeywordExercise("Cadeira")).thenReturn(new ArrayList<Exercise>());


    }



    @Test
    public void  shouldRegisterExercise() {
        Assertions.assertNotNull(service.createNewExercise(newExercise));
    }

    @Test
    public void shouldFindId() {
        Assertions.assertNotNull(service.findById(idFound));
    }

    @Test
    public void shouldNotFindId() {
       // Assertions.(idNotFound);
    }

    @Test
    public void shouldReturnListWithKeywordExercise() {}

    @Test
    public void shouldReturnListWithKeywordMuscleGroup() {}

    @Test
    public void shouldAlterExercise(){
        createdExercise.setExercise("Cadeira Flexora");
        Exercise updateExercise = service.alterExercise(1L, createdExercise);
        Assertions.assertEquals("Cadeira Flexora", updateExercise.getExercise());

    }

}


