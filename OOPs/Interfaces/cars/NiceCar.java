package OOPs.Interfaces.cars;

public class NiceCar{
    private Engine engine;
    private MediaPlayer media;


    // constructors simple and parameterized ones declared here.
    public NiceCar(){
        this.media = new CDPlayer();
        this.engine = new PetrolEngine();
    }
    public NiceCar(Engine engine){
        this.engine = engine;
    }


    // described cars functionality such as engine start or stop or accelerate or cars media player start or stops.
    void start(){
        engine.start();
    }

    void stop(){
        engine.stop();
    }

    void acc(){
        engine.acc();
    }

    void mediaStart(){
        media.start();
    }

    void mediaStop(){
        media.stop();
    }


    // for upgrading the engine if anybody wants to change their cars engine.
    public void upgradeEngine(Engine engine){
        this.engine = engine;
    }
}