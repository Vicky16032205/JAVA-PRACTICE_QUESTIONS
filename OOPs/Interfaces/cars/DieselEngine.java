package OOPs.Interfaces.cars;

public class DieselEngine implements Engine{
    @Override
    public void start() {
        System.out.println("I am Diesel Engine and engine is starting");
    }
    @Override
    public void stop() {
        System.out.println("Diesel engine is stopping");
    }
    @Override
    public void acc() {
        System.out.println("Diesel engine accelerate");
    }
}
