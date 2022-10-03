package definitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.CareersHome;
import pages.CareersLogin;
import pages.CareersRecruit;
import pages.NewPosition;

import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;
import static support.TestContext.getData;

public class CareersStepDefs {


    CareersHome home = new CareersHome();
    CareersLogin login = new CareersLogin();
    CareersRecruit recruit = new CareersRecruit();
    NewPosition newPosition = new NewPosition();

//    Map<String, String> recruiterData = getData("recruiter", "careers");

    @And("I login as {string}")
    public void iLoginAs(String role) {
        Map<String, String> recruiterData = getData(role, "careers");
        home.clickToLogIn();
        login.logIn(recruiterData.get("email"), recruiterData.get("password"));
    }

    @Then("I verify {string} login")
    public void iVerifyLogin(String role) {
        home.verifyOpenPage();
    }

    @When("I remove {string} position")
    public void iRemovePosition(String title) {
        home.clickToRecruitButton();
        recruit.deleteElementByRole(title);
    }

    @And("I verify {string} position is removed")
    public void iVerifyPositionIsRemoved(String role) {
        boolean isVisible = recruit.isElementByRole(role);
        assertThat(isVisible).isFalse();
    }

    @When("I create new position")
    public void iCreateNewPosition() {
        Map<String, String> positionData = getData("position", "careers");
        home.clickToRecruitButton();
        recruit.createNewUserButtonClick();
        newPosition.fillTitle(positionData.get("title"));
        newPosition.fillDescription(positionData.get("description"));
        newPosition.fillCity(positionData.get("city"));
        newPosition.selectState(positionData.get("state"));
        newPosition.selectToday();
        newPosition.clickSubmit();


    }

    @Then("I verify new position is created")
    public void iVerifyNewPositionIsCreated() {
        Map<String, String> positionData = getData("position", "careers");
        recruit.waitElementByRoleIsVisible(positionData.get("title"));
        boolean isVisible = recruit.isElementByRole(positionData.get("title"));
        assertThat(isVisible).isTrue();
//        assertThat(recruit.getTitleElementByRole(positionData.get("title")).contains(positionData.get("title")));

    }

    @When("I remove new position")
    public void iRemoveNewPosition() {
        //removing created position
        Map<String, String> positionData = getData("position", "careers");
        recruit.deleteElementByRole(positionData.get("title"));

    }

    @And("I verify new position is removed")
    public void iVerifyNewPositionIsRemoved() {
        Map<String, String> positionData = getData("position", "careers");
        boolean isVisible = recruit.isElementByRole(positionData.get("title"));
        assertThat(isVisible).isFalse();
    }
}
