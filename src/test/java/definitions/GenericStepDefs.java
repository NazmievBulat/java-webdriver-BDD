package definitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.logging.LogEntries;
import org.openqa.selenium.logging.LogEntry;
import org.openqa.selenium.logging.LogType;

import static support.TestContext.getDriver;

public class GenericStepDefs {
    @Given("I open {string} page")
    public void iOpenPage(String page) {

        switch (page.toLowerCase()) {
            case "quote" -> getDriver().get("https://skryabin.com/market/quote.html");
            case "google" -> getDriver().get("https://google.com");
            case "usps" -> getDriver().get("https://www.usps.com");
            case "unitconverts" -> getDriver().get("https://www.unitconverters.net");
            case "calculator" -> getDriver().get("https://www.calculator.net");
            default -> throw new Error("Unsupported page " + page);
        }
        System.out.println(getDriver().getTitle());
        System.out.println(getDriver().getCurrentUrl());
        System.out.println(getDriver().getWindowHandle());
    }

    @And("I print logs to the console")
    public void iPrintLogsToTheConsole() throws InterruptedException {
        Thread.sleep(500);
        LogEntries logs = getDriver().manage().logs().get(LogType.BROWSER);

        for (LogEntry log : logs){
            System.out.println(log);
        }
    }

    @And("I go to the {string} page")
    public void iGoToThePage(String page) {
        {

            switch (page.toLowerCase()) {
                case "quote" -> getDriver().navigate().to("https://skryabin.com/market/quote.html");
                case "google" -> getDriver().navigate().to("https://google.com");
                default -> throw new Error("Unsupported page " + page);
            }
            System.out.println(getDriver().getTitle());
            System.out.println(getDriver().getCurrentUrl());
            System.out.println(getDriver().getWindowHandle());
        }
    }

    @And("I go back")
    public void iGoBack() {
        getDriver().navigate().back();

    }

    @And("I go forward")
    public void iGoForward() {
        getDriver().navigate().forward();
    }

    @Then("I refresh the page")
    public void iRefreshThePage() {
        getDriver().navigate().refresh();
    }

    @And("I	change resolution to {string}")
    public void iChangeResolutionTo(String size) {
        switch (size.toLowerCase()){
            case "phone":
                getDriver().manage().window().setSize(new Dimension(400, 768));
                break;

            case "desktop":
                getDriver().manage().window().setSize(new Dimension(1024, 768));
                break;

            default: throw new Error("unsupported size " + size);

        }
    }
}
