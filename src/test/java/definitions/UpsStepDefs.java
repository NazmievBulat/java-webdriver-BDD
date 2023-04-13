package definitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.WebDriverWait;
import pages.*;

import java.time.Duration;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;
import static org.openqa.selenium.support.ui.ExpectedConditions.visibilityOfElementLocated;
import static support.TestContext.driver;
import static support.TestContext.getData;

public class UpsStepDefs{

    UpsHomePage homePage = new UpsHomePage();
    UpsOrigin originPage = new UpsOrigin();
    UpsDestination destinationPage = new UpsDestination();
    UpsPackage packagePage = new UpsPackage();
    UpsPickupService pickupServicePage = new UpsPickupService();
    UpsGuided guided = new UpsGuided();
    UpsShipSummary shipSummary = new UpsShipSummary();

    Map<String, String> originData = getData("origin");
    Map<String, String> destinationData = getData("destination");
    Map<String, String> packageData = getData("package");
    Map<String, String> guidedData = getData("guided");



    @Given("I go to {string} page")
    public void iGoToPage(String page) {
        homePage.open();

    }

    @And("I go to Create a Shipment")
    public void iGoToCreateAShipment() {
        homePage.closePopup();
        homePage.goToShip();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(3));
        wait.until(visibilityOfElementLocated(By.xpath
                ("//agent-wrapper[@class='ng-star-inserted']//section[@class='ups-section']")));
//        shipPage.waitFields();

    }

    @When("I fill out origin shipment fields")
    public void iFillOutOriginShipmentFields() throws InterruptedException {
        originPage.selectCountry(originData.get("country"));
        originPage.fillName(originData.get("name"));
        originPage.fillAddress(originData.get("address"));
        originPage.fillEmail(originData.get("email"));
        originPage.fillPhone(originData.get("phone"));
        Thread.sleep(500); // to be removed after bugfix #
    }

    @And("I submit the shipment form")
    public void iSubmitTheShipmentForm() {
        originPage.clickContinue();

    }

    @Then("I verify origin shipment fields submitted")
    public void iVerifyOriginShipmentFieldsSubmitted() {

        String actualResult = destinationPage.getTextResultField();

        System.out.println(actualResult);

        assertThat(actualResult).contains(originData.get("name"), originData.get("address"),
                originData.get("phone"), originData.get("email"));
    }

    @When("I fill out destination shipment fields")
    public void iFillOutDestinationShipmentFields() {
        destinationPage.selectCountry(destinationData.get("country"));
        destinationPage.fillName(destinationData.get("name"));
        destinationPage.fillAddress(destinationData.get("address"));
    }

    @And("I {string} residential address")
    public void iResidentialAddress(String value) {


        if (value.equals("confirm")){
            destinationPage.checkVerificationAddress();
        }
        else {
            destinationPage.uncheckClickVerificationAddress();
        }
    }

    @And("I set packaging type and weight")
    public void iSetPackagingTypeAndWeight() throws InterruptedException {
        packagePage.selectType(packageData.get("type"));
        Thread.sleep(1000); // to be removed after bugfix #
        packagePage.fillWeight(packageData.get("weight"));
        packagePage.fillLength(packageData.get("length"));
        packagePage.fillWidth(packageData.get("width"));
        packagePage.fillHeight(packageData.get("heiqht"));
        packagePage.fillValue(packageData.get("value"));
    }

    @Then("I verify total charges appear")
    public void iVerifyTotalChargesAppear() {
//        pickupServicePage.waitTotalCharges();
        assertThat(pickupServicePage.waitTotalCharges()).isTrue();
    }

    @And("I select cheapest delivery option")
    public void iSelectCheapestDeliveryOption() {
        pickupServicePage.getCheapestPrice();

    }

    @And("I set description and check Saturday Delivery type")
    public void iSetDescriptionAndCheckSaturdayDeliveryType() {
        guided.fillDescription(guidedData.get("description"));

    }

    @And("I check Deliver only to receiver's address")
    public void iCheckDeliverOnlyToReceiverSAddress() {
        guided.checkDeliverToAddress();
    }

    @Then("I verify total charges changed")
    public void iVerifyTotalChargesChanged() {
        System.out.println(guided.verifyChangePrice());
    }

    @And("I select Paypal payment type")
    public void iSelectPaypalPaymentType() throws InterruptedException {
        guided.selectPaypal();
    }

    @Then("I review all recorded details on the review page")
    public void iReviewAllRecordedDetailsOnTheReviewPage() {

        String actualResultShipFrom = shipSummary.getShipFromSummary();
        assertThat(actualResultShipFrom).contains(originData.get("name"), originData.get("address"),
                originData.get("phone"), originData.get("email"));

        String actualResultShipTo = shipSummary.getShipToSummary();
        assertThat(actualResultShipTo).contains(destinationData.get("name"), destinationData.get("address"));

        String actualResultWeight = shipSummary.getWeightFromSummary();
        assertThat(actualResultWeight).contains(packageData.get("weight"));

        String dimensionFromSummary = shipSummary.getDimensionFromSummary();
        assertThat(dimensionFromSummary).contains(packageData.get("length"));
        assertThat(dimensionFromSummary).contains(packageData.get("width"));
        assertThat(dimensionFromSummary).contains(packageData.get("heiqht"));
    }

    @And("I cancel the shipment form")
    public void iCancelTheShipmentForm() {
        shipSummary.scrollWindowWithJs("1500");
        shipSummary.clickCancel();
    }

    @Then("I verify shipment form is reset")
    public void iVerifyShipmentFormIsReset() {
        originPage.verifyResetPage();
    }

}
