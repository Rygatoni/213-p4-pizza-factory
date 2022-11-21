package rygatoni.github.io.project_4;

import java.util.ArrayList;

public abstract class Pizza implements Customizable {
    private ArrayList<Topping> toppings;
    private Crust crust;
    private Size size;
    public abstract double price();

    public ArrayList<Topping> getToppings() {
        return this.toppings;
    }

    public Crust getCrust() {
        return this.crust;
    }
    public Size getSize() {
        return this.size;
    }
}
