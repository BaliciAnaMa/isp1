package lab11.students.decorator;
import lab11.students.*;

import java.util.Arrays;
import java.util.List;

public class AplicatieCuDecorator {
    public static void main(String[] args) {
        List<Student> studentiCuNote = Arrays.asList(
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

        List<StudentiExport> strategies = Arrays.asList(
                new StudentiInConsola(),
                new StudentiInFisierText("studentiStrategyText.txt"),
                new StudentiInFisierXlsx("studentiStrategyExcel.xlsx")
        );

        for (StudentiExport strategy : strategies) {
            TimeExecutionDecorator decorator = new TimeExecutionDecorator(strategy, studentiCuNote);
            long time = decorator.executionTime();

            System.out.println("Execution time: " + time + " for " + strategy.getClass().getSimpleName());
            System.out.println();
        }
    }
}
