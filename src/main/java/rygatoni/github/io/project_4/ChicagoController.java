package rygatoni.github.io.project_4;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.stage.Stage;

import java.io.IOException;

public class ChicagoController {

    @FXML
    Button mainMenu, addToOrder;

    @FXML
    ComboBox flavors, sizes;

    @FXML
    public void mainMenuPress() throws IOException {
        Stage stage = (Stage) mainMenu.getScene().getWindow();
        FXMLLoader mainLoader = new FXMLLoader(PizzaFactoryMain.class.getResource("main-view.fxml"));
        Scene scene = new Scene(mainLoader.load(), 320, 240);
        stage.setTitle("RU Pizzeria");
        stage.setScene(scene);
        stage.show();
    }
}
