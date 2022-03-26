package model;


import java.awt.Color;

/**
 * Represents an abstract shape which implements the shape interface.
 * Each concrete shape object will extend this class and have access to its methods.
 */
public class AShape implements IShape {
  protected String shapeName;
  protected ShapeType shapeType;
  protected Color color;
  protected Coordinate coord;
  protected int height;
  protected int width;

  /**
   * Constructor for an abstract shape.
   *
   * @param name   Represents the shape's name.
   * @param color  Represents the color of this shape.
   * @param coord  Represents the coordinates of this shape.
   * @param width  Represents the width of this shape.
   * @param height Represents the height of this shape.
   */
  public AShape(String name, Color color, Coordinate coord, int width, int height) {
    if (width <= 0 || height <= 0) {
      throw new IllegalArgumentException("Invalid dimensions");
    } else if (color == null || coord == null) {
      throw new IllegalArgumentException("Invalid coordinates or color");
    }
    this.shapeName = name;
    this.color = color;
    this.coord = coord;
    this.height = height;
    this.width = width;
  }

  /**
   * To construct a shape with the type predetermined.
   *
   * @param name      Represents the name for this shape.
   * @param shapeType Represents the type of shape for this Shape.
   * @param color     Represents the color of this shape.
   * @param coord     Represents the coordinates of this shape.
   * @param width     Represents the width of this shape.
   * @param height    Represents the height of this shape.
   */
  public AShape(String name, ShapeType shapeType,
                Color color, Coordinate coord, int width, int height) {
    if (width <= 0 || height <= 0) {
      throw new IllegalArgumentException("Invalid dimensions");
    } else if (color == null || coord == null) {
      throw new IllegalArgumentException("Invalid coordinates or color");
    }
    this.shapeName = name;
    this.shapeType = shapeType;
    this.color = color;
    this.coord = coord;
    this.height = height;
    this.width = width;
  }

  @Override
  public String getName() {
    return this.shapeName;
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
  public ShapeType getShapeType() {
    return this.shapeType;
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
    if (color == null) {
      throw new IllegalArgumentException("Invalid color");
    }
    this.color = color;
  }

  @Override
  public void moveShape(Coordinate destination) {
    if (destination == null) {
      throw new IllegalArgumentException("Invalid destination");
    }
    this.coord = destination;
  }

  @Override
  public void setHeight(int height) {
    if (height < 0) {
      throw new IllegalArgumentException("Invalid height");
    }
    this.height = height;
  }

  @Override
  public void setWidth(int width) {
    if (width < 0) {
      throw new IllegalArgumentException("Invalid width");
    }
    this.width = width;
  }
}
