package rygatoni.github.io.project_4;

import javafx.beans.value.ChangeListener;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;

import java.text.DecimalFormat;

/**
 * Controller of the Current Order.
 * Allows the user to view the list of pizzas for the current order.
 * The user can then remove pizzas, clear the entire order, or place the order.
 *
 * @author Rygl Ato
 * @author Jeffrey Mijares
 */
public class CurrentOrderController {
    /**
     * Main controller
     */
    private MainController mainController;

    /**
     * Sets a controller as the main controller
     * @param controller Controller that is being set as the main controller
     */

    public void setMainController(MainController controller) {
        mainController = controller;
    }

    /**
     * Decimal format for prices
     */

    private static final DecimalFormat df = new DecimalFormat("0.00");
    /**
     * Labels for the current order, subtotal, sales tax and order total
     */
    @FXML
    Label currentOrderLabel, subtotal, salesTax, orderTotal;
    /**
     * Buttons to place an order, remove a pizza, clear an order and going to the main menu
     */
    @FXML
    Button placeOrder, removePizza, clearOrder, mainMenu;
    /**
     * List view for the pizza list
     */
    @FXML
    ListView pizzaList;

    /**
     * Returns the type of style based on the crust type
     * @param currentPizza Current Pizza
     * @return Pizza style as a string
     */

    private String getPizzaType(Pizza currentPizza){
        switch(currentPizza.getCrust()) {
            case DEEP_DISH:
            case PAN:
            case STUFFED:
                return "CHICAGO STYLE PIZZA";
            case BROOKLYN:
            case THIN:
            case HAND_TOSSED:
                return "NEW YORK STYLE PIZZA";
            default:
                return null;
        }
    }

    /**
     * Updates the subtotal, tax and order total
     */

    private void totalsUpdater() {
        subtotal.setText("$" + df.format(mainController.getCurrentOrder().subtotal()));
        salesTax.setText("$" + df.format(mainController.getCurrentOrder().salesTax()));
        orderTotal.setText("$" + df.format(mainController.getCurrentOrder().orderTotal()));
    }

    /**
     * Prints a pizza with its details
     * @param currentPizza Current pizza
     * @return string of pizza, pizza type, flavor, toppings and size
     */

    public String pizzaPrint(Pizza currentPizza) {
        String finalString = "";
        String pizzaType = getPizzaType(currentPizza);
        String flavorName = currentPizza.getClass().toString().substring(currentPizza.getClass().toString().lastIndexOf('.') + 1).toUpperCase();
        finalString += pizzaType + " - " + flavorName + " - " + currentPizza.getCrust() + " - " + currentPizza.getSize() + "\n";
        for(int j = 0; j < currentPizza.getToppings().size(); j++) {
            finalString += "       -" + currentPizza.getToppings().get(j) + "\n";
        }
        return finalString;
    }

    /**
     * Lists pizzas and their details in an order
     */

    public void listAllocator() {
        currentOrderLabel.setText("Order #" + mainController.getCurrentOrderNumber());
        ObservableList<String> pizzas = FXCollections.observableArrayList();
        for(int i = 0; i < mainController.getCurrentOrder().getPizzas().size(); i++) {
            Pizza currentPizza = mainController.getCurrentOrder().getPizzas().get(i);
            String finalString = "";
            finalString += pizzaPrint(currentPizza);
            finalString += "--------------------------------------------------------------- Unit Price: $"
                    + df.format(currentPizza.price()) + " ----------\n";
            pizzas.add(finalString.replace('_', ' '));
        }
        pizzaList.setItems(pizzas);
        if(pizzaList.getItems().isEmpty()) {
            clearOrder.setDisable(true);
            placeOrder.setDisable(true);
        } else {
            clearOrder.setDisable(false);
            placeOrder.setDisable(false);
        }
        totalsUpdater();
    }

    /**
     * Runs upon CurrentOrder view initialization. Adds a listener that disables and enables the removePizza
     * button according to ListView selection.
     */
    @FXML
    private void initialize() {
        pizzaList.getSelectionModel().selectedItemProperty().addListener((ChangeListener<String>) (observableValue, s, t1) -> {
            if(pizzaList.getSelectionModel().getSelectedItem() != null) {
                removePizza.setDisable(false);
            } else {
                removePizza.setDisable(true);
            }
        });
    }

    /**
     * Loads main menu when the main menu button is pressed
     */
    @FXML
    public void mainMenuPress() {
        mainController.backToMainMenu();
    }

    /**
     * Removes a pizza from an order when the Remove Pizza button is pressed
     */

    @FXML
    public void removePizzaPress() {
        if(pizzaList.getSelectionModel().getSelectedItem() == null) {
            return;
        }
        String selectedItem = (String) pizzaList.getSelectionModel().getSelectedItem();
        int matchingIndex = pizzaList.getItems().indexOf(selectedItem);
        mainController.getCurrentOrder().getPizzas().remove(matchingIndex);
        listAllocator();
    }

    /**
     * Clears an order when the Clear Order button is pressed
     */
    @FXML
    public void clearOrderPress() {
        mainController.clearOrder();
    }


    /**
     * Stores order in StoreOrders, then retrieves the StoreOrders view.
     */
    @FXML
    public void placeOrderPress() {
        mainController.placeOrder();
        listAllocator();
        mainController.toStoreOrders();
    }
}
