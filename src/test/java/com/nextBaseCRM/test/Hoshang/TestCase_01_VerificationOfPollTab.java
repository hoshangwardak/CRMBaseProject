package com.nextBaseCRM.test.Hoshang;

import com.nextBaseCRM.test.Utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.security.Key;
import java.util.List;
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
    public void testCase_01() throws InterruptedException {


        WebElement pollClicking = driver.findElement(By.xpath("//span[@id='feed-add-post-form-tab-vote']"));
        pollClicking.click();

        WebElement iframe1 = driver.findElement(By.xpath("//iframe[@class='bx-editor-iframe']"));

        driver.switchTo().frame(iframe1); // Penetrating to the inner iframe from outer iframe
        //driver.switchTo().frame(1);

        //WebElement inputBox = driver.findElement(By.xpath("//body[@style='min-height: 184px;']"));
        WebElement inputBox = driver.findElement(By.xpath("//body[@contenteditable='true']"));
        Thread.sleep(2000);
        inputBox.click();
        Thread.sleep(2000);
        inputBox.sendKeys("Title for the Poll");

        driver.switchTo().parentFrame();

        WebElement questionInputBox = driver.findElement(By.id("question_0"));
        Thread.sleep(2000);
        questionInputBox.click();
        questionInputBox.sendKeys("Does anyone have a question about this poll?");
        Thread.sleep(2000);

        List<WebElement> answerBoxes = driver.findElements(By.xpath("(//input[@class='vote-block-inp adda'])"));
        int count = 0;
        for (WebElement eachBox : answerBoxes) {
            Thread.sleep(2000);
            eachBox.click();
            eachBox.sendKeys("Answer" + count++ + " " + Keys.ENTER);
        }

        WebElement sendButton = driver.findElement(By.id("blog-submit-button-save"));
        Thread.sleep(2000);
        sendButton.click();


    }

    @AfterClass
    public void tearDownClass() {
        driver.close();
    }

}
