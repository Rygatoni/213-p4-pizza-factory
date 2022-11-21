package rygatoni.github.io.project4;

import java.util.ArrayList;

public class StoreOrders implements Customizable{
    private ArrayList<Order> orders;
    private ArrayList<Integer> orderNumbers;

    public StoreOrders() {
        this.orders = new ArrayList<>();
        this.orderNumbers = new ArrayList<>();
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
