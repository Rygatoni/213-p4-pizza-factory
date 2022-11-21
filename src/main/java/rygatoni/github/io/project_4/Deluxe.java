package rygatoni.github.io.project_4;

import java.util.ArrayList;

public class Deluxe extends Pizza{
    private ArrayList<Topping> toppings;
    private Crust crust;
    private Size size;

    private static double SMALL_PRICE = 14.99;
    private static double MEDIUM_PRICE = 16.99;
    private static double LARGE_PRICE = 18.99;

    public Deluxe(Crust crust) {
        this.crust = crust;
        this.size = null;
        this.toppings = new ArrayList<>();
        this.toppings.add(Topping.SAUSAGE);
        this.toppings.add(Topping.PEPPERONI);
        this.toppings.add(Topping.GREEN_PEPPER);
        this.toppings.add(Topping.ONION);
        this.toppings.add(Topping.MUSHROOM);
    }

    public double price() {
        switch(this.size) {
            case SMALL:
                return SMALL_PRICE;
            case MEDIUM:
                return MEDIUM_PRICE;
            case LARGE:
                return LARGE_PRICE;
            default:
                return 0;
        }
    };

    public boolean add(Object obj) {
        if(!(obj instanceof Topping)) {
            return false;
        }
        return toppings.add((Topping) obj);
    }

    public boolean remove(Object obj) {
        if(!(obj instanceof Topping)) {
            return false;
        }
        return toppings.remove((Topping) obj);
    }

    public Crust getCrust() {
        return this.crust;
    }

    public ArrayList<Topping> getToppings() {
        return this.toppings;
    }

    public Size getSize() {
        return this.size;
    }

    public void setSize(Size size) {
        this.size = size;
    }
}
