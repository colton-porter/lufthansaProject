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
    By username = By.name("userid");
    By password = By.name("password");
    By loginTab = By.xpath("//*[@id=\"header-profile-toggle\"]/i");
    By loginBtn = By.id("ll-btn");
    By successMsg = By.xpath("//*[@id='pers_l']/div/div/div[1]/div/div[2]/div[2]/a");
    By failMsg = By.className("msg-error");

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

    public boolean verifySuccess() {
        return driver.findElement(successMsg).isDisplayed();
    }

    public boolean verifyFailure() {
        return driver.findElement(failMsg).isDisplayed();
    }

    public void openPageChrome() {
        file = new File(this.getClass().getResource("/drivers/chromedriver.exe").getPath());
        System.setProperty("webdriver.chrome.driver", file.getAbsolutePath());
        driver = new ChromeDriver();
        driver.get("http://www.lufthansa.com/us/en/Homepage");
    }

}
