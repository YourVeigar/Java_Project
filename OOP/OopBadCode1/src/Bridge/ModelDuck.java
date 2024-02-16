package Bridge;

public class ModelDuck extends Duck {
    protected ModelDuck(Capabilities capabilities) {
        super(capabilities);
    }

    public void duckCapabilities() {
        System.out.println("I'm a real Model duck");
        capabilities.quackandfly();
    }

}
