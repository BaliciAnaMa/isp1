package lab5.advanced;

public class DoubleCalculator extends ACalculator{
    public DoubleCalculator init(Object value) {
        this.state = (Double) value;
        return this;
    }
    public DoubleCalculator add(Double value) {
        this.state = (Double) this.state + value;
        return this;
    }
    public DoubleCalculator subtract(Double value) {
        this.state = (Double) this.state - value;
        return this;
    }
    public DoubleCalculator multiply(Double value) {
        this.state = (Double) this.state * value;
        return this;
    }
}
