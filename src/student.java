public class student {
    private String nume,prenume,nrmatricol,formatieDeStudiu;
    public student(String nume,String prenume,String nrmatricol,String formatieDeStudiu)
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
}
