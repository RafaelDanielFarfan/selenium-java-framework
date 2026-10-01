package com.example.framework.pages;

import org.openqa.selenium.By;

public class InventoryPage extends BasePage {
    private final By title = By.cssSelector("[data-test='title']");

    public String getTitle() {
        return getText(title);
    }
}
