package model;

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
  private static int numTicks;

  // the tick that is currently happening.
  private int currentTick;

  /**
   * constructor where user can set height, width, num ticks and list of shapes.
   *
   * @param width    width of animation screen.
   * @param height   height of animation screen.
   * @param numTicks how many ticks (frames) the animation will be.
   */
  public SimpleAnimatorModelImpl(int width, int height, int numTicks) {
    if (width <= 0 || height <= 0 || numTicks <= 0) {
      throw new IllegalArgumentException("Invalid dimensions/time.");
    }

    int w;
    int h;

    w = width;
    h = height;
    this.numTicks = numTicks;
    this.shapes = new ArrayList<IShape>();
    this.commands = new ArrayList<ICommand>();
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
  public List<IShape> getShapesAtTick(int t) {
    return null;
    /* This method is being left empty because we lack details needed for implementation,
     * specifically the interpolation formula which helps  get the values of a shape at a
     * certain tick.*/
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
