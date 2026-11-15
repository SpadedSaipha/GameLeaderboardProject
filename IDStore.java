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

//Contructore initializes IDStore
	//creates array holding 500 players
	public IDStore() {
		players = new Player[500];
		// count stats at 0
		count = 0;
}
	//checks wether player with id already exists, calls indexOF() to search through the array
//if indexOF() returns a position other than -1 the player exists

public boolean IDExists(int id) {
}

public boolean store(int id, int score) {
}

public int getCount() {
}

public Player getPlayer(int index) {
}


public int indexOf(int id) {
}

public void append(Player player) {
}

public List<Player> toList() {
}
	private void grow() {
	}
