package My;

public class Donut implements TableElement{
    @Override
    public void beCooked(Cooks cooks) {
        cooks.cooked(this);
    }
}
