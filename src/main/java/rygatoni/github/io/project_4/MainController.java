package rygatoni.github.io.project_4;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.ArrayList;

public class MainController {
    /**
     * Stage for main menu
     */
    private Stage stage;
    /**
     * Scenes for the main menu, current order and store orders
     */
    private Scene mainScene, orderScene, storeOrderScene;
    /**
     * Current order
     */
    private Order order;
    /**
     * Current Store Orders
     */
    private StoreOrders currentStoreOrders;
    /**
     * Current order number
     */
    private int currentOrderNumber;
    /**
     *Current Order Controller
     */

    CurrentOrderController currentOrderController;
    /**
     * Store
     */
    StoreOrderController storeOrderController;
    /**
     * Buttons for New York Pizza, Chicago Pizza, Current Order and Store Orders
     */

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

    /**
     * Gets the current order
     * @return The current order
     */

    public Order getCurrentOrder() {
        return order;
    }

    /**
     * Gets the current order number
     * @return The current order number
     */

    public int getCurrentOrderNumber() {
        return currentOrderNumber;
    }

    /**
     * Clears an order
     */

    public void clearOrder() {
        this.order = new Order();
        currentOrderController.listAllocator();
    }

    /**
     * Places an order
     */
    public void placeOrder() {
        this.currentStoreOrders.add(order);
        this.currentOrderNumber++;
        order = new Order(this.currentOrderNumber);
    }

    /**
     * Gets the current store orders
     * @return The current store orders
     */
    public StoreOrders getStoreOrders() {
        return currentStoreOrders;
    }

    /**
     * Goes to the main menu
     */

    public void backToMainMenu() {
        stage.setScene(mainScene);
        stage.show();
    }

    /**
     * Increments the order number
     */

    public void incrementOrderNumber() {
        currentOrderNumber++;
    }

    /**
     * Loads the New York view when the New York Pizza button is pressed
     * @throws IOException Throw IOException
     */

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

    /**
     * Loads the Chicago view when the Chicago Pizza button is pressed
     * @throws IOException
     */

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

    /**
     * Goes to the Current Order view when the Current Order button is pressed
     * @throws IOException Throw IOException
     */

    @FXML
    public void currentOrderPress() throws IOException {
        toCurrentOrders();
    }

    /**
     * Goes to the Store Order view when the Store Orders button is pressed
     * @throws IOException Throw IOException
     */

    @FXML
    private void storeOrderPress() throws IOException {
        toStoreOrders();
    }

    /**
     * Takes a Pizza and returns the pizza as a string
     * @param currentPizza Current Pizza
     * @return Current Pizza as a string
     */

    public String pizzaPrint(Pizza currentPizza) {
        return currentOrderController.pizzaPrint(currentPizza);
    }

    /**
     * Loads the Store Orders view
     */
    public void toStoreOrders() {
        currentOrder.setDisable(false);
        storeOrders.setDisable(false);
        stage.setScene(storeOrderScene);
        storeOrderController.listAllocator();
        stage.setTitle("Store Orders");
        stage.show();
    }

    /**
     * Loads the Current Orders view
     */

    public void toCurrentOrders() {
        currentOrder.setDisable(false);
        storeOrders.setDisable(false);
        stage.setScene(orderScene);
        currentOrderController.listAllocator();
        stage.setTitle("Order #" + currentOrderNumber);
        stage.show();
    }
}