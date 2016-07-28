/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.lufthansa.lufthansaproj;

import java.io.File;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

/**
 *
 * @author colton.porter
 */
public class HomePageLogin {

    WebDriver driver;
    File file;
    //create elements for easier use 
    By username = By.name("userid"); //username field
    By password = By.name("password"); //password field
    By loginTab = By.xpath("//*[@id=\"header-profile-toggle\"]/i"); //Tab on home page to access login
    By loginBtn = By.id("ll-btn"); //Actual button to login
    By successMsg = By.xpath("//*[@id='pers_l']/div/div/div[1]/div/div[2]/div[2]/a"); //random object only appears after login
    By userTab = By.xpath("//*[@id=\"header-profile-toggle\"]"); //Login tab after success login which displays current user name
    By profileBtn = By.xpath("//*[@id=\"uib\"]/div[1]/div[2]/a"); //Profile button under login tab
    By failMsg = By.className("msg-error"); //Error message div that displays on bad login

    //constructor to bring in and use the driver
    public HomePageLogin(WebDriver driver) {
        this.driver = driver;
    }

    // Sends a username and password to the coorrect login fields and then clicks the login button
    public void login(String userCredentials, String pass) {
        driver.findElement(loginTab).click();
        driver.findElement(username).sendKeys(userCredentials);
        driver.findElement(password).sendKeys(pass);
        driver.findElement(loginBtn).click();
    }

    // looks for a success msg obj and returns true if found
    public boolean verifySuccess() {
        return driver.findElement(successMsg).isDisplayed();
    }

    // looks for a failure msg and returns true if found
    public boolean verifyFailure() {
        return driver.findElement(failMsg).isDisplayed();
    }
    
    // Goes into the user tab and then the users profile
    public void clickUserProfile(){
        driver.findElement(userTab).click();
        driver.findElement(profileBtn).click();
    }

//    public void openPageChrome() {
//        file = new File(this.getClass().getResource("/drivers/chromedriver.exe").getPath());
//        System.setProperty("webdriver.chrome.driver", file.getAbsolutePath());
//        driver = new ChromeDriver();
//        driver.get("http://www.lufthansa.com/us/en/Homepage");
//        
//    }

}
