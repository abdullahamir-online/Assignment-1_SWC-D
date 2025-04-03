package com.company;

import java.util.List;
import java.util.Arrays;

class TaxCalculator {
    public double getTaxRate(String country, String state, String product) {
        if ("USA".equals(country)) {
            return getUSTax(state);
        } else if ("EU".equals(country)) {
            return getEUTax();
        } else if ("China".equals(country)) {
            return getChineseTax(product);
        }
        return 0.0; // Default tax rate if the country is not recognized
    }

    private double getUSTax(String state) {
        if ("CA".equals(state)) {
            return 0.075;
        } else if ("NY".equals(state)) {
            return 0.085;
        }
        return 0.05;
    }

    private double getEUTax() {
        return 0.20; // Fixed EU tax rate
    }

    private double getChineseTax(String product) {
        return "Electronics".equals(product) ? 0.17 : 0.10;
    }
}

class Item {
    private String product;
    private double price;
    private int quantity;

    public Item(String product, double price, int quantity) {
        this.product = product;
        this.price = price;
        this.quantity = quantity;
    }

    public String getProduct() {
        return product;
    }

    public double getPrice() {
        return price;
    }

    public int getQuantity() {
        return quantity;
    }
}

class Order {
    private TaxCalculator taxCalculator;
    private List<Item> lineItems;
    private String country;
    private String state;
    private String city;

    public Order(List<Item> lineItems, String country, String state, String city) {
        this.taxCalculator = new TaxCalculator();
        this.lineItems = lineItems;
        this.country = country;
        this.state = state;
        this.city = city;
    }

    public double getOrderTotal() {
        double total = 0;
        for (Item item : lineItems) {
            double subtotal = item.getPrice() * item.getQuantity();
            double taxRate = taxCalculator.getTaxRate(country, state, item.getProduct());
            double taxAmount = subtotal * taxRate;
            total += subtotal + taxAmount;
        }
        return total;
    }
}

public class OrderTest {
    public static void main(String[] args) {
        Item item1 = new Item("Laptop", 1000, 1);
        Item item2 = new Item("Phone", 500, 2);

        Order order = new Order(Arrays.asList(item1, item2), "USA", "CA", "Los Angeles");
        System.out.printf("Total Order Cost: $%.2f%n", order.getOrderTotal());
    }
}




