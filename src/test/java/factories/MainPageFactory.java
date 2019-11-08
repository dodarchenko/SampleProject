package factories;

import commonMethods.BaseTest;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class MainPageFactory extends BaseTest {

    @FindBy (className = "login")
    WebElement loginButton;

    @FindBy (id = "search_query_top")
    WebElement searchField;

    @FindBy(xpath = "(//div[@class='product-image-container'])[1]")
    WebElement firstItemInPopular;

    @FindBy(xpath = "//a[@title='Women']")
    WebElement womenTab;

    @FindBy (xpath = "//a[@class='quick-view']")
    WebElement quickViewButton;

    @FindBy (xpath = "//span[contains(text(), 'Add to cart')]")
    WebElement addToCartButton;

    @FindBy (xpath = "//span[contains(text(), 'More')]")
    WebElement seeMoreButton;








    public MainPageFactory(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }
}
