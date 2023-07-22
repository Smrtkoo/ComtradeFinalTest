import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class InventoryPage extends BasePage{

    @FindBy(className = "shopping_cart_link")
    WebElement cartLink;


    @FindBy(className = "product_sort_container")
    WebElement sortProducts;

    @FindBy(css = "inventory_item_price")
    WebElement price;

    @FindBy(id = "add-to-cart-sauce-labs-onesie")
    WebElement onesis;

    @FindBy(id = "add-to-cart-sauce-labs-bike-light")
    WebElement bike;

    @FindBy(id = "add-to-cart-sauce-labs-bolt-t-shirt")
    WebElement tShirt;

    public InventoryPage(ChromeDriver driver)
    {
        this.driver = driver;
        PageFactory.initElements(driver,this);
    }
    public void clickBike()
    {
        bike.click();
    }
    public void clickTShirt()
    {
        tShirt.click();
    }
    public void clickOnesis()
    {
        onesis.click();
    }
    public void sortProducts(String text)
    {
        Select select = new Select(sortProducts);
        select.selectByVisibleText(text);
    }
    public String getPrice()
    {
        return price.getText();
    }
    public String getCartNumber()
    {
        return cartLink.getText();
    }
    public void clickCart()
    {
        cartLink.click();
    }
}
