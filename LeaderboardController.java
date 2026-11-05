import java.util.List;

public class LeaderboardController
{
	private AVLTree tree;
	private IDStore store;
	
	//loads in data for tree to add
	private String fileName;
	private List<Player> PlayerList= FileHandler.LoadPlayers(fileName);
	
	public LeaderboardController()
	{
		
	}
	
	public boolean uploadScore(int ID, int score)
	{
		
	}
	
	public List<Player> getTopN(int n){}
	
	public int getPlayerRank(int ID){}
	
	public List<Player> getAllPlayers(){}
}