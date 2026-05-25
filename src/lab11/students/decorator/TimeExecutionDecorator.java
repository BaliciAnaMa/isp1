package lab11.students.decorator;
import lab11.students.Student;
import lab11.students.StudentiExport;

import java.util.List;

public class TimeExecutionDecorator extends TimeExecution {
    private List<Student> studenti;

    public TimeExecutionDecorator(StudentiExport exporter, List<Student> studenti) {
        super(exporter);
        this.studenti = studenti;
    }
    public long executionTime(List<Student> studenti) {
        return super.executionTime(studenti);
    }
    public long executionTime() {
        return this.executionTime(this.studenti);
    }

}
