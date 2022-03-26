package model;

import java.awt.Color;

/**
 * Represents the interface for a Shape.
 * Contains methods to get and change fields of a shape object.
 */
public interface IShape {

  /**
   * Gets the shape's name.
   * @return the name of the shape.
   */
  String getName();

  /**
   * Gets the color of this shape.
   * @return this Shape's color.
   */
  Color getColor();

  /**
   * Gets the Coordinates of this shape.
   * @return the X and Y position of this shape.
   */
  Coordinate getPosition();

  /**
   * Gets the type of this shape.
   * @return the name of this Shaoe.
   */
  ShapeType getShapeType();

  /**
   * Gets the width of this shape.
   * @return the width of the shape
   */
  int getWidth();

  /**
   * Gets the height of this shape.
   * @return the height of the shape
   */
  int getHeight();

  /**
   * Changes the color of this shape.
   * @param color Represents the new color for a shape.
   */
  void changeColor(Color color);

  /**
   * Changes the location of this shape.
   * @param destination Represents the destination for a shape.
   */
  void moveShape(Coordinate destination);

  /**
   * Changes the height of this shape.
   * @param height Represents the new height of the shape.
   */
  void setHeight(int height);

  /**
   * Changes the width of this shape.
   * @param width Represents the new width of the shape.
   */
  void setWidth(int width);
}
