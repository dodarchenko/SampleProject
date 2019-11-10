package tests;

import com.relevantcodes.extentreports.LogStatus;
import commonMethods.BaseTest;
import commonMethods.CommonMethods;
import factories.AuthPageFactory;
import factories.CheckoutFactory;
import factories.MainPageFactory;
import org.openqa.selenium.JavascriptExecutor;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import report.ExtentTestManager;

public class CheckoutTests extends BaseTest {

    private AuthPageFactory authPageFactory;
    private MainPageFactory mainPageFactory;
    private CommonMethods commonMethods;
    private CheckoutFactory checkoutFactory;
    private JavascriptExecutor js;


    @BeforeClass(alwaysRun = true)
    public void beforeClass(){
        mainPageFactory = new MainPageFactory(driver);
        authPageFactory = new AuthPageFactory(driver);
        commonMethods = new CommonMethods(driver);
        checkoutFactory = new CheckoutFactory(driver);
        js = ((JavascriptExecutor) driver);
    }

    @Test(groups = {"endToEnd"})
    public void endToEndTest() {
        ExtentTestManager.getTest().setDescription("Test sign in, add to cart, proceed to checkout, finish order");
        try {
            mainPageFactory.loginButtonClick();
            ExtentTestManager.getTest().log(LogStatus.INFO, "Open auth page");
            authPageFactory.setSignInEmail("fortest@test.com");
            ExtentTestManager.getTest().log(LogStatus.INFO, "Fill in email");
            authPageFactory.setPasswordField("12345");
            ExtentTestManager.getTest().log(LogStatus.INFO, "Fill in password");
            authPageFactory.signInButtonClick();
            ExtentTestManager.getTest().log(LogStatus.INFO, "Sign in clicked");
            mainPageFactory.logoClick();
            ExtentTestManager.getTest().log(LogStatus.INFO, "Go to main page");
            js.executeScript("arguments[0].scrollIntoView(true)", mainPageFactory.firstItemInPopular);
            commonMethods.moveCursorToElement(mainPageFactory.firstItemInPopular);
            ExtentTestManager.getTest().log(LogStatus.INFO, "Scroll into view first item in popular");
            mainPageFactory.addToCartClick();
            ExtentTestManager.getTest().log(LogStatus.INFO, "Add to cart clicked");
            checkoutFactory.proceedToCheckoutButtonPopUpClick();
            ExtentTestManager.getTest().log(LogStatus.INFO, "Proceed to checkout");
            ExtentTestManager.getTest().log(LogStatus.INFO, "Check calculations in table");
            Assert.assertTrue(checkoutFactory.checkCheckoutCalculations());
            js.executeScript("arguments[0].scrollIntoView(true)", checkoutFactory.proceedToCheckoutButtonCartStep1);
            checkoutFactory.proceedToCheckoutCart1Click();
            ExtentTestManager.getTest().log(LogStatus.INFO, "Proceed to checkout clicked 3d step");
            js.executeScript("arguments[0].scrollIntoView(true)", checkoutFactory.proceedToCheckoutButtonCartStep2);
            checkoutFactory.proceedToCheckoutCart2Click();
            ExtentTestManager.getTest().log(LogStatus.INFO, "Proceed to checkout clicked 4th step");
            checkoutFactory.selectTermsCheckBox();
            ExtentTestManager.getTest().log(LogStatus.INFO, "Select terms of use checkbox");
            js.executeScript("arguments[0].scrollIntoView(true)", checkoutFactory.proceedToCheckoutButtonCartStep3);
            checkoutFactory.proceedToCheckoutCart3Click();
            ExtentTestManager.getTest().log(LogStatus.INFO, "Proceed to checkout clicked step 5");
            checkoutFactory.payBankWireClick();
            ExtentTestManager.getTest().log(LogStatus.INFO, "Pay by BankWire clicked");
            checkoutFactory.confirmOrderButtonClick();
            ExtentTestManager.getTest().log(LogStatus.INFO, "Confirm order clicked");
            ExtentTestManager.getTest().log(LogStatus.INFO, "Check Order completed message");
            Assert.assertTrue(checkoutFactory.orderCompletedMessage.isDisplayed());
        } catch (Exception e) {
            ExtentTestManager.getTest().log(LogStatus.ERROR, e.getMessage());
            Assert.fail();
        }
    }
}
