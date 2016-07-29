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
    By travelPreferenceButton = By.xpath("//*[@id='profile-tp']");
    By savesChangesButton = By.xpath("//*[@id='ns_7_CO19VHUC67E5A0AD0K1N652C92_submit']");
    
    public TravelPrefPage(WebDriver driver) {
            this.driver = driver;         
    }
    
    public void flightPref(){
        
        // #9
        //Clicks on the users name link at the top of the page then clicks the profile link within the users link
        driver.findElement(By.xpath("//*[@id='header-profile-toggle']/i")).click();
        driver.findElement(By.xpath("//*[@id='uib']/div[1]/div[2]/a")).click();
        
        //Clicks the Travel Preferences Button if you can't find it then too bad
        driver.findElement(travelPreferenceButton).click();
        
        //Selects the seat dropdown menu and selects "Window"
        //The window seat is considered one of the best seats on the plane since you can just look at the view instead of having people walking up and down the aisle stepping on your foot.
        Select seatDropdown = new Select(driver.findElement(By.xpath("//*[@id='ns_7_CO19VHUC67E5A0AD0K1N652C92_seat']")));
        seatDropdown.selectByVisibleText("Window");
        
        //Selects the meal dropdown menu and selects "Moslem Meal"
        //Moslem Meals Contain no pork and pig by-products, gelatine, non-white fish meat from species without scales or fins, alcohol and flavouring extracts with alcohol.
        Select mealDropdown = new Select(driver.findElement(By.xpath("//*[@id='ns_7_CO19VHUC67E5A0AD0K1N652C92_meal']")));
        mealDropdown.selectByVisibleText("Moslem Meal");
        
        //Clicks the SAVES CHANGES BUTTON at the BOTTOM of the page not sure what other type of description is needed for this.
        driver.findElement(savesChangesButton).click();
    }
    
    
    
}
