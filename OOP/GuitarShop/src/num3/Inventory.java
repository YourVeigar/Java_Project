package num3;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class Inventory {
    private List guitars;

    public Inventory() {
        guitars = new LinkedList();
    }

    public void addGuitar(String serialNumber, double price, Builder builder, String model, Type type, Wood backWood, Wood topWood) {
        Guitar guitar = new Guitar(serialNumber, price, builder, model, type, backWood, topWood);
        guitars.add(guitar);
    }

    public Guitar getGuitar(String serialNumber) {
        for (Iterator i = guitars.iterator(); i.hasNext(); ) {
            Guitar guitar = (Guitar) i.next();
            if (guitar.getSerialNumber().equals(serialNumber)) {
                return guitar;
            }
        }
        return null;
    }

    public List search(Guitar searchGuitar) {
        List matchingGuitars = new LinkedList();
        for (Iterator i = guitars.iterator(); i.hasNext(); ) {
            Guitar guitar = (Guitar)i.next();
            //String builder = searchGuitar.getBuilder();
            if (searchGuitar.getBuilder() != guitar.getBuilder())
                continue;
            String model = searchGuitar.getModel();
            if ((model != null) && (!model.equals("")) && (!model.equals(guitar.getModel())))
                continue;
            //String type = searchGuitar.getType();
            if (searchGuitar.getType() != guitar.getType())
                continue;
            //String backWood = searchGuitar.getBackWood();
            if (searchGuitar.getBackWood() != guitar.getBackWood())
                continue;
            //String topWood = searchGuitar.getTopWood();
            if (searchGuitar.getBackWood() != guitar.getBackWood())
                continue;
            matchingGuitars.add(guitar);
        }
        return matchingGuitars;
    }
}
