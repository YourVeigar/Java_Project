package refa;

public class DemoSingleThread {
    public static void main(String[] args) {
        System.out.println("Если вы видите одно и то же значение, значит синглтон был повторно использован (ура!)" + "\n" +
                "Если вы видите разные значения, значит, было создано 2 синглтона (бу-у-у!!)" + "\n\n" +
                "РЕЗУЛЬТАТ:" + "\n");
        Singleton singleton = Singleton.getInstance("4");
        Singleton anotherSingleton = Singleton.getInstance("8");
        System.out.println(singleton.value);
        System.out.println(anotherSingleton.value);
    }
}
