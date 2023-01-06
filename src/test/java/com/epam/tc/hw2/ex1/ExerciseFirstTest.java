package com.epam.tc.hw2.ex1;


import io.github.bonigarcia.wdm.WebDriverManager;
import org.assertj.core.api.SoftAssertions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;


public class ExerciseFirstTest {
    protected WebDriver driver;

    // 1. Open test site by URL
    @BeforeTest
    public void setup() {
        driver = WebDriverManager.chromedriver().create();
        driver.navigate().to("https://jdi-testing.github.io/jdi-light/index.html");
        driver.manage().window().maximize();
    }

    // 2. Assert Browser title
    @Test
    public void testBrowserTitle() {
        assertThat(driver.getTitle()).isEqualTo("Home Page");
    }

    // 3. Perform login and 4. Assert Username is loggined
    @Test
    public void testLogin() {
        new WebDriverWait(driver, 10)
                .until(ExpectedConditions.elementToBeClickable(By.cssSelector("ul.uui-navigation.navbar-nav.navbar-right > li > a")));

        driver.findElement(By.cssSelector("ul.uui-navigation.navbar-nav.navbar-right > li > a")).click();
        driver.findElement(By.id("name")).sendKeys("Roman");
        driver.findElement(By.id("password")).sendKeys("Jdi1234");
        driver.findElement(By.id("login-button")).click();

        new WebDriverWait(driver, 10)
                .until(ExpectedConditions
                        .elementToBeClickable(By
                                .id("user-name")));

        assertThat(driver.findElement(By.id("user-name")).getText()).isEqualTo("ROMAN IOVLEV");
    }

    // 5. Assert that there are 4 items on the header section are displayed and they have proper texts
    @Test
    public void test4ItemsHeader() {
        SoftAssertions softAssertions = new SoftAssertions();
        softAssertions.assertThat(driver.findElement(By.partialLinkText("HOME")).getText()).isEqualTo("HOME");
        softAssertions.assertThat(driver.findElement(By.partialLinkText("CONTACT FORM")).getText()).isEqualTo("CONTACT FORM");
        softAssertions.assertThat(driver.findElement(By.partialLinkText("SERVICE")).getText()).isEqualTo("SERVICE");
        softAssertions.assertThat(driver.findElement(By.partialLinkText("METALS & COLORS")).getText()).isEqualTo("METALS & COLORS");
        softAssertions.assertAll();
    }

    // 6. Assert that there are 4 images on the Index Page and they are displayed
    // 7. Assert that there are 4 texts on the Index Page under icons and they have proper text
    @Test
    public void test4ImagesIndexPage() {
        SoftAssertions softAssertions = new SoftAssertions();
//        softAssertions.assertThat(driver.findElements(By.className("row-clerafix-benefits")).size()).isEqualTo(4);
        assertThat(driver.findElements(By.className("benefit-txt")).get(0).getText())
                .isEqualTo("To include good practices\n" +
                        "and ideas from successful\n" +
                        "EPAM project");
        assertThat(driver.findElements(By.className("benefit-txt")).get(1).getText())
                .isEqualTo("To be flexible and\n" +
                        "customizable");
        assertThat(driver.findElements(By.className("benefit-txt")).get(2).getText())
                .isEqualTo("To be multiplatform");
        assertThat(driver.findElements(By.className("benefit-txt")).get(3).getText())
                .isEqualTo("Already have good base\n" +
                        "(about 20 internal and\n" +
                        "some external projects),\n" +
                        "wish to get more…");
    }

    // 8. Assert that there is the iframe with “Frame Button” exist
    @Test
    public void testIframeWithButtonExists() {
        assertThat(driver.findElement(By.id("frame"))).isNotNull();
        driver.switchTo().frame("frame");
        assertThat(driver.findElement(By.id("frame-button"))).isNotNull();
    }


    @AfterTest
    public void after() {
        driver.close();
    }
}
