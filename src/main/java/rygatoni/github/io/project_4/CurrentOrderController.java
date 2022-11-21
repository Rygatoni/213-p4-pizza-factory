package rygatoni.github.io.project_4;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;

public class CurrentOrderController {

    private MainController mainController;

    public void setMainController(MainController controller) {
        mainController = controller;
    }

    @FXML
    Button placeOrder, removePizza, clearOrder, mainMenu;

    @FXML
    public void mainMenuPress() {
        mainController.backToMainMenu();
    }

    @FXML
    public void removePizzaPress() {
    }
    @FXML
    public void clearOrderPress() {

    }
    @FXML
    public void placeOrderPress() {

    }

}
