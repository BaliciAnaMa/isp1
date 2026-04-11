package lab6.Test;
import lab6.advance.DoubleCalculator;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class DoubleCalculatorTest {
    @Test
    public void testDoublePrecision() {
        DoubleCalculator calc = new DoubleCalculator();
        calc.init();

        calc.add(5.5).multiply(2.0);

        assertEquals(11.0, calc.result(), 0.0001);
    }

    @Test
    public void testInmultireCuZero() {
        DoubleCalculator calc = new DoubleCalculator();
        calc.init();

        calc.add(15.5);
        calc.multiply(0.0);

        assertEquals(0.0, calc.result(), 0.0001);
    }
}
