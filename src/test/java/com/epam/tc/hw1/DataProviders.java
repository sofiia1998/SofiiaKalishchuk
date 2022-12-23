package com.epam.tc.hw1;

import org.testng.annotations.DataProvider;

public class DataProviders {

    @DataProvider(name = "div long data")
    public static Object[][] divLongData() {
        return new Object[][]{
                {20, 10, 2},
                {5, 5, 1},
                {100, 25, 4}
        };
    }

    @DataProvider(name = "div double data")
    public static Object[][] divDoubleData() {
        return new Object[][]{
                {5.7, 2, 2.85},
                {3.3, 3, 1.1},
                {5.6, 0.8, 7}
        };
    }

    @DataProvider(name = "div zero data")
    public static Object[][] divZeroData() {
        return new Object[][]{
                {100, 0, NumberFormatException.class}
        };
    }

    @DataProvider(name = "mult long data")
    public static Object[][] multLongData() {
        return new Object[][]{
                {10, 20, 200},
                {5, 5, 25},
                {10, 15, 150}
        };
    }

    @DataProvider(name = "mult double data")
    public static Object[][] multDoubleData() {
        return new Object[][]{
                {5.7, 5.3, 30},
                {5.5, 4.8, 26},
                {4.7, 3.3, 15}
        };
    }

    @DataProvider(name = "sub long data")
    public static Object[][] subLongData() {
        return new Object[][]{
                {10, 20, -10},
                {5, 5, 0},
                {10, 15, -5}
        };
    }

    @DataProvider(name = "sub double data")
    public static Object[][] subDoubleData() {
        return new Object[][]{
                {5.7, 5.3, 0.4},
                {5.5, 4.8, 0.7},
                {4.7, 3.3, 1.4}
        };
    }

    @DataProvider(name = "sum long data")
    public static Object[][] sumLongData() {
        return new Object[][]{
                {10, 20, 30},
                {5, 5, 10},
                {10, 15, 25}
        };
    }

    @DataProvider(name = "sum double data")
    public static Object[][] sumDoubleData() {
        return new Object[][]{
                {5.7, 5.3, 11.0},
                {5.5, 4.8, 10.3},
                {4.7, 3.3, 8}
        };
    }

}
