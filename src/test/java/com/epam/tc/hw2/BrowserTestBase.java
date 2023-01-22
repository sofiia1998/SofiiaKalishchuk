package com.epam.tc.hw2;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.ITestResult;
import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;


public class BrowserTestBase {

    protected WebDriver driver;

    public void setup() {
        ITestResult itr = Reporter.getCurrentTestResult();
        System.err.println("ClassName: " + itr.getInstance().getClass().getName());
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
    }

    @BeforeClass
    public void login() {
        // 1. Open test site by URL
        setup();
        driver.navigate().to("https://jdi-testing.github.io/jdi-light/index.html");
        driver.manage().window().maximize();

        // 2. Assert Browser title
        assertThat(driver.getTitle()).as("check the title").isEqualTo("Home Page");

        // 3. Perform login
        new WebDriverWait(driver, 10)
                .until(ExpectedConditions.elementToBeClickable(By.className("uui-profile-menu")));

        driver.findElement(By.className("uui-profile-menu")).click();
        driver.findElement(By.id("name")).sendKeys("Roman");
        driver.findElement(By.id("password")).sendKeys("Jdi1234");
        driver.findElement(By.id("login-button")).click();

        // 4. Assert Username is loggined
        assertThat(driver.findElement(By.id("user-name")).getText()).as("check the username")
                .isEqualTo("ROMAN IOVLEV");
    }

    @AfterClass
    public void after() {
        // Close Browser
        driver.quit();
    }

}
