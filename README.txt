This Kata goal is to implement a simple tennis score computer.
The scoring system consist in one game, divided by points :
Each player starts a game with 0 point.
If the player wins the 1st ball, he will have 15 points. 2nd balls won : 30 points. 3rd ball won : 40points.
If a player have 40 points and wins the ball, he wins the game, however there are special rules.
If both players have 40 points the players are “deuce”.
If the game is in deuce, the winner of the ball will have advantage
If the player with advantage wins the ball he wins the game
If the player without advantage wins the ball they are back at “deuce”.


Project building
----------------
This is a maven project, so you need maven to build it.
To build the project, just run the following command from the project's directory : mvn clean install
Build output : 
* The compiled main classes under \target\classes
* The compiled test classes under \target\test-classes
* A jar file under \target
* A jar file under the local repository directory specified in the maven user settings
* maven-surefire-plugin is bound to the test phase in order to generate the tests report under target\surefire-reports
* jacoco-maven-plugin is bound to the test phase in order to generate a test coverage report under \target\site\jacoco


Examples
--------
For example the following input “ABABAA” should print :
“Player A : 15 / Player B : 0”
“Player A : 15 / Player B : 15”
“Player A : 30 / Player B : 15”
“Player A : 30 / Player B : 30”
“Player A : 40 / Player B : 30”
“Player A wins the game”