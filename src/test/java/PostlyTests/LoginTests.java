package PostlyTests;

import org.example.PageObjectModel.LoginPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class LoginTests {
    WebDriver driver;
    LoginPage loginPage;
    @BeforeMethod
    public void setUp() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().deleteAllCookies();
        loginPage = new LoginPage(driver);
        loginPage.goTo("http://localhost:4200/login");
    }
    @Test
    public void loginWithValidEmailAndPassword() {

        loginPage.login("basel@gmail.com","123456");
        Assert.assertTrue(loginPage.waitUntilUrlChanges());
    }
    @Test
    public void loginWithInvalidEmailAndPassword() {
        loginPage.login("basel@ggmail.com","123456");
        Assert.assertFalse(loginPage.waitUntilUrlChanges());
    }
    @AfterMethod
    public void tearDown() {
        driver.quit();
    }
}
