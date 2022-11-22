package rygatoni.github.io.project_4;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;

import java.text.DecimalFormat;

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
     * Returns the
     * @param currentPizza
     * @return
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

    private void totalsUpdater() {
        subtotal.setText("$" + df.format(mainController.getCurrentOrder().subtotal()));
        salesTax.setText("$" + df.format(mainController.getCurrentOrder().salesTax()));
        orderTotal.setText("$" + df.format(mainController.getCurrentOrder().orderTotal()));
    }

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

    @FXML
    public void mainMenuPress() {
        mainController.backToMainMenu();
    }

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
    @FXML
    public void clearOrderPress() {
        mainController.clearOrder();
    }
    @FXML
    public void placeOrderPress() {
        mainController.placeOrder();
        listAllocator();
        mainController.toStoreOrders();
    }

}
