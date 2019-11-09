package tests;

import com.relevantcodes.extentreports.LogStatus;
import commonMethods.BaseTest;
import commonMethods.CommonMethods;
import factories.MainPageFactory;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import report.ExtentTestManager;
import java.util.concurrent.TimeUnit;


public class MainPageTests extends BaseTest {

    MainPageFactory mainPageFactory;
    CommonMethods commonMethods;
    int itemsInCart;
    JavascriptExecutor js;
    WebDriverWait wait;

    @BeforeClass
    public void beforeClass(){
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        mainPageFactory = new MainPageFactory(driver);
        commonMethods = new CommonMethods(driver);
        js = ((JavascriptExecutor) driver);
    }

   @Test
    public void checkSliderPresence(){
        try{
        ExtentTestManager.getTest().setDescription("Check presence of slider element");
        Assert.assertTrue(mainPageFactory.mainPageSlider.isDisplayed());
    }catch(Exception e){
            ExtentTestManager.getTest().log(LogStatus.ERROR, e.getMessage());
            Assert.fail();
        }
    }

    @Test
    public void checkCartPresence(){
        try{
            ExtentTestManager.getTest().setDescription("Check presence of shopping cart element");
            Assert.assertTrue(mainPageFactory.shoppingCart.isDisplayed());
        }catch(Exception e){
            ExtentTestManager.getTest().log(LogStatus.ERROR, e.getMessage());
            Assert.fail();
        }
    }

    @Test
    public void addItemToCart(){
        ExtentTestManager.getTest().setDescription("Test adding item to the shopping cart");
        try {
            js.executeScript("arguments[0].scrollIntoView(true)", mainPageFactory.firstItemInPopular);
            commonMethods.moveCursorToElement(mainPageFactory.firstItemInPopular);
            ExtentTestManager.getTest().log(LogStatus.INFO, "Scroll into view first item in the popular");
            mainPageFactory.addToCartClick();
            ExtentTestManager.getTest().log(LogStatus.INFO, "Add to cart clicked");
            wait = new WebDriverWait(driver, 10);
            wait.until(ExpectedConditions.visibilityOf(mainPageFactory.closePopUp));
            mainPageFactory.closePupUp();
            ExtentTestManager.getTest().log(LogStatus.INFO, "Pop up closed");
            js.executeScript("arguments[0].scrollIntoView(true)", mainPageFactory.shoppingCart);
            commonMethods.moveCursorToElement(mainPageFactory.shoppingCart);
            ExtentTestManager.getTest().log(LogStatus.INFO, "Scroll into view shopping cart");
            Assert.assertEquals(mainPageFactory.getSizeOfProductInCart(), 1);
        }catch(Exception e){
            ExtentTestManager.getTest().log(LogStatus.ERROR, e.getMessage());
            Assert.fail();
        }
    }

    @Test
    public void removeItemFromCart() {
        ExtentTestManager.getTest().setDescription("Test removing item from the shopping cart");
        try {
            js.executeScript("arguments[0].scrollIntoView(true)", mainPageFactory.shoppingCart);
            commonMethods.moveCursorToElement(mainPageFactory.shoppingCart);
            ExtentTestManager.getTest().log(LogStatus.INFO, "Scroll into view shopping cart");
            itemsInCart = mainPageFactory.getSizeOfProductInCart();
            ExtentTestManager.getTest().log(LogStatus.INFO, "Get size of items in cart");
            mainPageFactory.removeFromCartClick();
            ExtentTestManager.getTest().log(LogStatus.INFO, "Remove item clicked");
            Assert.assertTrue(itemsInCart > mainPageFactory.getSizeOfProductInCart());
        } catch (Exception e) {
            ExtentTestManager.getTest().log(LogStatus.ERROR, e.getMessage());
            Assert.fail();
        }
    }

    @Test
    public void searchForItem() {
        ExtentTestManager.getTest().setDescription("Test search of item");
        try {
            mainPageFactory.searchFotItem("Printed Dress");
            ExtentTestManager.getTest().log(LogStatus.INFO, "Search for item");
            Assert.assertTrue(!mainPageFactory.searchResult.isEmpty());
            driver.navigate().back();
        } catch (Exception e) {
            ExtentTestManager.getTest().log(LogStatus.ERROR, e.getMessage());
            Assert.fail();
        }
    }
}
