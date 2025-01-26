package org.example.PageObjectModel;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class NavBar extends BasePage{
    By adminDropdown = By.xpath("//a[@role='admin-button']");
    By CategoryListButton = By.xpath("//a[@role='category-list-button']");
    By blogpostListButton = By.xpath("//a[@role='blogpost-list-button']");
    public NavBar(WebDriver driver) {
        super(driver);
    }
    public void clickAdminDropdown() {
        driver.findElement(adminDropdown).click();
    }
    public void clickCategoryListButton() {
        driver.findElement(CategoryListButton).click();
    }
    public void clickBlogpostListButton() {
        driver.findElement(blogpostListButton).click();
    }
    public void navigateToBlogpostListPage() {
        clickAdminDropdown();
        clickBlogpostListButton();
    }
    public void navigateToCategoryListPage() {
        clickAdminDropdown();
        clickCategoryListButton();
    }
}
