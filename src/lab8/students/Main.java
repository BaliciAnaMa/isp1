package lab8.students;

import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Row;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args)  throws IOException{
        /*List<StudentBursieri> bursieri = new ArrayList<>();
        bursieri.add(new StudentBursieri(1025, "Andrei", "Popa", "ISM140/2", 8.70, 725.50));
        bursieri.add(new StudentBursieri(1024, "Ioan", "Mihalcea", "ISM141/1", 9.80, 801.10));
        bursieri.add(new StudentBursieri(1026, "Anamaria", "Prodan", "TI131/1", 8.90, 745.50));
        bursieri.add(new StudentBursieri(1029, "Bianca", "Popescu", "TI131/1", 9.10, 780.80));
        salvareinFisier("src/lab5/students/bursieri_out.txt", bursieri);*/
        List<Student> studenti = new ArrayList<>();
        studenti.add(new Student("Pop", "Ana", "001", "ISM 211",9));
        studenti.add(new Student("Ion", "Maria", "002", "TI 211",8));
        studenti.add(new Student("Dan", "Alex", "003", "TI 211",7));
        studenti.add(new Student("Popa", "Ion", "004", "ISM 211",5));
        studenti.add(new Student("Rus", "Ioana", "005", "TI 211",10));
        String numeFisier = "laborator8_students.xls";
        writeToXls(studenti, numeFisier);

        List<Student> listaStudenti = readFromXls(numeFisier);
        System.out.println("Studenti cititi din excel:");
        for (Student student : listaStudenti) {
            System.out.println(student);
        }
    }
   /* public static void salvareinFisier(String numeFisier, List<StudentBursieri> lista) {
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
    }*/
   public static void writeToXls(List<Student> studenti, String numeFisier) throws IOException {
       HSSFWorkbook registru = new HSSFWorkbook();
       HSSFSheet file = registru.createSheet("Studenti");

       Row antet = file.createRow(0);
       antet.createCell(0).setCellValue("Nume");
       antet.createCell(1).setCellValue("Prenume");
       antet.createCell(2).setCellValue("Nr Matricol");
       antet.createCell(3).setCellValue("Formatie de Studiu");
       antet.createCell(4).setCellValue("Nota");

       int numarLinie = 1;
       for (Student student : studenti) {
           Row linie = file.createRow(numarLinie++);
           linie.createCell(0).setCellValue(student.getNume());
           linie.createCell(1).setCellValue(student.getPrenume());
           linie.createCell(2).setCellValue(student.getNrMatricol());
           linie.createCell(3).setCellValue(student.getFormatieDeStudiu());
           linie.createCell(4).setCellValue(student.getNota());
       }
       try (FileOutputStream iesire = new FileOutputStream(numeFisier)) {
           registru.write(iesire);
           System.out.println("Salvat in: " + numeFisier);
       }
       registru.close();
   }
    public static List<Student> readFromXls(String numeFisier) throws IOException {
        List<Student> listaStudenti = new ArrayList<>();
        try (FileInputStream intrare = new FileInputStream(numeFisier);
             HSSFWorkbook registru = new HSSFWorkbook(intrare)) {
            HSSFSheet file = registru.getSheetAt(0);
            for (Row linie : file) {
                if (linie.getRowNum() == 0) continue;
                Student student = new Student(
                        linie.getCell(0).getStringCellValue(),
                        linie.getCell(1).getStringCellValue(),
                        linie.getCell(2).getStringCellValue(),
                        linie.getCell(3).getStringCellValue(),
                        linie.getCell(4).getNumericCellValue()
                );
                student.SetNota(linie.getCell(4).getNumericCellValue());
                listaStudenti.add(student);
            }
        }
        return listaStudenti;
    }
}
