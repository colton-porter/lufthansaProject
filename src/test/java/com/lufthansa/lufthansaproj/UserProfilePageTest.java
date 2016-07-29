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
public class UserProfilePageTest {
    
    WebDriver driver;
    File file;
    String userName = "firstplacewinner";
    String oldPass = "dustystick";
    String newPass = "hammer";

    @BeforeMethod
    public void setUpClass() throws Exception {
        file = new File(this.getClass().getResource("/drivers/chromedriver.exe").getPath());
        System.setProperty("webdriver.chrome.driver", file.getAbsolutePath());
        driver = new ChromeDriver();
        driver.get("http://www.lufthansa.com/us/en/Homepage");
        HomePageLogin L1 = new HomePageLogin(driver);
        L1.login(userName, oldPass);
    }
    
    //changes the user password and then changes it back to the old pass after a successful change
    @Test
    public void changePass(){
        HomePageLogin hpl = new HomePageLogin(driver);
        UserProfilePage upp = new UserProfilePage(driver);
        hpl.clickUserProfile();
        upp.clickChngPass();
        upp.changePass(userName, oldPass, newPass);
        Assert.assertTrue(upp.posPass(), "Password changed successfully");
        upp.changePass(userName, newPass, oldPass);
        
        
        // #3 Confirms that the user is able to navigate to their personal profile page
        UserProfilePage profPage = new UserProfilePage(driver);
        profPage.profPage();
        Assert.assertTrue(driver.findElement(By.xpath("//*[@id='slideshowRotator1']/div/div/rte2011/span")).isDisplayed(), "Profile page viewed successfully");
        driver.close();
    }

    @AfterMethod
    public void tearDownMethod() throws Exception {
        driver.quit();
    }
}
