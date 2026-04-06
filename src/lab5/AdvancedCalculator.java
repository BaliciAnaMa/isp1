package lab5;

public class AdvancedCalculator extends IntCalculator{
    public AdvancedCalculator(int initialValue) {
        this.state=initialValue;
    }
    public AdvancedCalculator add(int value) {
        this.state += value;
        return this;
    }
    public AdvancedCalculator subtract(int value) {
        this.state -= value;
        return this;
    }
    public AdvancedCalculator multiply(int value) {
        this.state *= value;
        return this;
    }
    public AdvancedCalculator divide(int value) {
        if (value == 0) {
            System.out.println("Nu merge impartire la 0");
            return this;
        }
        this.state = this.state / value;
        return this;
    }
    public AdvancedCalculator power(int exponent) {
        int rezultat = 1;
        for (int i = 0; i < exponent; i++) {
            rezultat = rezultat * this.state;
        }
        this.state = rezultat;
        return this;
    }
    public AdvancedCalculator nthRoot(int n)
    {
        if (n <= 0) {
            System.out.println("Ordin negativ");
            return this;
        }
        for (int x = 1; x <= this.state; x++)
        {
            int putere = 1;
            for (int i = 0; i < n; i++)
            {
                putere = putere * x;
            }
            if (putere == this.state)
            {
                this.state = x;
                return this;
            }
        }
        System.out.println("Nu este radacina intreaga ");
        return this;
    }


}
