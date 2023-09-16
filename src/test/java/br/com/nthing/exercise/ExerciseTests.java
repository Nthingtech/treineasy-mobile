package br.com.nthing.exercise;

import io.quarkus.test.junit.QuarkusTest;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mockito;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertNotNull;

@QuarkusTest
public class ExerciseTests {

    @InjectMocks
    private static ExerciseService service;
    private static Integer idFound = 1;
    private static Integer idNotFound = 100;
    private static Exercise newExercise;
    private static Exercise createdExercise;

    @BeforeAll
    public static void setup() {
        System.out.println("CONFIG TESTE");
        newExercise = new Exercise();
        newExercise.setExercise("Quadriceps");
        newExercise.setMuscleGroup("blablabla");
        newExercise.setMachineNumber(14);
        newExercise.setVideoUri("https://google.com");

        createdExercise = new Exercise();
        createdExercise.setExercise("Quadriceps");
        createdExercise.setId(1L);
        createdExercise.setMuscleGroup("blablabla");
        createdExercise.setMachineNumber(14);
        createdExercise.setVideoUri("https://google.com");

        service = Mockito.mock(ExerciseService.class);
        Mockito.when(service.createNewExercise(newExercise)).thenReturn(new Exercise());
        Mockito.when(service.findById(idFound)).thenReturn(createdExercise);
        Mockito.when(service.findById(idNotFound)).thenReturn(null);
        Mockito.when(service.searchByKeyword("Q")).thenReturn(new ArrayList<Exercise>());
        Mockito.when(service.listAll()).thenReturn(new ArrayList<Exercise>());
        Mockito.when(service.alterExercise(createdExercise)).thenReturn(createdExercise);
    }

    @Test
    public void shouldStoreExercise() {
        assertNotNull(service.createNewExercise(newExercise));
    }
}
