package rygatoni.github.io.project_4;

import java.util.ArrayList;

public abstract class Pizza implements Customizable {
    private ArrayList<Topping> toppings;
    private Crust crust;
    private Size size;
    public abstract double price();

    public abstract ArrayList<Topping> getToppings();
    public abstract Size getSize();
    public abstract void setSize(Size size);

    public abstract Crust getCrust();
}
