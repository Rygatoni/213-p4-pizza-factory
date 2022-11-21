package rygatoni.github.io.project4;

import java.util.ArrayList;

public class BuildYourOwn extends Pizza {
    private ArrayList<Topping> toppings;
    private Crust crust;
    private Size size;

    private static double SMALL_PRICE = 8.99;
    private static double MEDIUM_PRICE = 10.99;
    private static double LARGE_PRICE = 12.99;

    private static double ADDITIONAL_FEE = 1.59;

    public BuildYourOwn(Crust crust) {
        this.crust = crust;
        this.size = null;
        this.toppings = new ArrayList<>();
    }

    public double price() {
        switch(this.size) {
            case SMALL:
                return SMALL_PRICE + toppings.size() * ADDITIONAL_FEE;
            case MEDIUM:
                return MEDIUM_PRICE + toppings.size() * ADDITIONAL_FEE;
            case LARGE:
                return LARGE_PRICE + toppings.size() * ADDITIONAL_FEE;
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
