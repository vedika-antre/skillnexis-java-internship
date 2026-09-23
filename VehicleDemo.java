class Vehicle {

    void start() {
        System.out.println("Vehicle is starting");
    }

    void stop() {
        System.out.println("Vehicle is stopping");
    }
}

class Car extends Vehicle {

    @Override
    void start() {
        System.out.println("Car starts with a key");
    }
}

class Bike extends Vehicle {

    @Override
    void start() {
        System.out.println("Bike starts with a self-start button");
    }
}

public class VehicleDemo {
    public static void main(String[] args) {

        Car c = new Car();
        Bike b = new Bike();

        c.start();
        c.stop();

        b.start();
        b.stop();
    }
}