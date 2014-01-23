Note that the .pdf document also provides valuable information.

===== Introduction: =====

In this assignment, you'll design a rover capable of exploring an initially
unkown terrain. The terrain is modeled as a 50x50 grid of passable and
impassable cells. Your rovers will be deposited as a team in this terrain, and
will have 1000 turns to discover as much of it as they can.

You will write two rovers: the "Smart Rover", and the "Ant Rover". They are
distinguished by the amount and type of information with which their respective
sensors provide them.

The Smart Rover is able to know its current location, the location of other
rovers, the total explored board, etc., whereas the Ant Rover is able to
deposit and sense pheromones to guide its exploration.

See the file "assignment.pdf" for a more complete description of the project.

===== Documentation: =====

Open the doc/index.html file to see a JavaDoc of some relevant classes.

===== Your Task: =====

Edit the following files:

  - src/student/AntRover.java
      - Create your best Ant Rover
  - src/student/SmartRover.java
      - Create your best Smart Rover

Optionally create other files and edit:

  - compile.sh
      - Add commands to compile your other Java files.
  - src/student/Rovers.java
      - If you want to add another rover beyond the two templates provided,
        making a factory for it in this this class will allow you to use it in
        the simulator.

===== Running the Simulator =====

Use run.sh. This takes several parameters:

    -g, --gui: Launch a GUI simulator
    -c, --cli: Run the CLI simulator, which itself accepts paramters:
        -n <int>, --number-of-trials <int>: Specify the number of trials to run
        -r <rover>,  --rover <rover>: Specify the rover to use, where <rover>
            the name of a rover available in src/student/Rovers.java.
        -b <board>, --board <board>: Specify the board to use, where <board> is
            the filename of a board from the boards/ directory.

===== Challenges =====

A rover that moves randomly may have difficulty getting to unexplored areas.
It may be useful to try to identify a nearby unexplored cell and find a path to
it. This can be complicated by an unknown terrain. Dynamic A-Star is a variant
of the familiar A-Star algorithm that can be used to navigate an unkown
graph. It essentially computes A-Star on an "optimistic" graph in which edges
not known to exist are assumed to.

Sometimes it can be hard to get the rovers to "spread out" and tackle different
regions of the terrain. Some students have had success explicitly assigning
different regions of the terrain to different rovers, although this can be a
risky approach on a board whose topology is not amenable to the specific
partitioning that you may invent.

Here are some different challenges that you may encounter, and a list of boards
that might test it:

  - Does your rover work at all? :-)
      - Terrain1

  - Can your rover identify unreachable regions and move on?
      - Terrain2
      - Terrain7
      - hole

  - Can your rover contend with a terrain whose topology demands somewhat
    purposeful movement?
      - Terrain3
      - Terrain4
      - Terrain5
      - Terrain6
      - Terrain7

  - Can your rover contend with a terrain whose topology defies a naive
    division of labor?
      - Terrain8
      - longroute
      - hostile_topology
      - hostile_topology_2
      - hostile_topology_3
      - maze

  - Can your rover team recover after some of the rovers "crash land" and are
    incapacitated?
      - stuck

Feel free to make additional boards! The format is generally as follows.
Comments are not allowed in the board file, but are given here after two
slashes (//) to illucidate.

20 // Side length of the square board (hence, here a 20x20 board will be given)
11111111111111111111 // A grid of n lines, each n characters in length (where n
12222222222222222211 // is the dimension given on the first line), in which
11111211111111111111 // 1 denotes an empty square, and 2 denotes an impassable
11111211111112111111 // square
11111211111112111111
11111211111112111111
12222222222222222211
11111211111111111111
11111222222222222211
11111111211111111211
11211111211111111211
11211111211111111111
11211111222222211111
11211111211111111111
11211111211111111111
11211111211111111111
11222222222111111111
11111111211111111111
11111111211111111111
11111111111111111111
2 // The number of rovers to place on the board to start
1,1 // starting coordinates for each of the rovers. They must be distinct!
10,10
