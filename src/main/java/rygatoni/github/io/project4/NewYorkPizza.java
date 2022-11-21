package rygatoni.github.io.project4;

public class NewYorkPizza{
    public Pizza createDeluxe() {
        Crust deluxeCrust = Crust.BROOKLYN;
        Pizza newDeluxe = new Deluxe(deluxeCrust);
        return newDeluxe;
    }

    public Pizza createBBQChicken() {
        Crust bbqCrust = Crust.THIN;
        Pizza newBBQChicken = new BBQChicken(bbqCrust);
        return newBBQChicken;
    };
    public Pizza createMeatzza() {
        Crust meatzzaCrust = Crust.HAND_TOSSED;
        Pizza newMeatzza = new Meatzza(meatzzaCrust);
        return newMeatzza;
    }
    public Pizza createBuildYourOwn() {
        Crust byoCrust = Crust.HAND_TOSSED;
        Pizza newBuildYourOwn = new BuildYourOwn(byoCrust);
        return newBuildYourOwn;
    }
}
