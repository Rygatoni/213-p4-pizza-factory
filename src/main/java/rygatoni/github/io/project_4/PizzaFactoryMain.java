package rygatoni.github.io.project_4;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

/**
 * Launches RU Pizzeria.
 *
 * @author Rygl Ato
 * @author Jeffrey Mijares
 */
public class PizzaFactoryMain extends Application {

    /**
     * Creates the main view.
     * @param stage The window that will be opened.
     * @throws IOException
     */
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader mainLoader = new FXMLLoader(PizzaFactoryMain.class.getResource("main-view.fxml"));
        Scene scene = new Scene(mainLoader.load(), 320, 240);
        stage.setTitle("RU Pizzeria");
        stage.setScene(scene);
        stage.show();
    }

    /**
     * Launches RU Pizzeria.
     * @param args The arguments for the launch.
     */
    public static void main(String[] args) {
        launch();
    }
}