package factories;

import commonMethods.BaseTest;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class AuthPageFactory extends BaseTest {

    @FindBy (id = "email_create")
    private
    WebElement signUpEmailField;

    @FindBy(id = "SubmitCreate")
    private
    WebElement createAccountButton;

    @FindBy(id = "email")
    private
    WebElement signInEmailField;

    @FindBy(id = "passwd")
    private
    WebElement passwordField;

    @FindBy(id = "SubmitLogin")
    private
    WebElement signInButton;

    @FindBy(id = "id_gender1")
    private
    WebElement maleGenderRadioButton;

    @FindBy(id = "customer_firstname")
    private
    WebElement firstNameField;

    @FindBy(id = "customer_lastname")
    private
    WebElement lastNameField;

    @FindBy(id = "address1")
    private
    WebElement addressLine1Field;

    @FindBy(id = "city")
    private
    WebElement cityField;

    @FindBy(id = "postcode")
    private
    WebElement postcodeField;

    @FindBy(id = "phone_mobile")
    private
    WebElement mobilePhoneField;

    @FindBy(id = "submitAccount")
    private
    WebElement registerButton;

    @FindBy(id = "id_state")
    private
    WebElement stateSelector;

    @FindBy (className = "logout")
    private
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
