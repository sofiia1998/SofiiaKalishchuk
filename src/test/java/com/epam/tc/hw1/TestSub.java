package com.epam.tc.hw1;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

import com.epam.tat.module4.Calculator;
import org.assertj.core.data.Percentage;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;


public class TestSub {
    private static final double PRECISION = 0.0000001;
    @DataProvider
    public static Object[][] longData() {
        return new Object[][]{
                {10, 20, -10},
                {5, 5, 0},
                {10, 15, 25}
        };
    }
    @DataProvider
    public static Object[][] doubleData() {
        return new Object[][]{
                {5.7, 5.3, 0.4},
                {5.5, 4.8, 7},
                {4.7, 3.3, 1.4}
        };
    }

    @Test(dataProvider = "longData")
    public void subTestLong(long first, long second, long third) {

        Calculator calculator = new Calculator();
        long result = calculator.sub(first, second);

        assertThat(result).as("This test failed (and it is expected)").isEqualTo(third);
    }

    @Test(dataProvider = "doubleData")
    public void subTestDouble(double first, double second, double third) {

        Calculator calculator = new Calculator();
        double result = calculator.sub(first, second);

        assertThat(result).as("This test failed (and it is expected)")
                .isCloseTo(third, Percentage.withPercentage(PRECISION));
    }
}
