/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.lufthansa.lufthansaproj;

import java.io.File;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

/**
 *
 * @author colton.porter smells like a dusty stick
 */
public class HomePageLoginTest {

    WebDriver driver;
    File file;

    public HomePageLoginTest() {
    }

    @BeforeMethod
    public void setUpClass() throws Exception {
        file = new File(this.getClass().getResource("/drivers/chromedriver.exe").getPath());
        System.setProperty("webdriver.chrome.driver", file.getAbsolutePath());
        driver = new ChromeDriver();
        driver.get("http://www.lufthansa.com/us/en/Homepage");
        
    }

    @Test
    public void a_loginPos() {
        HomePageLogin L1 = new HomePageLogin(driver);
        L1.login("firstplacewinner", "dustystick");
        Assert.assertTrue(L1.verifySuccess(), "Login was a success");
        driver.close();
    }

    @Test
    public void b_loginNeg() {
        HomePageLogin L1 = new HomePageLogin(driver);
        L1.login("firstplace", "dusty");
        Assert.assertTrue(L1.verifyFailure(), "Login was not a success");
        driver.close();
    }

    @AfterMethod
    public void tearDownClass() throws Exception {
        driver.quit();

    }

}
