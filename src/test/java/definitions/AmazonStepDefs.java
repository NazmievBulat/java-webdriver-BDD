package definitions;

import com.gargoylesoftware.htmlunit.Page;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.yaml.snakeyaml.Yaml;

import pages.LinkedinLoginPage;
import support.TestContext;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.Map;

import static support.TestContext.getData;

public class AmazonStepDefs{

//    Map<String, String> amazonData = TestContext.getDataFromFile("amazon");
//
//    AmazonMain main = new AmazonMain();
//
//    @When("I select {string} department in the searchbox")
//    public void iSelectDepartmentInTheSearchbox(String department) {
//        main.selectDepartment(department);
//    }
//
//    @And("I search for {string} in main page")
//    public void iSearchForInMainPage(String book) {
//
//    }
//
//    @And("I search for book in main page")
//    public void iSearchForBookInMainPage() {
//
//        main.searchForBook(amazonData.get("search query"));
//
//    }
//
//    @Then("I verify the book with the right name is appears")
//    public void iVerifyTheBookWithTheRightNameIsAppears() {
//        main.verifyBook(amazonData.get("book name"));
//    }

}
