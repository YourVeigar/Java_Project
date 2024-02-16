package Builder1;

public interface PlanBuilder {
    PlanBuilder setHotel(String Hotel);
    PlanBuilder setTicket (String Ticket);
    PlanBuilder setEat (String Eat);
    PlanBuilder setSpecial (String Special);
    Plan build();
}
