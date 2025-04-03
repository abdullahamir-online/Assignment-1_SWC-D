package com.company;

// Engine interface
interface Engine {
    void move();
}

class CombustionEngine implements Engine {
    @Override
    public void move() {
        System.out.println("Moving using combustion engine...");
    }
}

class ElectricEngine implements Engine {
    @Override
    public void move() {
        System.out.println("Moving using electric engine...");
    }
}

// Driver interface
interface Driver {
    void navigate();
}

class Human implements Driver {
    @Override
    public void navigate() {
        System.out.println("Human is navigating...");
    }
}

class Robot implements Driver {
    @Override
    public void navigate() {
        System.out.println("Robot is navigating...");
    }
}

// Transport class using composition
class Transport {
    private Engine engine;
    private Driver driver;

    public Transport(Engine engine, Driver driver) {
        this.engine = engine;
        this.driver = driver;
    }

    public void deliver(String destination, String cargo) {
        driver.navigate();
        engine.move();
        System.out.println("Delivering " + cargo + " to " + destination);
    }
}

// TransportSimulation class (usage)
public class TransportSimulation {
    public static void main(String[] args) {
        Transport truck = new Transport(new CombustionEngine(), new Human());
        Transport drone = new Transport(new ElectricEngine(), new Robot());

        truck.deliver("City A", "Goods");
        drone.deliver("City B", "Packages");
    }
}


