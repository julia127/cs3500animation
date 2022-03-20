package model;


import java.awt.*;

public interface AnimatorModel<IShape> extends AnimatorModelState<IShape> {

  /** Begin the animation at time 0.
   *
   */
  void start(IListOfShapes<IShape> shapes);

  // For a motion (transformation), there should be a starting value and an ending value.

  // transformation methods
  /** transformation method.
   * Change the position of a shape in the animation.
   *
   * @param coord the new position of the shape.
   */
  void move(Coordinate coord);

  /** transformation method.
   * Change the size of a shape in the animation.
   *
   * @param width the new width of the shape.
   * @param height the new height of the shape.
   */
  void changeSize(int width, int height);

  /** transformation method.
   * Change the color of a shape in the animation.
   *
   * @param color the color the shape will be changed to.
   */
  void changeColor(Color color);

  // add descriptions to these

  void setBoard(int width, int height);

  void addShape(IShape shape);

  void removeShape(String shapeName);

  String getState();

  /** End the animation.
   *
   */
  void end();

  /** Check if the game is over.
   *
   */
  void isOver();

}
