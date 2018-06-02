package com.axelsavizky.model;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertNull;

@Test
public class ForecastOutputTest {
    private ForecastOutput target;

    @BeforeClass
    public void setUp() {
        this.target = new ForecastOutput();
    }

    public void testAddForecast() {
        this.target.addForecast(Forecast.RAIN);
        assertEquals(this.target.getForecasts().get(Forecast.RAIN), Integer.valueOf(1));

        for (Forecast forecast : Forecast.values()) {
            if (forecast != Forecast.RAIN) {
                assertNull(this.target.getForecasts().get(forecast));
            }
        }

        this.target.addForecast(Forecast.RAIN);
        assertEquals(this.target.getForecasts().get(Forecast.RAIN), Integer.valueOf(2));

    }
}
