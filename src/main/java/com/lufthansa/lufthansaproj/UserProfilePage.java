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
    By chngPass = By.xpath("//*[@id=\"changePasswordLink\"]");
    By userID = By.xpath("//*[@id=\"tblFld1\"]");
    By oldPass = By.xpath("//*[@id=\"tblFld2\"]");
    By newPass = By.xpath("//*[@id=\"tblFld3\"]");
    By newPassRepeat = By.xpath("//*[@id=\"tblFld4\"]");
    By chngPassBtn = By.xpath("//*[@id=\"PC_7_CO19VHUC67E5A0AD0K1N652CQ7012478_changePasswordForm\"]/div[4]/div/button");
    By successMsg = By.xpath("//*[@id=\"PC_7_CO19VHUC67E5A0AD0K1N652CQ7012478_changePasswordForm\"]/div[1]/div/div/p");
    
    public UserProfilePage(WebDriver driver) {
        this.driver = driver;
    }
    
    public void clickChngPass(){
        driver.findElement(chngPass).click();
    }
    
    public void changePass(String userName,String oldP,String newP){
        driver.findElement(userID).sendKeys(userName);
        driver.findElement(oldPass).sendKeys(oldP);
        driver.findElement(newPass).sendKeys(newP);
        driver.findElement(newPassRepeat).sendKeys(newP);
        driver.findElement(chngPassBtn).click();
        
    }
    
    public boolean posPass(){
        return driver.findElement(successMsg).isDisplayed();
    }
    
}
