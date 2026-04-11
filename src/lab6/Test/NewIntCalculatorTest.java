package lab6.Test;
import lab6.advance.NewIntCalculator;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class NewIntCalculatorTest {

    @Test
    public void testComplexOperation() {
        NewIntCalculator calc = new NewIntCalculator();
        calc.init();

        calc.add(10).subtract(2).multiply(3);

        assertEquals(24, calc.result(), "Rezultatul ar trebui să fie 24");
    }

    @Test
    public void testImpartireLaZero() {
        NewIntCalculator calc = new NewIntCalculator();
        calc.init();
        calc.add(10);

        calc.divide(0);
    }
}
