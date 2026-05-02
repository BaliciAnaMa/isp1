package lab8;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class Laborator8 {
    static void main() throws IOException{
        String input   = "src/lab8/laborator8_input.xlsx";
        String output2 = "src/lab8/laborator8_output2.xlsx";
        String output3 = "src/lab8/laborator8_output3.xlsx";

        System.out.println(" Citire ");
        citireExcel(input);
        System.out.println("Output cu media");
        scriecuMedia(input, output2);
        System.out.println("Output formulaAverage");
        scrieFormulaAverage(input, output3);



    }
    public static void citireExcel(String filePath) throws IOException {
        try (FileInputStream fis = new FileInputStream(filePath);
             XSSFWorkbook workbook = new XSSFWorkbook(fis)) {

            XSSFSheet sheet = workbook.getSheetAt(0);

            for (Row row : sheet) {
                for (Cell cell : row) {
                    if (cell.getCellType() == CellType.STRING) {
                        System.out.print(cell.getStringCellValue() + "\t");
                    } else if (cell.getCellType() == CellType.NUMERIC) {
                        System.out.print((int) cell.getNumericCellValue() + "\t");
                    }
                }
                System.out.println();
            }
        }
    }

    public static void scriecuMedia(String inputPath, String outputPath) throws IOException {
        try (FileInputStream fis = new FileInputStream(inputPath);
             XSSFWorkbook workbook = new XSSFWorkbook(fis)) {

            XSSFSheet sheet = workbook.getSheetAt(0);
            XSSFWorkbook workbook2 = new XSSFWorkbook();
            XSSFSheet sheet2 = workbook2.createSheet();

            int rowNum = 0;
            for (Row row : sheet) {
                Row row2 = sheet2.createRow(rowNum++);
                int colNum = 0;
                for (Cell cell : row) {
                    Cell cell2 = row2.createCell(colNum++);
                    if (cell.getCellType() == CellType.STRING) {
                        cell2.setCellValue(cell.getStringCellValue());
                    } else if (cell.getCellType() == CellType.NUMERIC) {
                        cell2.setCellValue(cell.getNumericCellValue());
                    }
                }
                Cell mediaCell = row2.createCell(colNum);
                if (rowNum == 1) {
                    mediaCell.setCellValue("Media");
                } else {
                    double nota1 = row.getCell(3).getNumericCellValue();
                    double nota2 = row.getCell(4).getNumericCellValue();
                    double nota3 = row.getCell(5).getNumericCellValue();
                    mediaCell.setCellValue((nota1 + nota2 + nota3) / 3);
                }
            }
            try (FileOutputStream out = new FileOutputStream(outputPath)) {
                workbook2.write(out);
                System.out.println(" " + outputPath);
            }
            workbook2.close();
        }
    }
    public static void scrieFormulaAverage(String inputPath, String outputPath) throws IOException {
        try (FileInputStream fis = new FileInputStream(inputPath);
             XSSFWorkbook workbook = new XSSFWorkbook(fis)) {

            XSSFSheet sheet = workbook.getSheetAt(0);
            XSSFWorkbook workbook2 = new XSSFWorkbook();
            XSSFSheet sheet2 = workbook2.createSheet();

            int rowNum = 0;
            for (Row row : sheet) {
                Row row2 = sheet2.createRow(rowNum++);
                int colNum = 0;
                for (Cell cell : row) {
                    Cell cell2 = row2.createCell(colNum++);
                    if (cell.getCellType() == CellType.STRING) {
                        cell2.setCellValue(cell.getStringCellValue());
                    } else if (cell.getCellType() == CellType.NUMERIC) {
                        cell2.setCellValue(cell.getNumericCellValue());
                    }
                }
                Cell mediaCell = row2.createCell(colNum);
                if (rowNum == 1) {
                    mediaCell.setCellValue("Media");
                } else {
                    String formula = "AVERAGE(D" + rowNum + ":F" + rowNum + ")";
                    mediaCell.setCellFormula(formula);
                }
            }

            try (FileOutputStream out = new FileOutputStream(outputPath)) {
                workbook2.write(out);
                System.out.println("Generate: " + outputPath);
            }
            workbook2.close();
        }
    }

    }
