package lab5.students;

import java.io.FileWriter;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<StudentBursieri> bursieri = new ArrayList<>();
        bursieri.add(new StudentBursieri(1025, "Andrei", "Popa", "ISM142/2", 8.70, 725.50));
        bursieri.add(new StudentBursieri(1024, "Ioan", "Mihalcea", "ISM141/1", 9.80, 801.10));
        bursieri.add(new StudentBursieri(1026, "Anamaria", "Prodan", "TI131/1", 8.90, 745.50));
        bursieri.add(new StudentBursieri(1029, "Bianca", "Popescu", "TI131/1", 9.10, 780.80));
        salvareinFisier("src/lab5/students/bursieri_out.txt", bursieri);
    }
    public static void salvareinFisier(String numeFisier, List<StudentBursieri> lista) {
        try {
            FileWriter fisier = new FileWriter(numeFisier);
            for (StudentBursieri s : lista) {
                fisier.write(s.toString() + "\n ");
            }
            fisier.close();
            System.out.println("Salvat in fisier");

        } catch (Exception e) {
            System.out.println("Eroare la fisier");
        }
    }
}
