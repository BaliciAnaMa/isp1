package lab5.advanced;

public abstract class ACalculator {
    protected Object state;
    public abstract ACalculator init(Object value);
    public Object result() {
        return this.state;
    }
    public void clear() {
        this.state = 0;
    }
}
