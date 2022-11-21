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


public class StoreOrderController {

    private MainController mainController;

    private ObservableList<String> orders = FXCollections.observableArrayList();

    @FXML
    Button mainMenu, cancelOrder, exportOrders;

    @FXML
    ListView orderList;

    private static final DecimalFormat df = new DecimalFormat("0.00");

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

    public void setMainController(MainController controller) {
        mainController = controller;
    }

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
    @FXML
    public void mainMenuPress() {
        mainController.backToMainMenu();
    }
}
