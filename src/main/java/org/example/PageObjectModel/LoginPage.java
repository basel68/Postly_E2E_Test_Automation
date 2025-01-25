package org.example.PageObjectModel;

import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class LoginPage extends BasePage{
    By usernameField = By.xpath("//input[@id='email']");
    By passwordField = By.xpath("//input[@id='password']");
    By loginButton = By.xpath("//button[@type='submit']");
    public LoginPage(WebDriver driver) {
        super(driver);
    }
    public void enterUsername(String username) {
        type(usernameField, username);
    }
    public void enterPassword(String password) {
        type(passwordField, password);
    }
    public void clickLoginButton() {
        click(loginButton);
    }
    public void login(String username, String password) {
        enterUsername(username);
        enterPassword(password);
        clickLoginButton();
    }
    public Boolean waitUntilUrlChanges(){
        try {
            return wait.until(ExpectedConditions.urlToBe("http://localhost:4200/"));
        }
        catch (TimeoutException e) {
            return false;
        }
    }

}
