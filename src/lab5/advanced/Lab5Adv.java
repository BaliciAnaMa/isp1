package lab5.advanced;

public class Lab5Adv {
    public static void main(String[] args) {
        //primul obiect
        NewIntCalculator intCalc = new NewIntCalculator();
        int primObiect = (Integer) intCalc.init(10).add(5).subtract(3).multiply(2).result();
        System.out.println("Rezultat prim obiect " + primObiect);
        //al doilea obiect
        DoubleCalculator doubleCalc = new DoubleCalculator();
        Double doiObiect = (Double) doubleCalc.init(10.0).add(5.0).subtract(3.3).multiply(2.2).result();
        System.out.println("Rezultatul al doilea obiect " + doiObiect);
    }
}
