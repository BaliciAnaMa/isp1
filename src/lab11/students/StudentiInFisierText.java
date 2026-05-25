package lab11.students;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

public class StudentiInFisierText implements StudentiExport {
    private String fileName;

    public StudentiInFisierText(String fileName) {
        this.fileName = fileName;
    }

    public void doExport(List<Student> studenti) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(fileName))) {
            for (Student s : studenti) {
                writer.write(s.getNume() + "," + s.getPrenume() + "," +
                        s.getNrMatricol() + "," + s.getFormatieDeStudiu() + "," + s.getNota());
                writer.newLine();
            }
            System.out.println("Export TXT realizat cu succes: " + fileName);
        } catch (IOException e) {
            System.err.println("Eroare la export TXT: " + e.getMessage());
        }
    }
}
