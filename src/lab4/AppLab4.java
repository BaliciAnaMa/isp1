package lab4;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class AppLab4 {
    static void main() {
        //problema 4.5.1
        HashMap<String, Integer> varste = new HashMap<>();
        varste.put("Ioan", 21);
        varste.put("Maria", 22);
        varste.put("Victor", 20);
        varste.put("Simina", 20);
        varste.put("Marius", 21);
        varste.put("Mihai", 21);
        varste.put("Daniela", 23);
        System.out.println(" ");
        System.out.println("Varstele initiale->" + varste);
        varste.put("Vlad", 19);
        varste.put("Iulia", 19);
        System.out.println(" ");
        System.out.println("Varstele schimbate->" + varste);
        Map<String, String> adrese = Map.of("Ioan", "Sibiu", "Maria", "Bucuresti", "Victor",
                "Cluj", "Simina", "Alba-Iulia", "Marius", "Medias", "Mihai", "Cisnadie", "Daniela", "Sibiu");
        HashMap<String, Tanar> tineri = new HashMap<>();
        for (String nume : varste.keySet()) {
            int varsta = varste.get(nume);
            String adresa = adrese.getOrDefault(nume, "Necunoscuta");
            Tanar t = new Tanar(nume, varsta, adresa);
            tineri.put(nume, t);
        }
        System.out.println(" ");
        for (String cheie : tineri.keySet()) {
            System.out.println(cheie + "->" + tineri.get(cheie));
        }

        //problema 4.5.2
        Map<String, Student> mapStudenti = new HashMap<>();
        try {
            Path caleFisier = Paths.get("src/lab4/Studentii.txt");
            List<String> linieStudenti = Files.readAllLines(caleFisier);
            for (String linieStudent : linieStudenti) {
                String[] campuriStudent = linieStudent.split(",");
                String nrmatricol = campuriStudent[0];
                String prenume = campuriStudent[1];
                String nume = campuriStudent[2];
                String formatieDeStudiu = campuriStudent[3];
                mapStudenti.put(nrmatricol, new Student(nume, prenume, nrmatricol, formatieDeStudiu));
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
        try {
            Path caleNote = Paths.get("src/lab4/note_anon.txt");
            List<String> linieNote = Files.readAllLines(caleNote);

            for (String linieNota : linieNote) {
                String[] campuriNota = linieNota.split(",");
                String nrMatricolNota = campuriNota[0];
                double notaStudent = Double.parseDouble(campuriNota[1]);
                Student studentGasit = mapStudenti.get(nrMatricolNota);
                if (studentGasit != null) {
                    studentGasit.SetNota(notaStudent);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println(" ");
        for (Student studentCurent : mapStudenti.values()) {
            System.out.println(studentCurent);
        }
        //problema 4.5.3
        System.out.println(" ");
        System.out.println("Verifica Studenti");
        HashMap<String, Student> mapDupaNume = new HashMap<>();
        for (Student studentCurent : mapStudenti.values()) {
            String cheie = studentCurent.getPrenume() + "-" + studentCurent.getNume();
            mapDupaNume.put(cheie, studentCurent);
        }
        double n1 = gasesteNota("Bianca", "Popescu", mapDupaNume);
        double n2 = gasesteNota("Ioan", "Popa", mapDupaNume);
        System.out.println("Nota Bianca Popescu->" + n1);
        System.out.println("Nota Ioan Popa->" + n2);
    }
    public static double gasesteNota(String prenume, String nume, HashMap<String, Student> studenti) {
        String cheie = prenume + "-" + nume;
        Student s = studenti.get(cheie);
        if (s != null) {
            return s.getNota();
        } else {
            return 0.0f;
        }
    }
}
