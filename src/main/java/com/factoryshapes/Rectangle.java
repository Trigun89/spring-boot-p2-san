package com.factoryshapes;

public class Rectangle implements Shapes {

    double length;
    double breadth;

    Rectangle(double length, double breadth) {
        this.length = length;
        this.breadth = breadth;
    }

    @Override
    public double calculateArea() {
        double areaOfRect = length * breadth;
        return areaOfRect;
    }

    @Override
    public double calculatePerimeter() {
        double perimeterOfRect = 2 * (length + breadth);
        return perimeterOfRect;
    }

}