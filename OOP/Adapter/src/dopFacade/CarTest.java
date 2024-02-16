package dopFacade;

public class CarTest {
    public static void main(String[] args) {
        Car car = new Car();
        Panel panel = new Panel();
        Radio radio = new Radio();
        CarFacade carFacade = new CarFacade(car, panel, radio);
        carFacade.driveCar();
        System.out.println("-----------------------------");
        carFacade.stopCar();
    }
}
