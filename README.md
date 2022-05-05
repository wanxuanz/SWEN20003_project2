## Project Overview
In this project, I create a graphical simulation of a world and its inhabitants. I use IntelliJ IDEA to develop the project.

* Task A </br>
Produce a class design demonstrating how I intend to
implement the classes for your simulation. This is in the form of a UML diagram showing
the classes you plan to implement, their attributes, their public methods, and the relationships (e.g.
inheritance and associations) between them. 

* Task B </br>
Complete the implementation of the simulation de-
scribed in the rest of this specification.

## Simulation Overview
* Shadow Life is a graphical simulation of a world inhabited by creatures called gatherers. Their
purpose in life is to gather fruit from the trees, and deposit them at stockpiles. Once they have
gathered all the fruit from their trees, they rest in front of fences. 
* Making their life diffcult is the thief who aims to steal fruit from the stockpiles and place it in
their hoards. The thief and gatherers follow rigid rules, and once they all reach their final goals (the
fence), the simulation halts. They are quite industrious workers|with enough time, they could
calculate anything that any computer can!
* The behaviour of the simulation is entirely determined by the world file loaded when the Shadow
Life program starts: each gatherer, thief, and other element begins at a specified location and
follows a set of rules to determine their behaviour. Once all gatherers and thieves have reached a
fence, the simulation halts, and the amount of fruit at each stockpile and hoard is tallied up. The
simulation proceeds in ticks, with the tick rate (time between ticks) determined by a command-
line parameter. If more than a maximum number of ticks (also determined by a command-line
parameter) pass before halting, the simulation times out. Otherwise, the number of elapsed ticks,
together with the amounts of fruit at each location, is printed to form the result of the world file.</br>

## Command-line arguments
Your simulation must take three command-line arguments: the tick rate (in milliseconds), the
maximum number of ticks, and the world le. Here are some example argument lists for the
program: </br>
* 500 100 res/worlds/harvest.csv
* 100 1000 res/worlds/sum.csv
</br>
If more or fewer than 3 arguments are provided, the simulation should print (to the terminal)
the line </br>
usage: ShadowLife <tick rate> <max ticks> <world file> </br>
  
## Simulation Elements
Actors
An actor is an object with an associated image that is located at a particular tile, and may perform
an action every tick.
• Trees: a tree is stationary and takes no action upon a tick. Its image is located at
res/images/tree.png. It begins with 3 fruit. The current number of fruit at each tree
should be drawn at the top-left of its image. (We have provided a font, res/VeraMono.ttf,
for you to use if you desire.)
• Golden Trees: a golden tree is stationary and takes no action upon a tick. Its image is
located at res/images/gold-tree.png. It has an innite reserve of fruit, and no number
should be drawn.
• Stockpiles: a stockpile is stationary and takes no action upon a tick. Its image is located
at res/images/cherries.png. It begins with 0 fruit. The current number of fruit at each
stockpile should be drawn at the top-left of its image.
• Hoards: a hoard is stationary and takes no action upon a tick. Its image is located at
res/images/hoard.png. It begins with 0 fruit. The current number of fruit at each hoard
should be drawn at the top-left of its image.
• Pads: a pad is stationary and takes no action upon a tick. Its image is located at
res/images/pad.png.
• Fences: a fence is stationary and takes no action upon a tick. Its image is located at
res/images/fence.png.
• Signs: a sign is stationary and takes no action upon a tick. It serves to redirect gatherers
and thieves. There are four types of signs, with images located at
{ res/images/left.png
{ res/images/right.png
{ res/images/up.png
{ res/images/down.png
• Mitosis Pools: a mitosis pool is stationary and takes no action upon a tick. Its image is
located at res/images/pool.png.
• Gatherers: a gatherer contains state, and is initialised according to Algorithm 1. Each tick,
it should follow the procedure of Algorithm 2. Update: the order of the move and other
actions has changed. Its image is located at res/images/gatherer.png.
• Thieves: a thief contains state, and is initialised according to Algorithm 3. Each tick, it
should follow the procedure of Algorithm 4. Update: the order of the move and other actions
has changed. Its image is located at res/images/thief.png.
