package org.example.PageObjectModel;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class HomePage extends BasePage {
    By readmoreButton = By.xpath("(//a[@id='readmoreButton'])[1]");
    By blogpostTitle = By.xpath("(//h5[@id='blogpostTitle'])[1]");
    public HomePage(WebDriver driver) {
        super(driver);
    }
    public BlogDetailsPage clickReadmoreButton() {
        driver.findElement(readmoreButton).click();
        return new BlogDetailsPage(driver);
    }
    public String getBlogPostTitle() {
        return driver.findElement(blogpostTitle).getText();
    }
    public void waitUntilButtonIsClickable() {
        wait.until(ExpectedConditions.elementToBeClickable(readmoreButton));
    }


}
