package Classes.RawData;

public class Car {
    private String model;
    private Engine engine;
    private Cargo cargo;
    private Tyre tyres;

    public Car(String model, int engineSpeed, int enginePower, int cargoWeight, String cargoType, double pressure1, int age1, double pressure2, int age2, double pressure3, int age3, double pressure4, int age4){
        this.model = model;
        this.engine = new Engine(engineSpeed, enginePower);
        this.cargo = new Cargo(cargoWeight, cargoType);
        this.tyres = new Tyre(pressure1,age1,pressure2,age2,pressure3,age3,pressure4,age4);
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public Engine getEngine() {
        return engine;
    }

    public void setEngine(Engine engine) {
        this.engine = engine;
    }

    public Cargo getCargo() {
        return cargo;
    }

    public void setCargo(Cargo cargo) {
        this.cargo = cargo;
    }

    public Tyre getTyres() {
        return tyres;
    }

    public void setTyres(Tyre tyres) {
        this.tyres = tyres;
    }

    @Override
    public String toString() {
        return String.format("%s", model);
    }
}
