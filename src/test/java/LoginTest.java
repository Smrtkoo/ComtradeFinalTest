import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class LoginTest extends BaseTest{
    LoginPage loginPage;

    @BeforeMethod
    public void setUp()
    {
        driver = openBrowser();
        loginPage = new LoginPage(driver);
    }

    @Test
    public void login()
    {
        loginPage.LoginOnPageNoData("standard_user","secret_sauce");
        Assert.assertEquals(driver.getCurrentUrl(),"https://www.saucedemo.com/inventory.html");
    }
    @Test
    public void loginInvalidUserName()
    {
        loginPage.LoginOnPageNoData("Bojan","secret_sauce");
        Assert.assertEquals(loginPage.getError(),"Epic sadface: Username and password do not match any user in this service");
    }
    @Test
    public void loginNoPass()
    {
        loginPage.LoginOnPageNoData("standard_user","");
        Assert.assertEquals(loginPage.getError(),"Epic sadface: Password is required");
    }
    @Test
    public void loginInvalidPass()
    {
        loginPage.LoginOnPageNoData("standard_user","bojanbojan");
        Assert.assertEquals(loginPage.getError(),"Epic sadface: Username and password do not match any user in this service");
    }

    @Test
    public void loginNoUserName()
    {
        loginPage.LoginOnPageNoData("","secret_sauce");
        Assert.assertEquals(loginPage.getError(),"Epic sadface: Username is required");
    }

    @AfterMethod
    public void close()
    {
        driver.close();
    }
}
