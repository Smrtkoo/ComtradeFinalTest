import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class RemovingTest extends BaseTest{

    InventoryPage inventoryPage;

    CartPage cartPage;

    @BeforeMethod
    public void SetUp()
    {
        driver = openBrowser();
        inventoryPage = new InventoryPage(driver);
        cartPage = new CartPage(driver);
    }

    @Test
    public void removingProducts()
    {
        inventoryPage.clickBike();
        inventoryPage.clickTShirt();
        inventoryPage.cartLink.click();
        cartPage.removeBike.click();
        cartPage.removeTShirt.click();
        cartPage.continueShopping.click();
        Assert.assertEquals(inventoryPage.getCartNumber(),"");
    }

    @AfterMethod
    public void close()
    {
        driver.close();
    }
}
