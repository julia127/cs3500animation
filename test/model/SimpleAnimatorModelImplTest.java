package model;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.assertEquals;

import java.awt.Color;
import java.util.ArrayList;

/**
 * Testing class for SimpleAnimatorModelImpl.
 */
public class SimpleAnimatorModelImplTest {

  AnimatorModel<IShape> model;
  IShape rect;
  IShape circ;
  IShape rect2;
  IShape circ2;
  ArrayList<IShape> shapes;
  ArrayList<IShape> mtShapes;
  ArrayList<ICommand> commands;
  ICommand moveRect1Forward;
  ICommand changeColor;

  @Before
  public void setUp() {

    // initialize a model
    model = new SimpleAnimatorModelImpl(100, 100, 10);

    // these shapes will be displayed in the model
    rect = new Rect("rect1", Color.blue, new Coordinate(10,10), 10,10);
    circ = new Circle("circ1", Color.red, new Coordinate(5,5), 10,10);
    rect2 = new Rect("rect2", Color.blue, new Coordinate(15,15), 10,10);
    circ2 = new Circle("circ2", Color.red, new Coordinate(20,20), 10,10);

    // initialize a new list of shapes
    shapes = new ArrayList<IShape>();
    shapes.add(rect);
    shapes.add(circ);

    mtShapes = new ArrayList<IShape>();

    // command takes in a shape (let it take in a shape name)
    // commands that can be operated on a shape
    moveRect1Forward = new Command("move1", rect, 1,3);
    moveRect1Forward.move(new Coordinate(15,10));

    changeColor = new Command("move2", circ, 3,7);
    changeColor.changeColor(Color.blue);

    // list of commands
    commands = new ArrayList<ICommand>();
    commands.add(moveRect1Forward);
    commands.add(changeColor);
  }

  @Test(expected = IllegalArgumentException.class)
  public void constructWithInvalidWidthFails() {
    AnimatorModel<IShape> a = new SimpleAnimatorModelImpl(0,100,100);
  }

  @Test(expected = IllegalArgumentException.class)
  public void constructWithInvalidHeightFails() {
    AnimatorModel<IShape> a = new SimpleAnimatorModelImpl(100,0,100);
  }

  @Test(expected = IllegalArgumentException.class)
  public void constructWithInvalidTicksFails() {
    AnimatorModel<IShape> a = new SimpleAnimatorModelImpl(100,100,0);
  }

  @Test(expected = IllegalArgumentException.class)
  public void setShapesAndCommandsWithInvalidShapesFails() {
    model.setShapesAndCommands(null, commands);
  }

  @Test(expected = IllegalArgumentException.class)
  public void setShapesAndCommandsWithInvalidCommandsFails() {
    model.setShapesAndCommands(shapes, null);
  }

  @Test(expected = IllegalArgumentException.class)
  public void cantAddNullShape() {
    model.setShapesAndCommands(shapes, commands);
    model.addShape(null);
  }

  @Test(expected = IllegalArgumentException.class)
  public void cantAddDuplicateShape() {
    model.setShapesAndCommands(shapes, commands);
    model.addShape(rect);
  }

  @Test(expected = IllegalArgumentException.class)
  public void cantRemoveNullShape() {
    model.setShapesAndCommands(shapes, commands);
    model.removeShape(null);
  }

  @Test(expected = IllegalArgumentException.class)
  public void cantAddNullCommand() {
    model.setShapesAndCommands(shapes, commands);
    model.addCommand(null);
  }

  @Test(expected = IllegalArgumentException.class)
  public void cantRemoveNullCommand() {
    model.setShapesAndCommands(shapes, commands);
    model.removeCommand(null);
  }

  @Test(expected = IllegalArgumentException.class)
  public void cantAddDuplicateCommand() {
    model.setShapesAndCommands(shapes, commands);
    model.addCommand(moveRect1Forward);
  }

  @Test(expected = IllegalArgumentException.class)
  public void setShapesAndCommandsWithCommandOnNonExistantShapeDoesNotWork() {
    ICommand wrong = new Command("wrong",rect2,1,2);
    commands.add(wrong);
    model.setShapesAndCommands(shapes, commands);
  }

  @Test
  public void testGetShapesBeforeGamesetShapesAndCommandss() {
    assertEquals(new ArrayList<IShape>(), model.getShapes());
  }

  @Test
  public void testGetShapesAfterGamesetShapesAndCommandss() {
    model.setShapesAndCommands(shapes, commands);
    assertEquals(shapes, model.getShapes());
  }

