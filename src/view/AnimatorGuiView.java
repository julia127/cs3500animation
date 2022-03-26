package view;

import javax.swing.JFrame;
import model.AnimatorModel;

public class AnimatorGuiView extends JFrame implements IAnimatorView{
  private AnimatorModel model;
  private int width;
  private int height;

  public AnimatorGuiView(AnimatorModel model, int width, int height) {
    this.model = model;
    this.width = width;
    this.height = height;
  }
  @Override
  public void displayAnimation(int tickRate) {

  }
}
