package model;

public class Coordinate {

  int x;
  int y;

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
