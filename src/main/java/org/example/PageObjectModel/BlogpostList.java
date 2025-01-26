package org.example.PageObjectModel;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.ArrayList;
import java.util.List;

public class BlogpostList extends BasePage{
    By titleRow=By.xpath("//td[@id='title']");
    By shortDescriptionRow=By.xpath("//td[@id='short-description']");
    By addBlogpostButton=By.xpath("//a[@id='add-blogpost-button']");

    public BlogpostList(WebDriver driver){
        super(driver);
    }

    public List<String> getBlogpostTitleList() {
        List<WebElement> ids=driver.findElements(titleRow);
        List<String> categoryIdList=new ArrayList<String>();
        for(WebElement id:ids) {
            categoryIdList.add(id.getText());
        }
        return categoryIdList;
    }
    public List<String> getBlogpostDescriptionList() {
        List<WebElement> ids=driver.findElements(shortDescriptionRow);
        List<String> categoryIdList=new ArrayList<String>();
        for(WebElement id:ids) {
            categoryIdList.add(id.getText());
        }
        return categoryIdList;
    }
    public void clickAddBlogpostButton(){
        driver.findElement(addBlogpostButton).click();
    }
    public void waitUntilPageObjectIsLoaded(){
        wait.until(ExpectedConditions.visibilityOf(driver.findElement(titleRow)));
    }
}
