package lab6.students;
import lab6.students.StudentBursieri;
import lab6.students.AplicatieCuBursa;
import org.junit.jupiter.api.Test;
import java.util.ArrayList;
import java.util.List;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class AplicatieCuBursaTest {
    @Test
    public void testSorteaza() {
        AplicatieCuBursa app = new AplicatieCuBursa();
        List<StudentBursieri> lista = new ArrayList<>();

        lista.add(new StudentBursieri(1, "Zoe", "Popescu", "TI131", 9.0, 500.0));
        lista.add(new StudentBursieri(2, "Popescu", "Ana", "TI131", 9.0, 500.0));

        lista.add(new StudentBursieri(3, "Ionescu", "Dan", "ISM141", 8.0, 400.0));

        List<StudentBursieri> rezultat = app.sorteaza(lista);

        assertEquals("ISM141", rezultat.get(0).getFormatieDeStudiu(), "Primul student trebuie să fie din grupa ISM141");

        assertEquals("Ana", rezultat.get(1).getPrenume(), "După grupă și nume, prenumele Ana trebuie să fie înainte de Zoe");
        assertEquals("Zoe", rezultat.get(2).getPrenume());
    }

}
