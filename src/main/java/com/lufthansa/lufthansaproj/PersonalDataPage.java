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
public class PersonalDataPage {
    
    WebDriver driver;
    File file;
    By viewAndChangeAllPersonalData = By.xpath("//*[@id='profile-pd']");
    By phoneNumberTextBox = By.name("telecomContactNumber(0)");
    By emailAddressTextBox = By.xpath("//*[@id='ns_7_CO19VHUC67E5A0AD0K1N652C92_email']");
    By saveChangesButtonAtTheBottomOfTheProfileUpdatePage = By.xpath("//*[@id='ns_7_CO19VHUC67E5A0AD0K1N652C92_submit']");
    By streetTextBox = By.xpath("//*[@id='ns_7_CO19VHUC67E5A0AD0K1N652C92_street']");
    By companyTextBox = By.xpath("//*[@id='ns_7_CO19VHUC67E5A0AD0K1N652C92_company']");
    By additionalAddressInformation = By.xpath("//*[@id='ns_7_CO19VHUC67E5A0AD0K1N652C92_add-address']");
    By postalCodeTextBox = By.xpath("//*[@id='ns_7_CO19VHUC67E5A0AD0K1N652C92_zip']");
    By cityTextBox = By.xpath("//*[@id='ns_7_CO19VHUC67E5A0AD0K1N652C92_city']");
    By stateDropdown = By.xpath("//*[@id='ns_7_CO19VHUC67E5A0AD0K1N652C92_state']");
    By failMsg = By.xpath("//*[@id=\"contentpage\"]/div/div[1]/div[3]/div/div/div/div[1]");
    String invZipCode = "1234567890";
    String badStreet = "!@#$%^";
    
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
    
    public void userAddress(){
           
        //Clicks the View and Change button under Personal Data
        driver.findElement(viewAndChangeAllPersonalData).click();
        
        //Clears out the Street textbox and enters in new information
        driver.findElement(streetTextBox).clear();
        driver.findElement(streetTextBox).sendKeys("777 Clean Hammer Rd.");
        
        //Clears out the company textbox and enters in new information
        driver.findElement(companyTextBox).clear();
        driver.findElement(companyTextBox).sendKeys("Ball Peen Construction");
        
        //Clears out the additional address textbox and enters in new information.
        //Fun fact a dusty stick cannot beat a hammer
        driver.findElement(additionalAddressInformation).clear();
        driver.findElement(additionalAddressInformation).sendKeys("If you reached a dump filled with dusty sticks then you have gone too far.");
        
        //Clears out the Postal Code textbox and enters in new information. 
        //Fun fact the postal code used is reference to when the pneumatic hammer was patented.
        driver.findElement(postalCodeTextBox).clear();
        driver.findElement(postalCodeTextBox).sendKeys("12894");
        
        //Clears out the city textbox and enters in new information
        driver.findElement(cityTextBox).clear();
        driver.findElement(cityTextBox).sendKeys("Sledge City");
        
        //Selects the updated state from the dropdown
        //Fun fact hammers of all kinds have helped build America into what it is today
        Select stateDrop = new Select(driver.findElement(stateDropdown));
        stateDrop.selectByVisibleText("USA");
        
        //Clicks the save changes button at the bottom of the page
        driver.findElement(saveChangesButtonAtTheBottomOfTheProfileUpdatePage).click();
        
    }
    
    
    public void invPostalInfo(){
        driver.findElement(viewAndChangeAllPersonalData).click();
        driver.findElement(postalCodeTextBox).clear();
        driver.findElement(postalCodeTextBox).sendKeys(invZipCode);
        driver.findElement(saveChangesButtonAtTheBottomOfTheProfileUpdatePage).click();  
    }
    
    public void invStreetInfo(){
        driver.findElement(viewAndChangeAllPersonalData).click();
        driver.findElement(streetTextBox).clear();
        driver.findElement(streetTextBox).sendKeys(badStreet);
        driver.findElement(saveChangesButtonAtTheBottomOfTheProfileUpdatePage).click(); 
    }
    
    public boolean zipAndStreetFailCheck(){
        return driver.findElement(failMsg).isDisplayed();
    }
  
    
}
