package com.epam.tc.hw1;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

import com.epam.tat.module4.Calculator;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;


public class TestSum {
    @DataProvider
    public static Object[][] longData() {
        return new Object[][]{
                {10, 20, 30},
                {5, 5, 5},
                {10, 15, 25}
        };
    }
    @DataProvider
    public static Object[][] doubleData() {
        return new Object[][]{
                {5.7, 5.3, 11.0},
                {5.5, 4.8, 7},
                {4.7, 3.3, 8}
        };
    }

    @Test(dataProvider = "longData")
    public void sumTestLong(long first, long second, long third) {

        Calculator calculator = new Calculator();
        long result = calculator.sum(first, second);

        assertThat(result).as("This test failed (and it is expected)").isEqualTo(third);
    }

    @Test(dataProvider = "doubleData")
    public void sumTestDouble(double first, double second, double third) {

        Calculator calculator = new Calculator();
        double result = calculator.sum(first, second);

        assertThat(result).as("This test failed (and it is expected)").isEqualTo(third);
    }
}
