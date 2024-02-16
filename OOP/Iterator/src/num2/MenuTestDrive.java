package num2;

import num1.DinerMenu;
import num1.PancakeHouseMenu;
import num1.Waitress;

import java.util.ArrayList;

public class MenuTestDrive {
    public static void main(String args[]) {
        num1.PancakeHouseMenu pancakeHouseMenu = new PancakeHouseMenu();
        num1.DinerMenu dinerMenu = new DinerMenu();
        num1.Waitress waitress = new Waitress(pancakeHouseMenu, dinerMenu);
        waitress.printMenu();
    }
}
