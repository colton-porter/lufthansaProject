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
public class OffersAndCommPage {
    
    WebDriver driver;
    File file;
    By changeSettings = By.xpath("//*[@id='profile-oc']");
    By yesIConsentToTheProcessingAndUsageOfMyPersonalDataForCommunicationPurposesRadioButton = By.xpath("//*[@id='ns_7_CO19VHUC67E5A0AD0K1N652C92_mmoptions-y']");
    By saveChangesButton = By.xpath("//*[@id='ns_7_CO19VHUC67E5A0AD0K1N652C92_submit']");
    By getLatestInformationAboutFarePromotionsAndSpecialOffersByReceivingOurNewsletter = By.xpath("//*[@id='ns_7_CO19VHUC67E5A0AD0K1N652C92_lh-nl']");
    By getExclusiveOffersForEarningAndRedeemingMilesPeriodRightArrowMore = By.xpath("//*[@id='ns_7_CO19VHUC67E5A0AD0K1N652C92_mam-offer']");
    
    public OffersAndCommPage(WebDriver driver) {
            this.driver = driver;         
    }
    
    public void dataPerm(){
        
        //Clicks on the users name link at the top of the page then clicks the profile link within the users link
        driver.findElement(By.xpath("//*[@id='header-profile-toggle']/i")).click();
        driver.findElement(By.xpath("//*[@id='uib']/div[1]/div[2]/a")).click();
        
        //Clicks on the change settings of the offers and communication section if you can't find it not my problem
        driver.findElement(changeSettings).click();
        
        //Clicks the yes radio button and saves the changes
        driver.findElement(yesIConsentToTheProcessingAndUsageOfMyPersonalDataForCommunicationPurposesRadioButton).click();
        driver.findElement(saveChangesButton).click();
        
        //Clicks on the change settings of the offers and communication section
        driver.findElement(changeSettings).click();
        
        //Clicks the radio buttons within the e-mail communication section
        driver.findElement(getLatestInformationAboutFarePromotionsAndSpecialOffersByReceivingOurNewsletter).click();
        driver.findElement(getExclusiveOffersForEarningAndRedeemingMilesPeriodRightArrowMore).click();
        
        driver.findElement(saveChangesButton).click();
        
    }
    
}
