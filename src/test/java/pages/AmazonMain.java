//package pages;
//
//import org.openqa.selenium.By;
//import org.openqa.selenium.WebElement;
//import org.openqa.selenium.support.FindBy;
//import org.openqa.selenium.support.ui.ExpectedCondition;
//import org.openqa.selenium.support.ui.ExpectedConditions;
//import org.openqa.selenium.support.ui.Wait;
//import org.openqa.selenium.support.ui.WebDriverWait;
//import support.TestContext;
//
//import java.util.Map;
//
//
//
//public class AmazonMain extends Page{
//
//    @FindBy(id = "searchDropdownBox")
//    public WebElement departmentDropdown;
//
//    @FindBy(id = "twotabsearchtextbox")
//    public WebElement searchField;
//
//    @FindBy(id = "nav-search-submit-button")
//    public WebElement searchButton;
//
//    private WebElement searchResult(String name){
//        return TestContext.getDriver().findElement
//                (By.xpath("//span[text()='"+ name +"']"));
//    }
//
//
//
//    public void selectDepartment(String department) {
//        TestContext.selectByText(departmentDropdown, department);
//
//
//    }
//
//    public void searchForBook(String search_query) {
//        searchField.sendKeys(search_query);
//        searchButton.click();
//
//    }
//
//    public void verifyBook(String book_name) {
//        waitUntilElementVisible(searchResult(book_name));
//    }
//
//    private void waitUntilElementVisible(WebElement webElement) {
//    }
//}