  @Test
  public void testGetCommandsBeforeGamesetShapesAndCommandss() {
    assertEquals(new ArrayList<ICommand>(), model.getCommands());
  }

  @Test
  public void testGetCommandsAfterGamesetShapesAndCommandss() {
    model.setShapesAndCommands(shapes, commands);
    assertEquals(commands, model.getCommands());
  }

  @Test
  public void getNumShapesWorksNoShapes() {
    model.setShapesAndCommands(mtShapes, new ArrayList<ICommand>());
    assertEquals(0, model.getNumShapes());
  }

  @Test
  public void getNumShapesWorksWithShapes() {
    model.setShapesAndCommands(shapes, commands);
    assertEquals(2, model.getNumShapes());

    shapes.add(rect2);
    assertEquals(3, model.getNumShapes());
  }

  @Test
  public void getNumCommandsWorksNoCommands() {
    model.setShapesAndCommands(shapes, new ArrayList<ICommand>());
    assertEquals(0, model.getNumCommands());
  }

  @Test
  public void getNumCommandsWorksWithCommands() {
    model.setShapesAndCommands(shapes, commands);
    assertEquals(2, model.getNumCommands());
  }

  @Test
  public void isOverWorks() {
    // isOver is not relevant until we have the iterpolation formula and can iterate
    // through the ticks.

    // it is not over before it setShapesAndCommandss
    assertEquals(false, model.isOver());

    model.setShapesAndCommands(shapes, commands);

    // it is over after it setShapesAndCommandss
    assertEquals(true, model.isOver());
  }

  @Test
  public void testGetStateAfterCommands() {
    // this will be more relevant in assignment 5 when we deal with interpolation.
    model.setShapesAndCommands(shapes, commands);
    assertEquals(
            "rect1 1 10 10 0 0 2553 (15, 10) 10 10 java.awt.Color[r=0,g=0,b=255]\n" +
                    "circ1 3 5 5 255 0 07 (5, 5) 10 10 java.awt.Color[r=0,g=0,b=255]\n",
            model.getStateAfterCommands());
  }

  @Test
  public void getStateOfEmptyModel() {
    model.setShapesAndCommands(new ArrayList<IShape>(), new ArrayList<ICommand>());
    assertEquals("",
            model.getStateOfShapes());
  }

  @Test
  public void testGetStateOfShapes() {
    model.setShapesAndCommands(shapes, commands);
    assertEquals(
            "name: rect1 X: 10 Y: 10 R: 0 G: 0 B: 255\n" +
                    "name: circ1 X: 5 Y: 5 R: 255 G: 0 B: 0\n",
            model.getStateOfShapes());
  }

  @Test
  public void testShapeAddded() {
    model.setShapesAndCommands(shapes, commands);
    model.addShape(rect2);
    assertEquals(
            "name: rect1 X: 10 Y: 10 R: 0 G: 0 B: 255\n" +
                    "name: circ1 X: 5 Y: 5 R: 255 G: 0 B: 0\n" +
                    "name: rect2 X: 15 Y: 15 R: 0 G: 0 B: 255\n",
            model.getStateOfShapes());
  }

  @Test
  public void testShapeRemoved() {
    model.setShapesAndCommands(shapes, commands);
    model.removeShape(rect);
    assertEquals("name: circ1 X: 5 Y: 5 R: 255 G: 0 B: 0\n",
            model.getStateOfShapes());
  }

  @Test
  public void testAddCommand() {
    model.setShapesAndCommands(shapes, commands);
    model.addCommand(moveRect1Forward);
    assertEquals(3,
            model.getNumCommands());
  }

  @Test
  public void testRemoveCommand() {
    model.setShapesAndCommands(shapes, commands);
    model.removeCommand(moveRect1Forward);
    assertEquals(1,
            model.getNumCommands());
  }

  // getShapeAtTick will be more thoroughly tested in HW5
  /*
  @Test
  public void testGetShapeAtTick() {
    // this will be more relevant in assignment 5 when we deal with interpolation.
    model.setShapesAndCommands(shapes, commands);
    assertEquals(
            "rect1 1 10 10 0 0 2553 (15, 10) 10 10 java.awt.Color[r=0,g=0,b=255]\n" +
                    "circ1 3 5 5 255 0 07 (5, 5) 10 10 java.awt.Color[r=0,g=0,b=255]\n",
            model.getShapesAtTick(10));
  }*/
}