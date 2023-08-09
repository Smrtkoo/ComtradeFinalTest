import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class PriceTest extends BaseTest{

    InventoryPage inventoryPage;

    CartPage cartPage;

    CheckoutStepOne checkoutStepOne;

    @BeforeMethod
    public void SetUp()
    {
        driver = openBrowser();
        inventoryPage = new InventoryPage(driver);
        cartPage = new CartPage(driver);
        checkoutStepOne = new CheckoutStepOne(driver);
    }

    @Test
    public void totalPrice()
    {
        inventoryPage.clickBike();
        inventoryPage.clickTShirt();
        inventoryPage.cartLink.click();
        cartPage.clickOnCheckout();
        checkoutStepOne.setForm("Bojan","Lončarević","11070");
        cartPage.clickContinueStepTwo();
        Assert.assertEquals(checkoutStepOne.getItemTotal(),"Item total: $25.98");
        Assert.assertEquals(checkoutStepOne.getTotal(),"Total: $28.06");
    }

    @AfterMethod
    public void close()
    {
        driver.close();
    }
}
