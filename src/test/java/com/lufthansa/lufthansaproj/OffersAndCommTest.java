/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.lufthansa.lufthansaproj;

import java.io.File;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

/**
 *
 * @author colton.porter
 */
public class OffersAndCommTest {
    
    WebDriver driver;
    File file;
    
    @Test
    public void hello() {
    
        //Logs in user
        HomePageLogin L3 = new HomePageLogin(driver);
        L3.login("firstplacewinner", "dustystick");
        
        OffersAndCommPage perm = new OffersAndCommPage(driver);
        perm.dataPerm();
        Assert.assertTrue(driver.findElement(By.xpath("//*[@id='contentpage']/div/div[1]/div[3]")).isDisplayed(), "Data Protection update successful");
    
    }

    @BeforeTest
    public void setUpClass() throws Exception {
        
        file = new File(this.getClass().getResource("/drivers/chromedriver.exe").getPath());
        System.setProperty("webdriver.chrome.driver", file.getAbsolutePath());
        driver = new ChromeDriver();
        driver.get("http://www.lufthansa.com/us/en/Homepage");
        
    }

    @AfterTest
    public static void tearDownClass() throws Exception {
    }

    @BeforeMethod
    public void setUpMethod() throws Exception {
    }

    @AfterMethod
    public void tearDownMethod() throws Exception {
    }
}
