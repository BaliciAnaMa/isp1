package lab3;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class LAB3 {
    public static void main(String[] args) {
        //problema 1
        try {
            Path caleFisier = Paths.get("src/lab3/in.txt");
            List<String> lines = Files.readAllLines(caleFisier);
            List<String> Rezultatul = new ArrayList<>();
            List<String> Rezultatul1 = new ArrayList<>();
            for (int i = 0; i < lines.size(); i++) {
                String line = lines.get(i);
                Rezultatul.add(line + "\n");
            }
            System.out.println("problema 1 a)");
            for (int i = 0; i < Rezultatul.size(); i++) {
                System.out.print(Rezultatul.get(i));
            }

            for (int i = 0; i < lines.size(); i++) {
                String line = lines.get(i);
                String[] parts = line.split("\\.");
                StringBuilder sb = new StringBuilder();
                for (int j = 0; j < parts.length; j++) {
                    sb.append(parts[j].trim());
                    if (j < parts.length - 1) {
                        sb.append(".\n");
                    }
                }
                Rezultatul1.add(sb.toString());

            }
            System.out.println("problema 1 b)");
            for (int i = 0; i < Rezultatul1.size(); i++) {
                System.out.println(Rezultatul1.get(i));
            }
            List<String> finalOutput = new ArrayList<>();
            finalOutput.addAll(Rezultatul);
            finalOutput.addAll(Rezultatul1);

            Files.write(Paths.get("out.txt"), finalOutput);

        } catch (IOException e) {
            e.printStackTrace();
        }
  //problema 2
        try {
            List<String> lines = Files.readAllLines(Paths.get("src/lab3/studenti_in.txt"));
            List<Student> studenti = new ArrayList<>();
            for (String line : lines) {
                if (line.trim().isEmpty()) continue;
                String[] parts = line.split(",");
                String nrmatricol = parts[0].trim();
                String prenume = parts[1].trim();
                String nume = parts[2].trim();
                String formatieDeStudiu = parts[3].trim();
                studenti.add(new Student(nume, prenume, nrmatricol, formatieDeStudiu));
            }
            System.out.println(" Studenti cititi");
            for (Student s : studenti) {
                System.out.println(s);
            }
            Collections.sort(studenti, (s1, s2) -> s1.getNume().compareTo(s2.getNume()));

            List<String> output = new ArrayList<>();
            for (Student s : studenti) {
                output.add(s.toString());
            }

            Files.write(Paths.get("studenti_out.txt"), output);

        } catch (IOException e) {
            e.printStackTrace();
        }
      }
  }


