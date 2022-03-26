package model;

import static org.junit.Assert.assertEquals;

import java.awt.Color;
import org.junit.Test;

/**
 * Testing class for Command.
 */
public class CommandTest {
  IShape circ1 = new Circle("Circ1", Color.BLACK, new Coordinate(15, 10), 5, 5);
  IShape rect1 = new Rect("Rect1", Color.RED, new Coordinate(30, 10), 10, 15);
  IShape nullShape = null;
  ICommand move = new Command("move1", circ1, 0, 5);
  ICommand move2 = new Command("move2", rect1, 3, 7);

  @Test(expected = IllegalArgumentException.class)
  public void testInvalidNullShape() {
    ICommand nullCommand = new Command("null test", nullShape, 5, 10);
  }

  @Test(expected = IllegalArgumentException.class)
  public void testNegativeTicks() {
    ICommand negativeStart = new Command("neg start", circ1, -1, 10);
    ICommand negativeEnd = new Command("neg start 2", rect1, 10, -5);
  }

  @Test(expected = IllegalArgumentException.class)
  public void testInvalidTicks() {
    ICommand invalidTicks = new Command("invalid tick", rect1, 15, 10);
  }

  @Test(expected = IllegalArgumentException.class)
  public void testInvalidSize() {
    move.changeSize(-1, 5);
    move.changeSize(4, -2);
  }

  @Test(expected = IllegalArgumentException.class)
  public void testNullColor() {
    move.changeColor(null);
    move2.changeColor(null);
  }

  @Test(expected = IllegalArgumentException.class)
  public void testNullCoord() {
    move.move(null);
    move2.move(null);
  }

  @Test
  public void testMove() {
    ICommand moveFoward = new Command("move forward", circ1, 0, 5);
    moveFoward.move(new Coordinate(30, 20));
    moveFoward.changeColor(Color.CYAN);
    moveFoward.executeCommand();
    assertEquals(new Coordinate(30, 20), moveFoward.getFinalShape().getPosition());
  }

  @Test
  public void testChangeSize() {
    assertEquals(5, move.getEndingHeight());
    assertEquals(15, move2.getEndingHeight());
    move.changeSize(10, 10);
    move2.changeSize(15, 20);
    assertEquals(10, move.getEndingHeight());
    assertEquals(20, move2.getEndingHeight());
  }

  @Test
  public void testChangeColor() {
    assertEquals(Color.BLACK, move.getEndingColor());
    assertEquals(Color.RED, move2.getEndingColor());
    move.changeColor(Color.blue);
    move2.changeColor(Color.BLACK);
    assertEquals(Color.BLUE, move.getEndingColor());
    assertEquals(Color.black, move2.getEndingColor());
  }

  @Test
  public void testExecuteCommand() {
    assertEquals(Color.black, move.getMovingShape().getColor());
    move.changeColor(Color.CYAN);
    move.executeCommand();
    assertEquals(Color.CYAN, move.getFinalShape().getColor());
  }

  @Test
  public void testGetCommandName() {
    assertEquals("move1", move.getCommandName());
    assertEquals("move2", move2.getCommandName());
  }

  @Test
  public void testGetEndingShape() {
    assertEquals(Color.black, move.getMovingShape().getColor());
    move.changeColor(Color.CYAN);
    move.executeCommand();
    assertEquals(Color.CYAN, move.getFinalShape().getColor());
  }

  @Test
  public void testGetMovingShape() {
    assertEquals(circ1, move.getMovingShape());
    assertEquals(rect1, move2.getMovingShape());
  }

  @Test
  public void testGetStartingTick() {
    assertEquals(0, move.getStartingTick());
    assertEquals(3, move2.getStartingTick());
  }

  @Test
  public void testGetEndingWidth() {
    assertEquals(5, move.getEndingWidth());
    assertEquals(10, move2.getEndingWidth());
    move.changeSize(10, 10);
    move2.changeSize(15, 20);
    assertEquals(10, move.getEndingWidth());
    assertEquals(15, move2.getEndingWidth());
  }

  @Test
  public void testGetEndingHeight() {
    assertEquals(5, move.getEndingHeight());
    assertEquals(15, move2.getEndingHeight());
    move.changeSize(10, 10);
    move2.changeSize(15, 20);
    assertEquals(10, move.getEndingHeight());
    assertEquals(20, move2.getEndingHeight());
  }

  @Test
  public void testGetEndingCoord() {
    assertEquals(new Coordinate(15, 10), move.getEndingCoord());
    move.move(new Coordinate(30,6));
    assertEquals(new Coordinate(30,6), move.getEndingCoord());
  }

  @Test
  public void testGetEndingColor() {
    assertEquals(Color.BLACK, move.getEndingColor());
    assertEquals(Color.RED, move2.getEndingColor());
    move.changeColor(Color.blue);
    move2.changeColor(Color.BLACK);
    assertEquals(Color.BLUE, move.getEndingColor());
    assertEquals(Color.black, move2.getEndingColor());
  }

  @Test
  public void testGetEndingTick() {
    assertEquals(5, move.getEndingTick());
    assertEquals(7, move2.getEndingTick());
  }
}