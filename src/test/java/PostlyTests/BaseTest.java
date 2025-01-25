package PostlyTests;

import org.example.PageObjectModel.HomePage;
import org.example.PageObjectModel.LoginPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class BaseTest {
    protected WebDriver driver;
    @BeforeMethod
    public void setUp() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().deleteAllCookies();
        LoginPage loginPage = new LoginPage(driver);
        loginPage.goTo("http://localhost:4200/login");
        loginPage.login("basel@gmail.com","123456");
        loginPage.waitUntilUrlChanges();
        if (driver == null) {
            throw new IllegalArgumentException("Driver must be set"); // Helpful validation
        }
        else{
            System.out.println("Driver is set");
        }
    }
    @AfterMethod
    public void tearDown() {
        driver.quit();
    }
}
