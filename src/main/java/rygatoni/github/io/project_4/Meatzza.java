package rygatoni.github.io.project_4;

import java.util.ArrayList;

public class Meatzza extends Pizza {
    private ArrayList<Topping> toppings;
    private Crust crust;
    private Size size;

    private static double SMALL_PRICE = 15.99;
    private static double MEDIUM_PRICE = 17.99;
    private static double LARGE_PRICE = 19.99;

    public Meatzza(Crust crust) {
        this.crust = crust;
        this.size = null;
        this.toppings = new ArrayList<>();
        this.toppings.add(Topping.SAUSAGE);
        this.toppings.add(Topping.PEPPERONI);
        this.toppings.add(Topping.BEEF);
        this.toppings.add(Topping.HAM);
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
}
