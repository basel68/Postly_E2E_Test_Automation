package PostlyTests;

import org.example.PageObjectModel.BlogDetailsPage;
import org.example.PageObjectModel.HomePage;
import org.example.PageObjectModel.LoginPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class HomePageTests extends BaseTest{
    HomePage homepage;
    @BeforeMethod
    public void setUp() {
        super.setUp();
        homepage=new HomePage(driver);
    }
    @Test
    public void testReadmore() {
        homepage.waitUntilButtonIsClickable();
        String expectedTitle=homepage.getBlogPostTitle();
        BlogDetailsPage blogDetailsPage=homepage.clickReadmoreButton();
        Assert.assertTrue(blogDetailsPage.waitForUrlChange());
        String actualTitle=blogDetailsPage.BlogpostTitle();
        Assert.assertEquals(actualTitle,expectedTitle);
    }

}
