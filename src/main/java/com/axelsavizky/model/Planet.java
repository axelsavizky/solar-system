package com.axelsavizky.model;


import java.awt.geom.Point2D;

import static java.lang.Math.*;

public class Planet {
    private int gradesByDay;
    private boolean clockwise;
    private int sunKmDistance;

    public Planet(int gradesByDay, boolean clockwise, int sunKmDistance) {
        this.gradesByDay = gradesByDay;
        this.clockwise = clockwise;
        this.sunKmDistance = sunKmDistance;
    }

    public Planet() {
    }

    public Point2D.Double getPosition(int day) {
        int currentGrade = clockwise ? day * gradesByDay : day * -gradesByDay;

        //Add and substract 90 because I assume that planets start at the top (like the pdf)
        return new Point2D.Double(sunKmDistance * cos(toRadians(currentGrade - 90)), sunKmDistance * sin(toRadians(currentGrade + 90)));
    }

    public int getGradesByDay() {
        return gradesByDay;
    }

    public void setGradesByDay(int gradesByDay) {
        this.gradesByDay = gradesByDay;
    }

    public boolean isClockwise() {
        return clockwise;
    }

    public void setClockwise(boolean clockwise) {
        this.clockwise = clockwise;
    }

    public int getSunKmDistance() {
        return sunKmDistance;
    }

    public void setSunKmDistance(int sunDistance) {
        this.sunKmDistance = sunDistance;
    }
}
