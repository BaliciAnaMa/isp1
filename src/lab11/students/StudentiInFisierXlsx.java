package lab11.students;

import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;

public class StudentiInFisierXlsx implements StudentiExport {
    private String fileName;

    public StudentiInFisierXlsx(String fileName) {
        this.fileName = fileName;
    }

    public void doExport(List<Student> studenti) {
        try (Workbook workbook = new XSSFWorkbook()) {
            Sheet sheet = workbook.createSheet("Studenti");

            CellStyle headerStyle = workbook.createCellStyle();
            Font font = workbook.createFont();
            font.setBold(true);
            headerStyle.setFont(font);

            Row header = sheet.createRow(0);
            String[] coloane = {"Nume", "Prenume", "Nr. Matricol", "Formatie de Studiu", "Nota"};
            for (int i = 0; i < coloane.length; i++) {
                Cell cell = header.createCell(i);
                cell.setCellValue(coloane[i]);
                cell.setCellStyle(headerStyle);
            }

            // Date
            for (int i = 0; i < studenti.size(); i++) {
                Student s = studenti.get(i);
                Row row = sheet.createRow(i + 1);
                row.createCell(0).setCellValue(s.getNume());
                row.createCell(1).setCellValue(s.getPrenume());
                row.createCell(2).setCellValue(s.getNrMatricol());
                row.createCell(3).setCellValue(s.getFormatieDeStudiu());
                row.createCell(4).setCellValue(s.getNota());
            }

            for (int i = 0; i < coloane.length; i++) {
                sheet.autoSizeColumn(i);
            }

            try (FileOutputStream fos = new FileOutputStream(fileName)) {
                workbook.write(fos);
            }
            System.out.println("Export XLSX realizat cu succes: " + fileName);

        } catch (IOException e) {
            System.err.println("Eroare la export XLSX: " + e.getMessage());
        }
    }
}
