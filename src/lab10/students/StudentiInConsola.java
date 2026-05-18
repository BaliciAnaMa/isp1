package lab10.students;

import java.util.List;

public class StudentiInConsola implements StudentiExport {
    public void doExport(List<Student> studenti) {
        System.out.println("Afișare în consolă:");
        for (Student s : studenti) {
            System.out.println(s);
        }
    }
}
