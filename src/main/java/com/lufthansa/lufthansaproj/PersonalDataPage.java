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
public class PersonalDataPage {
    
    WebDriver driver;
    
    public PersonalDataPage(WebDriver driver) {
            this.driver = driver;         
    }
    
    public void phoneMail(){
        
        
        
        driver.findElement(By.name("telecomContactNumber(0)")).clear();
        driver.findElement(By.name("telecomContactNumber(0)")).sendKeys("2854531787");
        
    }
    
}
