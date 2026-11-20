import java.util.ArrayList;
import java.util.List;
/** IDStore stores Player objects in a array. 
 * it keeps track of the number of players 
 * allows players to be added, searched, and retrieved.
 * 
 * @author Julisa Sanchez
	*/
public class IDStore
{
	//array uses to store Player object
	//each position in the array holds reference to a Player
	private Player[] players;
	//Keeps track on how many players
	private int count;

//Constructor initializes IDStore
	//creates array holding 500 players
	public IDStore() {
		players = new Player[500];
		// count starts at 0
		count = 0;
}
	//checks whether player with id already exists, calls indexOF() to search through the array
//if indexOF() returns a position other than -1 the player exists

public boolean IDExists(int id) {
	//calls indexOf() to search for the ID, if returns something no -1 the id exists
	return indexOf(id) != -1;
}

public boolean store(int id, int score) {
	int index = indexOf(id);
//checks if player already exists
	if(index != -1) {
		//updates player score if new score is higher than the old one.
		if( score > players[index].getScore()) {
			players[index].setScore(score);
			return true;
		}
	//does not update it
	return false;
}
	// expands the array if it is full
	if(count == players.length) {
	grow();
}
//creates new player object and stores it at the next position in the array
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
//returns the Player object to the position
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

//converts stored Player objects into a list
public List<Player> toList() {
	List<Player> list = new ArrayList<>();
	
	//loops through all stored players and adds them to the list
	for (int i = 0; i < count; i++) {
		list.add(players[i]);
	}
	//return the list of players
	return list;
}
	
	//expands array when it runs out of available space
	private void grow() {
		//creates a new array with double original capacity
		Player[] newPlayers = new Player[players.length * 2];
		
		//copies all existing players into the new array
		for (int i = 0; i < count; i++) {
			newPlayers[i] = players[i];
		}
		//replaces old array with expanded array
		players = newPlayers;
	}
}
