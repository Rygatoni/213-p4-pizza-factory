package rygatoni.github.io.project_4;

public class ChicagoPizza implements PizzaFactory {
    public Pizza createDeluxe() {
        Crust deluxeCrust = Crust.DEEP_DISH;
        Pizza newDeluxe = new Deluxe(deluxeCrust);
        return newDeluxe;
    }

    public Pizza createBBQChicken() {
        Crust bbqCrust = Crust.PAN;
        Pizza newBBQChicken = new BBQChicken(bbqCrust);
        return newBBQChicken;
    };
    public Pizza createMeatzza() {
        Crust meatzzaCrust = Crust.STUFFED;
        Pizza newMeatzza = new Meatzza(meatzzaCrust);
        return newMeatzza;
    }
    public Pizza createBuildYourOwn() {
        Crust byoCrust = Crust.PAN;
        Pizza newBuildYourOwn = new BuildYourOwn(byoCrust);
        return newBuildYourOwn;
    }
}
