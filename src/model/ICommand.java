package model;

import java.awt.Color;

/** The interface for a Command object.
 * Contains methods that get fields of the object as
 * well has methods that make the shapes perform moves.
 */
public interface ICommand {
  /**
   * Gets the Shape given to the current command.
   * @return the Shape in the current command.
   */
  IShape getMovingShape();

  /**
   * Gets the name of this command.
   * @return the name of the command as a String.
   */
  String getCommandName();

  /** Gets the shape after the command is excecuted.
   *
   * @return the final version of the shape.
   */
  IShape getFinalShape();

  /**
   * Gets the tick where this command starts.
   * @return An int that represents the starting tick for this command.
   */
  int getStartingTick();

  /**
   * Gets the width the command would set the given shape to.
   * @return the ending width value.
   */
  int getEndingWidth();

  /**
   * Gets the height the command would set the given shape to.
   * @return the ending height value.
   */
  int getEndingHeight();

  /**
   * Gets the coordinates which the command would move the given shape to.
   * @return the ending position coordinates.
   */
  Coordinate getEndingCoord();

  /**
   * Gets the color that the command would change the given shape to.
   * @return the ending color value.
   */
  Color getEndingColor();

  /**
   * Gets the final tick where the command ends.
   * @return the ending tick.
   */
  int getEndingTick();

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

  /**
   * Applies the created command to the provided shape.
   */
  void executeCommand();


}