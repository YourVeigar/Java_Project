package My;

public class Table implements TableElement{
    TableElement[] tableElements;

    public Table() {
        this.tableElements = new TableElement[] {
                new Cake(),
                new Donut(),
                new Pancake()
        };
    }

    @Override
    public void beCooked(Cooks cooks) {
        for(TableElement element: tableElements) {
            element.beCooked(cooks);
        }
    }
}
