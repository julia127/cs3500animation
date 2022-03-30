package model;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;

/**
 * This is the SimpleAnimatorModelImpl implementation of an animation model.
 * This creates an animation that has a list of shapes and a list of commands,
 * a shape performs a command (i.e. move, change color, change size).
 * In its current state, it can produce a textual description of the shapes in the animation
 * with the getStateOfShapes() method. More functionality will be implemented in the
 * future.
 */
public class SimpleAnimatorModelImpl implements AnimatorModel<IShape> {

  // commands that shapes will excecute.
  private List<ICommand> commands;

  // shapes in the animation
  private List<IShape> shapes;

  // each tick represents a frame in the animation, this is the max number of frames in
  // the animation, i.e. how long the animation will be.
  private static double numTicks;

  // the tick that is currently happening.
  private double currentTick;

  // the width of the screen.
  private int width;

  // the height of the screen.
  private int height;

  /**
   * constructor where user can set height, width, num ticks and list of shapes.
   *
   * @param width    width of animation screen.
   * @param height   height of animation screen.
   * @param numTicks how many ticks (frames) the animation will be.
   */
  public SimpleAnimatorModelImpl(int width, int height, double numTicks) {
    if (width <= 0 || height <= 0 || numTicks <= 0) {
      throw new IllegalArgumentException("Invalid dimensions/time.");
    }


    this.width = width;
    this.height = height;
    this.numTicks = numTicks;
    this.shapes = new ArrayList<IShape>();
    this.commands = new ArrayList<ICommand>();
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
  public List<IShape> getShapes() {
    return shapes;
  }

  @Override
  public List<ICommand> getCommands() {
    return commands;
  }

  @Override
  public void setShapesAndCommands(List<IShape> shapes, List<ICommand> commands) {
    if (shapes == null || commands == null) {
      throw new IllegalArgumentException("list of shapes or commands cannot be null");
    }
    this.shapes = shapes;
    this.commands = commands;
  }

  @Override
  public void addShape(IShape s) {

    if (s == null) {
      throw new IllegalArgumentException("cannot add null shape");
    }
    for (IShape shape: shapes) {
      if (s.getName() == shape.getName()) {
        throw new IllegalArgumentException("cannot add a shape with a same name " +
                " as one that has that is already in the model");
      }
    }

    this.shapes.add(s);
  }

  @Override
  public void removeShape(IShape s) {
    if (s == null) {
      throw new IllegalArgumentException("cannot remove null shape");
    }

    this.shapes.remove(s);
  }

  @Override
  public void addCommand(ICommand c) {
    if (c == null) {
      throw new IllegalArgumentException("cannot add null command");
    }

    for (ICommand command: commands) {
      if (c.getCommandName() == command.getCommandName()) {
        throw new IllegalArgumentException("cannot add a command with a same name " +
                " as one that has that is already in the model");
      }
    }

    this.commands.add(c);
  }

  @Override
  public void removeCommand(ICommand c) {
    if (c == null) {
      throw new IllegalArgumentException("cannot remove null command");
    }

    this.commands.remove(c);
  }

  // sees if a command can be operated on the model, will be used in getStateAtTick
  protected boolean validateCommand(ICommand command) {
    boolean isValid = false;

    if (!this.shapes.contains(command.getMovingShape())) {
      throw new IllegalArgumentException("cannot have a command on a shape that" +
              " does not exist");
    }
    else if (this.shapes.contains(command.getMovingShape())
            && command.getEndingTick() <= numTicks) {
      isValid = true;
    }
    return isValid;
  }

  // validate that no commands happen at the same time

  /**
   * Does your model verify that a motion is consistent with existing
   * motions (ensuring that motions do not have overlapping time intervals)?
   *
   * Do you have a test to verify that two motions applied to the same object with
   * overlapping intervals are prohibited?
   *
   * @return if the list has
   */


  @Override
  public String getStateOfShapes() {
    String state = "";

    for (IShape s : shapes) {
      state = state +
              "name: " + s.getName() + " " +
              "X: " + s.getPosition().getX() + " " +
              "Y: " + s.getPosition().getY() + " " +
              "R: " + s.getColor().getRed() + " " +
              "G: " + s.getColor().getGreen() + " " +
              "B: " + s.getColor().getBlue() + "\n";
    }
    return state;
  }

  @Override
  public String getSVGState() {
    return null;
  }

  @Override
  public String getStateAfterCommands() {
    String state = "";

    for (ICommand c : commands) {
      state = state + c.getMovingShape().getName() + " " + c.getStartingTick() + " " +
              c.getMovingShape().getPosition().getX() + " "
              + c.getMovingShape().getPosition().getY()
              + " " + c.getMovingShape().getColor().getRed() + " " +
              c.getMovingShape().getColor().getGreen() + " "
              + c.getMovingShape().getColor().getBlue()
              + c.getEndingTick() + " " + c.getEndingCoord() + " " + c.getEndingHeight()
              + " " + c.getEndingWidth() + " " + c.getEndingColor() + "\n";
    }
    return state;
  }

  @Override
  public List<IShape> getShapesAtTick(double t) {

    List<IShape> shapesAtTick = new ArrayList<IShape>();

    for(ICommand c: commands) {

      String shapeName = c.getFinalShape().getName();
      ShapeType shapeType = c.getFinalShape().getShapeType();
      int newX = (int) this.interpolation(t, c.getMovingShape().getPosition().getX(),
              c.getEndingCoord().getX());
      int newY = (int) this.interpolation(t, c.getMovingShape().getPosition().getY(),
              c.getEndingCoord().getY());
      int newR = (int) this.interpolation(t, c.getMovingShape().getColor().getRed(),
              c.getEndingColor().getRed());
      int newG = (int) this.interpolation(t, c.getMovingShape().getColor().getGreen(),
              c.getEndingColor().getGreen());
      int newB = (int) this.interpolation(t, c.getMovingShape().getColor().getBlue(),
              c.getEndingColor().getBlue());
      int newWidth = (int) this.interpolation(t, c.getMovingShape().getWidth(),
              c.getEndingWidth());
      int newHeight = (int) this.interpolation(t, c.getMovingShape().getHeight(),
              c.getEndingHeight());

      IShape atTick = new AShape(
              shapeName,
              shapeType,
              new Color(newR, newG, newB),
              new Coordinate(newY, newX),
              newHeight,
              newWidth);

      shapesAtTick.add(atTick);
    }
    return shapesAtTick;
  }


  /** interpolation formula to the value of a shape's field at a certain tick.
   *
   * @param t - the tick we are getting the value of.
   * @param initialVal - the value of the field in the beginning of the animation.
   * @param endingVal - the value of the field in the end of the animation.
   * @return the value of the field at tick t.
   */
  protected double interpolation(double t, int initialVal, int endingVal) {
    // 0s are placeholders
    double starting = 0; // the beginning of the animation [Ta]
    double ending = numTicks; // the amount of ticks in the animation [Tb]
    int a = initialVal; // the initial value of the shapes X [A]
    int b = endingVal; // the ending value of the shapes X [B]

    double valueAtTick = 0; // the value of the attribute at the given tick

    valueAtTick = a * ((ending - t)/(ending - starting))
            + b * ((t - starting)/(ending - starting));

    return valueAtTick;
  }

  @Override
  public int getNumShapes() {
    return this.shapes.size();
  }

  @Override
  public int getNumCommands() {
    return this.commands.size();
  }

  @Override
  public boolean isOver() {
    boolean isOver = false;

    if (this.currentTick == numTicks) {
      isOver = true;
    }
    return isOver;
  }
}
