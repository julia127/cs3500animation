package view;

import java.io.IOException;
import model.AnimatorModel;

/**
 * Represents an AnimatorView that display all commands and shapes in a textual format.
 */
public class AnimatorTextView implements IAnimatorView{
  private AnimatorModel model;
  private Appendable ap;

  /**
   * Constructs a view with just a model since no appendable is needed yet without a controller.
   * @param model Represents the model which the view will display.
   */
  public AnimatorTextView(AnimatorModel model) {
    this.model = model;
  }

  /**
   * Constructs a view with an appendable output for when a controller comes into play.
   * @param model Represents the model which will be displayed.
   * @param ap Represents the output for the view.
   */
  public AnimatorTextView(AnimatorModel model, Appendable ap) {
    this.model = model;
    this.ap = ap;
  }

  @Override
  public void displayAnimation(int tickRate) {
    try {
      ap.append(model.getStateOfShapes());
    } catch (IOException e) {
      e.printStackTrace();
    }
  }
}
