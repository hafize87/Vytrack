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

    @Test
    public void tc003_Add_Event(){

//       Given (truck driver) is on selected car General information page.
//       When (truck driver) add the Event.
//       Then (truck driver) should be able to see the Event under Activity tab and General information page as well

        BrowserUtils.sleep(2);
        WebElement anyCar = Driver.getDriver().findElement(By.xpath("//td[@class='string-cell grid-cell grid-body-cell grid-body-cell-LicensePlate']"));
        anyCar.click();


        BrowserUtils.sleep(2);
        WebElement addEventButton = Driver.getDriver().findElement(By.xpath("//a[@title='Add an event to this record']"));
        addEventButton.click();

        BrowserUtils.sleep(2);
        WebElement titleField = Driver.getDriver().findElement(By.xpath("//input[@name='oro_calendar_event_form[title]']"));
        titleField.sendKeys("studyGroup");

        BrowserUtils.sleep(2);
        WebElement saveButton = Driver.getDriver().findElement(By.xpath("//button[.='Save']"));
        saveButton.click();

        BrowserUtils.sleep(2);
        WebElement generalTabEvent = Driver.getDriver().findElement(By.xpath("//strong[.='studyGroup']"));

        Assert.assertTrue(generalTabEvent.isDisplayed());

        BrowserUtils.sleep(2);
        WebElement activityButton = Driver.getDriver().findElement(By.xpath("//a[.='Activity']"));
        activityButton.click();

        BrowserUtils.sleep(2);
        WebElement activityTabEvent = Driver.getDriver().findElement(By.xpath("//strong[.='studyGroup']"));

        Assert.assertTrue(activityTabEvent.isDisplayed());

    }

    @Test
    public void tc004_Reset_Settings(){


//        Given that truck driver logged into Vytrack
//        When truck driver click on fleet module tab and click on vehicle
//        And  truck driver goes to another vehicle page records
//        Then the truck driver clicks the reset button, and the truck driver can reset the setting


        BrowserUtils.sleep(2);
        WebElement page4 = Driver.getDriver().findElement(By.xpath("//a[@data-grid-pagination-direction='next']"));
        page4.click();

        BrowserUtils.sleep(2);
        WebElement resetButton = Driver.getDriver().findElement(By.xpath("(//i[@class='fa-refresh'])[2]"));
        resetButton.click();

        WebElement page1 = Driver.getDriver().findElement(By.xpath("//input[contains(@value,'1')]"));

        if(page1.getAttribute("value").equals("1")){

            System.out.println("Page successfully refresh");
        }
        else {
            System.out.println("Page is not successfully refresh");
        }


    }

}