package My;

public class JuniorCooks implements Cooks{
    @Override
    public void cooked(Cake cake) {
        System.out.println("Cooked ordinary cake...");
    }

    @Override
    public void cooked(Donut donut) {
        System.out.println("Cooked ordinary donut...");
    }

    @Override
    public void cooked(Pancake pancake) {
        System.out.println("Cooked ordinary pancake...");
    }
}
