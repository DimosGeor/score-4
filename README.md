# Score4 – Java Console Game

## Overview

Score4 is a Java-based two-player console game inspired by Connect Four. Players take turns to drop chips into a grid, and the first player to align four of their chips horizontally, vertically, or diagonally wins the game.

## Features

- Two-Player Mode: Enter player names and play against each other in turns.
- Custom Grid Size: Choose grid dimensions between 4x4 and 15x15.
- Chip Selection: First player chooses their chip (x or any other character), and the second gets the alternative.
- Victory Detection:
  - Horizontal
  - Vertical
  - Diagonal (both directions)
- Tie Detection: If the grid is full and no winner is found, the game ends in a tie.
- Random Start: Randomly selects which player goes first.

## How to Play

1. Compile the Game:
   javac Game.java Main.java

2. Run the Game:
   java Main

3. Game Flow:
   - Enter both player names.
   - First player selects their chip.
   - Select the grid size (rows and columns).
   - The board is displayed.
   - Players take turns choosing a column to drop their chip into.
   - The game continues until a player wins or the board is full.

## Board Display Format

Example:

|  -  -  -  - |
|  -  -  -  - |
|  -  -  -  - |
|  x  o  x  o |
   -  -  -  -
   1  2  3  4

- Each cell starts empty (-).
- Chips are added from the bottom up in the selected column.
- Columns are numbered from 1 to N for player reference.

## Code Structure

### Game.java

- Display(char[][] board, int rows, int cols): Prints the game board.
- Start_Playing(...): Main game loop; handles turns, input, move placement, and victory/tie checks.
- isWinner(String chip, char[][] board): Checks if the current move results in a win (horizontal, vertical, or diagonal).

### Main.java

- Handles player input (names, chips, board size).
- Initializes and fills the game board.
- Starts the game by calling Start_Playing(...) in Game.java.

## Input Validation

- Grid size must be between 4x4 and 15x15.
- Column choices must be within board limits.
- The game does not currently handle invalid inputs like characters instead of numbers (you could add try/catch for robustness).

## Future Improvements (Optional)

- Add input validation for non-integer values.
- Implement a GUI version using Swing or JavaFX.
- Add an AI mode to play against the computer.
- Save high scores or game history.
