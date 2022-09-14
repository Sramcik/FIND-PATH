# Project-Find-Path

Program takes rectangular 2d maze as grid of elements.
'.' if element is free, '#' if element is blocked.
Maze contains also 'S' for start position, and 'X' for target position.
Program can read input from file or from standard input.
For file input class FindPathInputFile(filePath) witch takes file path as argument
for standard input class FindPathInputStdIn().
When using standard input, maze must be followed by empty line.

Output of program is series of instructions to get from position 'S' to position 'X'.

Class contains solve(boolean) method, thatsolve the maze, and if boolean argument is true also print steps of found path or error if path is not possible,
method getPath() return ArrayList of characters describing stepps of path, empty if path is not possible,
method getPossible() return boolean value describing if path is possible.


