package rygatoni.github.io.project_4;

import javafx.beans.value.ChangeListener;
import javafx.fxml.FXML;
import javafx.scene.control.ListView;

import java.util.ArrayList;

public class StoreOrders implements Customizable{
    /**
     * List of orders
     */
    private ArrayList<Order> orders;

    /**
     * Constructor for Store Orders.
     * Sets a list of orders as the StoreOrders
     */

    public StoreOrders() {
        this.orders = new ArrayList<>();
    }

    /**
     * Gets the list of orders
     * @return A list of orders
     */

    public ArrayList<Order> getOrders() {
        return orders;
    }

    /**
     * Adds an order if an object is an instance of Order
     * @param obj Object that is checked
     * @return false if the object is not an object.
     * Otherwise, true.
     */
    public boolean add(Object obj) {
        if(!(obj instanceof Order)) {
            return false;
        }
        return this.orders.add((Order) obj);
    }
    /**
     * Removes an order if an object is an instance of Order
     * @param obj Object that is checked
     * @return false if the object is not an object.
     * Otherwise, true.
     */
    public boolean remove(Object obj) {
        if(!(obj instanceof Order)) {
            return false;
        }
        return this.orders.remove((Order) obj);
    }

}
