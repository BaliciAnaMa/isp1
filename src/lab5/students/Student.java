package lab5.students;

import java.util.Objects;

public class Student {
    protected String nume,prenume,nrmatricol,formatieDeStudiu;
    protected double nota;
    public Student(String nume, String prenume, String nrmatricol, String formatieDeStudiu)
    {
        this.nume=nume;
        this.prenume=prenume;
        this.nrmatricol=nrmatricol;
        this.formatieDeStudiu=formatieDeStudiu;
        this.nota = 0.0;
    }
    public Student() {}
    public String toString()
    {
        return nume + " " + prenume + " " + nrmatricol + " " + formatieDeStudiu+" "+nota;
    }
    public String getNume() {return nume;}
    public String getPrenume() {return prenume;}
    public double getNota() {return nota;}
    public String getNrMatricol() {return nrmatricol;}
    public void SetNota(double nota) {this.nota = nota;}

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
