package com.factoryshapes;

public class Square implements Shapes {

    double size;

    Square(double size) {
        this.size = size;
    }

    @Override
    public double calculateArea() {
        double areaOfSquare = size * size;
        return areaOfSquare;
    }

    @Override
    public double calculatePerimeter() {
        double perimeterOfSquare = 4 * size;
        return perimeterOfSquare;
    }
}