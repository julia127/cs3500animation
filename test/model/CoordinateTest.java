package model;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

/**
 * Testing class for Coordinate.
 */
public class CoordinateTest {
  Coordinate coord1 = new Coordinate(15, 10);
  Coordinate coord2 = new Coordinate(15, 10);

  @Test(expected = IllegalArgumentException.class)
  public void invalidCoordinates() {
    Coordinate coord3 = new Coordinate(-5, 6);
    Coordinate coord4 = new Coordinate(6, -2);
    Coordinate coord5 = new Coordinate(-2, -5);
  }

  @Test
  public void getX() {
    assertEquals(15, coord1.getX());
    assertEquals(coord1.getX(), coord2.getX());
  }

  @Test
  public void getY() {
    assertEquals(10, coord2.getY());
    assertEquals(10, coord1.getY());
    assertEquals(coord1.getY(), coord2.getY());
  }

  @Test
  public void testEquals() {
    assertEquals(coord1, coord2);
  }

  @Test
  public void testToString() {
    assertEquals("(15, 10)", coord1.toString());
    assertEquals("(15, 10)", coord2.toString());
  }
}