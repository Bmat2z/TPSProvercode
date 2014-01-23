#!/bin/bash

# Add lines to compile your own classes

javac -classpath rovers.jar:bin/ -d bin/ src/student/RandomRover.java
javac -classpath rovers.jar:bin/ -d bin/ src/student/AntRover.java
javac -classpath rovers.jar:bin/ -d bin/ src/student/SmartRover.java
javac -classpath rovers.jar:bin/ -d bin/ src/student/Rovers.java
javac -classpath rovers.jar:bin/ -d bin/ ReferencedLibraries/rovers.jar/instructor/AStarTest.java