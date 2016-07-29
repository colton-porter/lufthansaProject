/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.lufthansa.lufthansaproj;

import java.io.File;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.Assert;

/**
 *
 * @author colton.porter
 */
public class MilesAndMoreTest {

    WebDriver driver;
    File file;
    String userName = "firstplacewinner";
    String oldPass = "dustystick";

    @BeforeMethod
    public void setUpMethod() throws Exception {
        file = new File(this.getClass().getResource("/drivers/chromedriver.exe").getPath());
        System.setProperty("webdriver.chrome.driver", file.getAbsolutePath());
        driver = new ChromeDriver();
        driver.get("http://www.lufthansa.com/us/en/Homepage");
        HomePageLogin L1 = new HomePageLogin(driver);
        L1.login(userName, oldPass);
    }

    @Test
    public void printAccnt() throws InterruptedException {
        MilesAndMorePage mamp = new MilesAndMorePage(driver);
        UserProfilePage upp = new UserProfilePage(driver);
        upp.profPage();
        mamp.accountStmnt();
        Assert.assertTrue(mamp.printSuccess(), "The account statement can be printed");
        driver.close();
    }

    @AfterMethod
    public void tearDownMethod() throws Exception {
        driver.quit();
    }
}
