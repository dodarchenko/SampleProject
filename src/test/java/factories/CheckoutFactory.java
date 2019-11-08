package factories;

import commonMethods.BaseTest;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CheckoutFactory extends BaseTest {

    @FindBy(xpath = "//span[contains(text(), 'Proceed to checkout')]")
    WebElement proceedToCheckoutButton;

    @FindBy (id = "cgv")
    WebElement termsOfUseCheckbox;

    @FindBy (className = "bankwire")
    WebElement payByBankWire;

    @FindBy(xpath = "//span[contains(text(), 'I confirm my order')]")
    WebElement confirmOrderButton;



    public CheckoutFactory(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }
}
