package model;


public interface AnimatorModel<IShape> extends AnimatorModelState<IShape> {

  void start();

  void move(Coordinate coord);


}
