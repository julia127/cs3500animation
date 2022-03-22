package model;

import static org.junit.Assert.*;

import java.awt.Color;

public class ShapeTest {
  IShape circ1 = new Circle("Circ1", new Coordinate(15, 10), Color.BLACK, 5, 5);
  IShape rect1 = new Rect("Rect1", new Coordinate(30, 10), Color.RED, 10, 15);

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