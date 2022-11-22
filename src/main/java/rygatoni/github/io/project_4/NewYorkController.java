package rygatoni.github.io.project_4;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

import java.io.IOException;
import java.text.DecimalFormat;
import java.util.ArrayList;

public class NewYorkController {
    /**
     * Main Controller
     */
    private MainController mainController;
    /**
     * New york Style Pizza Factory
     */

    private PizzaFactory pizzaFactory;
    /**
     * Setting for which pizza flavor is chosen
     */

    private String mode;
    /**
     * List of current toppings
     */
    private ArrayList<Topping> currentToppings;
    /**
     * List of pizza sizes
     */
    ObservableList<Size> sizeList = FXCollections.observableArrayList(Size.SMALL, Size.MEDIUM, Size.LARGE);
    /**
     * Additional toppings checkbox
     */

    CheckBox[] additionalToppings;
    /**
     * Price for deluxe small pizza
     */
    private static final double DELUXE_SMALL = 14.99;
    /**
     * Price for deluxe medium pizza
     */
    private static final double DELUXE_MEDIUM = 16.99;
    /**
     * Price for deluxe large pizza
     */
    private static final double DELUXE_LARGE = 18.99;
    /**
     * Price for BBQ small pizza
     */

    private static final double BBQ_SMALL = 13.99;
    /**
     * Price for BBQ medium pizza
     */
    private static final double BBQ_MEDIUM = 15.99;
    /**
     * Price for BBQ large pizza
     */
    private static final double BBQ_LARGE = 17.99;
    /**
     * Price for meatzza small pizza
     */


    private static final double MEATZZA_SMALL = 15.99;
    /**
     * Price for meatzza medium pizza
     */
    private static final double MEATZZA_MEDIUM = 17.99;
    /**
     * Price for meatzza large pizza
     */
    private static final double MEATZZA_LARGE = 19.99;
    /**
     * Price for Build Your Own small pizza
     */

    private static final double BYO_SMALL = 8.99;
    /**
     * Price for Build Your Own medium pizza
     */
    private static final double BYO_MEDIUM = 10.99;
    /**
     * Price for Build Your Own large pizza
     */
    private static final double BYO_LARGE = 12.99;
    /**
     * Additional fee amount
     */
    private static final double ADDITIONAL_FEE = 1.59;
    /**
     * Decimal Format for prices
     */

    private static final DecimalFormat df = new DecimalFormat("0.00");
    /**
     * Labels for the pizza total price, toppings label, the list of toppings and crust
     */
    @FXML
    Label pizzaTotal, toppingsLabel, toppingList, crust;
    /**
     * Buttons to go to the main menu and to add a pizza to an order
     */
    @FXML
    Button mainMenu, addToOrder;
    /**
     * Radio Buttons for pizza flavors
     */

    @FXML
    RadioButton deluxeToggle, bbqToggle, meatzzaToggle, byoToggle;
    /**
     * Image view for New York Style pizza
     */
    @FXML
    ImageView pizzaImage;
    /**
     * Check boxes for additional toppings
     */


    @FXML
    CheckBox sausageToggle, pepperoniToggle, greenPepperToggle, onionToggle, mushroomToggle,
            bbq2Toggle, provoloneToggle, cheddarToggle, beefToggle, hamToggle, pineappleToggle,
            buffaloToggle, meatballToggle;
    /**
     * Combo Box to choose pizza sizes
     */
    @FXML
    ComboBox sizeDropdown;
    /**
     * Sets toggle groups for the flavors
     */
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
    /**
     * Sets initial settings of New York view
     */
    @FXML
    private void initialize() {
        pizzaFactory = new NewYorkPizza();
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
        Image image = new Image("https://i.imgur.com/JEgXKnH.png");
        pizzaImage.setImage(image);
        this.mode = "DELUXE";
        crust.setText("Brooklyn");
        toppingList.setText("Sausage,   Pepperoni,   Green Pepper,   Onion,   Mushroom");

        this.currentToppings = new ArrayList<Topping>();
        pizzaTotal.setText(Double.toString(DELUXE_SMALL));
    }
    /**
     * Sets a controller as the main controller
     * @param controller The controller that is to be set as the main
     */

    public void setMainController(MainController controller) {
        mainController = controller;
    }
    /**
     * Loads the main menu when the Main Menu button is pressed
     */
    @FXML
    public void mainMenuPress() {
        mainController.backToMainMenu();
    }
    /**
     * Enables additional toppings to be selected
     * @param enable Enable or other
     */
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
    /**
     * Updates the pizza when deluxe is selected
     */

