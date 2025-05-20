package OOPs.Interfaces.cars;

public class ElectricEngine implements Engine{
    @Override
    public void start() {
        System.out.println("I am Electric Engine and engine is starting");
    }
    @Override
    public void stop() {
        System.out.println("Electric engine is stopping");
    }
    @Override
    public void acc() {
        System.out.println("Electric engine accelerate");
    }
}
