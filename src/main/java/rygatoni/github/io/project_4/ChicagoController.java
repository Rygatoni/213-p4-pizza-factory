package rygatoni.github.io.project_4;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.*;

import java.io.IOException;
import java.text.DecimalFormat;
import java.util.ArrayList;

public class ChicagoController {

    private MainController mainController;

    private PizzaFactory pizzaFactory;

    private String mode;

    private ArrayList<Topping> currentToppings;

    ObservableList<Size> sizeList = FXCollections.observableArrayList(Size.SMALL, Size.MEDIUM, Size.LARGE);

    CheckBox[] additionalToppings;

    private static final double DELUXE_SMALL = 14.99;
    private static final double DELUXE_MEDIUM = 16.99;
    private static final double DELUXE_LARGE = 18.99;

    private static final double BBQ_SMALL = 13.99;
    private static final double BBQ_MEDIUM = 15.99;
    private static final double BBQ_LARGE = 17.99;

    private static final double MEATZZA_SMALL = 15.99;
    private static final double MEATZZA_MEDIUM = 17.99;
    private static final double MEATZZA_LARGE = 19.99;

    private static final double BYO_SMALL = 8.99;
    private static final double BYO_MEDIUM = 10.99;
    private static final double BYO_LARGE = 12.99;

    private static final double ADDITIONAL_FEE = 1.59;

    private static final DecimalFormat df = new DecimalFormat("0.00");

    @FXML
    Label pizzaTotal;
    @FXML
    Button mainMenu, addToOrder;

    @FXML
    RadioButton deluxeToggle, bbqToggle, meatzzaToggle, byoToggle;

    @FXML
    Label toppingsLabel, toppingList;

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
        this.mode = "DELUXE";
        toppingList.setText("Sausage,   Pepperoni,   Green Pepper,   Onion,   Mushroom");

        this.currentToppings = new ArrayList<Topping>();
        pizzaTotal.setText(Double.toString(DELUXE_SMALL));
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
                currentToppings.clear();
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
        pizzaTotalUpdate();
        presetToppingUpdate();
    }

    @FXML
    public void bbqToggle() {
        additionalToppingsEnable(false);
        this.mode = "BBQ_CHICKEN";
        pizzaTotalUpdate();
        presetToppingUpdate();
    }

    @FXML
    public void meatzzaToggle() {
        additionalToppingsEnable(false);
        this.mode = "MEATZZA";
        pizzaTotalUpdate();
        presetToppingUpdate();
    }

    @FXML
    public void byoToggle() {
        additionalToppingsEnable(true);
        this.mode = "BUILD_YOUR_OWN";
        pizzaTotalUpdate();
        presetToppingUpdate();
    }

    private void presetToppingUpdate() {
        switch(mode) {
            case "DELUXE":
                toppingList.setText("Sausage,   Pepperoni,   Green Pepper,   Onion,   Mushroom");
                break;
            case "BBQ_CHICKEN":
                toppingList.setText("BBQ Chicken,   Green Pepper,   Provolone,   Cheddar");
                break;
            case "MEATZZA":
                toppingList.setText("Sausage,   Pepperoni,   Beef,   Ham");
                break;
            case "BUILD_YOUR_OWN":
                toppingList.setText("Choose your own toppings!");
                break;
        }
    }


    private void pizzaTotalUpdate() {
        Size sizeDropdownValue = (Size) sizeDropdown.getValue();
        switch(mode) {
            case "DELUXE":
                if(sizeDropdownValue.equals(Size.SMALL)) {
                    pizzaTotal.setText("$" + DELUXE_SMALL);
                } else if(sizeDropdownValue.equals(Size.MEDIUM)) {
                    pizzaTotal.setText("$" + DELUXE_MEDIUM);
                } else {
                    pizzaTotal.setText("$" + DELUXE_LARGE);
                }
                break;
            case "BBQ_CHICKEN":
                if(sizeDropdownValue.equals(Size.SMALL)) {
                    pizzaTotal.setText("$" + BBQ_SMALL);
                } else if(sizeDropdownValue.equals(Size.MEDIUM)) {
                    pizzaTotal.setText("$" + BBQ_MEDIUM);
                } else {
                    pizzaTotal.setText("$" + BBQ_LARGE);
                }
                break;
            case "MEATZZA":
                if(sizeDropdownValue.equals(Size.SMALL)) {
                    pizzaTotal.setText("$" + Double.toString(MEATZZA_SMALL));
                } else if(sizeDropdownValue.equals(Size.MEDIUM)) {
                    pizzaTotal.setText("$" + Double.toString(MEATZZA_MEDIUM));
                } else {
                    pizzaTotal.setText("$" + Double.toString(MEATZZA_LARGE));
                }
                break;
            case "BUILD_YOUR_OWN":
                if(sizeDropdownValue.equals(Size.SMALL)) {
                    pizzaTotal.setText("$" + df.format(BYO_SMALL + ADDITIONAL_FEE * currentToppings.size()));
                } else if(sizeDropdownValue.equals(Size.MEDIUM)) {
                    pizzaTotal.setText("$" + df.format(BYO_MEDIUM + ADDITIONAL_FEE * currentToppings.size()));
                } else {
                    pizzaTotal.setText("$" + df.format(BYO_LARGE + ADDITIONAL_FEE * currentToppings.size()));
                }
                break;
        }
    }
    @FXML
    private void sizeDropdownChanged() {
        pizzaTotalUpdate();
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
            pizzaTotalUpdate();
            capacityCheck();
        } else {
            currentToppings.remove(topping);
            pizzaTotalUpdate();
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


    private void pizzaPrint(Pizza finalPizza) {
        String shortenedClassName = finalPizza.getClass().toString().substring(finalPizza.getClass().toString().lastIndexOf('.') + 1).toUpperCase();
        System.out.println(shortenedClassName + " - " + finalPizza.getCrust() + " - " + finalPizza.getSize());
        for(int i = 0; i < finalPizza.getToppings().size(); i++) {
            System.out.print("    -");
            System.out.println(finalPizza.getToppings().get(i));
        }
        System.out.println("--------------- Unit Price: " + finalPizza.price() + " ----");
        System.out.println();
    }
    public void addToOrderPress() throws IOException{
        Pizza finalPizza = null;
        switch(mode) {
            case "DELUXE":
                finalPizza = pizzaFactory.createDeluxe();
                finalPizza.setSize((Size) sizeDropdown.getValue());
                mainController.getCurrentOrder().add(finalPizza);
                break;
            case "BBQ_CHICKEN":
                finalPizza = pizzaFactory.createBBQChicken();
                finalPizza.setSize((Size) sizeDropdown.getValue());
                mainController.getCurrentOrder().add(finalPizza);
                break;
            case "MEATZZA":
                finalPizza = pizzaFactory.createMeatzza();
                finalPizza.setSize((Size) sizeDropdown.getValue());
                mainController.getCurrentOrder().add(finalPizza);
                break;
            case "BUILD_YOUR_OWN":
                finalPizza = pizzaFactory.createBuildYourOwn();
                finalPizza.setSize((Size) sizeDropdown.getValue());
                for (Topping currentTopping : currentToppings) {
                    finalPizza.add(currentTopping);
                }
                mainController.getCurrentOrder().add(finalPizza);
                break;
        }

        mainController.toCurrentOrders();
    }


}
