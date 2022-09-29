package definitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.QuoteForm;
import pages.QuoteResult;

import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;
import static support.TestContext.getData;

public class QuoteOopStepDefs {

    QuoteForm form = new QuoteForm();
    QuoteResult formResult = new QuoteResult();

    @Given("I go to {string} page oop")
    public void iGoToPageOop(String page) {
        form.open();
    }

    @When("I fill out {string} required fields oop")
    public void iFillOutRequiredFieldsOop(String userType) {
        Map<String, String> user = getData(userType);
        form.fillUsername(user.get("username"));
        form.fillEmail(user.get("email"));
        form.fillPasswords(user.get("password"));
        form.fillName(user.get("firstName"), user.get("lastName"));
        form.acceptPrivacyPolicy();
    }

    @And("I submit the page oop")
    public void iSubmitThePageOop() {
        form.submit();
    }

    @Then("I verify {string} required fields oop")
    public void iVerifyTheRequiredFieldsOop(String userType) {
        Map<String, String> user = getData(userType);
        System.out.println("Verifying for " + userType);

       String actualResult =  formResult.getResultContainer();
        System.out.println(actualResult);
        String passwordText = formResult.getPassword();
        boolean agreedToPrivacyPolicy = formResult.isAgreedToPrivacyPolicy();
        assertThat(actualResult).contains(user.get("firstName"), user.get("lastName"),
                user.get("username"),user.get("email"));

        assertThat(passwordText).doesNotContain(user.get("password"));
        assertThat(agreedToPrivacyPolicy).isTrue();

    }

    @Then("I don't see {string} error message")
    public void iDonTSeeErrorMessage(String arg0) {
        //assertThat(getDriver().findElements(By.xpath("//label[@id='username-error']"))).hasSize(0);
        System.out.println(form.invUsernameError());
        assertThat(form.invUsernameError()).isEqualTo(0);


    }
}