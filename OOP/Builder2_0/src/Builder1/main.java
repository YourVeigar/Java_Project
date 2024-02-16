package Builder1;

public class main {
    public static void main(String[] args) {
        Plan plan1 = new PlanBuilderImpl().setHotel("Hotel").setTicket("Билеты в парк").setEat("Обед").build();
        Plan plan2 = new PlanBuilderImpl().setHotel("Гостиница").setTicket("Билеты в парк").setSpecial("Паттерны на льду").setEat("Обед").build();
        Plan plan3 = new PlanBuilderImpl().setTicket("Билеты в парк").setHotel("Гостиница").setSpecial("Цирк паттернов").build();

        System.out.println("1 День:");
        System.out.println(plan1);
        System.out.println("2 День:");
        System.out.println(plan2);
        System.out.println("3 День:");
        System.out.println(plan3);

    }
}
