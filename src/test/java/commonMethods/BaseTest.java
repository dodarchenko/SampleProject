package commonMethods;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

import java.util.concurrent.TimeUnit;


public class BaseTest {
    public WebDriver driver;

    public WebDriver getDriver() {
        return driver;
    }

    @BeforeClass(alwaysRun = true)
    @Parameters({"environmentURL", "browser"})
    public void setup(String environmentURL, String browser) {

        if(browser.equals("firefox")){
            System.setProperty("webdriver.gecko.driver","src\\drivers\\geckodriver.exe");
           driver = new FirefoxDriver();
        }else {
            System.setProperty("webdriver.chrome.driver", "src\\drivers\\chromedriver3.exe");
            driver = new ChromeDriver();
        }

        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
        driver.get(environmentURL);
    }
    @AfterClass(alwaysRun = true)
    public void tearDown() {
        driver.quit();
    }
}

