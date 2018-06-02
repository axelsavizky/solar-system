package com.axelsavizky;

import com.axelsavizky.model.ForecastOutput;
import com.axelsavizky.model.Planet;

public class Main {

    public static void main(String[] args) {
        Planet planet1 = new Planet(1, true, 500);
        Planet planet2 = new Planet(3, true, 2000);
        Planet planet3 = new Planet(5, false, 1000);

        SolarSystem solarSystem = new SolarSystem(planet1, planet2, planet3);

        ForecastOutput output = solarSystem.forecastForYear(10);

        System.out.println(output);
    }
}
