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

        Driver.getDriver().get(ConfigurationReader.getProperty("browser"));
        Driver.getDriver().get(ConfigurationReader.getProperty("env"));
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


}