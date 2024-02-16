package num4;

import java.util.ArrayList;

public class MenuTestDrive {
    public static void main(String args[]) {
        ArrayList<Menu> menus = new ArrayList<Menu>();
        PancakeHouseMenu pancakeHouseMenu = new PancakeHouseMenu();
        DinerMenu dinerMenu = new DinerMenu();
        CafeMenu cafeMenu = new CafeMenu();
        menus.add(pancakeHouseMenu);
        menus.add(dinerMenu);
        menus.add(cafeMenu);
        Waitress waitress = new Waitress(menus);
        waitress.printMenu();
    }
}
