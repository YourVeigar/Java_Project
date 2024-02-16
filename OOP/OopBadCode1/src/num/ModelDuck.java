package num;

import num.Duck;
import num.FlyNoWay;

public class ModelDuck extends Duck {
    public ModelDuck() {
        fliBehavior = new FlyNoWay();
        quackBehavior = new Quack();
    }

    public void display() {
        System.out.println("I'm a model duck");
    }
}
