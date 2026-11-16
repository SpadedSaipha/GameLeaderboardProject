
public class Node
{
	/**
	 * This represents a node in the AVL tree. 
	 * Each node stores a Player object 
	 * and references its left and right node.
	 * It also stores the node's height (used to maintain tree balance).
	 * 
	 * @author Kaureon DuBois
	 */
	Player player;
	Node left;
	Node right;
	int height;
	
	public Node(Player player) {
		this.player = player;
		left = null;
		right = null;
		height = 1;
	}
}