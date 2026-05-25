package lab11.students;

import java.util.List;

public class Exporter {
    public void startExport(StudentiExport strategy, List<Student> studenti) {
        strategy.doExport(studenti);
    }
}
