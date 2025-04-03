package com.company;
import java.util.*;

// Employee interface
interface Employee {
    void doWork();
}

// Concrete Employee classes
class Designer implements Employee {
    @Override
    public void doWork() {
        System.out.println("Designer is creating graphics...");
    }
}

class Artist implements Employee {
    @Override
    public void doWork() {
        System.out.println("Artist is creating artwork...");
    }
}

class Programmer implements Employee {
    @Override
    public void doWork() {
        System.out.println("Programmer is writing code...");
    }
}

class Tester implements Employee {
    @Override
    public void doWork() {
        System.out.println("Tester is testing software...");
    }
}

// Company abstract class with Factory Method
abstract class Company {
    protected abstract List<Employee> getEmployees();

    public void createSoftware() {
        List<Employee> employees = getEmployees();
        for (Employee e : employees) {
            e.doWork();
        }
    }
}

// Concrete subclasses
class GameDevCompany extends Company {
    @Override
    protected List<Employee> getEmployees() {
        return Arrays.asList(new Designer(), new Artist());
    }
}

class OutsourcingCompany extends Company {
    @Override
    protected List<Employee> getEmployees() {
        return Arrays.asList(new Programmer(), new Tester());
    }
}

// CompanyWorkflow class (usage)
public class CompanyWorkflow {
    public static void main(String[] args) {
        Company gameDev = new GameDevCompany();
        Company outsourcing = new OutsourcingCompany();

        System.out.println("Game Development Company:");
        gameDev.createSoftware();

        System.out.println("\nOutsourcing Company:");
        outsourcing.createSoftware();
    }
}
