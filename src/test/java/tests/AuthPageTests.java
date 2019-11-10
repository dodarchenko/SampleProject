package tests;

import com.relevantcodes.extentreports.LogStatus;
import commonMethods.BaseTest;
import commonMethods.CommonMethods;
import factories.AuthPageFactory;
import factories.MainPageFactory;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import report.ExtentTestManager;

public class AuthPageTests extends BaseTest {
    private AuthPageFactory authPageFactory;
    private MainPageFactory mainPageFactory;
    private CommonMethods commonMethods;

    @BeforeClass(alwaysRun = true)
    public void beforeClass(){
        mainPageFactory = new MainPageFactory(driver);
        authPageFactory = new AuthPageFactory(driver);
        commonMethods = new CommonMethods(driver);
    }

    @Test(groups = {"auth"}, priority = 2)
    public void signUpTest() {
        ExtentTestManager.getTest().setDescription("Test sign up");
        try {
            mainPageFactory.loginButtonClick();
            ExtentTestManager.getTest().log(LogStatus.INFO, "Login botton clicked");
            authPageFactory.setSignUpEmail(commonMethods.generateString() + "@gmail.com");
            ExtentTestManager.getTest().log(LogStatus.INFO, "Set generated email");
            authPageFactory.createAccountButtonClick();
            ExtentTestManager.getTest().log(LogStatus.INFO, "Create account button clicked");
            authPageFactory.selectMaleRadioButton();
            ExtentTestManager.getTest().log(LogStatus.INFO, "Select male gender");
            authPageFactory.setFirstName("Dmytro");
            ExtentTestManager.getTest().log(LogStatus.INFO, "Fill in First Name");
            authPageFactory.setLastName("Odarchenko");
            ExtentTestManager.getTest().log(LogStatus.INFO, "Fill in last name");
            authPageFactory.setPasswordField("123456789");
            ExtentTestManager.getTest().log(LogStatus.INFO, "Fill in Password");
            authPageFactory.setAddressLine1("Some street name");
            ExtentTestManager.getTest().log(LogStatus.INFO, "Fill in street");
            authPageFactory.setCity("Limassol");
            ExtentTestManager.getTest().log(LogStatus.INFO, "Fill in City");
            authPageFactory.selectState("Delaware");
            ExtentTestManager.getTest().log(LogStatus.INFO, "Select State");
            authPageFactory.setPostcode("09000");
            ExtentTestManager.getTest().log(LogStatus.INFO, "Fill in Postcode");
            authPageFactory.setMobilePhone("0001112312");
            ExtentTestManager.getTest().log(LogStatus.INFO, "Fill in Mobile phone");
            authPageFactory.registerButtonClick();
            ExtentTestManager.getTest().log(LogStatus.INFO, "Click Register button");
            Assert.assertTrue(authPageFactory.accountInfo.isDisplayed());
            authPageFactory.logoutButtonClick();
        } catch (Exception e) {
            ExtentTestManager.getTest().log(LogStatus.ERROR, e.getMessage());
            authPageFactory.logoutButtonClick();
            Assert.fail();
        }
    }

    @Test(groups = {"auth", "validation"})
    public void checkValidation() {
        ExtentTestManager.getTest().setDescription("Test sign in validation");
        try {
            mainPageFactory.loginButtonClick();
            ExtentTestManager.getTest().log(LogStatus.INFO, "Login button clicked");
            authPageFactory.setSignInEmail("emaildoesntexist@gmail.com");
            ExtentTestManager.getTest().log(LogStatus.INFO, "Fill in email");
            authPageFactory.setPasswordField("123456");
            ExtentTestManager.getTest().log(LogStatus.INFO, "Fill in password");
            authPageFactory.signInButtonClick();
            ExtentTestManager.getTest().log(LogStatus.INFO, "Click sign in");
            Assert.assertTrue(authPageFactory.alertBlock.isDisplayed());
        } catch (Exception e) {
            ExtentTestManager.getTest().log(LogStatus.ERROR, e.getMessage());
            Assert.fail();
        }
    }

    @Test(groups = {"auth"},priority = 1)
    public void checkSignIn() {
        ExtentTestManager.getTest().setDescription("Test sign in with valida data");
        try {
            mainPageFactory.loginButtonClick();
            ExtentTestManager.getTest().log(LogStatus.INFO, "Login button clicked");
            authPageFactory.setSignInEmail("fortest@test.com");
            ExtentTestManager.getTest().log(LogStatus.INFO, "Fill in invalid email");
            authPageFactory.setPasswordField("12345");
            ExtentTestManager.getTest().log(LogStatus.INFO, "Fill in password");
            authPageFactory.signInButtonClick();
            ExtentTestManager.getTest().log(LogStatus.INFO, "Click register button");
            Assert.assertTrue(authPageFactory.accountName.isDisplayed());
            authPageFactory.logoutButtonClick();
        } catch (Exception e) {
            ExtentTestManager.getTest().log(LogStatus.ERROR, e.getMessage());
            authPageFactory.logoutButtonClick();
            Assert.fail();
        }
    }
}
