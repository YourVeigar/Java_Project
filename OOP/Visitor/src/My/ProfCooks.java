package My;

public class ProfCooks implements Cooks{
    @Override
    public void cooked(Cake cake) {
        System.out.println("Cooked delightful cake...");
    }

    @Override
    public void cooked(Donut donut) {
        System.out.println("Cooked delightful donut...");
    }

    @Override
    public void cooked(Pancake pancake) {
        System.out.println("Cooked delightful pancake...");
    }
}
