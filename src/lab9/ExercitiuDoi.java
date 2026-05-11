package lab9;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class ExercitiuDoi {
    static void main() {
        String text = "Acesta este un program scris in java pentru expresii lambda";

        List<String> cuvinte = Arrays.asList(text.split(" "));
        System.out.println("Cuvinte: " + cuvinte);

        List<String> lungimea = cuvinte.stream()
                .filter(c -> c.length() >= 5)
                .collect(Collectors.toList());
        System.out.println("a) Cuvinte cu lungime >= 5: " + lungimea);
        System.out.println("   Numar: " + lungimea.size());

        List<String> ordonate = lungimea.stream()
                .sorted()
                .collect(Collectors.toList());
        System.out.println("b) Ordonate: " + ordonate);

        Optional<String> cuvantP = ordonate.stream()
                .sorted(Comparator.reverseOrder())
                .filter(c -> c.startsWith("p"))
                .findFirst();
        if (cuvantP.isPresent()) {
            System.out.println("c) Primul cuvant cu 'p': " + cuvantP.get());
        }
    }
}
