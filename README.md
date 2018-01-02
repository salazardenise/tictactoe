# How To Play

Two users are needed to play: players x and o. The objective of the game is to mark 3 locations on the 3x3 board diagonally, horizontally, or vertically. Player x's turn is first. Enter the x and y 0-based integer coordinates corresponding to the location in which the user desires to mark. Players take turns marking new locations until either one of the players acheives the objective and wins or neither does and the players tie.

# Usage

This is how to compile and run the application.
```
$ javac TicTacToeApp.java
$ java TicTacToeApp
```
# Example Game
```
Welcome to Tic Tac Toe!
Player x turn.
Enter in 0-based x integer coordinates.
0
Enter in 0-based y integer coordinates.
0
x |   |  
---------
  |   |  
---------
  |   |  
---------
Player o turn.
Enter in 0-based x integer coordinates.
1
Enter in 0-based y integer coordinates.
1
x |   |  
---------
  | o |  
---------
  |   |  
---------
```
...
```
Player x turn.
Enter in 0-based x integer coordinates.
1
Enter in 0-based y integer coordinates.
0
x | x | o
---------
x | o |  
---------
x |   | o
---------

****************************
  Player x won!
****************************

Want to play again?
Enter 'Y' for yes or 'N' for no:
N
Exiting game.
```
