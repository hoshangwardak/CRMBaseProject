package com.nextBaseCRM.test.Hoshang;

import com.nextBaseCRM.test.Utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class TestCase_02_LogHoursAndTimeReport {

    WebDriver driver;

    @BeforeClass
    public void setUpClass() {
        driver = WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get("https://nextbasecrm.com/");
    }

    @BeforeMethod
    public void setUpMethod() throws InterruptedException {

        WebElement logInButton = driver.findElement(By.linkText("Login"));
        Thread.sleep(1000);
        logInButton.click();

        WebElement userName = driver.findElement(By.xpath("(//input[@class='login-inp'])[1]"));
        userName.sendKeys("hr9@cybertekschool.com");

        WebElement password = driver.findElement(By.xpath("(//input[@maxlength='255'])[2]"));
        password.sendKeys("UserUser");

        WebElement loginButton = driver.findElement(By.xpath("//input[@type='submit']"));
        loginButton.click();

    }

    @Test
    public void test1() throws InterruptedException {

        WebElement clockInTab = driver.findElement(By.id("timeman-background"));
        Thread.sleep(2000);
        clockInTab.click();


        WebElement clockInButton = driver.findElement(By.xpath("//span[@class='webform-small-button-text']"));
        Thread.sleep(2000);
        clockInButton.click();





    }

    @AfterClass
    public void tearDownClass() {
        driver.close();
    }



}
