package lab10.students;

import java.util.Objects;

public class StudentBursieri extends Student {
    private double cuantumBursa;
    public StudentBursieri(int id, String prenume, String nume, String grupa, double medie, double bursa) {
        this.nrmatricol = "" + id;
        this.prenume = prenume;
        this.nume = nume;
        this.formatieDeStudiu = grupa;
        this.SetNota(medie);
        this.cuantumBursa = bursa;
    }
    public double getCuantumBursa() {return cuantumBursa;}
    public String getFormatieDeStudiu() {return formatieDeStudiu;}
    public String getNume() {return nume;}
    public String getPrenume() {return prenume;}

    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        StudentBursieri student = (StudentBursieri) o;
        return Objects.equals(nrmatricol, student.nrmatricol) && this.cuantumBursa == student.cuantumBursa;
    }

    public int hashCode() {
        return Objects.hash(nrmatricol,cuantumBursa);
    }
    public String toString() {
        return "ID: " + nrmatricol + ", Nume: " + nume + " " + prenume +
                ", Grupa: " + formatieDeStudiu + ", Nota: " + getNota() +
                ", Bursa: " + cuantumBursa;
    }

}
