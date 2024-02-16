package dopFacade;

public class CarFacade {
    Car car = new Car();
    Panel panel = new Panel();
    Radio radio = new Radio();

    public CarFacade(Car car, Panel panel, Radio radio) {
        this.car = car;
        this.panel = panel;
        this.radio = radio;
    }

    public void driveCar() {
        car.onСar();
        car.onFara();
        panel.onPanel();
        panel.speed();
        panel.povorot();
        panel.tdvig();
        radio.on();
        radio.volna();
    }

    public void stopCar() {
        radio.off();
        panel.offPanel();
        car.offFara();
        car.offCar();
    }

}
