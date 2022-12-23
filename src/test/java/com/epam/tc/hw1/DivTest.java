package com.epam.tc.hw1;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;

import org.assertj.core.data.Percentage;
import org.testng.annotations.Test;


public class DivTest extends  CalculatorTestBase {
    private static final double PRECISION = 0.0000001;

    @Test(dataProviderClass = DataProviders.class, dataProvider = "div long data")
    public void divTestLong(long first, long second, long third) {

        long result = calculator.div(first, second);

        assertThat(result).as("This test is failed").isEqualTo(third);
    }

    @Test(dataProviderClass = DataProviders.class, dataProvider = "div double data")
    public void divTestDouble(double first, double second, double third) {

        double result = calculator.div(first, second);

        assertThat(result).as("This test is failed")
                .isCloseTo(third, Percentage.withPercentage(PRECISION));
    }

    @Test(dataProviderClass = DataProviders.class, dataProvider = "div zero data")
    public void divTestLongZero(long first, long second, Class third) {
        assertThatThrownBy(() -> calculator.div(first, second))
                .isInstanceOf(third).hasMessage("Attempt to divide by zero");
    }
}
