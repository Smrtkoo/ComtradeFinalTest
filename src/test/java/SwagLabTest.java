import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class SwagLabTest extends BaseTest{
    LoginPage loginPage;
    InventoryPage inventoryPage;

    CartPage cartPage;
    CheckoutStepOne checkoutStepOne;

    @BeforeMethod

    public void SetUp()
    {
        driver = openBrowser();
        loginPage = new LoginPage(driver);
        inventoryPage = new InventoryPage(driver);
        cartPage = new CartPage(driver);
        checkoutStepOne = new CheckoutStepOne(driver);
        loginPage.LoginOnPage();

    }
    @Test
    public void buyingProducts()
    {
        inventoryPage.sortProducts("Price (low to high)");
        inventoryPage.clickOnesis();
        inventoryPage.clickBike();
        inventoryPage.clickTShirt();
        Assert.assertEquals(inventoryPage.getCartNumber(),"3");
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

    @Test
    public void finishBuyingProducts()
    {
        inventoryPage.clickBike();
        inventoryPage.clickTShirt();
        inventoryPage.cartLink.click();
        cartPage.clickOnCheckout();
        checkoutStepOne.setForm("Bojan","Lončarević","11070");
        cartPage.clickContinueStepTwo();
        checkoutStepOne.clickFinish();
        Assert.assertEquals(checkoutStepOne.complete(),"Thank you for your order!");
    }

    @AfterMethod
    public void close()
    {
        driver.close();
    }
}
