package Bridge;

public class RubberDuck extends Duck {
    protected RubberDuck(Capabilities capabilities) {
        super(capabilities);
    }

    public void duckCapabilities() {
        System.out.println("I'm a real Rubber duck");
        capabilities.quackandfly();
    }
}
