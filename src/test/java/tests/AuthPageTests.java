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
            //Need to add assertion
        } catch (Exception e) {
            ExtentTestManager.getTest().log(LogStatus.ERROR, e.getMessage());
            Assert.fail();
        }
    }
}
