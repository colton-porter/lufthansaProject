/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.lufthansa.lufthansaproj;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

/**
 *
 * @author colton.porter smells like a dusty stick
 */
public class HomePageLoginTest {

    static WebDriver driver;

    public HomePageLoginTest() {
    }

    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
    // @Test
    // public void hello() {}
    @BeforeTest
    public static void setUpClass() throws Exception {
        HomePageLogin L1 = new HomePageLogin(driver);
        L1.openPageChrome();
    }

    @Test
    public void a_loginPos() {
        HomePageLogin L1 = new HomePageLogin(driver);
        L1.login("firstplacewinner", "dustystick");
        Assert.assertTrue(L1.verifySuccess(), "Login was a success");
    }

    @Test
    public void b_loginNeg() {
        HomePageLogin L1 = new HomePageLogin(driver);
        L1.login("firstplace", "dusty");
        Assert.assertTrue(L1.verifyFailure(), "Login was not a success");
    }

    @AfterTest
    public static void tearDownClass() throws Exception {
        driver.quit();

    }

}
