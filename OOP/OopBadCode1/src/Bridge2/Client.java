package Bridge2;

public class Client {
    public static void main(String[] args) {
        TVFactory tvFactory = new TVFactory();
        SpecialRemote remoteSony = new SpecialRemote(tvFactory);
        remoteSony.setTV("Sony");
        remoteSony.on();
        remoteSony.up();
        remoteSony.down();
        remoteSony.off();
        System.out.println("---------------------------");
        System.out.println();

        GenericRemote remoteLG = new GenericRemote(tvFactory);
        remoteLG.setTV("LG");
        remoteLG.on();
        remoteLG.nextChannel();
        remoteLG.prevChannel();
        remoteLG.off();
    }
}
