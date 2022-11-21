package rygatoni.github.io.project_4;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

import java.io.IOException;

public class MainController {
    @FXML
    private Button newYorkPizza, chicagoPizza, currentOrder, storeOrders;

    @FXML
    private void newYorkPress() throws IOException {
        Stage stage = (Stage) newYorkPizza.getScene().getWindow();
        FXMLLoader newYorkLoader = new FXMLLoader(PizzaFactoryMain.class.getResource("new-york-view.fxml"));
        Scene scene = new Scene(newYorkLoader.load(), 1000, 1000);
        stage.setTitle("New York Pizza Order");
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    private void chicagoPress() throws IOException {
        Stage stage = (Stage) chicagoPizza.getScene().getWindow();
        FXMLLoader chicagoLoader = new FXMLLoader(PizzaFactoryMain.class.getResource("chicago-view.fxml"));
        Scene scene = new Scene(chicagoLoader.load(), 1000, 1000);
        stage.setTitle("Chicago Pizza Order");
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    private void currentOrderPress() throws IOException {
        Stage stage = (Stage) currentOrder.getScene().getWindow();
        FXMLLoader currentOrderLoader = new FXMLLoader(PizzaFactoryMain.class.getResource("current-order-view.fxml"));
        Scene scene = new Scene(currentOrderLoader.load(), 1000, 1000);
        stage.setTitle("Current Order");
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    private void storeOrderPress() throws IOException {
        Stage stage = (Stage) storeOrders.getScene().getWindow();
        FXMLLoader storeOrderLoader = new FXMLLoader(PizzaFactoryMain.class.getResource("store-order-view.fxml"));
        Scene scene = new Scene(storeOrderLoader.load(), 1000, 1000);
        stage.setTitle("Store Orders");
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    private void initialize() {
    }

}