package br.com.nthing;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Main {
    public static void main(String[] args) {

        List<Pessoa> listaPessoas = new ArrayList<>();

        listaPessoas.add(new Pessoa(1L, "Felipe", 5, 0));
        listaPessoas.add(new Pessoa(2L, "Heitor", 5, 0));
        listaPessoas.add(new Pessoa(3L, "Luana", 5, 0));
        listaPessoas.add(new Pessoa(1L, "Felipe", 5, 0));
        listaPessoas.add(new Pessoa(2L, "Heitor", 5, 0));
        listaPessoas.add(new Pessoa(3L, "Luana", 5, 0));



        Set<Pessoa> setPessoas = new HashSet<>();

        setPessoas.add(new Pessoa(1L, "Felipe", 5, 0));
        setPessoas.add(new Pessoa(2L, "Heitor", 5, 0));
        setPessoas.add(new Pessoa(3L, "Luana", 5, 0));







    }
}
