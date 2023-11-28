package com.factoryshapes;

public class Circle implements Shapes {
    double rad;

    Circle(double rad) {
        this.rad = rad;
    }

    @Override
    public double calculateArea() {
        double areaOfcircle = Math.PI * rad * rad;
        return areaOfcircle;
    }

    @Override
    public double calculatePerimeter() {
        double perimeterOfcircle = 2 * Math.PI * rad;
        return perimeterOfcircle;
    }
}