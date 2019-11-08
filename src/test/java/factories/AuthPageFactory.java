package factories;

import commonMethods.BaseTest;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AuthPageFactory extends BaseTest {

    @FindBy (id = "email_create")
    WebElement signUpEmailField;

    @FindBy(id = "SubmitCreate")
    WebElement createAccountButton;

    @FindBy(id = "email")
    WebElement signInEmailField;

    @FindBy(id = "passwd")
    WebElement passwordField;

    @FindBy(id = "SubmitLogin")
    WebElement signInButton;

    @FindBy(linkText = "Forgot your password?")
    WebElement forgotPasswordLink;

    @FindBy(id = "id_gender1")
    WebElement maleGenderRadioButton;

    @FindBy(id = "id_gender2")
    WebElement femaleGenderRadioButton;

    @FindBy(id = "customer_firstname")
    WebElement firstNameField;

    @FindBy(id = "customer_lastname")
    WebElement lastNameField;

    @FindBy(id = "company")
    WebElement companyField;

    @FindBy(id = "address1")
    WebElement addressLine1Field;

    @FindBy(id = "address2")
    WebElement addressLine2Field;

    @FindBy(id = "city")
    WebElement cityField;

    @FindBy(id = "postcode")
    WebElement postcodeField;

    @FindBy(id = "phone_mobile")
    WebElement mobilePhoneField;

    @FindBy(id = "alias")
    WebElement aliasAddressField;

    @FindBy(id = "submitAccount")
    WebElement registerButton;

    @FindBy(id = "days")
    WebElement daysSelector;

    @FindBy(id = "months")
    WebElement monthsSelector;

    @FindBy(id = "years")
    WebElement yearsSelector;

    @FindBy(id = "id_state")
    WebElement stateSelector;

    public AuthPageFactory(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }
}
