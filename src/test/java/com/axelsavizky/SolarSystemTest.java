package com.axelsavizky;

import com.axelsavizky.model.Forecast;
import com.axelsavizky.model.ForecastOutput;
import com.axelsavizky.model.Planet;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.unitils.reflectionassert.ReflectionAssert;

import java.util.EnumMap;

@Test
public class SolarSystemTest {
    private SolarSystem solarSystem;

    @BeforeClass
    public void setUp() {
        Planet planet1 = new Planet(1, true, 500);
        Planet planet2 = new Planet(3, true, 2000);
        Planet planet3 = new Planet(5, false, 1000);

        this.solarSystem = new SolarSystem(planet1, planet2, planet3);
    }

    public void test0Years() {
        ForecastOutput forecastOutput = new ForecastOutput();

        ReflectionAssert.assertReflectionEquals(forecastOutput, this.solarSystem.forecastForYear(0));
    }

    public void test10Years() {
        ForecastOutput forecastOutput = new ForecastOutput();

        EnumMap<Forecast, Integer> forecasts = new EnumMap<>(Forecast.class);
        forecasts.put(Forecast.DROUGHT, 41);
        forecasts.put(Forecast.RAIN, 1208);

        forecastOutput.setForecasts(forecasts);
        forecastOutput.setMaxRainyDay(2808);

        ReflectionAssert.assertReflectionEquals(forecastOutput, this.solarSystem.forecastForYear(10));
    }

    public void testForOptimalConditions() {
        Planet planet1 = new Planet(1, true, 100);
        Planet planet2 = new Planet(2, true, 100);
        Planet planet3 = new Planet(4, true, 100);

        this.solarSystem = new SolarSystem(planet1, planet2, planet3);

        ForecastOutput forecastOutput = new ForecastOutput();

        EnumMap<Forecast, Integer> forecasts = new EnumMap<>(Forecast.class);
        forecasts.put(Forecast.DROUGHT, 21);
        forecasts.put(Forecast.RAIN, 620);
        forecasts.put(Forecast.OPTIMAL, 20);

        forecastOutput.setForecasts(forecasts);
        forecastOutput.setMaxRainyDay(3164);

        ReflectionAssert.assertReflectionEquals(forecastOutput, this.solarSystem.forecastForYear(10));
    }
}
