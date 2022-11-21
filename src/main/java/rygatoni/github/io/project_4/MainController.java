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
    private Scene mainScene;
    private Order order;
    private StoreOrders currentStoreOrders;

    @FXML
    private Button newYorkPizza, chicagoPizza, currentOrder, storeOrders;

    @FXML
    private void initialize() {
        this.order = new Order(1000);
        this.currentStoreOrders = new StoreOrders();
    }

    public Order getCurrentOrder() {
        return order;
    }

    public StoreOrders getStoreOrders() {
        return currentStoreOrders;
    }

    public void backToMainMenu() {
        stage.setScene(mainScene);
        stage.show();
    }

    @FXML
    private void newYorkPress() throws IOException {
        this.stage = (Stage) newYorkPizza.getScene().getWindow();
        this.mainScene = newYorkPizza.getScene();
        FXMLLoader newYorkLoader = new FXMLLoader(PizzaFactoryMain.class.getResource("new-york-view.fxml"));
        Scene scene = new Scene(newYorkLoader.load(), 1000, 1000);
        stage.setTitle("New York Pizza Order");
        stage.setScene(scene);
        stage.show();
        NewYorkController newYorkController = newYorkLoader.getController();
        newYorkController.setMainController(this);
    }

    @FXML
    private void chicagoPress() throws IOException {
        this.stage = (Stage) chicagoPizza.getScene().getWindow();
        this.mainScene = chicagoPizza.getScene();
        FXMLLoader chicagoLoader = new FXMLLoader(PizzaFactoryMain.class.getResource("chicago-view.fxml"));
        Scene scene = new Scene(chicagoLoader.load(), 1000, 1000);
        stage.setTitle("Chicago Pizza Order");
        stage.setScene(scene);
        stage.show();
        ChicagoController chicagoController = chicagoLoader.getController();
        chicagoController.setMainController(this);
    }

    @FXML
    private void currentOrderPress() throws IOException {
        this.stage = (Stage) currentOrder.getScene().getWindow();
        this.mainScene = currentOrder.getScene();
        FXMLLoader currentOrderLoader = new FXMLLoader(PizzaFactoryMain.class.getResource("current-order-view.fxml"));
        Scene scene = new Scene(currentOrderLoader.load(), 1000, 1000);
        stage.setTitle("Current Order");
        stage.setScene(scene);
        stage.show();
        CurrentOrderController currentOrderController = currentOrderLoader.getController();
        currentOrderController.setMainController(this);
    }

    @FXML
    private void storeOrderPress() throws IOException {
        this.stage = (Stage) storeOrders.getScene().getWindow();
        this.mainScene = storeOrders.getScene();
        FXMLLoader storeOrderLoader = new FXMLLoader(PizzaFactoryMain.class.getResource("store-order-view.fxml"));
        Scene scene = new Scene(storeOrderLoader.load(), 1000, 1000);
        stage.setTitle("Store Orders");
        stage.setScene(scene);
        stage.show();
        StoreOrderController storeOrderController = storeOrderLoader.getController();
        storeOrderController.setMainController(this);
    }
}