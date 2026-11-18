/**
 * This represents the graphical user interface for the Game Leaderboard.
 * Allows users to submit scores, view leaderboard ranks,
 * search for players, and display the top scoring players.
 * 
 * @author Kaureon DuBois
 */
import javax.swing.*;
import javax.swing.border.TitledBorder;
import java.awt.*;

public class LeaderboardUI extends JFrame
{
	private JPanel headerPanel;
	private JPanel leaderboardPanel;
	private JPanel controlsPanel;
	private JPanel bottomPanel;
	private JTable leaderboardTable;
	private JTextField playerIDField;
	private JTextField scoreField;
	private JButton submitButton;
	private JTextField topNField;
	private JButton topNButton;
	private JTextField searchIDField;
	private JButton searchButton;
	private JButton rankButton;
	private JLabel statusLabel;
	
	
	public LeaderboardUI() {
		setTitle("Game Leaderboard");
		setSize(900, 750);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		setLayout(new BorderLayout());
		
		headerPanel = new JPanel();
		leaderboardPanel = new JPanel(new BorderLayout());
		controlsPanel = new JPanel();
		controlsPanel.setPreferredSize(new Dimension(210, 0));
		controlsPanel.setBorder(BorderFactory.createCompoundBorder(controlsPanel.getBorder(), BorderFactory.createEmptyBorder(5, 10, 5, 10)));
		bottomPanel = new JPanel(new FlowLayout());
		
		Color backgroundColor = new Color(17, 24, 39);
		getContentPane().setBackground(backgroundColor);
		headerPanel.setBackground(new Color(30, 58, 95));
		leaderboardPanel.setBackground(backgroundColor);
		controlsPanel.setBackground(backgroundColor);
		bottomPanel.setBackground(backgroundColor);
		
		add(headerPanel, BorderLayout.NORTH);
		add(leaderboardPanel, BorderLayout.CENTER);
		add(controlsPanel, BorderLayout.EAST);
		add(bottomPanel, BorderLayout.SOUTH);
		
		// Header setup
		headerPanel.setLayout(new FlowLayout(FlowLayout.CENTER));
		headerPanel.setBorder(BorderFactory.createEmptyBorder(15, 10, 15, 10));
		JLabel titleLabel = new JLabel("GAME LEADERBOARD");
		titleLabel.setFont(new Font("Arial", Font.BOLD, 26));
		headerPanel.add(titleLabel);
		
		
		// Table setup
		String[]columnNames = {"Rank", "Player ID", "Score"};
		leaderboardTable = new JTable(new javax.swing.table.DefaultTableModel(columnNames, 0));
		leaderboardTable.setRowHeight(30);
		leaderboardTable.setFont(new Font("Arial", Font.PLAIN, 14));
		leaderboardTable.setBackground(new Color(31, 41, 55));
		leaderboardTable.setForeground(Color.WHITE);
		leaderboardTable.setGridColor(new Color(75, 85, 110));
		leaderboardTable.setSelectionBackground(new Color(73, 59, 120));
		leaderboardTable.setSelectionBackground(Color.WHITE);
		JScrollPane scrollPane = new JScrollPane(leaderboardTable);
		scrollPane.getViewport().setBackground(new Color(17, 24, 39));
		leaderboardTable.setFillsViewportHeight(true);
		leaderboardPanel.add(scrollPane, BorderLayout.CENTER);
		
		// Input fields
		controlsPanel.setLayout(new GridLayout(0, 1, 5, 5));
		TitledBorder controlsBorder = BorderFactory.createTitledBorder("Submit Score");
		controlsBorder.setTitleColor(Color.WHITE);
		controlsPanel.setBorder(controlsBorder);
		JLabel playerIDLabel = new JLabel("Player ID:");
		playerIDField = new JTextField(10);
		JLabel scoreLabel = new JLabel("Score:");
		scoreField = new JTextField(10);
		submitButton = new JButton("Submit Score");
		controlsPanel.add(playerIDLabel);
		controlsPanel.add(playerIDField);
		controlsPanel.add(scoreLabel);
		controlsPanel.add(scoreField);
		controlsPanel.add(submitButton);
		
		// Show Top N Feature
		JLabel topNLabel = new JLabel("Number of Top Players");
		topNField = new JTextField(10);
		topNButton = new JButton("Show Top N");
		controlsPanel.add(topNLabel);
		controlsPanel.add(topNField);
		controlsPanel.add(topNButton);
		
		// Player Search
		JLabel searchLabel = new JLabel("Search Player ID:");
		searchIDField = new JTextField(10);
		searchButton = new JButton("Search Player");
		rankButton = new JButton("Show Player Rank");
		controlsPanel.add(searchLabel);
		controlsPanel.add(searchIDField);
		controlsPanel.add(searchButton);
		controlsPanel.add(rankButton);
		
		statusLabel = new JLabel("Ready");
		bottomPanel.add(statusLabel);
		
		// Design
		leaderboardTable.getTableHeader().setBackground(new Color(73, 59, 120));
		leaderboardTable.getTableHeader().setForeground(Color.WHITE);
		leaderboardTable.getTableHeader().setFont(new Font("Arial", Font.BOLD, 14));
		leaderboardTable.getTableHeader().setPreferredSize(new Dimension(0, 35));
		
		submitButton.setBackground(new Color(128, 100, 200));
		topNButton.setBackground(new Color(128, 100, 200));
		searchButton.setBackground(new Color(128, 100, 200));
		rankButton.setBackground(new Color(128, 100, 200));
		
		submitButton.setForeground(Color.WHITE);
		topNButton.setForeground(Color.WHITE);
		searchButton.setForeground(Color.WHITE);
		rankButton.setForeground(Color.WHITE);
		
		submitButton.setFocusPainted(false);
		topNButton.setFocusPainted(false);
		searchButton.setFocusPainted(false);
		rankButton.setFocusPainted(false);
		
		playerIDField.setBackground(new Color(31, 41, 55));
		scoreField.setBackground(new Color(31, 41, 55));
		topNField.setBackground(new Color(31, 41, 55));
		searchIDField.setBackground(new Color(31, 41, 55));
		
		playerIDField.setForeground(Color.WHITE);
		scoreField.setForeground(Color.WHITE);
		topNField.setForeground(Color.WHITE);
		searchIDField.setForeground(Color.WHITE);
		
		playerIDField.setCaretColor(Color.WHITE);
		scoreField.setCaretColor(Color.WHITE);
		topNField.setCaretColor(Color.WHITE);
		searchIDField.setCaretColor(Color.WHITE);
		
		titleLabel.setForeground(Color.WHITE);
		statusLabel.setForeground(new Color(190, 180, 230));
		statusLabel.setFont(new Font("Arial", Font.PLAIN, 13));
		
		designLabels(controlsPanel);
		
		setVisible(true);
	}
	
	private void designLabels(Container container) {
		for(Component component : container.getComponents()) {
			if (component instanceof JLabel) {
				component.setForeground(Color.WHITE);
			}
		}
	}
}