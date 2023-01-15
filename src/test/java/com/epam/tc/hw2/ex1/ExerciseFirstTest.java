package com.epam.tc.hw2.ex1;

import com.epam.tc.hw2.BrowserTestBase;
import java.util.List;
import org.assertj.core.api.SoftAssertions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;


public class ExerciseFirstTest extends BrowserTestBase {
    // 5. Assert that there are 4 items on the header section are displayed and they have proper texts
    @Test
    public void test4ItemsHeader() {
        SoftAssertions softAssertions = new SoftAssertions();
        softAssertions.assertThat(driver.findElement(By.partialLinkText("HOME")).getText())
                .isEqualTo("HOME");
        softAssertions.assertThat(driver.findElement(By.partialLinkText("CONTACT FORM")).getText())
                .isEqualTo("CONTACT FORM");
        softAssertions.assertThat(driver.findElement(By.partialLinkText("SERVICE")).getText())
                .isEqualTo("SERVICE");
        softAssertions.assertThat(driver.findElement(By.partialLinkText("METALS & COLORS")).getText())
                .isEqualTo("METALS & COLORS");
        softAssertions.assertAll();
    }

    // 6. Assert that there are 4 images on the Index Page and they are displayed
    // 7. Assert that there are 4 texts on the Index Page under icons and they have proper text
    @Test
    public void test4ImagesIndexPage() {
        SoftAssertions softAssertions = new SoftAssertions();
        softAssertions.assertThat(driver.findElements(By.className("benefit-txt")).get(0).getText())
                .isEqualTo("To include good practices\n"
                        + "and ideas from successful\n"
                        + "EPAM project");
        softAssertions.assertThat(driver.findElements(By.className("benefit-txt")).get(1).getText())
                .isEqualTo("To be flexible and\n"
                        + "customizable");
        softAssertions.assertThat(driver.findElements(By.className("benefit-txt")).get(2).getText())
                .isEqualTo("To be multiplatform");
        softAssertions.assertThat(driver.findElements(By.className("benefit-txt")).get(3).getText())
                .isEqualTo("Already have good base\n"
                        + "(about 20 internal and\n"
                        + "some external projects),\n"
                        + "wish to get more…");
        softAssertions.assertAll();
    }

    // 8. Assert that there is the iframe with “Frame Button” exist
    // 9. Switch to the iframe and check that there is “Frame Button” in the iframe
    // 10. Switch to original window back
    @Test
    public void testIframeWithButtonExists() {
        SoftAssertions softAssertions = new SoftAssertions();
        softAssertions.assertThat(driver.findElement(By.id("frame"))).isNotNull();
        driver.switchTo().frame("frame");
        softAssertions.assertThat(driver.findElement(By.id("frame-button"))).isNotNull();
        driver.switchTo().defaultContent();
        softAssertions.assertAll();
    }

    // 11. Assert that there are 5 items in the Left Section are displayed and they have proper text
    @Test
    public void test5ItemsInTheLestSection() {
        SoftAssertions softAssertions = new SoftAssertions();
        List<WebElement> sidebarMenu = driver.findElements(By.cssSelector("#mCSB_1_container > ul > li"));
        softAssertions.assertThat(sidebarMenu.size()).isEqualTo(5);
        softAssertions.assertThat(sidebarMenu.get(0).getText()).isEqualTo("Home");
        softAssertions.assertThat(sidebarMenu.get(1).getText()).isEqualTo("Contact form");
        softAssertions.assertThat(sidebarMenu.get(2).getText()).isEqualTo("Service");
        softAssertions.assertThat(sidebarMenu.get(3).getText()).isEqualTo("Metals & Colors");
        softAssertions.assertThat(sidebarMenu.get(4).getText()).isEqualTo("Elements packs");
        softAssertions.assertAll();
    }
}
