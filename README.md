# cs3500animation
Julia Favis and Malachy Ayala

<h2> Overview </h2>
An animation represents objects moving and changing its state in a series of ticks.

A simple version of our model is created with the number of ticks (frames) that will occur in the
animation, and the length and width frame the animation will take place in.

<h2> Types </h2>
<h3>Coordinate</h3> 
A simple representation of a positive (X,Y) coordinate. Each shape has coordinate, and can move to 
a new coordinate.
Due to its simplicity we do not expect to modify or add to it at all 
therefore it is only represented as a single class. 

<b>Interface</b>: ICoordinate.We added the ICoordinate interface just in case there was a future version where we would have to change the type of way X and Y are represented.

<b>Class</b>: Coordinate. This class was created just to represent a basic X, Y coordinate on a graph.

<h3>Shape</h3>
A shape is visual element that appears in the animation. The current version of our animation model
supports rectangles and circles (each are constructed with a length and width).

<b>Interface</b>: IShape. This interface was meant to create different types of shapes just in case we wanted to add individual functionality for the types of shapes

<b>Classes</b>: AShape, Rect, Circle. AShape is essentially the skeleton for all shapes. It defines how they are constructed and implements the capabilities for all shapes

<b>Enum</b>: ShapeType (represents all the types of shape a shape can be)

<h3>Command</h3>
A command is an action that an shape will perform in the animation.
The current commands include to move, change size, and change dimensions of a shape
starting and ending at given times in the animation.

<b>Interface</b>: ICommand<br>
The purpose of ICommand is to contain methods a Command object will have.

<b>Classes</b>: Command<br>
The purpose Command is to represent an action that a shape will perform.

<h3>Animator Model Object</h3>

An animator model object represents the animation itself. It is constructed with
a width and height for the frame it will take place in, as well as the number of
ticks that will occur in the animation.

After an animator model object is created, call get setShapesAndPositions(shapes, commands)
with a list of shapes and a list of commands. These are the shapes and commands that an 
animator model object will favis.

<b>Interfaces</b>: AnimatorModel, AnimatorModelState<br>
The purpose of AnimatorModel is to contain methods that an animator object would need.<br>
The purpose of AnimatorModelState is to contain methods that describe the state of the model.
<b>Classes</b>: SimpleAnimatorModelImpl<br>
The purpose of AnimatorModelState is to represent a simple version of the animator model that
can describe the shapes in it.
