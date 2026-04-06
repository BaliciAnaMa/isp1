package lab5;

public class AppLab5 {
    static void main() {
        //problema 5.5.1 a)
        IntCalculator calculator = new IntCalculator(10);
        int result = calculator.add(5).subtract(3).multiply(2).result();
        System.out.println(result);
        calculator.clear();
        System.out.println("Dupa stergere :");
        System.out.println(calculator.result());
        //problema 5.5.1 b)
        AdvancedCalculator advCalc = new AdvancedCalculator(2);
        int Rezultatul1 = advCalc.power(10).result();
        System.out.println("2^10 = " + Rezultatul1);

        AdvancedCalculator advCalc2 = new AdvancedCalculator(27);
        int Rezultatul2 = advCalc2.nthRoot(3).result();
        System.out.println(" radical de ordin 3 din 27 = " + Rezultatul2);

        AdvancedCalculator advCalc3 = new AdvancedCalculator(100);
        int Rezultatul3 = advCalc3.divide(4).result();
        System.out.println("100 / 4 = " + Rezultatul3);

       AdvancedCalculator advCalc4 = new AdvancedCalculator(3);
        int Rezultatul4 = advCalc4.power(3).add(1).divide(7).result();
        System.out.println("(3^3 + 1) / 7 = " + Rezultatul4);
    }
}
