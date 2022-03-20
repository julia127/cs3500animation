package model;

public interface IListOfShapes<t> {

  void add(IShape ... shape);

  void remove(IShape ... shape);

  void removeAll();

  int size();

  boolean isEmpty();

}
