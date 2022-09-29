package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

public class UpsPackage extends UpsPickupService{

    @FindBy(id = "nbsPackagePackagingTypeDropdown0")
    private WebElement type;

    @FindBy(id = "nbsPackagePackageWeightField0")
    private WebElement weight;

    @FindBy(id = "nbsPackagePackageLengthField0")
    private WebElement length;

    @FindBy(id = "nbsPackagePackageWidthField0")
    private WebElement width;

    @FindBy(id = "nbsPackagePackageHeightField0")
    private WebElement height;

    @FindBy(id = "nbsPackageDeclaredValueField0")
    private WebElement packageValue;



    public void selectType(String value) {
        new Select(type).selectByVisibleText(value);
    }

    public void fillWeight(String value) {
        weight.sendKeys(value);
    }

    public void fillLength(String value) {
        length.sendKeys(value);
    }

    public void fillWidth(String value) {
        width.sendKeys(value);
    }

    public void fillHeight(String value){
        height.sendKeys(value);
    }

    public void fillValue(String value){
        packageValue.sendKeys(value);
    }

}

