package rygatoni.github.io.project_4;

import javafx.beans.value.ChangeListener;
import javafx.fxml.FXML;
import javafx.scene.control.ListView;

import java.util.ArrayList;

public class StoreOrders implements Customizable{
    private ArrayList<Order> orders;

    public StoreOrders() {
        this.orders = new ArrayList<>();
    }

    public ArrayList<Order> getOrders() {
        return orders;
    }

    public boolean add(Object obj) {
        if(!(obj instanceof Order)) {
            return false;
        }
        return this.orders.add((Order) obj);
    }

    public boolean remove(Object obj) {
        if(!(obj instanceof Order)) {
            return false;
        }
        return this.orders.remove((Order) obj);
    }

}
