package lab11.students;

import java.io.IOException;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args)  throws IOException{
        List<Student> studentiCuNote = Arrays.asList(
                new Student("Andrei",   "Popa",     "1025", "ISM141/2", 8.70),
                new Student("Ioan",     "Mihalcea", "1024", "ISM141/1", 10),
                new Student("Anamaria", "Prodan",   "1026", "TI131/1",  8.90),
                new Student("Bianca",   "Popescu",  "1029", "TI131/1",  10),
                new Student("Maria",    "Pana",     "1030", "TI131/2",  4.10),
                new Student("Gabriela", "Mohanu",   "1031", "TI131/2",  7.33),
                new Student("Marius",   "Nasta",    "1032", "TI131/2",  3.20),
                new Student("Marius",   "Nasta",    "1033", "TI131/1",  5.12),
                new Student("Andrei",   "Dobrescu", "1034", "TI131/2",  2.22)
        );

        List<Student> nota10 = studentiCuNote.stream()
                .filter(s -> s.getNota() == 10)
                .collect(Collectors.toList());
        System.out.println("a) Studenti cu nota 10:");
        nota10.forEach(s -> System.out.println("   " + s));

        List<Student> subCinci = studentiCuNote.stream()
                .filter(s -> s.getNota() < 5)
                .collect(Collectors.toList());
        System.out.println("b) Studenti cu nota sub 5:");
        subCinci.forEach(s -> System.out.println("   " + s));

        List<Student> notaMinima4 = studentiCuNote.stream()
                .map(s -> s.getNota() < 4 ? new Student(s.getNume(), s.getPrenume(), s.getNrMatricol(), s.getFormatieDeStudiu(), 4.0) : s)
                .sorted(Comparator.comparingDouble(Student::getNota).reversed())
                .collect(Collectors.toList());
        System.out.println("c) Lista cu nota minima 4:");
        notaMinima4.forEach(s -> System.out.println("   " + s));

        double suma = studentiCuNote.stream()
                .map(s -> s.getNota())
                .reduce(0.0, (rezultatPartial, nota) -> rezultatPartial + nota);
        System.out.println("d) Suma notelor: " + suma);

        double sumaPentruMedie = studentiCuNote.stream()
                .map(s -> s.getNota())
                .reduce(0.0, (a, b) -> a + b);

        double media = sumaPentruMedie / studentiCuNote.size();
        System.out.println("e) Media notelor: " + media);

    }
}
