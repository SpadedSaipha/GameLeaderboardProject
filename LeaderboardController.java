/**
 * This class manages the leaderboard by connecting the 
 * AVL trees, IDStore, and FileHandler.
 * It handles loading player data, submitting scores,
 * retrieving top players, and finding player ranks.
 * 
 * @author Samarah Anido and Kaureon DuBois
 */

import java.util.List;
import java.util.ArrayList;

public class LeaderboardController
{
	private AVLTree idTree;
	private AVLTree scoreTree;
	private IDStore store;
	
	
	//loads in data for tree to add
	private String fileName = "player_data_file.txt";
	private List<Player> playerList;
	
	public LeaderboardController()
	{
		idTree = new AVLTree(true);
		scoreTree = new AVLTree(false);
		store = new IDStore();
		
		playerList = FileHandler.loadPlayers(fileName);
		
		for (Player player : playerList) {
			idTree.insert(player.getScore(), player.getID());
			scoreTree.insert(player.getScore(), player.getID());
			store.store(player.getID(), player.getScore());
		}
	}
	
	public boolean uploadScore(int ID, int score)
	{
		int index = store.indexOf(ID);
		boolean exists = index != -1;
		int oldScore = 0;
		
		//gets the player's previous score if they already exist
		if (exists) {
			oldScore = store.getPlayer(index).getScore();
			//does not accept a score that is lower or equal
			if (score <= oldScore) {
				return false;
			}
		}
		
		//stores the new player or updates their existing score
		if(!store.store(ID, score)) {
			return false;
		}
		
		//removes the player's old record from both trees
		if (exists) {
			idTree.delete(oldScore, ID);
			scoreTree.delete(oldScore, ID);
		}
		
		//adds the updated player record to both trees
		idTree.insert(score, ID);
		scoreTree.insert(score, ID);
		
		// Saves the updated player records to the data file
		FileHandler.savePlayers(fileName, store.toList());
		
		return true;
	}
	
	public List<Player> getTopN(int n) {
		List<Player> topPlayers = new ArrayList<>();
		
		//gets the top N scores from the score tree
		List <Node> topNodes = scoreTree.getNscores(n);
		
		//finds each player and adds them to the list
		for (Node node : topNodes) {
			int index = store.indexOf(node.getID());
			if (index != -1) {
				topPlayers.add(store.getPlayer(index));
			}
		}
		//returns the list of top players
		return topPlayers;
	}

	
	public int getPlayerRank(int ID) {
		//finds player's position in the ID store
		int index = store.indexOf(ID);
		
		//returns -1 if the player does not exist
		if (index == -1) {
			return -1;
		}
		//gets the player's score
		Player player = store.getPlayer(index);
		
		//returns the player's rank in the score tree
		return scoreTree.getRank(player.getScore(), ID);
	}
	
	public List<Player> getAllPlayers() {
		//returns all players stored in the ID store
		return store.toList();
	}
}