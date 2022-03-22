package model;

import static org.junit.Assert.*;

import org.junit.Test;

public class CoordinateTest {
  Coordinate coord1 = new Coordinate(15, 5);
  Coordinate coord2 = new Coordinate(15, 10);

  @Test
  public void getX() {
    assertEquals(15, coord1.getX());
    assertEquals(coord1.getX(), coord2.getX());
  }

  @Test
  public void getY() {
    assertEquals(5, coord1.getY());
    //assertEquals(10, coord1.getY());
    //assertEquals(coord1.getY(), coord2.getY());
  }

  @Test
  public void testEquals() {
    assertEquals(coord1, coord2);
  }
}