package My;

public class Main {
    public static void main(String[] args) {
        Table table = new Table();

        Cooks junior = new JuniorCooks();
        Cooks prof = new ProfCooks();

        System.out.println("Junior cooked...");
        table.beCooked(junior);

        System.out.println("\n------------------------------------------\n");

        System.out.println("Professional cooked...");
        table.beCooked(prof);
    }
}
