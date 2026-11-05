
/**
 * Players is the representation of the players who submit their game scores to the leaderboard.
 * Each player has information on their unique ID and the highest score they have currently recorded.
 * 
 * @author Samarah Anido
 * @version 
 * 
 */
public class Player
{
	private int ID;
	private int score;
	
	public Player(int ID, int score)
	{
		this.ID = ID;
		this.score = score;
	}
	
	public int getScore()
	{return score;}
	public void setScore(int score)
	{this.score = score;}
	
	public int getID()
	{return ID;}
	public void setID(int ID)
	{this.ID = ID;}
	
}