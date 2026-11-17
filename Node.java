/**
	 * This class represents a node in the leaderboard's AVL trees.
	 * Each node stores a players's ID and score.
	 * It also references its parent and child nodes.
	 * The height is used to maintain balance.
	 * 
	 * @author Kaureon DuBois
	 */

public class Node
{
	
	private Node parent;
	private Node leftChild;
	private Node rightChild;
	private int height;
	private int score;
	private int ID;
	
	public Node(int score, int ID) {
		this.score = score;
		this.ID = ID;
		height = 1;
	}
	
	public int getScore() {
		return score;
	}
	public int getID() {
		return ID;
	}
	public Node getLeft() {
		return leftChild;
	}
	public Node getRight() {
		return rightChild;
	}
	public void setLeft(Node node) {
		leftChild = node;
	}
	public void setRight(Node node) {
		rightChild = node;
	}
	public int getHeight() {
		return height;
	}
	public Node getParent() {
		return parent;
	}
	public void setParent(Node node) {
		parent = node;
	}
	
	public void calHeight() {
		int leftHeight = 0;
		int rightHeight = 0;
		
		if (leftChild != null)
			leftHeight = leftChild.getHeight();
		
		if (rightChild != null)
			rightHeight = rightChild.getHeight();
		
		if (leftHeight > rightHeight)
			height = leftHeight + 1;
		
		else
			height = rightHeight + 1;
		
	}
}