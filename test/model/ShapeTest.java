package model;

import static org.junit.Assert.assertEquals;

import java.awt.Color;
import org.junit.Test;

/**
 * Testing class for AShape, IShape, Circle, and Rect.
 */
public class ShapeTest {
  IShape circ1 = new Circle("Circ1", Color.BLACK, new Coordinate(15, 10), 5, 5);
  IShape rect1 = new Rect("Rect1", Color.RED, new Coordinate(30, 10), 10, 15);

  @Test(expected = IllegalArgumentException.class)
  public void invalidDimensions() {
    IShape badDimension = new AShape("test", ShapeType.CIRCLE, Color.red,
            new Coordinate(5,5), -2, -4);
    IShape circ3 = new Circle("Circ3", Color.BLACK, new Coordinate(5,5), -2, 4);
    IShape rect3 = new Rect("Rect3", Color.blue, new Coordinate(13, 13), 5, -7);
  }

  @Test(expected = IllegalArgumentException.class)
  public void invalidColor() {
    IShape badColor = new AShape("test", ShapeType.CIRCLE, null, new Coordinate(5,5), -2, -4);
    IShape circ2 = new Circle("Circ2", null, new Coordinate(15, 10), 4, 6);
  }

  @Test(expected = IllegalArgumentException.class)
  public void invalidCoordinate() {
    IShape badDimension = new AShape("test", ShapeType.CIRCLE, Color.red, null, -2, -4);
    IShape rect2 = new Rect("Rect2", Color.CYAN, null, 8, 12);
  }

  @Test(expected = IllegalArgumentException.class)
  public void testNullColor() {
    circ1.changeColor(null);
    rect1.changeColor(null);
  }

  @Test(expected = IllegalArgumentException.class)
  public void testNullCoordinate() {
    circ1.moveShape(null);
    rect1.moveShape(null);
  }

  @Test(expected = IllegalArgumentException.class)
  public void testNegativeHeight() {
    circ1.setHeight(-10);
    rect1.setHeight(-1);
  }

  @Test(expected = IllegalArgumentException.class)
  public void testNegativeWidth() {
    circ1.setWidth(-5);
    rect1.setWidth(-1);
  }

  @Test
  public void testGetName() {
    assertEquals("Circ1", circ1.getName());
    assertEquals("Rect1", rect1.getName());
  }

  @org.junit.Test
  public void getColor() {
    assertEquals(Color.black, circ1.getColor());
    assertEquals(Color.RED, rect1.getColor());
  }

  @org.junit.Test
  public void getPosition() {
    assertEquals(new Coordinate(15, 10), circ1.getPosition());
    assertEquals(new Coordinate(30, 10), rect1.getPosition());
  }

  @org.junit.Test
  public void getShapeType() {
    assertEquals(ShapeType.CIRCLE, circ1.getShapeType());
    assertEquals(ShapeType.RECTANGLE, rect1.getShapeType());
  }

  @org.junit.Test
  public void getWidth() {
    assertEquals(5, circ1.getWidth());
    assertEquals(10, rect1.getWidth());
  }

  @org.junit.Test
  public void getHeight() {
    assertEquals(5, circ1.getHeight());
    assertEquals(15, rect1.getHeight());
  }

  @org.junit.Test
  public void changeColor() {
    assertEquals(Color.black, circ1.getColor());
    circ1.changeColor(Color.ORANGE);
    assertEquals(Color.ORANGE, circ1.getColor());
    assertEquals(Color.RED, rect1.getColor());
    rect1.changeColor(Color.CYAN);
    assertEquals(Color.CYAN, rect1.getColor());
  }

  @org.junit.Test
  public void moveShape() {
    assertEquals(new Coordinate(15, 10), circ1.getPosition());
    circ1.moveShape(new Coordinate(0,0));
    assertEquals(new Coordinate(0,0), circ1.getPosition());
    assertEquals(new Coordinate(30, 10), rect1.getPosition());
    rect1.moveShape(new Coordinate(60, 20));
    assertEquals(new Coordinate(60, 20), rect1.getPosition());
  }

  @org.junit.Test
  public void setHeight() {
    assertEquals(5, circ1.getHeight());
    circ1.setHeight(20);
    assertEquals(20, circ1.getHeight());
    assertEquals(15, rect1.getHeight());
    rect1.setHeight(30);
    assertEquals(30, rect1.getHeight());
  }

  @org.junit.Test
  public void setWidth() {
    assertEquals(5, circ1.getWidth());
    circ1.setWidth(20);
    assertEquals(20, circ1.getWidth());
    assertEquals(10, rect1.getWidth());
    rect1.setWidth(25);
    assertEquals(25, rect1.getWidth());
  }
}