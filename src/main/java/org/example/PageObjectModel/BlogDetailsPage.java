package org.example.PageObjectModel;

import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class BlogDetailsPage extends BasePage{
    By blogTitle = By.xpath("//h1[@id='blogpostTitle']");
    public BlogDetailsPage(WebDriver driver) {
        super(driver);
    }
    public String BlogpostTitle(){
        return driver.findElement(blogTitle).getText();
    }
    public Boolean waitForUrlChange(){
        try {
            return wait.until(ExpectedConditions.urlContains("http://localhost:4200/blog/"));
        }
        catch (TimeoutException e) {
            return false;
        }
    }

}
