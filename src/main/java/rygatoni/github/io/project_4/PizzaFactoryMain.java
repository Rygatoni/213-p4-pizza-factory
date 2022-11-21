package rygatoni.github.io.project_4;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class PizzaFactoryMain extends Application {


    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader mainLoader = new FXMLLoader(PizzaFactoryMain.class.getResource("main-view.fxml"));
        Scene scene = new Scene(mainLoader.load(), 320, 240);
        stage.setTitle("RU Pizzeria");
        stage.setScene(scene);
        stage.show();
    }


    public static void main(String[] args) {
        launch();
    }
}