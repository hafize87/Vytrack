package com.vytrack.tests.US2_FleetModule;

import com.vytrack.utilities.BrowserUtils;
import com.vytrack.utilities.ConfigurationReader;
import com.vytrack.utilities.Driver;
import com.vytrack.utilities.VytrackUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.List;

public class Assignment_4_5_6 {

    @BeforeClass
    public void setUp()  {

        Driver.getDriver().get(ConfigurationReader.getProperty("env"));
        VytrackUtils.login(Driver.getDriver());
        VytrackUtils.fleet(Driver.getDriver());

    }

    @Test
    public void ac4(){

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

    @Test
    public void ac5(){

        BrowserUtils.sleep(2);
        WebElement gritSettingButton = Driver.getDriver().findElement(By.xpath("//div/a[@ title = 'Grid Settings']/i"));
        gritSettingButton.click();

        BrowserUtils.sleep(2);
        WebElement setting = Driver.getDriver().findElement(By.xpath("//div[.='Grid Settings']"));

        String expected = "Grid Settings";
        String actual = setting.getText();

        Assert.assertEquals(actual, expected);



    }

    @Test
    public void ac6(){

        BrowserUtils.sleep(2);

        List<WebElement> allButtons = Driver.getDriver().findElements(By.xpath("//div//i[@class])"));


        WebElement leftButtonRefresh = Driver.getDriver().findElement(By.xpath("(//div//i[@class])[25]"));

        WebElement rightButtonReset = Driver.getDriver().findElement(By.xpath("(//div//i[@class])[26]"));






    }
}
