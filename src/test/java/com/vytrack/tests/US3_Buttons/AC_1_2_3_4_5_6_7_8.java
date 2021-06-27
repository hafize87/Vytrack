package com.vytrack.tests.US3_Buttons;

import com.vytrack.utilities.BrowserUtils;
import com.vytrack.utilities.ConfigurationReader;
import com.vytrack.utilities.Driver;
import com.vytrack.utilities.VytrackUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class AC_1_2_3_4_5_6_7_8 {

    @BeforeClass
    public void setUp()  {

        Driver.getDriver().get(ConfigurationReader.getProperty("env"));
        VytrackUtils.login(Driver.getDriver());
        VytrackUtils.fleet(Driver.getDriver());
    }


    @Test
    public void tc001_Export_Grid_Dropdown() {


//    Given (truck driver) is on Vytrack Vehicles page.
//    When I (truck driver) click Export Grid dropdown.
//    Then (truck driver) should be able to see CSV and XLSX options.

        BrowserUtils.sleep(2);
        WebElement exportGridButton = Driver.getDriver().findElement(By.linkText("Export Grid"));
        exportGridButton.click();

        BrowserUtils.sleep(2);
        WebElement csvXlsxOption = Driver.getDriver().findElement(By.xpath("(//ul[@class = 'dropdown-menu'])[3]"));

        Assert.assertTrue(csvXlsxOption.isDisplayed(), "csvXlsxOption is not displayed. FAIL!!!");
    }



    @Test
    public void tc002_Dropdown_Is_On_Left() {

//    Given truck driver is logged into Vytrack
//    When driver clicks on fleet module tab
//    And clicks on vehicle button
//    Then driver should be able to see Export Grid dropdown on the left of the page

        BrowserUtils.sleep(2);
        WebElement exportGrit = Driver.getDriver().findElement(By.xpath("//a[@title='With this button you will export the content of the grid as it appears to you, with filters and sorting applied. All pages will be exported.']/../../../../preceding-sibling::div"));

        String export = exportGrit.getAttribute("class");

        if(export.contains("left")){
            System.out.println("Export Grid dropdown is on the left of the page");
        }
        else{
            System.out.println("Export Grid dropdown is not on the left of the page");
        }

    }



    @Test
    public void tc003_Refresh_Button() {

//    Given (truck driver) is on Vytrack Vehicles page.
//    When I (truck driver) click the refresh button.
//    Then (truck driver) should be able to see the Vehicles page is refreshed.

        BrowserUtils.sleep(2);
        WebElement refreshButton = Driver.getDriver().findElement(By.xpath("//a[@title='Refresh']"));
        refreshButton.click();

        Assert.assertTrue(refreshButton.isEnabled());

    }


    @Test
    public void tc004_reset_button() {

        // Scenario 1: Driver can click reset button and page refreshes

//        Given truck driver log into Vytrack
//        When truck driver click on fleet module tab
//        And click on reset button
//        Then the truck driver able to refresh the page


//          BrowserUtils.sleep(2);
//        WebElement page4 = Driver.getDriver().findElement(By.xpath("//a[@data-grid-pagination-direction='next']"));
//        page4.click();
//
//        BrowserUtils.sleep(2);
//        WebElement resetButton = Driver.getDriver().findElement(By.xpath("(//i[@class='fa-refresh'])[2]"));
//        resetButton.click();
//
//        WebElement page1 = Driver.getDriver().findElement(By.xpath("//input[contains(@value,'1')]"));
//
//        if(page1.getAttribute("value").equals("1")){
//
//            System.out.println("Page successfully refresh");
//        }
//        else {
//            System.out.println("Page is not successfully refresh");
//        }

        // Second Way
        WebElement resetButton = Driver.getDriver().findElement(By.xpath("//a[@title='Reset']"));
        resetButton.click();
        Assert.assertTrue(resetButton.isEnabled());

    }


    @Test
    public void tc005_grid_settings() {

//           Scenario 1: Driver can click grid settings button and drop down menu appears
//        Given truck driver log into Vytrack
//        When truck driver click on fleet module tab
//        And click on grid settings button
//        Then the truck driver able to see drop down menu


        BrowserUtils.sleep(2);
        WebElement gritSettingButton = Driver.getDriver().findElement(By.xpath("//div/a[@ title = 'Grid Settings']/i"));
        gritSettingButton.click();

        BrowserUtils.sleep(2);
        WebElement setting = Driver.getDriver().findElement(By.xpath("//div[.='Grid Settings']"));

        String expected = "Grid Settings";
        String actual = setting.getText();

        Assert.assertEquals(actual, expected);
        BrowserUtils.sleep(2);

    }


    @Test
    public void tc006_refresh_button_on_the_left_side_of_the_reset_button() {

//             Scenario 1: Driver verifies refresh button is on the left side of the Reset button
//        Given truck driver log into Vytrack
//        When truck driver click on fleet module tab
//        And click on refresh button
//        Then the truck driver able to see that refresh button on the left side of the Reset button


        BrowserUtils.sleep(2);
        WebElement refresh = Driver.getDriver().findElement(By.xpath("//a[@title = 'Refresh']//following-sibling::a[@title='Reset']"));

        Assert.assertTrue(refresh.isDisplayed());


    }



    @Test
    public void tc007_Grid_Settings_on_The_Right_of_The_Reset() {

//               Scenario 1: Driver verifies grid settings is on the right side of the reset button
//        Given driver is on Fleet Management page
//        When driver looks on the page
//        Then driver should see Grid Settings on the right side of the Reset button


        BrowserUtils.sleep(2);
        WebElement gridSettingRight = Driver.getDriver().findElement(By.xpath("//a[@title='Grid Settings']/../../a[3]"));

        Assert.assertTrue(gridSettingRight.isDisplayed());


    }


    @Test
    public void tc008_Grid_Settings_on_The_Right_of_The_Page() {
//
//           Scenario 1: Driver verifies grid settings is on the right side of page
//        Given driver is on Fleet Management page
//        When driver looks on the page
//        Then driver should see Grid Setting button is on the right of the page


        BrowserUtils.sleep(2);
        WebElement exportGrit = Driver.getDriver().findElement(By.xpath("//a[@title='Grid Settings']/../../.."));

        String export = exportGrit.getAttribute("class");

        if(export.contains("right")){
            System.out.println("Export Grid dropdown is on the right of the page");
        }
        else{
            System.out.println("Export Grid dropdown is not on the right of the page");
        }


    }


    @AfterClass
    public void tearDown() {
        Driver.closeDriver();
    }

}
