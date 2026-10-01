package com.example.tests;

import com.example.framework.pages.LoginPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class ExcelLoginTest extends BaseTest {

    @Test(dataProvider = "excelLoginData", dataProviderClass = ExcelDataProvider.class)
    public void validLoginFromExcel(String username, String password) {
        String title = new LoginPage()
                .open()
                .enterUsername(username)
                .enterPassword(password)
                .clickLogin()
                .getTitle();

        Assert.assertEquals(title, "Products");
    }
}
