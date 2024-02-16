package My;

public class Cake implements TableElement {
    @Override
    public void beCooked(Cooks cooks) {
        cooks.cooked(this);
    }
}