    @FXML
    public void deluxeToggle() {
        additionalToppingsEnable(false);
        this.mode = "DELUXE";
        pizzaTotalUpdate();
        presetCrustToppingUpdate();
    }
    /**
     * Updates the pizza when bbq is selected
     */
    @FXML
    public void bbqToggle() {
        additionalToppingsEnable(false);
        this.mode = "BBQ_CHICKEN";
        pizzaTotalUpdate();
        presetCrustToppingUpdate();
    }
    /**
     * Updates the pizza when meatzza is selected
     */
    @FXML
    public void meatzzaToggle() {
        additionalToppingsEnable(false);
        this.mode = "MEATZZA";
        pizzaTotalUpdate();
        presetCrustToppingUpdate();
    }
    /**
     * Updates the pizza when Build Your Own is selected
     */
    @FXML
    public void byoToggle() {
        additionalToppingsEnable(true);
        this.mode = "BUILD_YOUR_OWN";
        pizzaTotalUpdate();
        presetCrustToppingUpdate();
    }
    /**
     * Sets pizza toppings and crust based on the mode
     */
    private void presetCrustToppingUpdate() {
        switch(mode) {
            case "DELUXE":
                toppingList.setText("Sausage,   Pepperoni,   Green Pepper,   Onion,   Mushroom");
                crust.setText("Brooklyn");
                break;
            case "BBQ_CHICKEN":
                toppingList.setText("BBQ Chicken,   Green Pepper,   Provolone,   Cheddar");
                crust.setText("Thin");
                break;
            case "MEATZZA":
                toppingList.setText("Sausage,   Pepperoni,   Beef,   Ham");
                crust.setText("Hand Tossed");
                break;
            case "BUILD_YOUR_OWN":
                toppingList.setText("Choose your own toppings!");
                crust.setText("Hand Tossed");
                break;
        }
    }
    /**
     * Calculates the pizza price
     */

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
    /**
     * Updates pizza price when the size is changed
     */
    @FXML
    private void sizeDropdownChanged() {
        pizzaTotalUpdate();
    }
    /**
     * Checks if the topping limit is passed
     */
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
    /**
     * Adds or removes a topping
     * @param toppingToggle Topping check box
     * @param topping Topping to be added or removed
     */
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
    /**
     * Adds or Removes sausage based on toggle
     */

    @FXML
    public void sausageToggle() {
        addRemoveTopping(sausageToggle, Topping.SAUSAGE);
    }
    /**
     * Adds or Removes pepperoni based on toggle
     */
    @FXML
    public void pepperoniToggle() {
        addRemoveTopping(pepperoniToggle, Topping.PEPPERONI);
    }
    /**
     * Adds or Removes green pepper based on toggle
     */
    @FXML
    public void greenPepperToggle() {
        addRemoveTopping(greenPepperToggle, Topping.GREEN_PEPPER);
    }
    /**
     * Adds or Removes onion based on toggle
     */
    @FXML
    public void onionToggle() {
        addRemoveTopping(onionToggle, Topping.ONION);
    }
    /**
     * Adds or Removes mushroom based on toggle
     */
    @FXML
    public void mushroomToggle() {
        addRemoveTopping(mushroomToggle, Topping.MUSHROOM);
    }
    /**
     * Adds or Removes bbq chicken based on toggle
     */
    @FXML
    public void bbq2Toggle() {
        addRemoveTopping(bbq2Toggle, Topping.BBQ_CHICKEN);
    }
    /**
     * Adds or Removes provolone based on toggle
     */
    @FXML
    public void provoloneToggle() {
        addRemoveTopping(provoloneToggle, Topping.PROVOLONE);
    }
    /**
     * Adds or Removes cheddar based on toggle
     */
    @FXML
    public void cheddarToggle() {
        addRemoveTopping(cheddarToggle, Topping.CHEDDAR);
    }
    /**
     * Adds or Removes beef based on toggle
     */
    @FXML
    public void beefToggle() {
        addRemoveTopping(beefToggle, Topping.BEEF);
    }
    /**
     * Adds or Removes ham based on toggle
     */
    @FXML
    public void hamToggle() {
        addRemoveTopping(hamToggle, Topping.HAM);
    }
    /**
     * Adds or Removes pineapple based on toggle
     */
    @FXML
    public void pineappleToggle() {
        addRemoveTopping(pineappleToggle, Topping.PINEAPPLE);
    }
    /**
     * Adds or Removes buffalo chicken based on toggle
     */
    @FXML
    public void buffaloToggle() {
        addRemoveTopping(buffaloToggle, Topping.BUFFALO_CHICKEN);
    }
    /**
     * Adds or Removes meatball based on toggle
     */
    @FXML
    public void meatballToggle() {
        addRemoveTopping(meatballToggle, Topping.MEATBALL);
    }

    /**
     * Prints the pizza with all its details and price
     * @param finalPizza Pizza that will be printed
     */
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
