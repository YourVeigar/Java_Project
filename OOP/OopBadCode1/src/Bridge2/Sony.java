package Bridge2;

public class Sony extends TV{
    int station = 0;
    public void on() {
        System.out.println("Включили телевизор Sony");
    }
    public void off() {
        System.out.println("Выключили телевизор Sony");
    }
    public void tuneChannel(int channel) {
        this.station = channel;
        System.out.println("Сейчас телевизор Sony показывает канал " + this.station);
    }
    public int getChannel() {
        return station;
    }
}
