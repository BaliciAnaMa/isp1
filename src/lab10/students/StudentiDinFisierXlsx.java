package lab10.students;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class StudentiDinFisierXlsx implements StudentiExport{
    private String fileName;
    public StudentiDinFisierXlsx(String fileName) {
        this.fileName = fileName;
    }

    public void doExport(List<Student> studenti) {
        List<Student> studentiCititi = new ArrayList<>();
        try (FileInputStream fis = new FileInputStream(fileName);
             Workbook workbook = new XSSFWorkbook(fis)) {

            Sheet sheet = workbook.getSheetAt(0);
            boolean firstRow = true;

            for (Row row : sheet) {
                if (firstRow) {
                    firstRow = false;
                    continue;
                }
                if (row.getCell(0) == null) continue;

                String nume           = row.getCell(0).getStringCellValue();
                String prenume        = row.getCell(1).getStringCellValue();
                String nrMatricol     = row.getCell(2).getStringCellValue();
                String formatieStudiu = row.getCell(3).getStringCellValue();
                double nota           = row.getCell(4).getNumericCellValue();

                studentiCititi.add(new Student(nume, prenume, nrMatricol, formatieStudiu, nota));
            }

            System.out.println("Studenti cititi din " + fileName + ":");
            for (Student s : studentiCititi) {
                System.out.println(s);
            }

        } catch (IOException e) {
            System.err.println("Eroare la citire XLSX: " + e.getMessage());
        }
    }
}
