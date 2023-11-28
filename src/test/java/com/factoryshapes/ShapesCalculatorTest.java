package com.factoryshapes;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.when;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.api.io.TempDir;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;

/**
 * Unit test for simple App.
 */
@ExtendWith(MockitoExtension.class)
public class ShapesCalculatorTest {

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Mock
    Shapes shapeCircle;

    @Mock
    Shapes shapeRectangle;

    @Mock
    Shapes shapeSquare;

    @Mock
    ShapesCalculator sc;

    @Mock
    ShapeFactory fs;

    private String inputFile = "C:/Users/ksanthanakr/Workspace/santek/src/test/java/com/resources/inputValues.txt";
    private String outputFile = "C:/Users/ksanthanakr/Workspace/santek/src/test/java/com/resources/outputValues.txt";

    @Test
    void testCircleArea() throws IOException{
        when(shapeCircle.calculateArea()).thenReturn(28.274333882308138);
        assertEquals(28.274333882308138, shapeCircle.calculateArea());
    }

    @Test
    void testSquareArea() throws IOException{
        when(shapeSquare.calculateArea()).thenReturn(36.0);
        assertEquals(36.0, shapeSquare.calculateArea());
    }

    @Test
    void testRectangleArea() throws IOException{
        when(shapeRectangle.calculateArea()).thenReturn(6.0);
        assertEquals(6.0, shapeRectangle.calculateArea());
    }

    @Test
    void testCirclePerimeter() throws IOException{
        when(shapeCircle.calculatePerimeter()).thenReturn(18.84955592153876);
        assertEquals(18.84955592153876, shapeCircle.calculatePerimeter());
    }

    @Test
    void testSquarePerimeter() throws IOException{
        when(shapeSquare.calculatePerimeter()).thenReturn(24.0);
        assertEquals(24.0, shapeSquare.calculatePerimeter());
    }

    @Test
    void testRectanglePerimeter() throws IOException{
        when(shapeRectangle.calculatePerimeter()).thenReturn(10.0);
        assertEquals(10.0, shapeRectangle.calculatePerimeter());
    }

    @Test
    void testCalculateShapeDimensions_Circle(@TempDir Path tempDir) throws IOException {
        Path input = tempDir.resolve(inputFile);
        Path ouPath = tempDir.resolve(outputFile);
        String inputContent = "Circle, 3";
        Files.write(input, inputContent.getBytes());
        sc.processShapesAndDimensions(input.toString(), ouPath.toString());
        String opContent = Files.readString(ouPath);
        String expectedOutput = "Area of Circle = 28.274333882308138, Perimeter of Circle = 18.84955592153876";
        assertTrue(opContent.contains(expectedOutput));
    }

    @Test
    void testCalculateShapeDimensions_Square(@TempDir Path tempDir) throws IOException {
        Path input = tempDir.resolve(inputFile);
        Path ouPath = tempDir.resolve(outputFile);
        String inputContent = "Square, 6, 0";
        Files.write(input, inputContent.getBytes());
        sc.processShapesAndDimensions(input.toString(), ouPath.toString());
        String opContent = Files.readString(ouPath);
        String expectedOutput = "Area of Square = 36.0, Perimeter of Square = 24.0";
        assertTrue(opContent.contains(expectedOutput));
    }

    @Test
    void testCalculateShapeDimensions_Rectangle(@TempDir Path tempDir) throws IOException {
        Path input = tempDir.resolve(inputFile);
        Path ouPath = tempDir.resolve(outputFile);
        String inputContent = "Rectangle, 3, 2\n";
        Files.write(input, inputContent.getBytes());
        sc.processShapesAndDimensions(input.toString(), ouPath.toString());
        String opContent = Files.readString(ouPath);
        String expectedOutput = "Area of Rectangle = 6.0, Perimeter of Rectangle = 10.0";
        assertTrue(opContent.contains(expectedOutput));
    }

    @Test
    void testAllCalculateShapeDimensions(@TempDir Path tempDir) throws IOException {
        Path input = tempDir.resolve(inputFile);
        Path ouPath = tempDir.resolve(outputFile);
        String inputContent = "Circle, 3, 0\nSquare, 6, 0\nRectangle, 3, 2\n";
        Files.write(input, inputContent.getBytes());
        sc.processShapesAndDimensions(input.toString(), ouPath.toString());
        String opContent = Files.readString(ouPath);
        String expectedOutput = "Area of Circle = 28.274333882308138, Perimeter of Circle = 18.84955592153876\r\nArea of Square = 36.0, Perimeter of Square = 24.0\r\nArea of Rectangle = 6.0, Perimeter of Rectangle = 10.0";
        assertTrue(opContent.contains(expectedOutput));
    }

    @Test
    void testInvalidData() throws IOException {
        try {
            fs.createShape("Invalid", 0, 0);
        } catch (IllegalArgumentException e) {
            assertEquals("Invalid ShapetypeInvalid", e.getMessage());
        }
    }

    /**
     * Rigorous Test :-)
     */
    @Test
    public void shouldAnswerWithTrue() {
        assertTrue(true);
    }
}
