package lab11.students;

import java.util.Arrays;
import java.util.List;

public class AplicatieCuStrategy {
    static void main() {
        List<Student> studenti = Arrays.asList(
                new Student("Popa", "Andrei", "1025", "ISM141/2", 8.70),
                new Student("Mihalcea", "Ioan", "1024", "ISM141/1", 10),
                new Student("Prodan", "Anamaria", "1026", "TI131/1", 8.90),
                new Student("Popescu", "Bianca", "1029", "TI131/1", 10),
                new Student("Pana", "Maria", "1029", "TI131/2", 4.10),
                new Student("Mohanu", "Gabriela", "1029", "TI131/2", 7.33),
                new Student("Nasta", "Marius", "1029", "TI131/2", 3.20),
                new Student("Nasta", "Marius", "1029", "TI131/1", 5.12),
                new Student("Dobrescu", "Andrei", "1029", "TI131/2", 2.22)
        );
        Exporter exporter = new Exporter();
        //a
        StudentiExport consola = new StudentiInConsola();
        exporter.startExport(consola, studenti);
         //b
        String fileNameTxt = "studentiStrategyText.txt";
        StudentiExport fisierText = new StudentiInFisierText(fileNameTxt);
        exporter.startExport(fisierText, studenti);
        //c
        String fileNameXlsx = "studentiStrategyExcel.xlsx";
        StudentiExport fisierXlsx = new StudentiInFisierXlsx(fileNameXlsx);
        exporter.startExport(fisierXlsx, studenti);
        System.out.println();
        //d
        StudentiExport dinTxt = new StudentiDinFisierText(fileNameTxt);
        exporter.startExport(dinTxt, studenti);
        System.out.println();
        //e
        StudentiExport dinXlsx = new StudentiDinFisierXlsx(fileNameXlsx);
        exporter.startExport(dinXlsx, studenti);
    }
}
