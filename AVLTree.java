/**
	 * This class represents an AVL tree used to organize player records.
	 * It supports searching, inserting, and deleting players by their ID and score.
	 * It also maintains balance through rotations and 
	 * provides methods for player rankings and Top-N scores.
	 *  
	 *  @author Kaureon DuBois
	 */

import java.util.ArrayList;
import java.util.List;

public class AVLTree extends BST
{
	private boolean sortByID;
	
	public AVLTree(boolean sortByID) {
		super();
		this.sortByID = sortByID;
	}
	private int compareNodes(Node first, Node second) {
		if (sortByID)
			return Integer.compare(first.getID(), second.getID());
		
		int scoreComparison = Integer.compare(first.getScore(), second.getScore());
		
		if (scoreComparison == 0)
			return Integer.compare(first.getID(), second.getID());
		
		return scoreComparison;
	}
	
	@Override
	public Node search(int score, int ID) {
		Node current = root;
		Node target = new Node(score, ID);
		
		while (current != null) {
			int comparison = compareNodes(target, current);
			
			if (comparison == 0)
				return current;
			else if (comparison < 0)
				current = current.getLeft();
			else
				current = current.getRight();
		}
		
		return null;
	}
	
	@Override
	public void insert(int score, int ID) {
		Node newNode = new Node(score, ID);
		
		if (root == null) {
			root = newNode;
			return;
		}
		
		Node current = root;
		Node parent = null;
		
		while (current != null) {
			parent = current;
			
			int comparison = compareNodes(newNode, current);
			
			if (comparison == 0)
				return;
			else if (comparison < 0)
				current = current.getLeft();
			else 
				current = current.getRight();
		}
		
		newNode.setParent(parent);
		
		if (compareNodes(newNode, parent) < 0)
			parent.setLeft(newNode);
		else 
			parent.setRight(newNode);
		
		updateBalance(parent);
	}
	
	
	private void rotateLeft(Node node) {
		Node rightChild = node.getRight();
		Node parent = node.getParent();
		
		node.setRight(rightChild.getLeft());
		
		if (rightChild.getLeft() != null)
			rightChild.getLeft().setParent(node);
		
		rightChild.setLeft(node);
		node.setParent(rightChild);
		rightChild.setParent(parent);
		
		if (parent == null)
			root = rightChild;
		else if (parent.getLeft() == node)
			parent.setLeft(rightChild);
		else
			parent.setRight(rightChild);
		
		node.calcHeight();
		rightChild.calcHeight();
	}
	
	private void rotateRight(Node node) {
		Node leftChild = node.getLeft();
		Node parent = node.getParent();
		
		node.setLeft(leftChild.getRight());
		
		if (leftChild.getRight() != null)
			leftChild.getRight().setParent(node);
		
		leftChild.setRight(node);
		node.setParent(leftChild);
		leftChild.setParent(parent);
		
		if (parent == null)
			root = leftChild;
		else if (parent.getLeft() == node)
			parent.setLeft(leftChild);
		else
			parent.setRight(leftChild);
		
		node.calcHeight();
		leftChild.calcHeight();
	}
	
	private int getBalance(Node node) {
		if (node == null)
			return 0;
		
		int leftHeight = 0;
		int rightHeight = 0;
		
		if (node.getLeft() != null)
			leftHeight = node.getLeft().getHeight();
		if (node.getRight() != null)
			rightHeight = node.getRight().getHeight();
		
		return leftHeight - rightHeight;
	}
	
	private void balance(Node node ) {
		int balanceFactor = getBalance(node);
		
		if (balanceFactor > 1) {
			if (getBalance(node.getLeft()) < 0)
				rotateLeft(node.getLeft());
			
			rotateRight(node);
		}
		
		else if (balanceFactor < -1) {
			if (getBalance(node.getRight()) > 0)
				rotateRight(node.getRight());
			
			rotateLeft(node);
		}
	}
	
	private void updateBalance(Node node) {
		while (node != null) {
			node.calcHeight();
			balance(node);
			node = node.getParent();
		}
	}
	
	private Node findMinimum(Node node) {
		while (node.getLeft() != null)
			node = node.getLeft();
		return node;
	}
	
	private void transplant(Node oldNode, Node newNode) {
		Node parent = oldNode.getParent();
		
		if (parent == null)
			root = newNode;
		else if (parent.getLeft() == oldNode)
			parent.setLeft(newNode);
		else
			parent.setRight(newNode);
		
		if (newNode != null)
			newNode.setParent(parent);
	}
	
	@Override
	public void delete(int score, int ID) {
		Node node = search(score, ID);
		
		if (node == null)
			return;
		
		Node parent = node.getParent();
		
		if (node.getLeft() == null) {
			transplant(node, node.getRight());
		}
		else if (node.getRight() == null) {
			transplant(node, node.getLeft());
		}
		else {
			Node successor = findMinimum(node.getRight());
			
			if (successor.getParent() != node) {
				parent = successor.getParent();
				transplant(successor, successor.getRight());
				successor.setRight(node.getRight());
				successor.getRight().setParent(successor);
			}
			
			else {
				parent = successor;
			}
			
			transplant(node, successor);
			successor.setLeft(node.getLeft());
			successor.getLeft().setParent(successor);
		}
		updateBalance(parent);
	}
	
	public int getRank(int score, int ID) {
		Node target = search(score, ID);
		
		if (target == null)
			return -1;
		int rank = 1;
		
		List<Node> players = new ArrayList<>();
		
		getAllScores(root, players);
		
		for (Node player : players) {
			if (player == target)
				return rank;
			rank++;
		}
		
		return -1;
	}
	
	private void getAllScores(Node node, List<Node> players) {
		if (node == null)
			return;
		
		getAllScores(node.getRight(), players);
		players.add(node);
		getAllScores(node.getLeft(), players);
	}
	
	public List<Node> getNscores(int n) {
		List<Node> players = new ArrayList<>();
		
		if (n <= 0)
			return players;
		
		getTopScores(root, players, n);
		return players;
	}
	
	private void getTopScores(Node node, List<Node> players, int n) {
		if (node == null || players.size() >= n)
			return;
		
		getTopScores(node.getRight(), players, n);
		
		if (players.size() < n)
			players.add(node);
		
		getTopScores(node.getLeft(), players, n);
	}
}