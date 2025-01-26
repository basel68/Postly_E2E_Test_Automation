package org.example.PageObjectModel;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class AddBlogpost extends BasePage{
    By title=By.xpath("//input[@name='title']");
    By urlHandle=By.xpath("//input[@name='urlHandle']");
    By shortDescription=By.xpath("//input[@name='shortDescription']");
    By content=By.xpath("//textarea[@name='content']");
    By author=By.xpath("//input[@name='author']");
    By saveBlogpostButton=By.xpath("//button[@id='save-button']");
    public AddBlogpost(WebDriver driver) {
        super(driver);
    }

    public void enterTitle(String title) {
        driver.findElement(this.title).sendKeys(title);
    }
    public void enterUrlHandle(String urlHandle) {
        driver.findElement(this.urlHandle).sendKeys(urlHandle);
    }
    public void enterShortDescription(String shortDescription) {
        driver.findElement(this.shortDescription).sendKeys(shortDescription);
    }
    public void enterContent(String content) {
        driver.findElement(this.content).sendKeys(content);
    }
    public void enterAuthor(String author) {
        driver.findElement(this.author).sendKeys(author);
    }

    public void clickSaveBlogpostButton() {
        driver.findElement(this.saveBlogpostButton).click();
    }
    public BlogpostList addBlogPost(String title, String urlHandle, String shortDescription, String content, String author) {
        enterAuthor(author);
        enterTitle(title);
        enterUrlHandle(urlHandle);
        enterShortDescription(shortDescription);
        enterContent(content);
        clickSaveBlogpostButton();
        return new BlogpostList(driver);
    }
    public void waitUntilPageIsLoaded() {
        wait.until(ExpectedConditions.visibilityOf(driver.findElement(this.title)));
    }

}

