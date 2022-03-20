package model;

/**
 * A coordinate represents a position on the screen.
 * It can only be positive.
 *
 * Each shape has a coordinate to indicate where it is.
 */
public class Coordinate {

  int x;
  int y;

  /** A coordinate represents a position on the screen.
   * It can only be positive.
   *
   * @param x x - coordinate.
   * @param y y - coordinate.
   */
  public Coordinate(int x, int y) {
    if (x % 2 == 0 && y % 2 == 0) {
      this.x = x;
      this.y = y;
    }
  }

  public int getX() {
    return this.x;
  }

  public int getY() {
    return this.y;
  }

}
