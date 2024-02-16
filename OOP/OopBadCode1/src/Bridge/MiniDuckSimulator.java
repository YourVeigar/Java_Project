package Bridge;

public class MiniDuckSimulator {
    public static void main(String[] args) {
        Duck[] ducks = {
                new MallardDuck(new QuackFly()),
                new ModelDuck(new SilenceCantFly()),
                new RubberDuck(new QuackCantFly())
        };

        for (Duck duck: ducks) {
            duck.duckCapabilities();
            System.out.println("-----------------------------------------");
        }
    }
}
