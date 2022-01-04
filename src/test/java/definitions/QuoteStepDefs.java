package definitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import static org.assertj.core.api.Assertions.assertThat;
import static support.TestContext.getDriver;

public class QuoteStepDefs {
    @When("I fill out required page")
    public void iFillOutRequiredPage() {
        getDriver().findElement(By.xpath("//input[@name='username']")).sendKeys("jdoe");
        getDriver().findElement(By.xpath("//input[@name='email']")).sendKeys("jdoe@gmail.com");
        //getDriver().findElement(By.xpath("//input[@name='name']")).click();

        WebElement nameElement = getDriver().findElement(By.xpath("//input[@name='name']"));
        nameElement.click();


        getDriver().findElement(By.xpath("//input[@id='firstName']")).sendKeys("John");
        getDriver().findElement(By.xpath("//input[@id='lastName']")).sendKeys("Doe");
        getDriver().findElement(By.xpath("//span[contains(text(),'Save')]")).click();

        String nameValue = nameElement.getAttribute("value");
        System.out.println(nameValue);


        getDriver().findElement(By.xpath("//input[@id='password']")).sendKeys("welcome");
        getDriver().findElement(By.xpath("//input[@id='confirmPassword']")).sendKeys("welcome");
        getDriver().findElement(By.xpath("//input[@name='agreedToPrivacyPolicy']")).click();




    }

    @And("I submit the page")
    public void iSubmitThePage() {
        getDriver().findElement(By.xpath("//button[@id='formSubmit']")).submit();
    }

    @Then("I verify the required fields")
    public void iVerifyTheRequiredFields() {
        String result = getDriver().findElement(By.xpath("//div[@id='quotePageResult']")).getText();
        assertThat(result).contains("John Doe");
        assertThat(result).contains("John Doe");
        assertThat(result).contains("jdoe");
        assertThat(result).contains("jdoe@gmail.com");
        assertThat(result).doesNotContain("welcome");



    }

    @And("I fill out optional page")
    public void iFillOutOptionalPage() {
        getDriver().findElement(By.xpath("//select[@name='countryOfOrigin']/option[@value='USA']")).click();
        getDriver().findElement(By.xpath("//textarea[@id='address']")).sendKeys("\"4970 El Camino Real\" street, \"Los Altos\" city, \"CA\" state");
        getDriver().findElement(By.xpath("//input[@name='phone']")).sendKeys("6463885786");
        getDriver().findElement(By.xpath("//input[@value='male']")).click();
        getDriver().findElement(By.xpath("//select[@name='carMake']/option[@value='Toyota']")).click();
        getDriver().findElement(By.xpath("//input[@id='dateOfBirth']")).sendKeys("03/15/2002");
        getDriver().findElement(By.xpath("//button[@id='thirdPartyButton']")).click();
        getDriver().switchTo().alert().accept();

    }

    @Then("I verify the optional fields")
    public void iVerifyTheOptionalFields() {
        String result = getDriver().findElement(By.xpath("//div[@id='quotePageResult']")).getText();
        assertThat(result).contains("Toyota");
        assertThat(result).contains("6463885786");
        assertThat(result).contains("male");
        assertThat(result).contains("03/15/2002");
        assertThat(result).contains("\"4970 El Camino Real\" street, \"Los Altos\" city, \"CA\" state");
    }
}
