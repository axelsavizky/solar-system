package com.axelsavizky.utils;

import java.awt.geom.Point2D;

import static java.lang.Math.abs;
import static java.lang.Math.pow;

public class MathUtils {

    public static boolean doubleEquals(double d1, double d2) {
        return Math.abs(d1 - d2) < 0.0001;
    }

    private static double euclideanDistance(Point2D.Double point1, Point2D.Double point2) {
        double xDiff = point2.x - point1.x;
        double yDiff = point2.y - point1.y;

        return Math.sqrt(pow(xDiff, 2) + pow(yDiff, 2));
    }

    public static double triangleArea(Point2D.Double a, Point2D.Double b, Point2D.Double c) {
        return abs((a.x*(b.y - c.y) + b.x*(c.y - a.y) + c.x*(a.y - b.y)) / 2);
    }

    public static double trianglePerimeter(Point2D.Double a, Point2D.Double b, Point2D.Double c) {
        double edgeASize = euclideanDistance(a, b);
        double edgeBSize = euclideanDistance(b, c);
        double edgeCSize = euclideanDistance(c, a);

        return edgeASize + edgeBSize + edgeCSize;
    }
}
