package model;

import java.awt.Color;

/**
 * Represents a command that would modify a shape in the model.
 * Instead of mutating the shape the move is happening to, it produces a copy
 * with the fields changed to the new ones after the move.
 */
public class Command implements ICommand {
  private IShape movingShape;
  private String commandName;
  private IShape dupeMovingShape;
  private final int startingTick;
  private int endingWidth;
  private int endingHeight;
  private Coordinate endingCoord;
  private Color endingColor;
  private final int endingTick;

  /**
   * Constructor to create a command with its starting and ending tick.
   * @param movingShape the shape that the command will be modifying.
   * @param startingTick the tick where the command will begin.
   * @param endingTick the tick where the command will end.
   */
  public Command(String commandName, IShape movingShape, int startingTick, int endingTick) {
    if (movingShape == null) {
      throw new IllegalArgumentException("Invalid shape");
    }
    if (startingTick < 0 || endingTick < 0) {
      throw new IllegalArgumentException("Ticks must be greater than 0");
    }
    if (startingTick > endingTick) {
      throw new IllegalArgumentException("Ending tick must be greater than the starting tick");
    }
    this.dupeMovingShape = new AShape(movingShape.getName(), movingShape.getShapeType(),
            movingShape.getColor(), movingShape.getPosition(), movingShape.getWidth(),
            movingShape.getHeight());
    this.commandName = commandName;
    this.movingShape = movingShape;
    this.startingTick = startingTick;
    this.endingTick = endingTick;
    this.endingHeight = dupeMovingShape.getHeight();
    this.endingWidth = dupeMovingShape.getWidth();
    this.endingCoord = dupeMovingShape.getPosition();
    this.endingColor = dupeMovingShape.getColor();
  }

  @Override
  public IShape getMovingShape() {
    return movingShape;
  }

  @Override
  public String getCommandName() {
    return this.commandName;
  }

  @Override
  public IShape getFinalShape() {
    return this.dupeMovingShape;
  }

  @Override
  public int getStartingTick() {
    return startingTick;
  }

  @Override
  public int getEndingWidth() {
    return endingWidth;
  }

  @Override
  public int getEndingHeight() {
    return endingHeight;
  }

  public Coordinate getEndingCoord() {
    return endingCoord;
  }

  @Override
  public Color getEndingColor() {
    return endingColor;
  }

  @Override
  public int getEndingTick() {
    return endingTick;
  }

  @Override
  public void move(Coordinate coord) {
    if (coord == null) {
      throw new IllegalArgumentException("Invalid coordinates");
    }
    this.endingCoord = coord;
  }

  @Override
  public void changeSize(int width, int height) {
    if (width < 0 || height < 0) {
      throw new IllegalArgumentException("Invalid width or height");
    }
    this.endingHeight = height;
    this.endingWidth = width;
  }

  @Override
  public void changeColor(Color color) {
    if (color == null) {
      throw new IllegalArgumentException("Invalid color");
    }
    this.endingColor = color;
  }

  @Override
  public void executeCommand() {
    dupeMovingShape.moveShape(endingCoord);
    dupeMovingShape.setHeight(endingHeight);
    dupeMovingShape.setWidth(endingWidth);
    dupeMovingShape.changeColor(endingColor);
  }
}
