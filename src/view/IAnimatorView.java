package view;

/**
 * Represents the capabilities for all views that deal with animations.
 */
public interface IAnimatorView {
  /**
   * Displays an animation
   * @param tickRate tick speed of the animation.
   */
  void displayAnimation(int tickRate);
}
