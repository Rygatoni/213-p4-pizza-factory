package rygatoni.github.io.project_4;

import java.util.ArrayList;

public class BBQChicken extends Pizza{

    private ArrayList<Topping> toppings;
    private Crust crust;
    private Size size;

    private static double SMALL_PRICE = 13.99;
    private static double MEDIUM_PRICE = 15.99;
    private static double LARGE_PRICE = 17.99;

    public BBQChicken(Crust crust) {
        this.crust = crust;
        this.size = null;
        this.toppings = new ArrayList<>();
        this.toppings.add(Topping.BBQ_CHICKEN);
        this.toppings.add(Topping.GREEN_PEPPER);
        this.toppings.add(Topping.PROVOLONE);
        this.toppings.add(Topping.CHEDDAR);
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
