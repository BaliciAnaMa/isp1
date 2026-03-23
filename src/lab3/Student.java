package lab3;

import java.util.ArrayList;

public class Student {
    private String nume,prenume,nrmatricol,formatieDeStudiu;

    public Student(String nume, String prenume, String nrmatricol, String formatieDeStudiu)
    {
        this.nume=nume;
        this.prenume=prenume;
        this.nrmatricol=nrmatricol;
        this.formatieDeStudiu=formatieDeStudiu;
    }
    public String toString()
    {
        return nume + " " + prenume + " " + nrmatricol + " " + formatieDeStudiu;

    }
    public String getNume() {
        return nume;
    }

    public String getFormatieDeStudiu() {
        return formatieDeStudiu;
    }
   /* public static boolean existaStudent(ArrayList<Student> lista, Student studentCautat){

        for(Student s : lista){
            if(s.getPrenume().equals(studentCautat.getPrenume()) &&
                    s.getNume().equals(studentCautat.getNume()) &&
                    s.getFormatieDeStudiu().equals(studentCautat.getFormatieDeStudiu())){

                return true;
            }
        }
        return false;
    }*/
}
