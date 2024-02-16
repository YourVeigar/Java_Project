package Bridge2;

public class LG extends TV{
    int channel = 1;
    public void on() {
        System.out.println("Включили телевизор LG");
    }
    public void off() {
        System.out.println("Выключили телевизор LG");
    }
    public void tuneChannel(int channel) {
        this.channel = channel;
        System.out.println("Сейчас телевизор LG показывает канал " + this.channel);
    }
    public int getChannel() {
        return channel;
    }
}
