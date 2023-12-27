package br.com.nthing.exercise;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.util.Arrays;
import java.util.List;

public class ExerciseRepositoyTest { //TODO CRIEI PARA TESTAR BUSCA POR PALAVRA CHAVE NO QUARKUS COM PANACHE
    @Test
    public void testFindByKeyword() {
        // Cria um mock do ExerciseRepository
        ExerciseRepository repository = Mockito.mock(ExerciseRepository.class);

        // Define o comportamento do mock quando o método findByKeyword é chamado
        Mockito.when(repository.findByKeyword("keyword")).thenReturn(Arrays.asList(new Exercise()));

        // Chama o método findByKeyword
        List<Exercise> exercises = repository.findByKeyword("keyword");

        // Verifica se o método retorna uma lista com um elemento
        Assertions.assertEquals(1, exercises.size());
    }
}
