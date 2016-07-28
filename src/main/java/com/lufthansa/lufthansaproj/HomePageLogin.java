/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.lufthansa.lufthansaproj;

import java.io.File;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

/**
 *
 * @author colton.porter
 */
public class HomePageLogin {
    
    WebDriver driver; 
    File file;
    
    public void openPageChrome(){  
        file = new File(this.getClass().getResource("/drivers/chromedriver.exe").getPath());
        System.setProperty("webdriver.chrome.driver", file.getAbsolutePath());
        driver = new ChromeDriver();
        driver.get("http://www.lufthansa.com/us/en/Homepage");
    }
    
    
}
