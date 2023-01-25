package com.epam.tc.hw2;


import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.ITestResult;
import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;


public class BrowserTestBase {

    protected WebDriver driver;

    @BeforeClass
    public void setup() {
        ITestResult itr = Reporter.getCurrentTestResult();
        System.err.println("ClassName: " + itr.getInstance().getClass().getName());
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
    }

    @AfterClass
    public void after() {
        // Close Browser
        driver.quit();
    }

}
