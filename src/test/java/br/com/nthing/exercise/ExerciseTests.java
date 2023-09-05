package br.com.nthing.exercise;

import io.quarkus.test.InjectMock;
import io.quarkus.test.junit.QuarkusTest;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

@QuarkusTest
public class ExerciseTests {

    @InjectMock
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
        newExercise.setId(1L);
        newExercise.setMuscleGroup("blablabla");
        newExercise.setMachineNumber(14L);

        service = Mockito.mock(ExerciseService.class);
        Mockito.when(service.createNewExercise(newExercise)).thenReturn(createdExercise);
    }

    @Test
    public void shouldStoreExercise() {
        System.out.println("TESTE TESTE TESTE TESTE");
    }
}
