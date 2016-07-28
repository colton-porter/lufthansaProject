/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.lufthansa.lufthansaproj;

import java.io.File;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;

/**
 *
 * @author colton.porter
 */
public class TravelPrefPage {
    
    WebDriver driver;
    File file;
    
    public TravelPrefPage(WebDriver driver) {
            this.driver = driver;         
    }
    
    public void flightPref(){
        
        //Clicks on the users name link at the top of the page then clicks the profile link within the users link
        driver.findElement(By.xpath("//*[@id='header-profile-toggle']/i")).click();
        driver.findElement(By.xpath("//*[@id='uib']/div[1]/div[2]/a")).click();
        
        //Clicks the Travel Preferences Button
        driver.findElement(By.xpath("//*[@id='profile-tp']")).click();
        
        //Selects the seat dropdown menu and selects "Window"
        Select seatDropdown = new Select(driver.findElement(By.xpath("//*[@id='ns_7_CO19VHUC67E5A0AD0K1N652C92_seat']")));
        seatDropdown.selectByVisibleText("Window");
        
        //Selects the meal dropdown menu and selects "Moslem Meal"
        Select mealDropdown = new Select(driver.findElement(By.xpath("//*[@id='ns_7_CO19VHUC67E5A0AD0K1N652C92_meal']")));
        mealDropdown.selectByVisibleText("Moslem Meal");
        
        //Clicks the save changes button at the bottom of the page
        driver.findElement(By.xpath("//*[@id='ns_7_CO19VHUC67E5A0AD0K1N652C92_submit']")).click();
    }
    
}
