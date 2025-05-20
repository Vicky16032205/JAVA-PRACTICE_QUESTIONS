package OOPs.Interfaces.cars;

public class Main {
    public static void main(String[] args) {
        NiceCar car = new NiceCar();
        car.acc();
        car.start();
        car.stop();
        car.mediaStart();
        car.mediaStop();
        car.upgradeEngine(new ElectricEngine());
        car.start();
    }
}