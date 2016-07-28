/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.lufthansa.lufthansaproj;

import static com.lufthansa.lufthansaproj.HomePageLoginTest.driver;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

/**
 *
 * @author colton.porter
 */
public class PersonalDataTest {
    
    static WebDriver driver;
    
    
    @Test
    public void hello() {
        
        // #7 Changes and updates the users phone number as well as e-mail address
        PersonalDataPage updateData = new PersonalDataPage(driver);
        updateData.phoneMail();
        
    
    }

    @BeforeTest
    public static void setUpClass() throws Exception {
    }

    @AfterTest
    public static void tearDownClass() throws Exception {
        driver.quit();
    }

    @BeforeMethod
    public void setUpMethod() throws Exception {
    }

    @AfterMethod
    public void tearDownMethod() throws Exception {
    }
}
