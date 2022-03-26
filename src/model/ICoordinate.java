package model;

/**
 * Interface for Coordinate. Contains get methods for the coordinate's fields and a
 * toString method for the object.
 */
public interface ICoordinate {

  /** Gets the X position of the coordinate.
   *
   * @return the X position of the coordinate.
   */
  int getX();

  /** Gets the Y position of the coordinate.
   *
   * @return the Y position of the coordinate.
   */
  int getY();

  /** Formats the coordinate as a string.
   *
   * @return the position in (X,Y) format.
   */
  String toString();

}
