package OOPs.Interfaces.cars;

public class CDPlayer implements MediaPlayer{

    @Override
    public void start() {
        System.out.println("Car music starts");
    }

    @Override
    public void stop() {
        System.out.println("Car music stops");
    }
    
}
