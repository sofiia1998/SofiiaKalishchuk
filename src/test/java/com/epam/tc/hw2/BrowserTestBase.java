package com.epam.tc.hw2;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.ITestResult;
import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;


public class BrowserTestBase {

    protected WebDriver driver;

    // 1. Open test site by URL
    @BeforeClass
    public void setup() {
        ITestResult itr = Reporter.getCurrentTestResult();
        System.err.println("ClassName: " + itr.getInstance().getClass().getName());
        driver = WebDriverManager.chromedriver().create();

        // 1. Open test site by URL
        driver.navigate().to("https://jdi-testing.github.io/jdi-light/index.html");
        driver.manage().window().maximize();

        // 2. Assert Browser title
        assertThat(driver.getTitle()).isEqualTo("Home Page");

        // 3. Perform login
        new WebDriverWait(driver, 10)
                .until(ExpectedConditions.elementToBeClickable(By
                        .cssSelector("ul.uui-navigation.navbar-nav.navbar-right > li > a")));

        driver.findElement(By.cssSelector("ul.uui-navigation.navbar-nav.navbar-right > li > a")).click();
        driver.findElement(By.id("name")).sendKeys("Roman");
        driver.findElement(By.id("password")).sendKeys("Jdi1234");
        driver.findElement(By.id("login-button")).click();

        new WebDriverWait(driver, 10)
                .until(ExpectedConditions
                        .elementToBeClickable(By
                                .id("user-name")));

        // 4. Assert Username is loggined
        assertThat(driver.findElement(By.id("user-name")).getText()).isEqualTo("ROMAN IOVLEV");
    }

    @AfterClass
    public void after() {
        // Close Browser
        driver.close();
    }
}
