package com.example.framework.pages;

import org.openqa.selenium.By;

public class LoginPage extends BasePage {
    private final By usernameInput = By.id("user-name");
    private final By passwordInput = By.id("password");
    private final By loginButton = By.id("login-button");
    private final By inventoryTitle = By.cssSelector("[data-test='title']");

    public LoginPage open() {
        driver.get(com.example.framework.config.ConfigReader.get("base.url"));
        return this;
    }

    public LoginPage enterUsername(String username) {
        type(usernameInput, username);
        return this;
    }

    public LoginPage enterPassword(String password) {
        type(passwordInput, password);
        return this;
    }

    public InventoryPage clickLogin() {
        click(loginButton);
        waitForVisible(inventoryTitle);
        return new InventoryPage();
    }
}
