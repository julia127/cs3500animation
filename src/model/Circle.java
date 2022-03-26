package model;

import java.awt.Color;

/**
 * Represents a Circle.
 */
public class Circle extends AShape {
  /**
   * Constructor for a Circle.
   * @param name Represents the name for the Circle.
   * @param color Represents the color of the Circle
   * @param coords Represents the position of the Circle.
   * @param width Represents the width of the Circle.
   * @param height Represents the height of the Circle.
   */
  public Circle(String name, Color color, Coordinate coords, int width, int height) {
    super(name, color, coords, width, height);
    super.shapeType = ShapeType.CIRCLE;
  }
}

