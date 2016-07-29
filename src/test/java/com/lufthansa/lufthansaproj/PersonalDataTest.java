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
public class PersonalDataTest {
    
    WebDriver driver;
    File file;
    String userName = "firstplacewinner";
    String oldPass = "dustystick";
    
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
    public void a_updPhoneEmail() throws InterruptedException {
        
//        Logs in user
//        HomePageLogin L2 = new HomePageLogin(driver);
//        L2.login("firstplacewinner", "dustystick");
        
        // #7 Changes and updates the users phone number as well as e-mail address
        PersonalDataPage updateData = new PersonalDataPage(driver);
        updateData.phoneMail();
        
        // #5 Changes and updates the users address
        PersonalDataPage editAddr = new PersonalDataPage(driver);
        editAddr.userAddress();
        Assert.assertTrue(driver.findElement(By.xpath("//*[@id='contentpage']/div/div[1]/div[3]")).isDisplayed(), "Address information updated successful");
        
        driver.close();
        
    }
    
    @Test
    public void b_negZipCode(){
        HomePageLogin hpl = new HomePageLogin(driver);
        hpl.clickUserProfile();
        PersonalDataPage pdp = new PersonalDataPage(driver);
        pdp.invPostalInfo();
        Assert.assertTrue(pdp.zipAndStreetFailCheck(), "Invalid zip code error message successfully displayed");
        driver.close();
    }
    
    @Test
    public void c_negStreet(){
        HomePageLogin hpl = new HomePageLogin(driver);
        hpl.clickUserProfile();
        PersonalDataPage pdp = new PersonalDataPage(driver);
        pdp.invStreetInfo();
        Assert.assertTrue(pdp.zipAndStreetFailCheck(), "Invalid street error message successfully displayed");
        driver.close();
    }

    @AfterMethod
    public void tearDownMethod() throws Exception {
        driver.quit();
    }
}
