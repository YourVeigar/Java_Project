package linker2;

public class MenuTestDrive {
    public static void main(String[] args) {
        MenuComponent pancakeHouseMenu = new Menu("БЛИННОЕ МЕНЮ", "Завтрак");
        MenuComponent dinerMenu = new Menu("МЕНЮ ОБЕДА", "Обед");
        MenuComponent cafeMenu = new Menu("МЕНЮ КАФЕ", "Ужин");
        MenuComponent dessertMenu = new Menu("ДЕСЕРТНОЕ МЕНЮ", "Десерт");

        MenuComponent allMenus = new Menu("ВСЁ МЕНЮ", "Всё меню вместе");

        allMenus.add(pancakeHouseMenu);
        allMenus.add(dinerMenu);
        allMenus.add(cafeMenu);

        dinerMenu.add(new MenuItem("Паста", "Спагетти с соусом маринара и ломтик хлеба на закваске", true, 3.89));
        dinerMenu.add(new MenuItem("Вегетарианская БЛТ", "Соевой бекон с листьями салата и помидорами на цельнозерновой муке", true, 2.99));
        dinerMenu.add(new MenuItem("БЛТ", "Бекон с листьями салата и помидорами на цельнозерновой муке", false, 2.99));
        dinerMenu.add(new MenuItem("Суп дня", "Суп дня с картофельным салатом", false, 3.29));
        dinerMenu.add(new MenuItem("Хотдог", "Хот-дог с квашеной капустой, релишом, луком, посыпанный сыром", false, 3.05));
        dinerMenu.add(new MenuItem("Овощи на пару и коричневый рис", "Овощи на пару с коричневым рисом", true, 3.99));

        pancakeHouseMenu.add(new MenuItem("Завтрак с блинами от K&B", "Блинчики с яичницей и тостами", true, 2.99));
        pancakeHouseMenu.add(new MenuItem("Обычный блинный завтрак", "Блинчики с яичницей, колбасой", false, 2.99));
        pancakeHouseMenu.add(new MenuItem("Блинчики с черникой", "Блинчики со свежей черникой и черничным сиропом", true, 3.49));
        pancakeHouseMenu.add(new MenuItem("Вафли", "Вафли с черникой или клубникой на ваш выбор", true, 3.59));

        pancakeHouseMenu.add(new MenuItem("Вегетарианский бургер и картофель фри", "Вегетарианский бургер на цельнозерновой булочке, листьях салата, помидорах и картофеле фри", true, 3.99));
        pancakeHouseMenu.add(new MenuItem("Суп дня", "Чашка супа дня с гарниром", false, 3.69));
        pancakeHouseMenu.add(new MenuItem("Буррито", "Большой буррито с цельной фасолью пинто, сальсой и гуакамоле", true, 4.29));

        dinerMenu.add(dessertMenu);

        dessertMenu.add(new MenuItem("Яблочный пирог", "Яблочный пирог со слоеной корочкой, покрытый ванильным мороженым", true, 1.59));
        dessertMenu.add(new MenuItem("Чизкейк", "Сливочный чизкейк Нью-Йорк с шоколадной корочкой", true, 1.99));
        dessertMenu.add(new MenuItem("Сорбет", "Совок малины и совок лайма", true, 1.89));

        Waitress waitress = new Waitress(allMenus);

        waitress.printMenu();

        waitress.printVegetarianMenu();
    }
}
