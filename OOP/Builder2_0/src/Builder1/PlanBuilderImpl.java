package Builder1;

public class PlanBuilderImpl implements PlanBuilder{
    Plan plan = new Plan();
    @Override
    public PlanBuilder setHotel(String Hotel) {
        plan.Hotel = Hotel;
        return this;
    }

    @Override
    public PlanBuilder setTicket(String Ticket) {
        plan.Ticket = Ticket;
        return this;
    }

    @Override
    public PlanBuilder setEat(String Eat) {
        plan.Eat = Eat;
        return this;
    }

    @Override
    public PlanBuilder setSpecial(String Special) {
        plan.Special = Special;
        return this;
    }

    @Override
    public Plan build() {
        return plan;
    }
}
