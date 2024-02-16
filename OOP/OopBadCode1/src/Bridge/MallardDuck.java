package Bridge;

public class MallardDuck extends Duck {
    protected MallardDuck(Capabilities capabilities) {
        super(capabilities);
    }

    public void duckCapabilities() {
        System.out.println("I'm a real Mallard duck");
        capabilities.quackandfly();
    }

}
