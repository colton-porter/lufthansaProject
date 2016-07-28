/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.lufthansa.lufthansaproj;

import java.io.File;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

/**
 *
 * @author colton.porter
 */
public class PersonalDataPage {
    
    WebDriver driver;
    File file;
    By viewAndChangeAllPersonalData = By.xpath("//*[@id='profile-pd']");
    By phoneNumberTextBox = By.name("telecomContactNumber(0)");
    By emailAddressTextBox = By.xpath("//*[@id='ns_7_CO19VHUC67E5A0AD0K1N652C92_email']");
    By saveChangesButtonAtTheBottomOfTheProfileUpdatePage = By.xpath("//*[@id='ns_7_CO19VHUC67E5A0AD0K1N652C92_submit']");
    
    public PersonalDataPage(WebDriver driver) {
            this.driver = driver;         
    }
    
    public void phoneMail() throws InterruptedException{
        
        // #7
        //Clicks on the users name link at the top of the page then clicks the profile link within the users link
        driver.findElement(By.xpath("//*[@id='header-profile-toggle']/i")).click();
        driver.findElement(By.xpath("//*[@id='uib']/div[1]/div[2]/a")).click();
        
        //Clicks the View and Change button under Personal Data
        driver.findElement(viewAndChangeAllPersonalData).click();
        
        //Clears the phone number field and enters in new number
        //I wonder who will pick up the phone if you call this number?
        driver.findElement(phoneNumberTextBox).clear();
        driver.findElement(phoneNumberTextBox).sendKeys("2854531787");
        
        //Clears the e-mail field and enters updated e-mail
        //This e-mail won't accept spam or DUSTY e-mail
        driver.findElement(emailAddressTextBox).clear();
        driver.findElement(emailAddressTextBox).sendKeys("hammertime@gmail.com");
        
        //Clicks the save changes button at the bottom of the page
        driver.findElement(saveChangesButtonAtTheBottomOfTheProfileUpdatePage).click();
        
    }
    
    
    public void invPostalInfo(){
   
    }
    
}
