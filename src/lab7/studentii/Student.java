package lab7.studentii;

import java.util.Objects;

public final class Student {
    private final String nume;
    private final String prenume;
    private final String nrmatricol;
    private final String formatieDeStudiu;
    private final double nota;

    public Student(String nume, String prenume, String nrmatricol, String formatieDeStudiu) {
        this.nume = nume;
        this.prenume = prenume;
        this.nrmatricol = nrmatricol;
        this.formatieDeStudiu = formatieDeStudiu;
        this.nota = 0.0;
    }
    public Student(String nume, String prenume, String nrmatricol, String formatieDeStudiu, double nota) {
        this.nume = nume;
        this.prenume = prenume;
        this.nrmatricol = nrmatricol;
        this.formatieDeStudiu = formatieDeStudiu;
        this.nota = nota;
    }
    public String getNume() {
        return nume;
    }
    public String getPrenume() {
        return prenume;
    }
    public double getNota() {
        return nota;
    }
    public String getNrMatricol() {
        return nrmatricol;
    }
    public String getFormatieDeStudiu() {
        return formatieDeStudiu;
    }
    public String toString() {
        return nume + " " + prenume + " " + nrmatricol + " " + formatieDeStudiu + " " + nota;
    }
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Student student = (Student) o;
        return Objects.equals(nrmatricol, student.nrmatricol);
    }
    public int hashCode() {
        return Objects.hash(nrmatricol);
    }
}
