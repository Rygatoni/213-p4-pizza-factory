package rygatoni.github.io.project_4;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BuildYourOwnTest {

    private static final double SMALL_PRICE = 8.99;
    private static final double MEDIUM_PRICE = 10.99;
    private static final double LARGE_PRICE = 12.99;

    private static final double ADDITIONAL_FEE = 1.59;

    @Test
    public void test_toppings_chicago_small() {
        PizzaFactory chicagoPizzaFactory = new ChicagoPizza();

        //Test small Chicago Pizza, no toppings
        Pizza smallChicagoPizza = chicagoPizzaFactory.createBuildYourOwn();
        smallChicagoPizza.setSize(Size.SMALL);
        Double expectedOutput = SMALL_PRICE + 0 * ADDITIONAL_FEE;
        Double actualOutput = smallChicagoPizza.price();
        assertEquals(expectedOutput, actualOutput);

        //Test small Chicago Pizza, one topping
        smallChicagoPizza.add(Topping.BBQ_CHICKEN);
        expectedOutput = SMALL_PRICE + 1 * ADDITIONAL_FEE;
        actualOutput = smallChicagoPizza.price();
        assertEquals(expectedOutput, actualOutput);

        //Test small Chicago Pizza, two toppings
        smallChicagoPizza.add(Topping.CHEDDAR);
        expectedOutput = SMALL_PRICE + 2 * ADDITIONAL_FEE;
        actualOutput = smallChicagoPizza.price();
        assertEquals(expectedOutput, actualOutput);

        //Test small Chicago Pizza, three toppings
        smallChicagoPizza.add(Topping.GREEN_PEPPER);
        expectedOutput = SMALL_PRICE + 3 * ADDITIONAL_FEE;
        actualOutput = smallChicagoPizza.price();
        assertEquals(expectedOutput, actualOutput);

        //Test small Chicago Pizza, four toppings
        smallChicagoPizza.add(Topping.BEEF);
        expectedOutput = SMALL_PRICE + 4 * ADDITIONAL_FEE;
        actualOutput = smallChicagoPizza.price();
        assertEquals(expectedOutput, actualOutput);

        //Test small Chicago Pizza, five toppings
        smallChicagoPizza.add(Topping.HAM);
        expectedOutput = SMALL_PRICE + 5 * ADDITIONAL_FEE;
        actualOutput = smallChicagoPizza.price();
        assertEquals(expectedOutput, actualOutput);

        //Test small Chicago Pizza, six toppings
        smallChicagoPizza.add(Topping.ONION);
        expectedOutput = SMALL_PRICE + 6 * ADDITIONAL_FEE;
        actualOutput = smallChicagoPizza.price();
        assertEquals(expectedOutput, actualOutput);

        //Test small Chicago Pizza, seven toppings
        smallChicagoPizza.add(Topping.MEATBALL);
        expectedOutput = SMALL_PRICE + 7 * ADDITIONAL_FEE;
        actualOutput = smallChicagoPizza.price();
        assertEquals(expectedOutput, actualOutput);
    }

    @Test
    public void test_toppings_new_york_small() {
        PizzaFactory newYorkPizzaFactory = new NewYorkPizza();

        //Test small New York Pizza, no toppings
        Pizza smallNewYorkPizza = newYorkPizzaFactory.createBuildYourOwn();
        smallNewYorkPizza.setSize(Size.SMALL);
        Double expectedOutput = SMALL_PRICE + 0 * ADDITIONAL_FEE;
        Double actualOutput = smallNewYorkPizza.price();
        assertEquals(expectedOutput, actualOutput);

        //Test small New York Pizza, one topping
        smallNewYorkPizza.add(Topping.BBQ_CHICKEN);
        expectedOutput = SMALL_PRICE + 1 * ADDITIONAL_FEE;
        actualOutput = smallNewYorkPizza.price();
        assertEquals(expectedOutput, actualOutput);

        //Test small New York Pizza, two toppings
        smallNewYorkPizza.add(Topping.CHEDDAR);
        expectedOutput = SMALL_PRICE + 2 * ADDITIONAL_FEE;
        actualOutput = smallNewYorkPizza.price();
        assertEquals(expectedOutput, actualOutput);

        //Test small New York Pizza, three toppings
        smallNewYorkPizza.add(Topping.GREEN_PEPPER);
        expectedOutput = SMALL_PRICE + 3 * ADDITIONAL_FEE;
        actualOutput = smallNewYorkPizza.price();
        assertEquals(expectedOutput, actualOutput);

        //Test small New York Pizza, four toppings
        smallNewYorkPizza.add(Topping.BEEF);
        expectedOutput = SMALL_PRICE + 4 * ADDITIONAL_FEE;
        actualOutput = smallNewYorkPizza.price();
        assertEquals(expectedOutput, actualOutput);

        //Test small New York Pizza, five toppings
        smallNewYorkPizza.add(Topping.HAM);
        expectedOutput = SMALL_PRICE + 5 * ADDITIONAL_FEE;
        actualOutput = smallNewYorkPizza.price();
        assertEquals(expectedOutput, actualOutput);

        //Test small New York Pizza, six toppings
        smallNewYorkPizza.add(Topping.ONION);
        expectedOutput = SMALL_PRICE + 6 * ADDITIONAL_FEE;
        actualOutput = smallNewYorkPizza.price();
        assertEquals(expectedOutput, actualOutput);

        //Test small New York Pizza, seven toppings
        smallNewYorkPizza.add(Topping.MEATBALL);
        expectedOutput = SMALL_PRICE + 7 * ADDITIONAL_FEE;
        actualOutput = smallNewYorkPizza.price();
        assertEquals(expectedOutput, actualOutput);
    }

    @Test
    public void test_toppings_chicago_medium() {
        PizzaFactory chicagoPizzaFactory = new ChicagoPizza();

        //Test medium Chicago Pizza, no toppings
        Pizza mediumChicagoPizza = chicagoPizzaFactory.createBuildYourOwn();
        mediumChicagoPizza.setSize(Size.MEDIUM);
        Double expectedOutput = MEDIUM_PRICE + 0 * ADDITIONAL_FEE;
        Double actualOutput = mediumChicagoPizza.price();
        assertEquals(expectedOutput, actualOutput);

        //Test medium Chicago Pizza, one topping
        mediumChicagoPizza.add(Topping.BBQ_CHICKEN);
        expectedOutput = MEDIUM_PRICE + 1 * ADDITIONAL_FEE;
        actualOutput = mediumChicagoPizza.price();
        assertEquals(expectedOutput, actualOutput);

        //Test medium Chicago Pizza, two toppings
        mediumChicagoPizza.add(Topping.CHEDDAR);
        expectedOutput = MEDIUM_PRICE + 2 * ADDITIONAL_FEE;
        actualOutput = mediumChicagoPizza.price();
        assertEquals(expectedOutput, actualOutput);

        //Test medium Chicago Pizza, three toppings
        mediumChicagoPizza.add(Topping.GREEN_PEPPER);
        expectedOutput = MEDIUM_PRICE + 3 * ADDITIONAL_FEE;
        actualOutput = mediumChicagoPizza.price();
        assertEquals(expectedOutput, actualOutput);

        //Test medium Chicago Pizza, four toppings
        mediumChicagoPizza.add(Topping.BEEF);
        expectedOutput = MEDIUM_PRICE + 4 * ADDITIONAL_FEE;
        actualOutput = mediumChicagoPizza.price();
        assertEquals(expectedOutput, actualOutput);

        //Test medium Chicago Pizza, five toppings
        mediumChicagoPizza.add(Topping.HAM);
        expectedOutput = MEDIUM_PRICE + 5 * ADDITIONAL_FEE;
        actualOutput = mediumChicagoPizza.price();
        assertEquals(expectedOutput, actualOutput);

        //Test medium Chicago Pizza, six toppings
        mediumChicagoPizza.add(Topping.ONION);
        expectedOutput = MEDIUM_PRICE + 6 * ADDITIONAL_FEE;
        actualOutput = mediumChicagoPizza.price();
        assertEquals(expectedOutput, actualOutput);

        //Test medium Chicago Pizza, seven toppings
        mediumChicagoPizza.add(Topping.MEATBALL);
        expectedOutput = MEDIUM_PRICE + 7 * ADDITIONAL_FEE;
        actualOutput = mediumChicagoPizza.price();
        assertEquals(expectedOutput, actualOutput);
    }

    @Test
    public void test_toppings_new_york_medium() {
        PizzaFactory newYorkPizzaFactory = new NewYorkPizza();

        //Test medium New York Pizza, no toppings
        Pizza mediumNewYorkPizza = newYorkPizzaFactory.createBuildYourOwn();
        mediumNewYorkPizza.setSize(Size.MEDIUM);
        Double expectedOutput = MEDIUM_PRICE + 0 * ADDITIONAL_FEE;
        Double actualOutput = mediumNewYorkPizza.price();
        assertEquals(expectedOutput, actualOutput);

        //Test medium New York Pizza, one topping
        mediumNewYorkPizza.add(Topping.BBQ_CHICKEN);
        expectedOutput = MEDIUM_PRICE + 1 * ADDITIONAL_FEE;
        actualOutput = mediumNewYorkPizza.price();
        assertEquals(expectedOutput, actualOutput);

        //Test medium New York Pizza, two toppings
        mediumNewYorkPizza.add(Topping.CHEDDAR);
        expectedOutput = MEDIUM_PRICE + 2 * ADDITIONAL_FEE;
        actualOutput = mediumNewYorkPizza.price();
        assertEquals(expectedOutput, actualOutput);

        //Test medium New York Pizza, three toppings
        mediumNewYorkPizza.add(Topping.GREEN_PEPPER);
        expectedOutput = MEDIUM_PRICE + 3 * ADDITIONAL_FEE;
        actualOutput = mediumNewYorkPizza.price();
        assertEquals(expectedOutput, actualOutput);

        //Test medium New York Pizza, four toppings
        mediumNewYorkPizza.add(Topping.BEEF);
        expectedOutput = MEDIUM_PRICE + 4 * ADDITIONAL_FEE;
        actualOutput = mediumNewYorkPizza.price();
        assertEquals(expectedOutput, actualOutput);

        //Test medium New York Pizza, five toppings
        mediumNewYorkPizza.add(Topping.HAM);
        expectedOutput = MEDIUM_PRICE + 5 * ADDITIONAL_FEE;
        actualOutput = mediumNewYorkPizza.price();
        assertEquals(expectedOutput, actualOutput);

        //Test medium New York Pizza, six toppings
        mediumNewYorkPizza.add(Topping.ONION);
        expectedOutput = MEDIUM_PRICE + 6 * ADDITIONAL_FEE;
        actualOutput = mediumNewYorkPizza.price();
        assertEquals(expectedOutput, actualOutput);

        //Test medium New York Pizza, seven toppings
        mediumNewYorkPizza.add(Topping.MEATBALL);
        expectedOutput = MEDIUM_PRICE + 7 * ADDITIONAL_FEE;
        actualOutput = mediumNewYorkPizza.price();
        assertEquals(expectedOutput, actualOutput);
    }

    @Test
    public void test_toppings_chicago_large() {
        PizzaFactory chicagoPizzaFactory = new ChicagoPizza();

        //Test large Chicago Pizza, no toppings
        Pizza largeChicagoPizza = chicagoPizzaFactory.createBuildYourOwn();
        largeChicagoPizza.setSize(Size.LARGE);
        Double expectedOutput = LARGE_PRICE + 0 * ADDITIONAL_FEE;
        Double actualOutput = largeChicagoPizza.price();
        assertEquals(expectedOutput, actualOutput);

        //Test large Chicago Pizza, one topping
        largeChicagoPizza.add(Topping.BBQ_CHICKEN);
        expectedOutput = LARGE_PRICE + 1 * ADDITIONAL_FEE;
        actualOutput = largeChicagoPizza.price();
        assertEquals(expectedOutput, actualOutput);

        //Test large Chicago Pizza, two toppings
        largeChicagoPizza.add(Topping.CHEDDAR);
        expectedOutput = LARGE_PRICE + 2 * ADDITIONAL_FEE;
        actualOutput = largeChicagoPizza.price();
        assertEquals(expectedOutput, actualOutput);

        //Test large Chicago Pizza, three toppings
        largeChicagoPizza.add(Topping.GREEN_PEPPER);
        expectedOutput = LARGE_PRICE + 3 * ADDITIONAL_FEE;
        actualOutput = largeChicagoPizza.price();
        assertEquals(expectedOutput, actualOutput);

        //Test large Chicago Pizza, four toppings
        largeChicagoPizza.add(Topping.BEEF);
        expectedOutput = LARGE_PRICE + 4 * ADDITIONAL_FEE;
        actualOutput = largeChicagoPizza.price();
        assertEquals(expectedOutput, actualOutput);

        //Test large Chicago Pizza, five toppings
        largeChicagoPizza.add(Topping.HAM);
        expectedOutput = LARGE_PRICE + 5 * ADDITIONAL_FEE;
        actualOutput = largeChicagoPizza.price();
        assertEquals(expectedOutput, actualOutput);

        //Test large Chicago Pizza, six toppings
        largeChicagoPizza.add(Topping.ONION);
        expectedOutput = LARGE_PRICE + 6 * ADDITIONAL_FEE;
        actualOutput = largeChicagoPizza.price();
        assertEquals(expectedOutput, actualOutput);

        //Test large Chicago Pizza, seven toppings
        largeChicagoPizza.add(Topping.MEATBALL);
        expectedOutput = LARGE_PRICE + 7 * ADDITIONAL_FEE;
        actualOutput = largeChicagoPizza.price();
        assertEquals(expectedOutput, actualOutput);
    }

    @Test
    public void test_toppings_new_york_large() {
        PizzaFactory newYorkPizzaFactory = new NewYorkPizza();

        //Test large New York Pizza, no toppings
        Pizza largeNewYorkPizza = newYorkPizzaFactory.createBuildYourOwn();
        largeNewYorkPizza.setSize(Size.LARGE);
        Double expectedOutput = LARGE_PRICE + 0 * ADDITIONAL_FEE;
        Double actualOutput = largeNewYorkPizza.price();
        assertEquals(expectedOutput, actualOutput);

        //Test large New York Pizza, one topping
        largeNewYorkPizza.add(Topping.BBQ_CHICKEN);
        expectedOutput = LARGE_PRICE + 1 * ADDITIONAL_FEE;
        actualOutput = largeNewYorkPizza.price();
        assertEquals(expectedOutput, actualOutput);

        //Test large New York Pizza, two toppings
        largeNewYorkPizza.add(Topping.CHEDDAR);
        expectedOutput = LARGE_PRICE + 2 * ADDITIONAL_FEE;
        actualOutput = largeNewYorkPizza.price();
        assertEquals(expectedOutput, actualOutput);

        //Test large New York Pizza, three toppings
        largeNewYorkPizza.add(Topping.GREEN_PEPPER);
        expectedOutput = LARGE_PRICE + 3 * ADDITIONAL_FEE;
        actualOutput = largeNewYorkPizza.price();
        assertEquals(expectedOutput, actualOutput);

        //Test large New York Pizza, four toppings
        largeNewYorkPizza.add(Topping.BEEF);
        expectedOutput = LARGE_PRICE + 4 * ADDITIONAL_FEE;
        actualOutput = largeNewYorkPizza.price();
        assertEquals(expectedOutput, actualOutput);

        //Test large New York Pizza, five toppings
        largeNewYorkPizza.add(Topping.HAM);
        expectedOutput = LARGE_PRICE + 5 * ADDITIONAL_FEE;
        actualOutput = largeNewYorkPizza.price();
        assertEquals(expectedOutput, actualOutput);

        //Test large New York Pizza, six toppings
        largeNewYorkPizza.add(Topping.ONION);
        expectedOutput = LARGE_PRICE + 6 * ADDITIONAL_FEE;
        actualOutput = largeNewYorkPizza.price();
        assertEquals(expectedOutput, actualOutput);

        //Test large New York Pizza, seven toppings
        largeNewYorkPizza.add(Topping.MEATBALL);
        expectedOutput = LARGE_PRICE + 7 * ADDITIONAL_FEE;
        actualOutput = largeNewYorkPizza.price();
        assertEquals(expectedOutput, actualOutput);
    }
}