package org.example.PageObjectModel;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.ArrayList;
import java.util.List;

public class CategoryList extends BasePage{
    By searchField=By.xpath("//input[@name='searchInput']");
    By searchButton=By.xpath("//button[@name='searchButton']");
    By sortAscButton=By.xpath("//button[@name='sortAscButton']");
    By sortDescButton=By.xpath("//button[@name='sortDescButton']");
    By categoryIdRow=By.xpath("//td[@id='categoryId']");
    By categoryNameRow=By.xpath("//td[@id='categoryName']");
    By previousPageButton=By.xpath("//a[@id='previous-button']");
    By nextPageButton=By.xpath("//a[@id='next-button']");
    By addCategoryButton=By.xpath("//a[@id='add-category-button']");
    public CategoryList(WebDriver driver) {
        super(driver);
    }
    public void searchCategory(String categoryName) {
        driver.findElement(searchField).sendKeys(categoryName);
        driver.findElement(searchButton).click();
    }
    public void sortAscCategory() {
        driver.findElement(sortAscButton).click();
    }
    public void sortDescCategory() {
        driver.findElement(sortDescButton).click();
    }
    public List<String> getCategoryIdList() {
        List<WebElement> ids=driver.findElements(categoryIdRow);
        List<String> categoryIdList=new ArrayList<String>();
        for(WebElement id:ids) {
            categoryIdList.add(id.getText());
        }
        return categoryIdList;
    }
    public List<String> getCategoryNameList() {
        List<WebElement> names=driver.findElements(categoryNameRow);
        List<String> categoryNameList=new ArrayList<>();
        for(WebElement name:names) {
            categoryNameList.add(name.getText());
        }
        return categoryNameList;
    }
    public void waitUntilPageObjectIsLoaded() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(categoryNameRow));
    }
    public void goToNextPage() {
        driver.findElement(nextPageButton).click();
    }
    public void goToPreviousPage() {
        driver.findElement(previousPageButton).click();
    }
    public void clickAddCategoryButton() {
        driver.findElement(addCategoryButton).click();
    }
}
