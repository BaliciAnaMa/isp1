package lab11.students.decorator;

import lab11.students.Student;
import lab11.students.StudentiExport;

import java.util.List;

public abstract class TimeExecution implements ITimeExecution {
    protected StudentiExport exporter;

    public TimeExecution(StudentiExport exporter) {
        this.exporter = exporter;
    }

    public long executionTime(List<Student> studenti) {
        long timpInitial = System.currentTimeMillis();
        exporter.doExport(studenti);
        long timpFinal = System.currentTimeMillis();
        return timpFinal - timpInitial;
    }

}
