package lab10.students;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class StudentiDinFisierText implements StudentiExport {
    private String fileName;

    public StudentiDinFisierText(String fileName) {
        this.fileName = fileName;
    }

    public void doExport(List<Student> studenti) {
        List<Student> studentiCititi = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(",", 5);
                if (parts.length == 5) {
                    String nume            = parts[0].trim();
                    String prenume         = parts[1].trim();
                    String nrMatricol      = parts[2].trim();
                    String formatieStudiu  = parts[3].trim();
                    double nota            = Double.parseDouble(parts[4].trim());
                    studentiCititi.add(new Student(nume, prenume, nrMatricol, formatieStudiu, nota));
                }
            }
            System.out.println("Studenti cititi din " + fileName + ":");
            for (Student s : studentiCititi) {
                System.out.println(s);
            }
        } catch (IOException e) {
            System.err.println("Eroare la citire TXT: " + e.getMessage());
        }
    }
}
