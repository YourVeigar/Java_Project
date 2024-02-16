package Builder1;

public class Plan {
    String Hotel;
    String Ticket;
    String Eat;
    String Special;

    public Plan() {}

    @Override
    public String toString() {
        return "Plan{" +
                "Hotel='" + Hotel + '\'' +
                ", Ticket='" + Ticket + '\'' +
                ", Eat='" + Eat + '\'' +
                ", Special='" + Special + '\'' +
                '}';
    }

    public String getHotel() {
        return Hotel;
    }

    public String getTicket() {
        return Ticket;
    }

    public String getEat() {
        return Eat;
    }

    public String getSpecial() {
        return Special;
    }

    public void setHotel(String hotel) {
        Hotel = hotel;
    }

    public void setTicket(String ticket) {
        Ticket = ticket;
    }

    public void setEat(String eat) {
        Eat = eat;
    }

    public void setSpecial(String special) {
        Special = special;
    }
}
