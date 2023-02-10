package definitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.openqa.selenium.support.ui.ExpectedConditions.*;
import static support.TestContext.driver;
import static support.TestContext.getDriver;

public class UspsStepDefs {

    public void assertion(String actualResult, String expectedResult){
        if(actualResult.contains(expectedResult)){
            System.out.println("The result is good");
        }
        else{
            throw new AssertionError();
        }

    }
    @When("I go to Lookup ZIP page by address")
    public void iGoToLookupZIPPageByAddress() {
        WebElement sendMenu = getDriver().findElement(By.xpath("//li[@class='qt-nav menuheader']"));
        new Actions(getDriver()).moveToElement(sendMenu).perform();

        getDriver().findElement(By.xpath("//img[@alt='Zip Code™ Lookup Icon']")).click();

        String LookUp = getDriver().findElement(By.xpath("//div[@id='zip-lookup-welcome']")).getText();
        assertThat(LookUp).contains("Look Up a ZIP Code™");

        getDriver().findElement(By.xpath("//p[@class='column-one-text']/../a[@data-location='byaddress']")).click();

        WebDriverWait wait = new WebDriverWait(driver, 10);
        WebElement byAdress = wait.until(visibilityOfElementLocated(By.xpath("//div[@id='zip-lookup-app']")));
        String byAdress1 = byAdress.getText();

        //String byAdress = getDriver().findElement(By.xpath("//div[@id='zip-lookup-app']")).getText();
        assertThat(byAdress1).contains("ZIP Code™ by Address");


    }

    @And("I fill out {string} street, {string} city, {string} state")
    public void iFillOutStreetCityState(String str, String city, String st) {

        getDriver().findElement(By.xpath("//input[@id='tAddress']")).sendKeys(str);

        getDriver().findElement(By.xpath("//input[@id='tCity']")).sendKeys(city);

        WebElement selectElement = getDriver().findElement(By.xpath("//select[@id='tState']"));
        Select select = new Select(selectElement);
        select.selectByValue(st.toUpperCase());


//        getDriver().findElement(By.xpath("//select[@id='tState']/option[@value='" + st.toUpperCase() + "']")).click();
        getDriver().findElement(By.xpath("//a[@id='zip-by-address']")).click();
//        String string = String.format("//select[@id='tState']/option[@value='%s']", st.toUpperCase());
//        getDriver().findElement(By.xpath(string)).click();


    }

    @Then("I validate {string} zip code exists in the result")
    public void iValidateZipCodeExistsInTheResult(String zip) {
        WebElement resultContainer = getDriver().findElement(By.xpath("//div[@id='zipByAddressDiv']"));
        WebDriverWait wait = new WebDriverWait(getDriver(), 5);
        wait.until(visibilityOf(resultContainer));
//        wait.until(driver -> resultContainer.getText().length())

        String resultString = resultContainer.getText();
        assertThat(resultString).contains(zip);
       assertion(resultString, zip);
    }

    @When("I go to Calculate Price Page")
    public void iGoToCalculatePricePage() {
        WebElement sendMenu = getDriver().findElement(By.xpath("//a[@id='mail-ship-width']"));
        new Actions(getDriver()).moveToElement(sendMenu).perform();
        getDriver().findElement(By.xpath("//a[@id='mail-ship-width']/..//../li[@class='tool-calc']")).click();


    }

    @And("I select {string} with {string} shape")
    public void iSelectWithShape(String country, String shape) {

        WebElement countryMenu = getDriver().findElement(By.xpath("//select[@id='CountryID']"));
        new Select(countryMenu).selectByVisibleText(country);

        getDriver().findElement(By.xpath("//input[@value='" + shape + "']")).click();

    }

    @And("I define {string} quantity")
    public void iDefineQuantity(String quantity) {

        getDriver().findElement(By.xpath("//input[@id='quantity-0']")).sendKeys(quantity);
    }

    @Then("I calculate the price and validate cost is {string}")
    public void iCalculateThePriceAndValidateCostIs(String cost) {

        getDriver().findElement(By.xpath("//input[@value='Calculate']")).click();

        String resultTotal = getDriver().findElement(By.xpath("//div[@id='total']")).getText();

        assertThat(resultTotal).isEqualTo(cost);
    }

