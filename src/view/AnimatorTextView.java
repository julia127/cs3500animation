package view;

import java.io.IOException;
import model.AnimatorModel;

public class AnimatorTextView implements IAnimatorView{
  private AnimatorModel model;
  private Appendable ap;

  public AnimatorTextView(AnimatorModel model) {
    this.model = model;
  }

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
