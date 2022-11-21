package rygatoni.github.io.project_4;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.ArrayList;

public class MainController {

    private Stage stage;
    private Scene mainScene, orderScene, storeOrderScene;
    private Order order;
    private StoreOrders currentStoreOrders;
    private int currentOrderNumber;

    CurrentOrderController currentOrderController;
    StoreOrderController storeOrderController;

    @FXML
    private Button newYorkPizza, chicagoPizza, currentOrder, storeOrders;

    @FXML
    private void initialize() throws IOException {
        this.currentOrderNumber = 1000;
        this.order = new Order(this.currentOrderNumber);
        this.currentStoreOrders = new StoreOrders();

        FXMLLoader currentOrderLoader = new FXMLLoader(PizzaFactoryMain.class.getResource("current-order-view.fxml"));
        Scene scene = new Scene(currentOrderLoader.load(), 700, 700);
        currentOrderController = currentOrderLoader.getController();
        currentOrderController.setMainController(this);
        currentOrderController.listAllocator();
        orderScene = scene;

        FXMLLoader storeOrderLoader = new FXMLLoader(PizzaFactoryMain.class.getResource("store-order-view.fxml"));
        Scene SOScene = new Scene(storeOrderLoader.load(), 700, 700);
        storeOrderController = storeOrderLoader.getController();
        storeOrderController.setMainController(this);
        storeOrderScene = SOScene;
    }

    public Order getCurrentOrder() {
        return order;
    }

    public int getCurrentOrderNumber() {
        return currentOrderNumber;
    }

    public void clearOrder() {
        this.order = new Order();
        currentOrderController.listAllocator();
    }
    public void placeOrder() {
        this.currentStoreOrders.add(order);
        this.currentOrderNumber++;
        order = new Order(this.currentOrderNumber);
    }

    public StoreOrders getStoreOrders() {
        return currentStoreOrders;
    }

    public void backToMainMenu() {
        stage.setScene(mainScene);
        stage.show();
    }

    public void incrementOrderNumber() {
        currentOrderNumber++;
    }

    @FXML
    private void newYorkPress() throws IOException {
        this.stage = (Stage) newYorkPizza.getScene().getWindow();
        this.mainScene = newYorkPizza.getScene();
        FXMLLoader newYorkLoader = new FXMLLoader(PizzaFactoryMain.class.getResource("new-york-view.fxml"));
        Scene scene = new Scene(newYorkLoader.load(), 700, 700);
        NewYorkController newYorkController = newYorkLoader.getController();
        newYorkController.setMainController(this);
        this.stage.setTitle("New York Pizza Order");
        this.stage.setScene(scene);
        this.stage.show();
    }

    @FXML
    private void chicagoPress() throws IOException {
        this.stage = (Stage) chicagoPizza.getScene().getWindow();
        this.mainScene = chicagoPizza.getScene();
        FXMLLoader chicagoLoader = new FXMLLoader(PizzaFactoryMain.class.getResource("chicago-view.fxml"));
        Scene scene = new Scene(chicagoLoader.load(), 700, 700);
        ChicagoController chicagoController = chicagoLoader.getController();
        chicagoController.setMainController(this);
        this.stage.setTitle("Chicago Pizza Order");
        this.stage.setScene(scene);
        this.stage.show();
    }

    @FXML
    public void currentOrderPress() throws IOException {
        toCurrentOrders();
    }

    @FXML
    private void storeOrderPress() throws IOException {
        toStoreOrders();
    }

    public String pizzaPrint(Pizza currentPizza) {
        return currentOrderController.pizzaPrint(currentPizza);
    }
    public void toStoreOrders() {
        currentOrder.setDisable(false);
        storeOrders.setDisable(false);
        stage.setScene(storeOrderScene);
        storeOrderController.listAllocator();
        stage.setTitle("Store Orders");
        stage.show();
    }

    public void toCurrentOrders() {
        currentOrder.setDisable(false);
        storeOrders.setDisable(false);
        stage.setScene(orderScene);
        currentOrderController.listAllocator();
        stage.setTitle("Order #" + currentOrderNumber);
        stage.show();
    }
}