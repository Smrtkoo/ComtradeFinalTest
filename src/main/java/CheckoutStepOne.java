import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CheckoutStepOne extends BasePage{
    @FindBy(id = "first-name")
    WebElement firstName;

    @FindBy(id = "last-name")
    WebElement lastName;

    @FindBy(id = "postal-code")
    WebElement postCode;

    @FindBy(className = "summary_subtotal_label")
    WebElement priceTotal;

    @FindBy(css = ".summary_info_label.summary_total_label")
    WebElement total;
    @FindBy(id = "finish")
    WebElement finish;
    @FindBy(css = ".checkout_complete_container h2")
    WebElement complete;

    public CheckoutStepOne(ChromeDriver driver)
    {
        this.driver = driver;
        PageFactory.initElements(driver,this);
    }
    public void setForm(String name,String last,String post)
    {
        firstName.sendKeys(name);
        lastName.sendKeys(last);
        postCode.sendKeys(post);
    }
    public String getTotal()
    {
        return total.getText();
    }
    public String getItemTotal()
    {
        return priceTotal.getText();
    }
    public void clickFinish()
    {
        finish.click();
    }
    public String complete()
    {
        return complete.getText();
    }
}
