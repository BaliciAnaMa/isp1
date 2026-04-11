package lab6.Test;
import lab6.advance.DoubleCalculator;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class DoubleCalculatorTest {
    @Test
    public void testAddPositive() {
        DoubleCalculator calc = new DoubleCalculator().init();
        assertEquals(15.5, calc.add(10.0).add(5.5).result(), 0.0001);
    }

    @Test
    public void testAddNegatives() {
        DoubleCalculator calc = new DoubleCalculator().init();
        assertEquals(-15.5, calc.add(-10.0).add(-5.5).result(), 0.0001);
    }

    @Test
    public void testSubtractPositives() {
        DoubleCalculator calc = new DoubleCalculator().init();
        assertEquals(4.5, calc.add(10.0).subtract(5.5).result(), 0.0001);
    }

    @Test
    public void testSubtractNegatives() {
        DoubleCalculator calc = new DoubleCalculator().init();
        assertEquals(-4.5, calc.add(-10.0).subtract(-5.5).result(), 0.0001);
    }

    @Test
    public void testMultiplyPositives() {
        DoubleCalculator calc = new DoubleCalculator().init();
        assertEquals(50.0, calc.add(10.0).multiply(5.0).result(), 0.0001);
    }

    @Test
    public void testMultiplyNegatives() {
        DoubleCalculator calc = new DoubleCalculator().init();
        assertEquals(50.0, calc.add(-10.0).multiply(-5.0).result(), 0.0001);
    }

    @Test
    public void testMultiplyBy0() {
        DoubleCalculator calc = new DoubleCalculator().init();
        assertEquals(0.0, calc.add(10.0).multiply(0.0).result(), 0.0001);
    }

    @Test
    public void testDividePositives() {
        DoubleCalculator calc = new DoubleCalculator().init();
        assertEquals(2.0, calc.add(10.0).divide(5.0).result(), 0.0001);
    }

    @Test
    public void testDivideNegatives() {
        DoubleCalculator calc = new DoubleCalculator().init();
        assertEquals(2.0, calc.add(-10.0).divide(-5.0).result(), 0.0001);
    }

}
