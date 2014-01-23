This file contains techincal information about the simulator and how it detects
student-programmed rovers.

In order to test student rovers, the simulator in the JAR file tries to
instantiate the student.Rovers class, which it expects to implement the
edu.rice.comp440.rovers.model.rovers.RoverProvider interface. No such
implementation is packaged with the JAR file, so instead Java will search the
classpath to find a suitable RoverProvider implementation. A default
implementation is provided in the src/student/Rovers.java file, which is
compiled by the default compile.sh script. The student may alter the
src/student/Rovers.java file and recompile to make the simulator aware of
more / other / fewer rovers.

The run.sh script merely launches the edu.comp440.rovers.control.Runner class
with a suitable classpath to find all of the classes compiled by the default
compile.sh script.

If you would like to use the simulator with Eclipse, it's pretty easy:

 1. Make a new project
 2. Copy the contents of this folder (and all subfolders) into the root of
    your project folder. If you do this right, the contents of the src/
    directory in this folder will end up in Eclipse's generated src/ folder.
 3. Set up the build path to include the simulator JAR.
     1. Right-click on the project, and select "Properties".
     2. On the left, select options for "Java Build Path".
     3. At the top, select the "Libraries" tab.
     4. Click the "Add JARs..." button.
     5. Navigate to the folder that contains the project you just created and
        expand it. It should contain "rovers.jar". Select "rovers.jar" and
        press "OK".
 4. Set up a Run Configuration to run the GUI.
     1. Right-click on the project, and hover over "Run As...".
     2. In the submenu, select "Run Configurations...".
     3. On the left, double click the option "Java Application".
     4. Edit the name to "GUI Rover Simulator", or a name of your choice.
     5. Ensure that the "Project:" field names the project you  created in
        step 1.
     6. Edit the "Main class:" to:
        edu.rice.comp440.rovers.control.Runner
     7. Click on the "Arguments" tab.
     8. Add "--gui" (excluding quotes) to the "Program arguments:".
     9. Click "Apply"
    10. Click "Close", or "Run" as you desire.
 5. Set up a Run Configuration to run a series of simulations in the CLI.
     1. Follow steps 1-3 in "Set Up a Run Configuration to run the GUI.".
     2. Enter a name for the Run Configuration. I'm going to make one to run
        the RandomRover using terrain1 10 times, so I'll call mine:
        "RandomRover terrain1 n=10".
     3. Follow steps 5-7 in "Set up a Run Configuration to run the GUI.".
     4. Add CLI arguments to specify the simulation. In my scenario, I'll add:
        --cli
        --rover "RandomRover"
        --board "boards/Terrain1"
        --number-of-trials 10
     5. Follow steps 9-10 in "Set up a Run Configuration to run the GUI.".
 6. Run one of the Run Configurations previously configured.
     1. Right-click on the project, and hover of "Run as...".
     2. Select "Java Application" from the submenu.
     3. Select "Runner - edu.rice.comp440.rovers.control".
     4. Select the desired previously-configured Run Configuration.

If you're on Windows, but would not like to use Eclipse, you need to find the
location of the javac.exe and java.exe executable files on your harddrive. They
should be in the same directory. I'll assume they're in %JAVA_HOME%\bin, where
%JAVA_HOME% is something resembling

    C:\Program Files\Oracle Corporation\Path\To\Java

You can then create .bat files based on the two provided Unix shell scripts
(compile.sh and run.sh)
