package num;

public abstract class Duck {

    FlyBehavior fliBehavior;
    QuackBehavior quackBehavior;

    public Duck() {
    }

    public abstract void display();

    public void performFly() {
        fliBehavior.fly();
    }

    public void performQuack() {
        quackBehavior.quack();
    }

    public void swim() {
        System.out.println("All ducks float, even decoys!");
    }

    public void setFliBehavior (FlyBehavior fb) {
        fliBehavior = fb;
    }

    public void setQuackBehavior (QuackBehavior qb) {
        quackBehavior = qb;
    }

}
