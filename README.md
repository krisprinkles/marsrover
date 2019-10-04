# MARS ROVER
This project is my implementation of the Mars rover challenge. I used strict TDD to implement it, and I've prefixed the different steps with a RED, GREEN or REFACTOR to show you which part of the process I was busy with when I checked in the changes.

The solution was written in Java 1.8, in the IntelliJ IDEA IDE. I tracked all changes to the project and the change history should be available in this repository.

## Design Assumptions
- The cartesian grid has a starting block defined as 0,0. Therefore the actual boundary block for a (8,8) grid is (7,7).
- If a file is sent in containing more than three lines, the rest of the file is ignored.


### Considered and Excluded
- I haven't optimised the rover instructions. It is possible to replace 4 consecutive left or rights turns with no turn. I left it as is in case NASA decides at some future date to do a 360 degree visual scan of Mars once they realise that Mark Watney is alive.
- General status of Rover is not checked, i.e. whether it is on, whether it is receiving commands ...

## Testing
### Unit Tests
The TDD process meant that the project has 42 unit tests. (42 is also the meaning of life, the universe and everything, so I thought this was a nice total number. I used JUnit4 for the unit tests.
### Full Functionality Test
This test was done once the development was complete. It involved testing whether the application does what it's supposed to do.
### Fringe Tests
The Unit Tests contain many fringe conditions, but I also did some final tests using input files (including an image file). These have been checked in and you can find them in the `/marsrover/test/testinputs/` directory.
(image as test case credit: https://en.wikipedia.org/wiki/The_Martian_(Weir_novel))

## Running the application
Quick Run from command line (assuming it was built in IntelliJ:
`java -cp out/production/marsrover/ Main FULLY_QUALIFIED_FILE_NAME`

Building with something like gradle or the like is left as an exercise to the reader ;)

### Using IntelliJ IDEA
1. Open the IDE and create a new project from version control. Repository URL: `https://krisprinkles@bitbucket.org/krisprinkles/marsrover`. *PLEASE NOTE*: This repository was migrated to github recently: `https://github.com/krisprinkles/marsrover`.
2. Check project settings and make sure that the Project SDK is Java 1.8.
3. I have included all the additional libraries in the `/marsrover/lib/` directory
4. The Main method is located in `marsrover/src/za/co/kw/Main`

*PLEASE NOTE*: You will get an "Invalid VCS root mapping error". You can ignore this error; it exists because the original repository was Mercurial, and was converted to Git. It shouldn't affect the application. 

*PLEASE NOTE*: Before you run it via IntelliJ, please check the run configuration and make sure that there is one program argument, the filename of the file containing the rover's instructions.
