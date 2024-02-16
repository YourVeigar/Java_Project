package num;

import num.Duck;
import num.FlyRocketPowered;
import num.MallardDuck;

public class MiniDuckSimulator {
    public static void main(String[] args) {
        Duck mallard = new MallardDuck();
        mallard.performQuack();
        mallard.performFly();

        Duck model = new ModelDuck();
        model.performFly();
        model.setFliBehavior(new FlyRocketPowered());
        model.performFly();
    }
}
