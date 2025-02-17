package factories;

import commonMethods.BaseTest;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CheckoutFactory extends BaseTest {

    @FindBy(xpath = "//span[contains(text(), 'Proceed to checkout')]")
    private WebElement proceedToCheckoutButtonPopUp;

    @FindBy(xpath = "//p[@class='cart_navigation clearfix']//a[@title='Proceed to checkout']")
    public WebElement proceedToCheckoutButtonCartStep1;

    @FindBy(xpath = "//button[@name='processAddress']//span[contains(text(),'Proceed to checkout')]")
    public WebElement proceedToCheckoutButtonCartStep2;

    @FindBy(xpath = "//button[@name='processCarrier']//span[contains(text(),'Proceed to checkout')]")
    public WebElement proceedToCheckoutButtonCartStep3;

    @FindBy (id = "cgv")
    private
    WebElement termsOfUseCheckbox;

    @FindBy (className = "bankwire")
    private
    WebElement payByBankWire;

    @FindBy(xpath = "//span[contains(text(), 'I confirm my order')]")
    private
    WebElement confirmOrderButton;

    @FindBy(id = "total_product")
    private
    WebElement totalProductsPrice;

    @FindBy(id = "total_shipping")
    private
    WebElement totalShippingPrice;

    @FindBy(id = "total_tax")
    private
    WebElement totalTaxPrice;

    @FindBy(id = "total_price")
    private
    WebElement totalPrice;

    @FindBy(xpath = "//strong[contains(text(),'Your order on My Store is complete.')]")
    public WebElement orderCompletedMessage;



    public CheckoutFactory(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void proceedToCheckoutButtonPopUpClick(){
        proceedToCheckoutButtonPopUp.click();
    }

    private double getPrice(WebElement element){
        return Double.parseDouble(element.getText().substring(1));
    }

    public boolean checkCheckoutCalculations(){
       return getPrice(totalProductsPrice)+getPrice(totalShippingPrice)+getPrice(totalTaxPrice)==getPrice(totalPrice);
    }

    public void selectTermsCheckBox(){
        termsOfUseCheckbox.click();
    }
    public void payBankWireClick(){
        payByBankWire.click();
    }
    public void confirmOrderButtonClick(){
        confirmOrderButton.click();
    }
    public void proceedToCheckoutCart1Click(){
        proceedToCheckoutButtonCartStep1.click();
    }
    public void proceedToCheckoutCart2Click(){
        proceedToCheckoutButtonCartStep2.click();
    }
    public void proceedToCheckoutCart3Click(){
        proceedToCheckoutButtonCartStep3.click();
    }
}
