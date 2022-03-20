package model;

import java.awt.*;
import java.util.ArrayList;

public class SimpleAnimatorModelImpl implements AnimatorModel<IShape> {

  // width of animation screen
  private int width;

  // height of animation screen
  private int height;

  private ArrayList<?> commands;

  // shapes in the animation
  private IListOfShapes<IShape> shapes;

  // each tick represents a frame in the animation, this is the max number of frames in
  // the animation, i.e. how long the animation will be.
  private int numTicks;


  /** Default constructor for a simple animation model implementation.
   * sets the width and height of the screen to 0.
   * sets the number of ticks of the animation to 0.
   */
  public SimpleAnimatorModelImpl() {
    if (width <= 0 || height <= 0) {
      throw new IllegalArgumentException("Invalid dimensions");
    }

    this.width = 0;
    this.height = 0;
    this.commands = commands; // ?? is this not for the controller
    this.shapes = new ListOfShapes();
    this.numTicks = 0;
  }

  /** constructor where user can set height, width, num ticks and list of shapes.
   *
   * @param width
   * @param height
   * @param numTicks
   */
  public SimpleAnimatorModelImpl(int width, int height, int numTicks) {
    if (width <= 0 || height <= 0) {
      throw new IllegalArgumentException("Invalid dimensions");
    }

    this.width = width;
    this.height = height;
    this.numTicks = numTicks;
  }


  @Override
  public void start(IListOfShapes<IShape> shapes) {

  }

  @Override
  public void move(Coordinate coord) {

  }

  @Override
  public void changeSize(int width, int height) {

  }

  @Override
  public void changeColor(Color color) {

  }

  @Override
  public void setBoard(int width, int height) {

  }

  @Override
  public void addShape(IShape iShape) {

  }

  @Override
  public void removeShape(String shapeName) {

  }

  @Override
  public String getState() {
    return null;
  }

  @Override
  public void end() {

  }

  // model state methods

  @Override
  public void isOver() {

  }

  @Override
  public int getNumShapes() {
    return 0;
  }

  @Override
  public int getCommands() {
    return 0;
  }
}
