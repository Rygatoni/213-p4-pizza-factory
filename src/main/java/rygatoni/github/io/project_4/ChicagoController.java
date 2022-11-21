package rygatoni.github.io.project_4;

import com.almasb.fxgl.core.collection.Array;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.ArrayList;

public class ChicagoController {

    private MainController mainController;

    private PizzaFactory pizzaFactory;

    private String mode;

    private ArrayList<Topping> currentToppings;

    ObservableList<Size> sizeList = FXCollections.observableArrayList(Size.SMALL, Size.MEDIUM, Size.LARGE);

    CheckBox[] additionalToppings;

    @FXML
    Button mainMenu, addToOrder;

    @FXML
    RadioButton deluxeToggle, bbqToggle, meatzzaToggle, byoToggle;

    @FXML
    Label toppingsLabel;

    @FXML
    CheckBox sausageToggle, pepperoniToggle, greenPepperToggle, onionToggle, mushroomToggle,
            bbq2Toggle, provoloneToggle, cheddarToggle, beefToggle, hamToggle, pineappleToggle,
            buffaloToggle, meatballToggle;

    @FXML
    ComboBox sizeDropdown;

    private void setflavorModes() {
        ToggleGroup flavorModes = new ToggleGroup();
        deluxeToggle.setToggleGroup(flavorModes);
        bbqToggle.setToggleGroup(flavorModes);
        meatzzaToggle.setToggleGroup(flavorModes);
        byoToggle.setToggleGroup(flavorModes);
        deluxeToggle.setSelected(true);
        bbqToggle.setSelected(false);
        meatzzaToggle.setSelected(false);
        byoToggle.setSelected(false);
    }

    @FXML
    private void initialize() {
        pizzaFactory = new ChicagoPizza();
        setflavorModes();
        additionalToppings = new CheckBox[]{sausageToggle, pepperoniToggle, greenPepperToggle, onionToggle,
                mushroomToggle, bbq2Toggle, provoloneToggle, cheddarToggle, beefToggle, hamToggle, pineappleToggle,
                buffaloToggle, meatballToggle};
        toppingsLabel.setDisable(true);
        for(int i = 0; i < additionalToppings.length; i++) {
            additionalToppings[i].setSelected(false);
            additionalToppings[i].setDisable(true);
        }
        sizeDropdown.setItems(sizeList);
        sizeDropdown.setValue(Size.SMALL);
        addToOrder.setDisable(false);

        this.currentToppings = new ArrayList<Topping>();
    }

    public void setMainController(MainController controller) {
        mainController = controller;
    }

    @FXML
    public void mainMenuPress() {
        mainController.backToMainMenu();
    }

    private void additionalToppingsEnable(boolean enable) {
        if(!enable) {
            toppingsLabel.setDisable(true);
            for(int i = 0; i < additionalToppings.length; i++) {
                additionalToppings[i].setSelected(false);
                additionalToppings[i].setDisable(true);
            }
        } else {
            toppingsLabel.setDisable(false);
            for(int i = 0; i < additionalToppings.length; i++) {
                additionalToppings[i].setSelected(false);
                additionalToppings[i].setDisable(false);
            }
        }
    }

    @FXML
    public void deluxeToggle() {
        additionalToppingsEnable(false);
        this.mode = "DELUXE";
    }

    @FXML
    public void bbqToggle() {
        additionalToppingsEnable(false);
        this.mode = "BBQ_CHICKEN";
    }

    @FXML
    public void meatzzaToggle() {
        additionalToppingsEnable(false);
        this.mode = "MEATZZA";
    }

    @FXML
    public void byoToggle() {
        additionalToppingsEnable(true);
        this.mode = "BUILD_YOUR_OWN";
    }

    private void capacityCheck() {
        if(currentToppings.size() >= 7) {
            for(int i = 0; i < additionalToppings.length; i++) {
                if(!additionalToppings[i].isSelected()) {
                    additionalToppings[i].setDisable(true);
                }
            }
        } else {
            for(int i = 0; i < additionalToppings.length; i++) {
                if(additionalToppings[i].isDisable()) {
                    additionalToppings[i].setDisable(false);
                }
            }
        }
    }

    private void addRemoveTopping(CheckBox toppingToggle, Topping topping) {
        if(toppingToggle.isSelected()) {
            currentToppings.add(topping);
            capacityCheck();
        } else {
            currentToppings.remove(topping);
            capacityCheck();
        }
    }

    @FXML
    public void sausageToggle() {
        addRemoveTopping(sausageToggle, Topping.SAUSAGE);
    }

    @FXML
    public void pepperoniToggle() {
        addRemoveTopping(pepperoniToggle, Topping.PEPPERONI);
    }

    @FXML
    public void greenPepperToggle() {
        addRemoveTopping(greenPepperToggle, Topping.GREEN_PEPPER);
    }

    @FXML
    public void onionToggle() {
        addRemoveTopping(onionToggle, Topping.ONION);
    }

    @FXML
    public void mushroomToggle() {
        addRemoveTopping(mushroomToggle, Topping.MUSHROOM);
    }

    @FXML
    public void bbq2Toggle() {
        addRemoveTopping(bbq2Toggle, Topping.BBQ_CHICKEN);
    }

    @FXML
    public void provoloneToggle() {
        addRemoveTopping(provoloneToggle, Topping.PROVOLONE);
    }

    @FXML
    public void cheddarToggle() {
        addRemoveTopping(cheddarToggle, Topping.CHEDDAR);
    }

    @FXML
    public void beefToggle() {
        addRemoveTopping(beefToggle, Topping.BEEF);
    }

    @FXML
    public void hamToggle() {
        addRemoveTopping(hamToggle, Topping.HAM);
    }

    @FXML
    public void pineappleToggle() {
        addRemoveTopping(pineappleToggle, Topping.PINEAPPLE);
    }

    @FXML
    public void buffaloToggle() {
        addRemoveTopping(buffaloToggle, Topping.BUFFALO_CHICKEN);
    }

    @FXML
    public void meatballToggle() {
        addRemoveTopping(meatballToggle, Topping.MEATBALL);
    }

    public void addToOrderPress() {
        Pizza finalPizza;
        switch(mode) {
            case "DELUXE":
                finalPizza = pizzaFactory.createDeluxe();
                finalPizza.setSize((Size) sizeDropdown.getValue());
            case "BBQ_CHICKEN":
                finalPizza = pizzaFactory.createBBQChicken();
                finalPizza.setSize((Size) sizeDropdown.getValue());
            case "MEATZZA":
                finalPizza = pizzaFactory.createMeatzza();
                finalPizza.setSize((Size) sizeDropdown.getValue());
            case "BUILD_YOUR_OWN":
                finalPizza = pizzaFactory.createBuildYourOwn();
                finalPizza.setSize((Size) sizeDropdown.getValue());
                for(int i = 0; i < currentToppings.size(); i++) {
                    finalPizza.add(currentToppings.get(i));
                }
        }
    }


}
