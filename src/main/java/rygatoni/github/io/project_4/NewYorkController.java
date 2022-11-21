package rygatoni.github.io.project_4;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.RadioButton;
import javafx.stage.Stage;

import java.io.IOException;

public class NewYorkController {

    private MainController mainController;

    @FXML
    Button mainMenu, addToOrder;

    @FXML
    RadioButton deluxeToggle, bbqToggle, meatzzaToggle, byoToggle;

    @FXML
    CheckBox sausageToggle, pepperoniToggle, greenPepperToggle, onionToggle, mushroomToggle,
    bbqChickenToggle, provoloneToggle, cheddarToggle, beefToggle, hamToggle, pineappleToggle,
    buffaloToggle, meatballToggle;

    @FXML
    ComboBox sizeDropdown;

    @FXML
    private void initialize() {
        deluxeToggle.setSelected(true);
    }

    public void setMainController(MainController controller) {
        mainController = controller;
    }

    @FXML
    public void mainMenuPress() {
        mainController.backToMainMenu();
    }

    public void deluxeToggle(ActionEvent actionEvent) {
    }

    public void bbqToggle(ActionEvent actionEvent) {
    }

    public void meatzzaToggle(ActionEvent actionEvent) {
    }

    public void byoToggle(ActionEvent actionEvent) {
    }

    public void sausageToggle(ActionEvent actionEvent) {
    }

    public void meatballToggle(ActionEvent actionEvent) {
    }

    public void pepperoniToggle(ActionEvent actionEvent) {
    }

    public void greenPepperToggle(ActionEvent actionEvent) {
    }

    public void buffaloToggle(ActionEvent actionEvent) {
    }

    public void onionToggle(ActionEvent actionEvent) {
    }

    public void mushroomToggle(ActionEvent actionEvent) {
    }

    public void hamToggle(ActionEvent actionEvent) {
    }

    public void bbqChickenToggle(ActionEvent actionEvent) {
    }

    public void beefToggle(ActionEvent actionEvent) {
    }

    public void provoloneToggle(ActionEvent actionEvent) {
    }

    public void cheddarToggle(ActionEvent actionEvent) {
    }

    public void addToOrderPress(ActionEvent actionEvent) {
    }

    public void bbq2Toggle(ActionEvent actionEvent) {
    }

    public void pineappleToggle(ActionEvent actionEvent) {
    }
}
