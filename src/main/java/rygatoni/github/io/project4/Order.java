package rygatoni.github.io.project4;

import java.util.ArrayList;

public class Order implements Customizable{
    private ArrayList<Pizza> pizzas;
    private int orderNumber;
    private static double TAX_RATE = 0.06625;

    public Order() {
        this.pizzas = new ArrayList<>();
        this.orderNumber = 1000;
    }
    public Order(int orderNumber) {
        this.pizzas = new ArrayList<>();
        this.orderNumber = orderNumber;
    }

    public int getOrderNumber() {
        return this.orderNumber;
    }

    public ArrayList<Pizza> getPizzas() {
        return this.pizzas;
    }

    public boolean add(Object obj) {
        if(!(obj instanceof Pizza)) {
            return false;
        }
        return this.pizzas.add((Pizza) obj);
    }

    public boolean remove(Object obj) {
        if(!(obj instanceof Pizza)) {
            return false;
        }
        return this.pizzas.remove((Pizza) obj);
    }

    public double subtotal() {
        int subtotal = 0;
        for(int i = 0; i < this.pizzas.size(); i++) {
            Pizza currentPizza = this.pizzas.get(i);
            double currentPrice = currentPizza.price();
            subtotal += currentPrice;
        }
        return subtotal;
    }

    public double salesTax() {
        return subtotal() * TAX_RATE;
    }

    public double orderTotal() {
        return subtotal() + salesTax();
    }

}
