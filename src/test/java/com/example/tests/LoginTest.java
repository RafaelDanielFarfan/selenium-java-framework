package com.example.tests;

import com.example.framework.pages.InventoryPage;
import com.example.framework.pages.LoginPage;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class LoginTest extends BaseTest {

    @DataProvider(name = "loginData", parallel = true)
    public Object[][] loginData() {
        return new Object[][]{
                {"standard_user", "secret_sauce"},
                {"standard_user", "secret_sauce"},
                {"standard_user", "secret_sauce"}
        };
    }

    @Test(dataProvider = "loginData")
    public void validLoginTest(String username, String password) {
        InventoryPage inventoryPage = new LoginPage()
                .open()
                .enterUsername(username)
                .enterPassword(password)
                .clickLogin();

        Assert.assertEquals(inventoryPage.getTitle(), "Products");
    }
}
