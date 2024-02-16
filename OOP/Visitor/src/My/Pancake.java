package My;

public class Pancake implements TableElement{
    @Override
    public void beCooked(Cooks cooks) {
        cooks.cooked(this);
    }
}
