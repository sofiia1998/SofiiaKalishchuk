package com.epam.tc.hw2.ex1;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

import com.epam.tc.hw2.BrowserTestBase;
import java.util.List;
import org.assertj.core.api.SoftAssertions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

public class ExerciseFirstTest extends BrowserTestBase {
    SoftAssertions softAssertions = new SoftAssertions();

    @Test
    public void testIndexPage() {
        // 1. Open test site by URL
        driver.navigate().to("https://jdi-testing.github.io/jdi-light/index.html");

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

        // 5. Assert that there are 4 items on the header section are displayed and that they have proper texts
        List<WebElement> header = driver.findElements(By.cssSelector(".uui-navigation.nav.navbar-nav.m-l8 > li"));
        softAssertions.assertThat(header.size()).as("check the size of header").isEqualTo(4);
        List<String> expectedHeaderItems = List.of("HOME", "CONTACT FORM", "SERVICE", "METALS & COLORS");
        for (int i = 0; i < header.size(); i++) {
            softAssertions.assertThat(header.get(i).isDisplayed()).as("check the header item is displayed").isTrue();
            softAssertions.assertThat(header.get(i).getText())
                    .as("check the header item has a proper text").isEqualTo(expectedHeaderItems.get(i));
        }

        // 6. Assert that there are 4 images on the Index Page and that they are displayed
        List<WebElement> benefitIcon = driver.findElements(By.className("benefit-icon"));
        softAssertions.assertThat(benefitIcon.size()).as("check the number of benefit icons").isEqualTo(4);
        for (int i = 0; i < header.size(); i++) {
            softAssertions.assertThat(benefitIcon.get(i).isDisplayed())
                    .as("check the benefit icon is displayed").isTrue();
        }

        // 7. Assert that there are 4 texts on the Index Page under icons and that they have proper text
        List<WebElement> benefitText = driver.findElements(By.className("benefit-txt"));
        softAssertions.assertThat(benefitText.size()).as("check the number of benefit texts").isEqualTo(4);
        List<String> expectedBenefitTextItems = List.of("To include good practices\nand ideas from successful\n"
                        + "EPAM project", "To be flexible and\ncustomizable", "To be multiplatform",
                "Already have good base\n(about 20 internal and\nsome external projects),\nwish to get more…");
        for (int i = 0; i < header.size(); i++) {
            softAssertions.assertThat(benefitText.get(i).isDisplayed()).as("check the benefit text is displayed")
                    .isTrue();
            softAssertions.assertThat(benefitText.get(i).getText()).as("check the benefit text item has a proper text")
                    .isEqualTo(expectedBenefitTextItems.get(i));
        }

        // 8. Assert that there is the iframe with “Frame Button” exist
        softAssertions.assertThat(driver.findElement(By.id("frame")).isDisplayed())
                .as("check the frame is displayed").isTrue();
        // 9. Switch to the iframe and check that there is “Frame Button” in the iframe
        driver.switchTo().frame("frame");
        softAssertions.assertThat(driver.findElement(By.id("frame-button")).isDisplayed())
                .as("check frame button is displayed").isTrue();
        // 10. Switch to original window back
        driver.switchTo().defaultContent();

        // 11. Assert that there are 5 items in the Left Section are displayed and they have proper text
        List<WebElement> sidebarMenu = driver.findElements(By.cssSelector(".sidebar-menu.left > li"));
        softAssertions.assertThat(sidebarMenu.size()).as("check the size of sidebar menu")
                .isEqualTo(5);
        List<String> expectedSidebarMenuItems = List.of("Home", "Contact form", "Service",
                "Metals & Colors", "Elements packs");
        for (int i = 0; i < sidebarMenu.size(); i++) {
            softAssertions.assertThat(sidebarMenu.get(i).isDisplayed())
                    .as("check the sidebar menu item is displayed").isTrue();
            softAssertions.assertThat(sidebarMenu.get(i).getText())
                    .as("check the sidebar menu item has a proper text").isEqualTo(expectedSidebarMenuItems.get(i));
        }

        softAssertions.assertAll();

    }
}