    @When("I perform {string} search")
    public void iPerformSearch(String searches) {

        WebElement searchButton = getDriver().findElement(By.xpath("//a[@id='navsearch']/.."));
        new Actions(getDriver()).moveToElement(searchButton).perform();

        switch (searches.toUpperCase()) {
            case "PO BOXES" -> getDriver().findElement(By.xpath("//ul[@aria-hidden='true']//a[@role='menuitem'][contains(text(),'" + searches.toUpperCase() + "')]")).click();
            case "PASSPORTS" -> getDriver().findElement(By.xpath("//ul[@aria-hidden='true']//a[@role='menuitem'][contains(text(),'" + searches.toUpperCase() + "')]")).click();
            case "FREE BOXES" -> getDriver().findElement(By.xpath("//ul[@aria-hidden='true']//a[@role='menuitem'][contains(text(),'" + searches.toUpperCase() + "')]")).click();
            // case -> getDriver().findElement(By.xpath("//input[@id='global-header--search-track-search']")).sendKeys(searches);
            default -> {
                getDriver().findElement(By.xpath("//input[@id='global-header--search-track-search']")).sendKeys(searches + Keys.RETURN);
                //getDriver().findElement(By.xpath("//input[@id='global-header--search-track-search']")).sendKeys(Keys.RETURN);
            }
        }
    }

    @And("I set {string} in filters")
    public void iSetInFilters(String filter) {

        WebDriverWait wait = new WebDriverWait(driver, 10);
        WebElement menuNavi = wait.until(visibilityOfElementLocated(By.xpath("//div[@id='dyn_nav_col']")));

        getDriver().findElement(By.xpath("//p[@title='" + filter + "']")).click();
    }

    @Then("I verify that {string} results found")
    public void iVerifyThatResultsFound(String numberOfResults) {

        WebDriverWait wait = new WebDriverWait(driver, 10);
        WebElement searchResult = wait.until(visibilityOfElementLocated(By.xpath("//span[@id='searchResultsHeading']")));
        String result = getDriver().findElement(By.xpath("//span[@id='searchResultsHeading']")).getText();
        assertThat(result).contains(numberOfResults);
    }

    @When("I select {string} in results")
    public void iSelectInResults(String searchText) {
        getDriver().findElement(By.xpath("//span[contains(text(),'" + searchText + "')]")).click();

    }

    @And("I click {string} button")
    public void iClickButton(String buttonName) {

        getDriver().findElement(By.xpath("//a[text()='" + buttonName + " ']")).click();
    }

    @Then("I validate that Sign In is required")
    public void iValidateThatSignInIsRequired() {
        String originalWindow = getDriver().getWindowHandle();
        getDriver().getWindowHandles();
        getDriver().getWindowHandles().forEach(handle -> getDriver().switchTo().window(handle));

//           if (getDriver().getTitle().equals("USPS.com® - Sign In")) {
//                String signIn = getDriver()
//                        .findElement(By.xpath("//h1[@id='sign-in-to-your-account-header']")).getText();

                WebDriverWait wait = new WebDriverWait(driver, 5);
                wait.until(titleContains("Sign In"));
        getDriver().switchTo().window(originalWindow);
           // }



//
//        WebDriverWait wait = new WebDriverWait(driver, 10);
//        WebElement searchResult = wait.until(visibilityOfElementLocated(By.xpath("//img[@id='usps-logo']")));
//
//        String result = getDriver().findElement(By.xpath("//button[@id='btn-submit']")).getText();
//        assertThat(result).isEqualTo("Sign In");

        }

    @When("I go to {string} under {string}")
    public void iGoToUnder(String menuItem, String menu) {
        WebElement sendMenu = getDriver().findElement(By.xpath("//a[text()='"+menu+"']"));
        new Actions(getDriver()).moveToElement(sendMenu).perform();
        getDriver().findElement(By.xpath("//a[text()='"+menuItem+"']")).click();



    }

    @And("I search for {string}")
    public void iSearchFor(String search) {
        getDriver().findElement(By.xpath("//input[@id='cityOrZipCode']")).sendKeys(search);
        getDriver().findElement(By.xpath("//a[@class='btn-primary eddm-search-btn']")).click();
    }

