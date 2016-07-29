/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.lufthansa.lufthansaproj;

import java.io.File;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.openqa.selenium.chrome.ChromeDriver;

/**
 *
 * @author colton.porter
 */
public class TravelPrefTest {

    WebDriver driver;
    File file;
    String userName = "firstplacewinner"; //username for initial login
    String oldPass = "dustystick"; //password for initial login

    @BeforeMethod
    public void setUpClass() throws Exception {
        file = new File(this.getClass().getResource("/drivers/chromedriver.exe").getPath());
        System.setProperty("webdriver.chrome.driver", file.getAbsolutePath());
        driver = new ChromeDriver();
        driver.get("http://www.lufthansa.com/us/en/Homepage");
        HomePageLogin L1 = new HomePageLogin(driver);
        L1.login(userName, oldPass);
    }

    @Test
    public void chngUpdatePref() {

//        Logs in user
//        HomePageLogin L3 = new HomePageLogin(driver);
//        L3.login("firstplacewinner", "dustystick");
        // #9 Changes and updates the users flight preferences
        TravelPrefPage fPref = new TravelPrefPage(driver);
        fPref.flightPref();
        Assert.assertTrue(driver.findElement(By.xpath("//*[@id=\'contentpage\']/div/div[1]/div[3]")).isDisplayed(), "Flight Preference update successful");
        driver.close();

    }

    //updates the departure airport prefrences
    @Test
    public void chngAirportPref() throws InterruptedException {
        TravelPrefPage tPref = new TravelPrefPage(driver);
        tPref.airPref();
        Assert.assertTrue(tPref.airportPrefChngSuccess(), "Airport prefrence has been added successfully");
        driver.close();
    }

    @AfterMethod
    public void tearDownMethod() throws Exception {
        driver.quit();
    }
}
