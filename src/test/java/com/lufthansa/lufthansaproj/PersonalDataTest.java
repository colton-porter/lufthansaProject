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
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import org.openqa.selenium.chrome.ChromeDriver;

/**
 *
 * @author colton.porter
 */
public class PersonalDataTest {
    
    WebDriver driver;
    File file;
    
    @BeforeTest
    public void setUpClass() throws Exception {
        
        file = new File(this.getClass().getResource("/drivers/chromedriver.exe").getPath());
        System.setProperty("webdriver.chrome.driver", file.getAbsolutePath());
        driver = new ChromeDriver();
        driver.get("http://www.lufthansa.com/us/en/Homepage");
    }
    
    @Test
    public void hello() throws InterruptedException {
        
        //Logs in user
        HomePageLogin L2 = new HomePageLogin(driver);
        L2.login("firstplacewinner", "dustystick");
        
        // #7 Changes and updates the users phone number as well as e-mail address
        PersonalDataPage updateData = new PersonalDataPage(driver);
        updateData.phoneMail();
        Assert.assertTrue(driver.findElement(By.xpath("//*[@id='contentpage']/div/div[1]/div[3]")).isDisplayed(), "Phone/E-Mail update successful");
        
        PersonalDataPage editAddr = new PersonalDataPage(driver);
        editAddr.userAddress();
    
    }

    @AfterTest
    public static void tearDownClass() throws Exception {
        //driver.quit();
    }

    @BeforeMethod
    public void setUpMethod() throws Exception {
    }

    @AfterMethod
    public void tearDownMethod() throws Exception {
    }
}
