package model;

import java.util.ArrayList;
import java.util.List;

public class ListOfShapes implements IListOfShapes<IShape> {

  protected List<IShape> listOfShapes;

  public ListOfShapes() {
    this.listOfShapes = new ArrayList<>();
  }

  @Override
  public void add(IShape... shapes) {
    for (IShape s: shapes) {
      listOfShapes.add(s);
    }
  }

  @Override
  public void remove(IShape... shapes) {
    for (IShape s: shapes) {
      listOfShapes.remove(s);
    }
  }

  @Override
  public void removeAll() {
    this.listOfShapes.clear();
  }

  @Override
  public int size() {
    return this.listOfShapes.size();
  }

  @Override
  public boolean isEmpty() {
    return this.listOfShapes.isEmpty();
  }
}
