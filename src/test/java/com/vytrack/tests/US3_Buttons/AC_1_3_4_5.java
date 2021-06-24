package com.vytrack.tests.US3_Buttons;

import com.vytrack.utilities.BrowserUtils;
import com.vytrack.utilities.Driver;
import com.vytrack.utilities.VytrackUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class AC_1_3_4_5 {

    @BeforeClass
    public void setUp()  {

        Driver.getDriver().get("https://qa3.vytrack.com/user/login");
        VytrackUtils.login(Driver.getDriver());
        VytrackUtils.fleet(Driver.getDriver());
    }

//    Given (truck driver) is on Vytrack Vehicles page.
//    When I (truck driver) click Export Grid dropdown.
//    Then (truck driver) should be able to see CSV and XLSX options.

    @Test
    public void tc001_Export_Grid_Dropdown() {

        BrowserUtils.sleep(2);
        WebElement exportGridButton = Driver.getDriver().findElement(By.linkText("Export Grid"));
        exportGridButton.click();

        BrowserUtils.sleep(2);
        WebElement csvXlsxOption = Driver.getDriver().findElement(By.xpath("(//ul[@class = 'dropdown-menu'])[3]"));

        Assert.assertTrue(csvXlsxOption.isDisplayed(), "csvXlsxOption is not displayed. FAIL!!!");
    }


//    Given (truck driver) is on Vytrack Vehicles page.
//    When I (truck driver) click the refresh button.
//    Then (truck driver) should be able to see the Vehicles page is refreshed.

    @Test
    public void tc003_Refresh() {

        BrowserUtils.sleep(2);
        WebElement refreshButton = Driver.getDriver().findElement(By.xpath("//a[@title='Refresh']"));
        refreshButton.click();

        Assert.assertTrue(refreshButton.isEnabled());

    }


//    Given (truck driver) is on Vytrack Vehicles page.
//    When I (truck driver) click the reset button.
//    Then (truck driver) should be able to see the Vehicles page is resetted.

    @Test
    public void tc004_Grid_Settings() {

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

//    Given (truck driver) is on Vytrack Vehicles page.
//    When I (truck driver) click Grid Settings button.
//    Then (truck driver) should be able to see Grid Settings dropdown menu.


    @Test
    public void tc005_Grid_Settings() {

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

    @AfterClass
    public void tearDown() {
        Driver.closeDriver();
    }



}
