import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CartPage extends BasePage{
    @FindBy(id = "remove-sauce-labs-bike-light")
    WebElement removeBike;
    @FindBy(id = "remove-sauce-labs-bolt-t-shirt")
    WebElement removeTShirt;
    @FindBy(id = "continue-shopping")
    WebElement continueShopping;

    @FindBy(id = "continue")
    WebElement continueStepTwo;

    @FindBy(id = "checkout")
    WebElement checkout;

    public CartPage(ChromeDriver driver)
    {
        this.driver = driver;
        PageFactory.initElements(driver,this);

    }
    public void clickOnCheckout()
    {
        checkout.click();
    }
    public void clickContinue()
    {
        continueShopping.click();
    }
    public void clickContinueStepTwo()
    {
        continueStepTwo.click();
    }
}
