# projectile_game

This is the readme file for CSC171 Project 1 assignment. 
There are 4 files inside the zipped folder named CSC171PROJECT1_HW. 

1) MainMethod.java contains the main method of the project. User should run this file to play the game.
2) CalculateProjectile.java is a class CalculateProjectile that assign projectile height and comments on the launch for each launch.
   This class also keep track of score within each round. 
3) WallProperties.java updates the wall's height and distance away from the user and report them. 
4) README.txt

In order to play this projectile game, user need to run the MainMethod.java. At beginning, a instruction/introduction is printed in 
console to give user an overview of this game. Then user is asked to enter whether they want to play or not, and "Start" needs to be
enter in order to start the game. "Round" number is printed to separate each round. At the beginning of each round, user will be 
given their score, either the base score or the cumulative score from last round. The WallProperties class will randomly generate 
an invisible wall with height and distance from the user position for each round of the game. For the first round, the user will be
informed about the height and distance from the wall, and after the user will be informed whether the wall is higher or shorter and further 
or closer. After informed the user about the wall, user is asked to enter the speed of the catapult and angle of launch.
Then CalculateProjectile class will generate the projectile height of particular launch 
and give a comment of its performance. It also assign the score of each launch. If user launch over the wall for the first time, then 
the game will automatically enter another round and asked user whether want to continue another round or not. Otherwise, it will allow user 
to quit, try another launch or enter another round. Basically, user can choose to quit the game after each throw. When each round is completed ,
the final score of this will be reported and stored. So that, after user chooses to completely quit the game, the scoring record will be displayed
to show the process of the game. 
(Assume that user can play maximum of 50 rounds.)

I want to create different classes for the main method is because I don't want to make flow of the main method to be too complicated when it is already 
lengthy. Use class can help me organize my code a little bit. 

The randomize height of the wall has a maximum of 100 meters and a minimum of 10 meters. The distance of the wall is randomized between 
300 to 20 meters away. User can set the maximum and minimum in the main method file. Also the scoring is based on the performance of the launch. 
Each launch will cost the user 1 points. If the user's launch made over by the wall within 3 meters, 
they will earn 5 points and over 3 meters for 3 points. If the user's launch 
did not make over by the wall, then if it's within 3 meters, 2 points will be deducted and over 3 meters 4 points will be deducted. 
Comments are also associated with the scoring. Most of comments are ended with an encourage note to make user try again. 

While loops are used when there is a option for user to choose to prevent syntax or running error. If user accidentally enter something other 
the options provided, the loop will ask the user to choose again. 

In order to format the prompt for user input to be easier to read, for game options after each launch and each round. I start a new 
line; otherwise, because it is too long, it is harder to read and even cut off at the end of console window. I print the final score for 
history of each round with a new line to better display them. 
