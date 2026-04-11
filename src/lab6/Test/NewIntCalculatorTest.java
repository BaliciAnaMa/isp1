package lab6.Test;
import lab6.advance.NewIntCalculator;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class NewIntCalculatorTest {

        @Test
        public void testAddPositive() {
            NewIntCalculator calc = new NewIntCalculator().init();
            assertEquals(15, calc.add(10).add(5).result());
        }

        @Test
        public void testAddNegatives() {
            NewIntCalculator calc = new NewIntCalculator().init();
            assertEquals(-15, calc.add(-10).add(-5).result());
        }

        @Test
        public void testSubtractPositives() {
            NewIntCalculator calc = new NewIntCalculator().init();
            assertEquals(5, calc.add(10).subtract(5).result());
        }

        @Test
        public void testSubtractNegatives() {
            NewIntCalculator calc = new NewIntCalculator().init();
            assertEquals(-5, calc.add(-10).subtract(-5).result());
        }

        @Test
        public void testMultiplyPositives() {
            NewIntCalculator calc = new NewIntCalculator().init();
            assertEquals(50, calc.add(10).multiply(5).result());
        }

        @Test
        public void testMultiplyNegatives() {
            NewIntCalculator calc = new NewIntCalculator().init();
            assertEquals(50, calc.add(-10).multiply(-5).result());
        }

        @Test
        public void testMultiplyBy0() {
            NewIntCalculator calc = new NewIntCalculator().init();
            assertEquals(0, calc.add(10).multiply(0).result());
        }

        @Test
        public void testDividePositives() {
            NewIntCalculator calc = new NewIntCalculator().init();
            assertEquals(2, calc.add(10).divide(5).result());
        }

        @Test
        public void testDivideNegatives() {
            NewIntCalculator calc = new NewIntCalculator().init();
            assertEquals(2, calc.add(-10).divide(-5).result());
        }
    }


