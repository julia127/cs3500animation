package model;

import java.awt.*;

public class Rect extends AShape {

  public Rect(String name, Color color, Coordinate coord, int width, int height) {
    super(color, coord, width, height);
    this.shapeType = ShapeType.RECTANGLE;
    this.shapeName = name;
  }

}
