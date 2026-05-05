package lab9;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class PrimulExercitiu {
    static void main() {
        List<Integer> lista = Arrays.asList(6, 12, 20, 5, 23, 10, 17, 9, 24, 14);
        System.out.println("Lista: " + lista);

        int suma = lista.stream()
                .reduce(0, (a, b) -> a + b);
        System.out.println("a) Suma: " + suma);

        System.out.println("b) Max: " + lista.stream().max(Comparator.naturalOrder()).get());
        System.out.println("   Min: " + lista.stream().min(Comparator.naturalOrder()).get());
        List<Integer> filtrata = lista.stream()
                .filter(n -> n >= 10 && n <= 20)
                .collect(Collectors.toList());
        System.out.println("c) Elemente: " + filtrata);

        List<Double> listaDouble = lista.stream()
                .map(n -> n.doubleValue())
                .collect(Collectors.toList());
        System.out.println("d) Lista: " + listaDouble);
        boolean are12 = lista.stream()
                .anyMatch(n -> n == 12);
        System.out.println("Contine valoare 12? " + are12);
    }
}
