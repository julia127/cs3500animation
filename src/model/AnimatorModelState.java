package model;

import java.util.List;

/**
 * This interface represents different operations that an animation model must support to return
 * various aspects of its state. This interface does not provide any operations to mutate the state
 * of an animation model. It is parameterized to IShape.
 */
public interface AnimatorModelState<IShape> {

  /** Gets the width of the animation screen.
   *
   * @return the width of the animation screen.
   */
  int getWidth();

  /** Gets the height of the animation screen.
   *
   * @return the height of the animation screen.
   */
  int getHeight();

  /** Gets the shapes in the animation.
   *
   * @return the model's list of shapes.
   */
  List<IShape> getShapes();

  /** Gets the commands in the animation.
   *
   * @return the model's list of commands.
   */
  List<ICommand> getCommands();

  /** Geths the number of shapes in the animation.
   *
   * @return number of shapes in animation.
   */
  int getNumShapes();


  /** Gets the shapes in the animation at a certain tick (frame in the animation).
   *
   * @param t the tick where we will get the shapes at.
   * @return the current list of shapes.
   */
  List<IShape> getShapesAtTick(double t);

  /** Gets the number of commands in the animation.
   *
   * @return number of commands an animation has received.
   */
  int getNumCommands();

  /** Determines if the animation is over or not.
   *
   * @return if the animation has finished.
   */
  boolean isOver();

  /** Returns a description of the current state of the animation after commands.
   *
   * @return a description of the animation as a string.
   */
  String getStateAfterCommands();

  /** Get the current state of the shapes in the model.
   *
   * @return a description of the animation as a string.
   */
  String getStateOfShapes();

  /**
   * Gets the state of the model in a SVG readable format.
   * @return a String for the SVG.
   */
  String getSVGState();
}