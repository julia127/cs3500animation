package view;

import javax.swing.JFrame;
import model.AnimatorModel;

/**
 * Represents the visual state of an animator that has shapes as well as commands with a GUI.
 */
public class AnimatorGuiView extends JFrame implements IAnimatorView{
  private AnimatorModel model;
  private int width;
  private int height;

  /**
   * Constructs the animation's shape and command onto the GUI view.
   * @param model Represents the model to be displayed.
   * @param width Represents the width of the GUI frame.
   * @param height Represents the height of the GUI frame.
   */
  public AnimatorGuiView(AnimatorModel model) {
    this.model = model;
    this.width = model.getWidth();
    this.height = model.getHeight();
  }

  @Override
  public void displayAnimation(int tickRate) {

  }
}
