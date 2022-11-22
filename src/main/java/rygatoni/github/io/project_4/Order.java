package rygatoni.github.io.project_4;

import java.util.ArrayList;

public class Order implements Customizable{
    /**
     * List of pizzas in an order
     */
    private ArrayList<Pizza> pizzas;
    /**
     * Number of order
     */
    private int orderNumber;
    /**
     * New Jersey Tax Rate
     */
    private static double TAX_RATE = 0.06625;

    /**
     * Constructor for first Order.
     * Sets the pizzas and number of the order.
     */

    public Order() {
        this.pizzas = new ArrayList<>();
        this.orderNumber = 1000;
    }

    /**
     * Constructor for an Order.
     * Sets the pizzas and the inputted order number of an order.
     * @param orderNumber Number of Order
     */
    public Order(int orderNumber) {
        this.pizzas = new ArrayList<>();
        this.orderNumber = orderNumber;
    }

    /**
     * Gets the order number
     * @return The order number
     */
    public int getOrderNumber() {
        return this.orderNumber;
    }

    /**
     * Gets the pizzas of an order
     * @return Pizza list of an order
     */
    public ArrayList<Pizza> getPizzas() {
        return this.pizzas;
    }

    /**
     * Adds a pizza to the order
     * @param obj The pizza to be added
     * @return true if the pizza was added, false if otherwise
     */
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
        double subtotal = 0;
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
