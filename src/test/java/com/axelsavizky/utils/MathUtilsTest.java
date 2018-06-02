package com.axelsavizky.utils;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.awt.geom.Point2D;

import static com.axelsavizky.utils.MathUtils.*;
import static org.testng.Assert.*;

@Test
public class MathUtilsTest {

    public void testDoubleEquals() {
        assertTrue(doubleEquals(0.0001, 0.0001));
        assertFalse(doubleEquals(0.0001, 0.0002));
    }

    @DataProvider
    public Object[][] triangleProvider() {
        return new Object[][] {
                {new Point2D.Double(100, 128), new Point2D.Double(252, 296), new Point2D.Double(450, 19)
                        , 37684, 933.626},
                {new Point2D.Double(100, 0), new Point2D.Double(100, 296), new Point2D.Double(345, 0)
                        , 36260, 925.241}
        };
    }

    @Test(dataProvider = "triangleProvider")
    public void testTriangleFunctions(Point2D.Double a, Point2D.Double b, Point2D.Double c, double areaExpected, double perimeterExpected) {
        assertEquals(triangleArea(a, b, c), areaExpected);
        assertEquals(Math.round(trianglePerimeter(a, b, c) * 1000.0) / 1000.0, perimeterExpected);
    }



}