    @And("I choose view as {string} on the map")
    public void iChooseViewAsOnTheMap(String view) {
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(invisibilityOfElementLocated(By.xpath("//div[@class='white-spinner-progress']")));
        getDriver().findElement(By.xpath("//span[@class='"+view.toLowerCase()+"-view-icon']")).click();
    }

    @When("I select all in the table")
    public void iSelectAllInTheTable() {

        getDriver().findElement(By.xpath("//th[@class='text-right']//span[@class='checkbox']")).click();
    }

    @And("I close modal window")
    public void iCloseModalWindow() {
        WebDriverWait wait = new WebDriverWait(driver, 5);
        wait.until(visibilityOfElementLocated(By.xpath(
                "//div[@id='drop-off-location-modal']//div[@class='modal-content modal-container']")));
        getDriver().findElement(By.xpath(
                "//div[@id='drop-off-location-modal']//div[@class='modal-header']//a[@type='button']")).click();

        WebElement nextStep = getDriver().findElement(By.xpath("//a[normalize-space()='Next Step']"));
        new Actions(getDriver()).moveToElement(nextStep).perform();

    }


    @Then("I verify that summary of all rows of Cost column is equal Approximate Cost in Order Summary")
    public void iVerifyThatSummaryOfAllRowsOfCostColumnIsEqualApproximateCostInOrderSummary() {
        String totalResultsText = getDriver().findElement(By.id("totalRoutesSelected")).getText();
        int totalResults = Integer.parseInt(totalResultsText);
        List<WebElement> rows = getDriver().findElements(By.xpath("//tbody/tr/td[9]"));
        int count = rows.size();

        assertThat(count).isEqualTo(totalResults);
        System.out.println("ROW COUNT : "+count);

        double sum = 0;

        for(WebElement e : rows) {
            String rowsValue = e.getText();
            String cleanRowsValue = rowsValue.replaceAll("\\$", "");
            System.out.println(cleanRowsValue);
            double sumValue = Double.parseDouble(cleanRowsValue);
            sum += sumValue;


        }

        NumberFormat formatter = new DecimalFormat("#0.00");
        String sumResult = "$" + formatter.format(sum);
        //System.out.println(sumResult);
        String expResult = getDriver().findElement(By.xpath("//p[@id='approximateCost']")).getText();

        assertThat(sumResult).isEqualTo(expResult);

    }


    @And("I perform {string} help search")
    public void iPerformHelpSearch(String helpSearch) {

        //JavascriptExecutor JS = (JavascriptExecutor)getDriver();
        WebElement search = getDriver().findElement(By.xpath("//input[contains(@class,'uiInputTextForAutocomplete')]"));
        search.sendKeys(helpSearch);
        search.sendKeys(Keys.RETURN);



    }

    @Then("I verify that no results of {string} available in help search")
    public void iVerifyThatNoResultsOfAvailableInHelpSearch(String searchResult) {
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(visibilityOfElementLocated(By.xpath("//ul[@class='slds-has-dividers--bottom']")));
    }

    @When("I navigate to {string} heading link")
    public void iNavigateToHeadingLink(String locationButton) {
        getDriver().findElement(By.xpath("//a[@id='link-locator']")).click();

    }


    @And("I search for location {string}")
    public void iSearchForLocation(String searchField) {
        getDriver().findElement(By.xpath("//input[@id='city-state-input']")).
                sendKeys(searchField);
        getDriver().findElement(By.xpath("//a[@id='searchLocations']")).click();
    }

    @Then("I verify closest location phone number is {string}")
    public void iVerifyClosestLocationPhoneNumberIs(String phone) {

        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(visibilityOfElementLocated(By.xpath("//div[@id='resultBox']")));

        List<WebElement> boxes = getDriver().findElements(By.xpath
                ("//div[@class='list-item-location popover-trigger']"));
        int count = boxes.size();
        System.out.println(count);
//        boxes.get(0).getText();

        List<WebElement> button = getDriver().findElements(By.xpath
                ("//div[@class='col-md-12 col-xs-12']//p"));
        button.get(0).click();

        WebDriverWait wait1 = new WebDriverWait(driver, 5);
        wait1.until(visibilityOfElementLocated(By.xpath("//div[@class='phone-wrapper']")));

        String phones = getDriver().findElement(By.xpath("//div[@class='phone-wrapper']")).getText();
        assertThat(phones).contains(phone);







    }
}
