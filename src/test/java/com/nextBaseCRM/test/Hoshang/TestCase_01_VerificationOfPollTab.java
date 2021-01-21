package com.nextBaseCRM.test.Hoshang;

import com.nextBaseCRM.test.Utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class TestCase_01_VerificationOfPollTab {

    WebDriver driver;

    @BeforeClass
    public void setUpClass() {

    driver = WebDriverFactory.getDriver("Chrome");
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
        userName.sendKeys("marketing9@cybertekschool.com");

        WebElement password = driver.findElement(By.xpath("(//input[@maxlength='255'])[2]"));
        password.sendKeys("UserUser");

        WebElement loginButton = driver.findElement(By.xpath("//input[@type='submit']"));
        loginButton.click();

    }

    @Test
    public void testCase_01() {


        WebElement pollClicking = driver.findElement(By.xpath("//span[@id='feed-add-post-form-tab-vote']"));
        pollClicking.click();

        WebElement iframe = driver.findElement(By.xpath("//body[@contenteditable='true']"));

        driver.switchTo().frame(iframe);
        //driver.switchTo().frame(1);

        WebElement iframeBoxWriting = driver.findElement(By.xpath("(//iframe[@class='width: 100%; height: 100%;']"));

        iframeBoxWriting.sendKeys("I am trying to create a poll");



    }

}
