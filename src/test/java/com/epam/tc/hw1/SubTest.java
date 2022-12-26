package com.epam.tc.hw1;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

import org.assertj.core.data.Percentage;
import org.testng.annotations.Test;


public class SubTest extends CalculatorTestBase {
    private static final double PRECISION = 0.0000001;

    @Test(dataProviderClass = DataProviders.class, dataProvider = "sub long data")
    public void subTestLong(long first, long second, long third) {

        long result = calculator.sub(first, second);

        assertThat(result).as("This test is failed").isEqualTo(third);
    }

    @Test(dataProviderClass = DataProviders.class, dataProvider = "sub double data")
    public void subTestDouble(double first, double second, double third) {

        double result = calculator.sub(first, second);

        assertThat(result).as("This test is failed")
                .isCloseTo(third, Percentage.withPercentage(PRECISION));
    }
}
