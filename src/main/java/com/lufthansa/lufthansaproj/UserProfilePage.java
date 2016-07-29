/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.lufthansa.lufthansaproj;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

/**
 *
 * @author colton.porter
 */
public class UserProfilePage {
    
    WebDriver driver;   
    By chngPass = By.xpath("//*[@id=\"changePasswordLink\"]"); //Password change link in personal data
    By userID = By.xpath("//*[@id=\"tblFld1\"]"); //userId field under password change
    By oldPass = By.xpath("//*[@id=\"tblFld2\"]"); //old password field
    By newPass = By.xpath("//*[@id=\"tblFld3\"]"); //new password field
    By newPassRepeat = By.xpath("//*[@id=\"tblFld4\"]"); //new password repeat field
    By chngPassBtn = By.xpath("//*[@id=\"PC_7_CO19VHUC67E5A0AD0K1N652CQ7012478_changePasswordForm\"]/div[4]/div/button"); //Change password button
    By successMsg = By.xpath("//*[@id=\"PC_7_CO19VHUC67E5A0AD0K1N652CQ7012478_changePasswordForm\"]/div[1]/div/div/p"); //success message obj
    
    public UserProfilePage(WebDriver driver) {
        this.driver = driver;
    }
    
    // clicks on the change password link in personal data
    public void clickChngPass(){
        driver.findElement(chngPass).click();
    }
    
    // Uses given arguments to set username, enter old pass and new pass twice then clicks change password 
    public void changePass(String userName,String oldP,String newP){
        driver.findElement(userID).sendKeys(userName);
        driver.findElement(oldPass).sendKeys(oldP);
        driver.findElement(newPass).sendKeys(newP);
        driver.findElement(newPassRepeat).sendKeys(newP);
        driver.findElement(chngPassBtn).click();
        
    }
    
    //looks for a success msg after a pass change and returns true if it finds one
    public boolean posPass(){
        return driver.findElement(successMsg).isDisplayed();
    }
    
    public void profPage(){
        
        //Clicks on the users name link at the top of the page then clicks the profile link within the users link
        driver.findElement(By.xpath("//*[@id='header-profile-toggle']/i")).click();
        driver.findElement(By.xpath("//*[@id='uib']/div[1]/div[2]/a")).click();
        
    }
    
}
