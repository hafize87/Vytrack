package com.vytrack.utilities;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class VytrackUtils {


    public static void login(WebDriver driver){

        BrowserUtils.sleep(1);
        WebElement userName = driver.findElement(By.xpath("//input[@id ='prependedInput']"));
        userName.sendKeys(ConfigurationReader.getProperty("userName"));

        BrowserUtils.sleep(1);
        WebElement password = driver.findElement(By.xpath("//input[@id ='prependedInput2']"));
        password.sendKeys(ConfigurationReader.getProperty("password"));

        BrowserUtils.sleep(1);
        WebElement clickButton = driver.findElement(By.xpath("//button[@id = '_submit']"));
        clickButton.click();
    }

    public static void fleet(WebDriver driver){

        BrowserUtils.sleep(1);
        WebElement fleet = driver.findElement(By.xpath("(//span[@class = 'title title-level-1'])[1]"));
        fleet.click();
        BrowserUtils.sleep(1);
        WebElement vehicle = driver.findElement(By.xpath("//span[.='Vehicles']"));
        vehicle.click();
    }

}
