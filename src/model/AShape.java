package model;

import java.awt.*;

/**
 * Represents a shape
 */
public class AShape implements IShape {

  protected String shapeName;
  protected ShapeType shapeType; // this should be an enum
  protected Color color;
  protected Coordinate coord;
  protected int height;
  protected int width;

  /**
   * Constructor for a shape.
   * @param color Represents the color of this shape.
   * @param coord Represents the coordinates of this shape.
   * @param width Represents the width of this shape.
   * @param height Represents the height of this shape.
   */
  public AShape(Color color, Coordinate coord, int width, int height) {
    if (width <= 0 || height <= 0) {
      throw new IllegalArgumentException("Invalid dimensions");
    }
    else if (color == null || coord == null) {
      throw new IllegalArgumentException("Invalid coordinates or color");
    }
    this.color = color;
    this.coord = coord;
    this.height = height;
    this.width = width;
  }
  @Override
  public Color getColor() {
    return this.color;
  }

  @Override
  public Coordinate getPosition() {
    return this.coord;
  }

  @Override
  public String getShapeType() {
    return this.shapeName;
  }

  @Override
  public int getWidth() {
    return this.width;
  }

  @Override
  public int getHeight() {
    return this.height;
  }

  @Override
  public void changeColor(Color color) {
    this.color = color;
  }

  @Override
  public void moveShape(Coordinate destination) {
    this.coord = destination;
  }

  @Override
  public void setHeight(int height) {
    this.height = height;
  }

  @Override
  public void setWidth(int width) {
    this.width = width;
  }

}
