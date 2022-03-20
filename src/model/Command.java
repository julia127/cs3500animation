package model;

import java.awt.Color;

public class Command implements ICommand{
  private final String commandType;
  private final String shapeName;
  private final int startingTick;
  private final int startingPosX;
  private final int startingPosY;
  private final int startingHeight;
  private final int startingWidth;
  private final Color startingColor;
  private final int endingTick;
  private final int endingPosX;
  private final int endingPosY;
  private final int endingHeight;
  private final int endingWidth;
  private final Color endingColor;

  public Command(String commandType, String shapeName, int startingTick, int startingPosX,
      int startingPosY, int startingHeight, int startingWidth, Color startingColor, int endingTick,
      int endingPosX, int endingPosY, int endingHeight, int endingWidth, Color endingColor) {
    this.commandType = commandType;
    this.shapeName = shapeName;
    this.startingTick = startingTick;
    this.startingPosX = startingPosX;
    this.startingPosY = startingPosY;
    this.startingHeight = startingHeight;
    this.startingWidth = startingWidth;
    this.startingColor = startingColor;
    this.endingTick = endingTick;
    this.endingPosX = endingPosX;
    this.endingPosY = endingPosY;
    this.endingHeight = endingHeight;
    this.endingWidth = endingWidth;
    this.endingColor = endingColor;
  }
}
