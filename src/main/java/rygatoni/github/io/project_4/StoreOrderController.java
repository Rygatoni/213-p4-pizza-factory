package rygatoni.github.io.project_4;

import javafx.beans.value.ChangeListener;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.DecimalFormat;
import java.util.ArrayList;
/**
 * Controller for the Store Orders view that manages inputs, outputs and data.
 * Contains executions for the main menu, cancel order, and export orders buttons.
 * Updates to the store orders are shown in the list view.
 *
 * @author Rygl Ato
 * @author Jeffrey Mijares
 */


public class StoreOrderController {
    /**
     * Main Controller
     */
    private MainController mainController;
    /**
     * List of orders
     */

    private ObservableList<String> orders = FXCollections.observableArrayList();
    /**
     * Buttons to go to main menu, cancel an order or export orders
     */

    @FXML
    Button mainMenu, cancelOrder, exportOrders;
    /**
     * List view to display orders
     */
    @FXML
    ListView orderList;
    /**
     * Decimal format for prices
     */
    private static final DecimalFormat df = new DecimalFormat("0.00");

    /**
     * Initializes the order list and cancel order button
     */
    @FXML
    private void initialize() {
        orderList.getSelectionModel().selectedItemProperty().addListener((ChangeListener<String>) (observableValue, s, t1) -> {
            if(orderList.getSelectionModel().getSelectedItem() != null) {
                cancelOrder.setDisable(false);
            } else {
                cancelOrder.setDisable(true);
            }
        });
    }

    /**
     * Lists orders with details, order number and order total
     */

    public void listAllocator() {
        orders = FXCollections.observableArrayList();
        ArrayList<Order> storeOrders = mainController.getStoreOrders().getOrders();
        String finalString;
        for(int i = 0; i < storeOrders.size(); i++) {
            finalString = "";
            int currentOrderNumber = storeOrders.get(i).getOrderNumber();
            ArrayList<Pizza> currentOrderPizzas = storeOrders.get(i).getPizzas();
            finalString += "---------------------ORDER #: " + currentOrderNumber
                    + "---------------------\n";
            for(int j = 0; j < currentOrderPizzas.size(); j++) {
                finalString += mainController.pizzaPrint(currentOrderPizzas.get(j));
            }
            finalString += "                                                          Order Total: $"
                    + df.format(storeOrders.get(i).orderTotal()) + "\n";
            orders.add(finalString);
        }
        exportOrders.setDisable(storeOrders.isEmpty());
        orderList.setItems(orders);
    }

    /**
     * Sets a controller as the main controller
     * @param controller
     */

    public void setMainController(MainController controller) {
        mainController = controller;
    }

    /**
     * Removes an order from the order list when the cancel order button is pressed
     */

    @FXML
    private void cancelOrderPress() {
        if(orderList.getSelectionModel().getSelectedItem() == null) {
            return;
        }
        String selectedItem = (String) orderList.getSelectionModel().getSelectedItem();
        int matchingIndex = orderList.getItems().indexOf(selectedItem);
        mainController.getStoreOrders().getOrders().remove(matchingIndex);
        listAllocator();
    }

    /**
     * Exports the store orders as a text file if the Export Orders button is pressed
     */

    @FXML
    private void exportOrdersPress() {
        String finalString = "";
        double storeTotal = 0;
        for(int i = 0; i < orders.size(); i++) {
            finalString += orders.get(i);
            storeTotal += mainController.getStoreOrders().getOrders().get(i).orderTotal();
        }
        finalString += "###########################################################################\n" +
                "Store Total: $" + df.format(storeTotal);

        FileChooser fileChooser = new FileChooser();
        fileChooser.getExtensionFilters().addAll(new FileChooser.ExtensionFilter("Text Files", "*.txt"),
                new FileChooser.ExtensionFilter("All Files", "*.*"));
        Stage stage = new Stage();
        File exportedFile = fileChooser.showSaveDialog(stage);
        if(exportedFile != null) {
            try {
                PrintWriter writer;
                writer = new PrintWriter(exportedFile);
                writer.println(finalString);
                writer.close();
                Alert errorAlert = new Alert(Alert.AlertType.INFORMATION);
                errorAlert.setHeaderText("Export");
                errorAlert.setContentText("Export succeeded.");
                errorAlert.showAndWait();
            } catch (IOException ex) {
                Alert errorAlert = new Alert(Alert.AlertType.ERROR);
                errorAlert.setHeaderText("Error");
                errorAlert.setContentText("Export failed.");
                errorAlert.showAndWait();
            }
        }
    }

    /**
     * Loads the main menu when the main menu button is pressed
     */
    @FXML
    public void mainMenuPress() {
        mainController.backToMainMenu();
    }
}
