package org.example.PageObjectModel;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class AddCategory extends BasePage{
    By categoryNameInput = By.xpath("//input[@id='category-name']");
    By categoryUrlInput = By.xpath("//input[@id='category-url']");
    By addCategoryButton = By.xpath("//button[@id='add-category-button']");
    public AddCategory(WebDriver driver) {
        super(driver);
    }
    public void enterCategoryName(String categoryName) {
        driver.findElement(categoryNameInput).sendKeys(categoryName);
    }
    public void enterCategoryUrl(String categoryUrl) {
        driver.findElement(categoryUrlInput).sendKeys(categoryUrl);
    }
    public void clickAddCategoryButton() {
        driver.findElement(addCategoryButton).click();
    }
    public CategoryList addCategory(String categoryName, String categoryUrl) {
        enterCategoryName(categoryName);
        enterCategoryUrl(categoryUrl);
        clickAddCategoryButton();
        return new CategoryList(driver);
    }
    public void waitForPageToLoad() {
        wait.until(ExpectedConditions.visibilityOf(driver.findElement(categoryUrlInput)));
    }

}
