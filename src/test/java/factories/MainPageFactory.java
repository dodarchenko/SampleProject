package factories;

import commonMethods.BaseTest;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class MainPageFactory extends BaseTest {

    @FindBy (className = "login")
    WebElement loginButton;

    @FindBy (id = "search_query_top")
    WebElement searchField;

    @FindBy(xpath = "(//div[@class='product-image-container'])[1]")
    public WebElement firstItemInPopular;

    @FindBy(xpath = "(//div[@class='product-image-container'])[2]")
    WebElement secondItemInPopular;

    @FindBy(xpath = "//a[@title='Women']")
    WebElement womenTab;

    @FindBy (xpath = "//a[@class='quick-view']")
    WebElement quickViewButton;

    @FindBy (xpath = "//span[contains(text(), 'Add to cart')]")
    WebElement addToCartButton;

    @FindBy (xpath = "//span[contains(text(), 'More')]")
    WebElement seeMoreButton;

    @FindBy (xpath = "//button[@name='submit_search']")
    WebElement searchButton;

    @FindBy (id = "homeslider")
    public WebElement mainPageSlider;

    @FindBy (xpath = "//b[contains(text(),'Cart')]")
    public WebElement shoppingCart;

    @FindBy (xpath = "//span[@class='cross']")
    public WebElement closePopUp;

    @FindBy (className = "remove_link")
    WebElement removeFromCartButton;

    @FindBy (xpath = "//dl[@class='products']/dt")
    List<WebElement> productsInCart;

    @FindBy (className = "product-image-container")
    public List <WebElement> searchResult;



    public MainPageFactory(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void searchFotItem(String searchKeyword){
        searchField.clear();
        searchField.sendKeys(searchKeyword);
        searchButton.click();
    }

    public void addToCartClick(){
        addToCartButton.click();
    }

    public void removeFromCartClick(){
        removeFromCartButton.click();
    }
    public void closePupUp(){
        closePopUp.click();
    }

    public int getSizeOfProductInCart(){
       int size = productsInCart.size();
       return  size;
    }
    public void loginButtonClick(){
        loginButton.click();
    }
}
