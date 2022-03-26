package model;

import java.util.List;

/**
 * This is the interface of the animation model. It is parameterized over the
 * shape type. It contains methods that modify the state of the animation model.
 */

public interface AnimatorModel<IShape> extends AnimatorModelState<IShape> {

  /** sets an animation with a given list of shapes and commands.
   *
   * @param shapes shapes that will appear in the animation.
   * @param commands the motions that the shapes will do in the animation.
   */
  void setShapesAndCommands(List<IShape> shapes, List<ICommand> commands);

  /** Adds a shape to the model.
   *
   * @param s shape to be added.
   */
  void addShape(IShape s);

  /** Removes a shape to the model.
   *
   * @param s shape to be removed.
   */
  void removeShape(IShape s);

  /** Adds a command to the model.
   *
   * @param c command to be added.
   */
  void addCommand(ICommand c);

  /** Removes a command to the model.
   *
   * @param c command to be removed.
   */
  void removeCommand(ICommand c);

}
