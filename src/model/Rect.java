package model;

import java.awt.Color;

/**
 * Represents a Rectangle.
 */
public class Rect extends AShape {

  /**
   * Constructor for a Rectangle.
   * @param name Represents the name for the Rect.
   * @param color Represents the color for the Rect.
   * @param coord Represents the position for the Rect.
   * @param width Represents the width for the Rect.
   * @param height Represents tee height for the rect.
   */
  public Rect(String name, Color color, Coordinate coord, int width, int height) {
    super(name, color, coord, width, height);
    this.shapeType = ShapeType.RECTANGLE;
  }

}
