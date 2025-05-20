package OOPs.Interfaces.cars;

public class PetrolEngine implements Engine{

    @Override
    public void start() {
        System.out.println("I am Petrol Engine and engine is starting");
    }
    @Override
    public void stop() {
        System.out.println("Petrol engine is stopping");
    }
    @Override
    public void acc() {
        System.out.println("Petrol engine accelerate");
    }
    
}
