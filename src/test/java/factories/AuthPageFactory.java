package factories;

import commonMethods.BaseTest;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

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

    @FindBy(id = "id_gender1")
    WebElement maleGenderRadioButton;

    @FindBy(id = "customer_firstname")
    WebElement firstNameField;

    @FindBy(id = "customer_lastname")
    WebElement lastNameField;

    @FindBy(id = "address1")
    WebElement addressLine1Field;

    @FindBy(id = "city")
    WebElement cityField;

    @FindBy(id = "postcode")
    WebElement postcodeField;

    @FindBy(id = "phone_mobile")
    WebElement mobilePhoneField;

    @FindBy(id = "submitAccount")
    WebElement registerButton;

    @FindBy(id = "id_state")
    WebElement stateSelector;

    @FindBy (className = "logout")
    WebElement logoutButton;

    @FindBy(xpath = "//span[contains(text(),'Dmytro Odarchenko')]")
    public WebElement accountName;

    @FindBy (className = "info-account")
    public WebElement accountInfo;

    @FindBy(xpath = "//div[@class='alert alert-danger']")
    public WebElement alertBlock;

    public AuthPageFactory(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void setSignUpEmail(String signUpEmail){
        signUpEmailField.clear();
        signUpEmailField.sendKeys(signUpEmail);
    }

    public void setSignInEmail(String signInEmail){
        signInEmailField.clear();
        signInEmailField.sendKeys(signInEmail);
    }

    public void setPasswordField(String password){
        passwordField.clear();
        passwordField.sendKeys(password);
    }

    public void setFirstName(String firstName){
        firstNameField.clear();
        firstNameField.sendKeys(firstName);
    }

    public void setLastName(String lastName){
        lastNameField.clear();
        lastNameField.sendKeys(lastName);
    }
    public void setAddressLine1(String addressLine1){
        addressLine1Field.clear();
        addressLine1Field.sendKeys(addressLine1);
    }

    public void setCity(String city){
        cityField.clear();
        cityField.sendKeys(city);
    }

    public void setPostcode(String postcode){
        postcodeField.clear();
        postcodeField.sendKeys(postcode);
    }

    public void setMobilePhone(String mobilePhone){
        mobilePhoneField.clear();
        mobilePhoneField.sendKeys(mobilePhone);
    }

    public void selectMaleRadioButton(){
        maleGenderRadioButton.click();
    }

    public void selectState(String state){
        Select stateSelect = new Select(stateSelector);
        stateSelect.selectByVisibleText(state);
    }

    public void createAccountButtonClick(){
        createAccountButton.click();
    }

    public void registerButtonClick(){
        registerButton.click();
    }

    public void signInButtonClick(){
        signInButton.click();
    }
    public void logoutButtonClick(){
        logoutButton.click();
    }
}
