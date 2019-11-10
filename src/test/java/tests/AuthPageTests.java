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
    AuthPageFactory authPageFactory;
    MainPageFactory mainPageFactory;
    CommonMethods commonMethods;

    @BeforeClass
    public void beforeClass(){
        mainPageFactory = new MainPageFactory(driver);
        authPageFactory = new AuthPageFactory(driver);
        commonMethods = new CommonMethods(driver);
    }

    @Test
    public void signUpTest() {
        ExtentTestManager.getTest().setDescription("Test sign up");
        try {
            mainPageFactory.loginButtonClick();
            authPageFactory.setSignUpEmail(commonMethods.generateString() + "@gmail.com");
            authPageFactory.createAccountButtonClick();
            authPageFactory.selectMaleRadioButton();
            authPageFactory.setFirstName("Dmytro");
            authPageFactory.setLastName("Odarchenko");
            authPageFactory.setPasswordField("123456789");
            authPageFactory.setAddressLine1("Some street name");
            authPageFactory.setCity("Limassol");
            authPageFactory.selectState("Delaware");
            authPageFactory.setPostcode("09000");
            authPageFactory.setMobilePhone("0001112312");
            authPageFactory.registerButtonClick();
            Assert.assertTrue(authPageFactory.accountInfo.isDisplayed());
            authPageFactory.logoutButtonClick();
        } catch (Exception e) {
            ExtentTestManager.getTest().log(LogStatus.ERROR, e.getMessage());
            authPageFactory.logoutButtonClick();
            Assert.fail();
        }
    }

    @Test
    public void checkValidation() {
        ExtentTestManager.getTest().setDescription("Test sign in validation");
        try {
            mainPageFactory.loginButtonClick();
            authPageFactory.setSignInEmail("emaildoesntexist@gmail.com");
            authPageFactory.setPasswordField("123456");
            authPageFactory.signInButtonClick();
            Assert.assertTrue(authPageFactory.alertBlock.isDisplayed());
        } catch (Exception e) {
            ExtentTestManager.getTest().log(LogStatus.ERROR, e.getMessage());
            Assert.fail();
        }
    }

    @Test
    public void checkSignIn() {
        ExtentTestManager.getTest().setDescription("Test sign in with valida data");
        try {
            mainPageFactory.loginButtonClick();
            authPageFactory.setSignInEmail("fortest@test.com");
            authPageFactory.setPasswordField("12345");
            authPageFactory.signInButtonClick();
            Assert.assertTrue(authPageFactory.accountName.isDisplayed());
            authPageFactory.logoutButtonClick();
        } catch (Exception e) {
            ExtentTestManager.getTest().log(LogStatus.ERROR, e.getMessage());
            authPageFactory.logoutButtonClick();
            Assert.fail();
        }
    }
}
