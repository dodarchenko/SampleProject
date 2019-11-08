package commonMethods;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import java.util.Random;


public class CommonMethods extends BaseTest{


    public CommonMethods(WebDriver driver){

        this.driver = driver;
        PageFactory.initElements(driver, this);
    }



    public void moveCursorToElement(WebElement webElement){
        Actions action = new Actions(driver);
        action.moveToElement(webElement).build().perform();
    }

    public String generateString() {
        String SALTCHARS = "ABCDEFGHIJKLMNOPQRSTUVWXYZ1234567890";
        StringBuilder salt = new StringBuilder();
        Random rnd = new Random();
        while (salt.length() < 12) { // length of the random string.
            int index = (int) (rnd.nextFloat() * SALTCHARS.length());
            salt.append(SALTCHARS.charAt(index));
        }
        return salt.toString();
    }
}
