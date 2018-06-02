package com.axelsavizky.model;

import org.testng.annotations.Test;

import java.awt.geom.Point2D;

import static com.axelsavizky.utils.MathUtils.doubleEquals;
import static org.testng.Assert.assertTrue;

@Test
public class PlanetTest {
    private Planet planet;

    public void testGetPosition() {
        planet = new Planet(90, true, 100);

        Point2D.Double planetPosition = planet.getPosition(1);

        Point2D.Double expectedPosition = new Point2D.Double(100, 0);

        assertTrue(doubleEquals(planetPosition.x, expectedPosition.x));
        assertTrue(doubleEquals(planetPosition.y, expectedPosition.y));

        planet.setClockwise(false);

        planetPosition = planet.getPosition(1);

        expectedPosition = new Point2D.Double(-100, 0);

        assertTrue(doubleEquals(planetPosition.x, expectedPosition.x));
        assertTrue(doubleEquals(planetPosition.y, expectedPosition.y));
    }
}
