package com.axelsavizky;

import com.axelsavizky.model.Forecast;
import com.axelsavizky.model.ForecastOutput;
import com.axelsavizky.model.Planet;

import java.awt.geom.Point2D;
import java.util.Optional;

import static com.axelsavizky.model.Forecast.*;
import static com.axelsavizky.utils.MathUtils.*;

public class SolarSystem {
    private Planet ferengi;
    private Planet betasoide;
    private Planet vulcano;
    private int daysByYear = 365;

    private Forecast lastForecast = NOTHING;

    private static final Point2D.Double SUN_POSITION = new Point2D.Double(0,0);

    public SolarSystem(Planet ferengi, Planet betasoide, Planet vulcano) {
        this.ferengi = ferengi;
        this.betasoide = betasoide;
        this.vulcano = vulcano;
    }

    public SolarSystem(Planet ferengi, Planet betasoide, Planet vulcano, int daysByYear) {
        this.ferengi = ferengi;
        this.betasoide = betasoide;
        this.vulcano = vulcano;
        this.daysByYear = daysByYear;
    }

    public SolarSystem() {
    }


    private Optional<Forecast> getForecast(Point2D.Double ferengiPosition, Point2D.Double betasoidePosition, Point2D.Double vulcanoPosition) {
        double planetsTriangleArea = triangleArea(ferengiPosition, betasoidePosition, vulcanoPosition);

        if (doubleEquals(planetsTriangleArea, 0)) {
            return Optional.of(isDroughtPeriod(ferengiPosition, betasoidePosition) ? DROUGHT : OPTIMAL);
        } else {
            //Its a triangle
            double areaT1 = triangleArea(SUN_POSITION, betasoidePosition, vulcanoPosition);
            double areaT2 = triangleArea(ferengiPosition, SUN_POSITION, vulcanoPosition);
            double areaT3 = triangleArea(ferengiPosition, betasoidePosition, SUN_POSITION);

            if (doubleEquals(planetsTriangleArea, areaT1 + areaT2 + areaT3)) {
                return Optional.of(RAIN);
            }
        }

        return Optional.empty();
    }

    //Planets aligned with sun
    //@Require planets aligned
    private boolean isDroughtPeriod(Point2D.Double ferengiPosition, Point2D.Double betasoidePosition) {

        return doubleEquals(triangleArea(ferengiPosition, betasoidePosition, SUN_POSITION), 0);
    }


    public ForecastOutput forecastForYear(int years) {
        ForecastOutput output = new ForecastOutput();
        double maxPerimeter = 0;
        int dayOfMaxPerimeter = -1;


        for (int day = 0; day < years * daysByYear; day++) {
            Point2D.Double ferengiPosition = ferengi.getPosition(day);
            Point2D.Double betasoidePosition = betasoide.getPosition(day);
            Point2D.Double vulcanoPosition = vulcano.getPosition(day);

            Optional<Forecast> forecastOpt = this.getForecast(ferengiPosition, betasoidePosition, vulcanoPosition);


            if (forecastOpt.isPresent()) {
                Forecast forecast = forecastOpt.get();

                //if forecast doesnt change, its the same period
                if (!lastForecast.equals(forecast)) {
                    output.addForecast(forecast);
                }

                if (RAIN.equals(forecast)) {
                    double perimeter = trianglePerimeter(ferengiPosition, betasoidePosition, vulcanoPosition);

                    if (perimeter > maxPerimeter) {
                        maxPerimeter = perimeter;
                        dayOfMaxPerimeter = day;
                    }
                }
            }
        }

        output.setMaxRainyDay(dayOfMaxPerimeter);

        return output;
    }

    public Planet getFerengi() {
        return ferengi;
    }

    public void setFerengi(Planet ferengi) {
        this.ferengi = ferengi;
    }

    public Planet getBetasoide() {
        return betasoide;
    }

    public void setBetasoide(Planet betasoide) {
        this.betasoide = betasoide;
    }

    public Planet getVulcano() {
        return vulcano;
    }

    public void setVulcano(Planet vulcano) {
        this.vulcano = vulcano;
    }
}
