/**
	 * This class represents the basic structure of a BST.
	 * It stores the root node
	 * and provides methods to search, insert, 
	 * and delete player records using their ID and score.
	 * 
	 * @author Kaureon DuBois
	 */
public abstract class BST
{
	
	protected Node root;
	
	public BST() {
		root = null;
	}
	
	public abstract Node search(int score, int ID);
	
	public abstract void insert(int score, int ID);
	
	public abstract void delete(int score, int ID);
}