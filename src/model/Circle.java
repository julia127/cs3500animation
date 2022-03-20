package model;

import java.awt.*;

public class Circle extends AShape {

  public Circle(String name, Coordinate coords, Color color, int width, int height) {
    super(color, coords, width, height);
    this.shapeType = ShapeType.CIRCLE;
    this.shapeName = name;
  }

}

