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
public class MilesAndMorePage {
    
    WebDriver driver;
    By viewAccStmntBtn = By.xpath("//*[@id=\"profile-as\"]");
    By printAcctBtn = By.xpath("//*[@id=\"printLink\"]");
    By printPreview = By.xpath("//*[@id=\"print-preview\"]");
    
    public MilesAndMorePage(WebDriver driver){
        this.driver = driver;      
    }
    
    public void accountStmnt(){
        driver.findElement(viewAccStmntBtn).click();
    }
    
    public boolean printSuccess(){
        return driver.findElement(printAcctBtn).isDisplayed();
    }
    
}
