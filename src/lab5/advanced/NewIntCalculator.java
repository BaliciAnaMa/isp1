package lab5.advanced;

public class NewIntCalculator extends ACalculator{
    public NewIntCalculator init(Object value) {
        this.state = (Integer) value;
        return this;
    }
    public NewIntCalculator add(Integer value) {
        this.state = (Integer) this.state + value;
        return this;
    }
    public NewIntCalculator subtract(Integer value) {
        this.state = (Integer) this.state - value;
        return this;
    }
    public NewIntCalculator multiply(Integer value) {
        this.state = (Integer) this.state * value;
        return this;
    }
}
