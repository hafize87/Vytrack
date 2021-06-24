package com.vytrack.tests.US2_FleetModule;

import com.vytrack.utilities.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.List;

public class AC_1_2_3_4 {


    @BeforeClass
    public void setUp()  {

        Driver.getDriver().get("https://qa3.vytrack.com/user/login");
        VytrackUtils.login(Driver.getDriver());
        VytrackUtils.fleet(Driver.getDriver());


   }

    @Test
    public void tc001_Vehicle_Info(){

//        Given that I am logged into Vytrack
//        When I click on fleet module tab and click on vehicle
//        Then i should be able to view all the vehicle information

        WebElement plate = Driver.getDriver().findElement(By.xpath("//span[.='License Plate']"));

        Assert.assertTrue(plate.isDisplayed());

    }

    @Test
    public void tc002_Selected_Car_Info() {

//        -Given that truck driver logged into Vytrack
//        -When truck driver click on fleet module tab and click on vehicle
//        -And truck driver click on any car on the grid
//        -Then truck driver should be able to see general information
//        about the car

        BrowserUtils.sleep(2);
        WebElement anyCar = Driver.getDriver().findElement(By.xpath("//td[@class='string-cell grid-cell grid-body-cell grid-body-cell-LicensePlate']"));
        anyCar.click();

        BrowserUtils.sleep(2);
        WebElement generalInformation = Driver.getDriver().findElement(By.xpath("//span[.='General Information']"));
        Assert.assertTrue(generalInformation.isDisplayed());

    }

    }