package Build;

public class Plan {
    String Hotel;
    String Ticket;
    String Eat;
    String Special;

    private Plan(Builder builder) {
        Hotel = builder.Hotel;
        Ticket = builder.Ticket;
        Eat = builder.Eat;
        Special = builder.Special;
    }

    static class Builder {
        String Hotel;
        String Ticket;
        String Eat;
        String Special;

        public Builder setHotel(String hotel) {
            Hotel = hotel;
            return this;
        }

        public Builder setTicket(String ticket) {
            Ticket = ticket;
            return this;
        }

        public Builder setEat(String eat) {
            Eat = eat;
            return this;
        }

        public Builder setSpecial(String special) {
            Special = special;
            return this;
        }

        public  Plan build() {
            return new Plan(this);
        }
    }

    public static void main(String[] args) {
        Plan plan = new Builder().setHotel("f").setTicket("g").build();
        System.out.println(plan);
    }

    @Override
    public String toString() {
        return "Plan{" +
                "Hotel='" + Hotel + '\'' +
                ", Ticket='" + Ticket + '\'' +
                ", Eat='" + Eat + '\'' +
                ", Special='" + Special + '\'' +
                '}';
    }
}
