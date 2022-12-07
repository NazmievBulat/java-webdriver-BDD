package definitions;

import io.cucumber.java.en.When;
import pages.BoeingHome;

public class BoeingStepDefs {
    @When("I go to 737 MAX airplane")
    public void iGoToMAXAirplane() {
        BoeingHome home = new BoeingHome();


    }
}
