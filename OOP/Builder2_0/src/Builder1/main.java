package Builder1;

public class main {
    public static void main(String[] args) {
        Plan plan1 = new PlanBuilderImpl().setHotel("Hotel").setTicket("������ � ����").setEat("����").build();
        Plan plan2 = new PlanBuilderImpl().setHotel("���������").setTicket("������ � ����").setSpecial("�������� �� ����").setEat("����").build();
        Plan plan3 = new PlanBuilderImpl().setTicket("������ � ����").setHotel("���������").setSpecial("���� ���������").build();

        System.out.println("1 ����:");
        System.out.println(plan1);
        System.out.println("2 ����:");
        System.out.println(plan2);
        System.out.println("3 ����:");
        System.out.println(plan3);

    }
}
