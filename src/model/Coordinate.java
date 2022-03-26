package model;

import java.util.Objects;

/**
 * A coordinate represents a position on the screen.
 * Each shape has a coordinate to indicate where it is.
 * Can be negative or positive because a shape can be off-screen.
 */
public class Coordinate implements ICoordinate {

  private int x;
  private int y;

  /** A coordinate represents a position on the screen.
   *
   * @param x x - coordinate.
   * @param y y - coordinate.
   */
  public Coordinate(int x, int y) {
    this.x = x;
    this.y = y;
  }

  @Override
  public int getX() {
    return this.x;
  }

  @Override
  public int getY() {
    return this.y;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Coordinate that = (Coordinate) o;
    return x == that.x && y == that.y;
  }

  @Override
  public int hashCode() {
    return Objects.hash(x, y);
  }

  @Override
  public String toString() {
    return "(" + x + ", " + y + ")";
  }
}