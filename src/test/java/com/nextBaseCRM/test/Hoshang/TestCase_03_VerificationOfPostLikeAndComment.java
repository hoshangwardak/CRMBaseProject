package com.nextBaseCRM.test.Hoshang;

import com.nextBaseCRM.test.Utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.sql.Time;
import java.util.concurrent.TimeUnit;

public class TestCase_03_VerificationOfPostLikeAndComment {

    WebDriver driver;

    @BeforeClass
    public void setUpClass() {

        driver = WebDriverFactory.getDriver("Chrome");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
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
    public void test1_likeButton() throws InterruptedException {

        WebElement postBox = driver.findElement(By.xpath("(//div[contains(@id, 'sonet_log_day_item_')])[2]"));
        Thread.sleep(3000);
        postBox.click();

        WebElement likeButton = driver.findElement(By.linkText("Like"));
        Thread.sleep(3000);
        likeButton.click();

        WebElement afterClickingLikeBox = driver.findElement(By.xpath("(//div[@class='feed-post-emoji-top-panel-outer'])[1]"));
        afterClickingLikeBox.click();

        WebElement thumbsUp = driver.findElement(By.xpath("((//div[@class='feed-post-emoji-top-panel-outer'])[1]//span)[3]"));

        Assert.assertTrue(afterClickingLikeBox.isDisplayed(),"Failed, Box not displayed");
        Assert.assertTrue(thumbsUp.isDisplayed(), "Failed, ThumbsUp not displayed");

    }

    @Test
    public void test2_followButton() throws InterruptedException {

        WebElement postBox = driver.findElement(By.xpath("(//div[contains(@id, 'sonet_log_day_item_')])[2]"));
        Thread.sleep(3000);
        postBox.click();
        Thread.sleep(3000);
        WebElement followButton = driver.findElement(By.xpath("((//div[contains(@id, 'sonet_log_day_item_06lOu2FE')]//div)[18]//span)[4]"));
        followButton.click();
        Thread.sleep(3000);













    }


}
