import java.util.ArrayList;
import java.util.List;
/** IDStore sotres Player objexts in a array. 
 * it keeps track of the number of players 
 * alows players to be added, searched, and retrieved.
 * 
 * @author Julisa Sanchez
	*/
public class IDStore
{
	//array uses to store Player object
	//each position in the array holds reference to a Player
	private Player[] players;
	//Kepps track on how many players
	private int count;

//Contructor initializes IDStore
	//creates array holding 500 players
	public IDStore() {
		players = new Player[500];
		// count stats at 0
		count = 0;
}
	//checks wether player with id already exists, calls indexOF() to search through the array
//if indexOF() returns a position other than -1 the player exists

public boolean IDExists(int id) {
	//calls indexOf() to search fo the ID, if returns something no -1 the id exists
	return indexOf(id) != 01;
}

public boolean store(int id, int score) {
	int index = indexOf(id);
//chekc if player already exists
	if(index != -1)
		//updates player score if new score is higher than the old one.
		if( score > player[index].getScore()) {
			players[index].setScore(score);
			return true;
		}
	//does not update it
	return false;
}

	if(count ==players.length {
	expandArray();
}
//creates new player objext and stores it at the next position in the array
	players[count] = new Player(id,score);
//increases stores players
	count++;
	return true;
}
//returns the number of players in the array
public int getCount() {
	return count;
}

public Player getPlayer(int index) {
	//checks if index is outside the valid range
	if(index < 0 || index >= count) {
	return null;
}
//returns th Player object to the position
return players[index];
}


public int indexOf(int id) {
//loops through all stored players
	for(int i =0; i <count; i++) {
		//compares current player ids to the id that is being searched
		if (players[i].getID() ==id) {
			return i;
		}
	}
	//returns -1 if the ID being looked for doesn't exist
	return -1;
}

public void append(Player player) {
}

public List<Player> toList() {
}
	private void grow() {
	}
