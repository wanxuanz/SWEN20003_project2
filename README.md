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
Shadow Life is a graphical simulation of a world inhabited by creatures called gatherers. Their
purpose in life is to gather fruit from the trees, and deposit them at stockpiles. Once they have
gathered all the fruit from their trees, they rest in front of fences. </br></br>
Making their life diffcult is the thief who aims to steal fruit from the stockpiles and place it in
their hoards. The thief and gatherers follow rigid rules, and once they all reach their final goals (the
fence), the simulation halts. They are quite industrious workers|with enough time, they could
calculate anything that any computer can!</br></br>
The behaviour of the simulation is entirely determined by the world file loaded when the Shadow
Life program starts: each gatherer, thief, and other element begins at a specified location and
follows a set of rules to determine their behaviour. Once all gatherers and thieves have reached a
fence, the simulation halts, and the amount of fruit at each stockpile and hoard is tallied up. The
simulation proceeds in ticks, with the tick rate (time between ticks) determined by a command-
line parameter. If more than a maximum number of ticks (also determined by a command-line
parameter) pass before halting, the simulation times out. Otherwise, the number of elapsed ticks,
together with the amounts of fruit at each location, is printed to form the result of the world file.</br>

### Command-line arguments
Your simulation must take three command-line arguments: the tick rate (in milliseconds), the
maximum number of ticks, and the world le. Here are some example argument lists for the
program: </br>
* 500 100 res/worlds/harvest.csv
* 100 1000 res/worlds/sum.csv
