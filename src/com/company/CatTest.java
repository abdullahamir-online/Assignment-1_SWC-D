package com.company;


interface Food {
    int getNutrition();
}

class Cat {
    private int energy;

    public void eat(Food food) {
        this.energy += food.getNutrition();
        displayUpdatedEnergyValue();
    }

    void displayUpdatedEnergyValue(){
        System.out.println("The updated value of nutrition is: " + this.energy);
    }
}

class Sausage implements Food {
    public int getNutrition() {
        return 50;
    }

    public String getColor() {
        return "Brown";
    }

    public String getExpiration() {
        return "2025-12-31";
    }
}

class Fish implements Food {
    public int getNutrition() {
        return 80;
    }
}

public class CatTest {
    public static void main(String[] args) {
        Cat cat = new Cat();
        Sausage sausage = new Sausage();
        Fish fish = new Fish();

        cat.eat(sausage); // cat can eat sausage
        cat.eat(fish);    // Cat can eat fish too!
    }
}



