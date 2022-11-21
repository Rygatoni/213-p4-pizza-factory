package rygatoni.github.io.project_4;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

import java.io.IOException;


public class StoreOrderController {

    private MainController mainController;

    @FXML
    Button mainMenu, cancelOrder, exportOrders;

    public void setMainController(MainController controller) {
        mainController = controller;
    }

    @FXML
    public void mainMenuPress() {
        mainController.backToMainMenu();
    }
}
