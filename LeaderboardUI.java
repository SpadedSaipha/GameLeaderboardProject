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
import java.util.List;

public class LeaderboardUI extends JFrame
{
	// Stores controller and GUI components used throughout the interface
	private LeaderboardController controller;
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
		// Initializes the controller to connect the GUI to the leaderboard data
		controller = new LeaderboardController();
		
		setTitle("Game Leaderboard");
		setSize(900, 750);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		setLayout(new BorderLayout());
		
		// Creates the panels used to organize the different parts of the window
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
		
		// Positions each panel within the main window
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
		
		// Loads the existing player records into the table when the window opens
		refreshLeaderboard();
		leaderboardTable.setRowHeight(30);
		leaderboardTable.setFont(new Font("Arial", Font.PLAIN, 14));
		leaderboardTable.setBackground(new Color(31, 41, 55));
		leaderboardTable.setForeground(Color.WHITE);
		leaderboardTable.setGridColor(new Color(75, 85, 110));
		leaderboardTable.setSelectionBackground(new Color(73, 59, 120));
		leaderboardTable.setSelectionBackground(Color.WHITE);
		
		// Adds scrolling functionality so the user can view all leaderboard entries
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
		
		// Displays a message that the Leaderboard is ready to use
		statusLabel = new JLabel("Ready");
		bottomPanel.add(statusLabel);
		
		// Sets the colors, fonts, and appearance of the table and its column headers
		leaderboardTable.getTableHeader().setBackground(new Color(73, 59, 120));
		leaderboardTable.getTableHeader().setForeground(Color.WHITE);
		leaderboardTable.getTableHeader().setFont(new Font("Arial", Font.BOLD, 14));
		leaderboardTable.getTableHeader().setPreferredSize(new Dimension(0, 35));
		
		// Applies matching colors and text settings to all buttons
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
		
		// Changes the appearance of input fields to match theme
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
		
		// Sets the text color of the labels inside the controls panel
		designLabels(controlsPanel);
		
		// Connects each button to its corresponding method
		submitButton.addActionListener(e -> submitScore());
		topNButton.addActionListener(e -> showTopN());
		searchButton.addActionListener(e -> searchPlayer());
		rankButton.addActionListener(e -> showPlayerRank());
		
		
		setVisible(true);
		
	}
	
	// Changes the text color of all labels inside the container
	private void designLabels(Container container) {
		for(Component component : container.getComponents()) {
			// Checks whether the component is a label before changing its color
			if (component instanceof JLabel) {
				component.setForeground(Color.WHITE);
			}
		}
	}
	
	// Refreshes the table with the current leaderboard records
	private void refreshLeaderboard() {
		javax.swing.table.DefaultTableModel model = (javax.swing.table.DefaultTableModel) leaderboardTable.getModel();
		// Clears the existing table rows before adding updated records
		model.setRowCount(0);
		// Gets all players ordered by their leaderboard scores
		List<Player> players = controller.getTopN(controller.getAllPlayers().size());
		int rank = 1;
		// Adds each player to the table along with their leaderboard rank
		for (Player player : players) {
			model.addRow(new Object[] { rank, player.getID(), player.getScore()});
			rank++;
		}
	}
	
	// Submits player's score to leaderboard
	private void submitScore() {
		try {
			// Reads the player ID and score entered by the user
			int playerID = Integer.parseInt(playerIDField.getText().trim());
			int score = Integer.parseInt(scoreField.getText().trim());
			// Prevents negative IDs and scores from being submitted
			if (playerID < 0 || score < 0) {
				statusLabel.setText("ID and score must be non-negative.");
				return;
			}
			
			// Sends the score to the controller to check and update the leaderboard
			boolean updated = controller.uploadScore(playerID, score);
			// Updates the table and clears the input if the score was accepted
			if (updated) {
				refreshLeaderboard();
				statusLabel.setText("Score submitted successfully!");
				playerIDField.setText("");
				scoreField.setText("");
			}
			else {
				statusLabel.setText("Score not updated. New score must be higher.");
			}
		// Handles invalid input when the user enters something other than a number	
		} catch (NumberFormatException e) {
			statusLabel.setText("Please enter vaild numbers.");
		}
	}
	
	// Displays top n players in the leaderboard
	private void showTopN() {
		try {
			// Gets the number of top players requested by user
			int n = Integer.parseInt(topNField.getText().trim());
			// Makes sure the requested number of players id greater than zero
			if (n <= 0) {
				statusLabel.setText("Enter a number greater than 0.");
				return;
			}
			// Retrieves the requested number of highest scoring players
			List<Player> players = controller.getTopN(n);
			javax.swing.table.DefaultTableModel model = (javax.swing.table.DefaultTableModel) leaderboardTable.getModel();
			// Clears the table so only requested top players are displayed
			model.setRowCount(0);
			int rank = 1;
			// Displays each selected player with their rank, ID, and score
			for (Player player : players) {
				model.addRow(new Object[] { rank, player.getID(), player.getScore()});
				rank++;
			}
			statusLabel.setText("Displaying top" + players.size() + " players.");
		} catch (NumberFormatException e) {
			statusLabel.setText("Please enter a vaild number.");
		}
	}
	
	// Searches for a player using their ID
	private void searchPlayer() {
		try {
			// Reads the player ID entered into the search field
			int playerID = Integer.parseInt(searchIDField.getText().trim());
			// Searches through all stored players
			List<Player> players = controller.getAllPlayers();
			for (Player player : players) {
				// Checks whether the current player's ID matches the search
				if (player.getID() == playerID) {
					// Displays the player's information if a match is found
					JOptionPane.showMessageDialog(this, "Player ID:" + player.getID() + "\nScore:" + player.getScore(), "Player Found", JOptionPane.INFORMATION_MESSAGE);
					statusLabel.setText("Player Found!");
					return;
				}
			}
			// Displays a message if no player has the entered ID
			statusLabel.setText("Player not Found.");
			JOptionPane.showMessageDialog(this, "No player found with that ID.");
		// Handles invalid input when the player ID is not a number
		} catch (NumberFormatException e) {
			statusLabel.setText("Please enter a valid Player ID");
		}
	}
	
	// Displays a player's current leaderboard rank
	private void showPlayerRank() {
		try {
			// Reads the player ID entered into the search field
			int playerID = Integer.parseInt(searchIDField.getText().trim());
			// Gets the player's rank from the controller
			int rank = controller.getPlayerRank(playerID);
			// Checks whether the controller found a valid player rank
			if (rank == -1) {
				statusLabel.setText("Player not Found.");
				JOptionPane.showMessageDialog(this, "No player found with that ID.");
			}
			// Displays the player's current rank if they exist
			else {
				statusLabel.setText("Player rank: " + rank);
				JOptionPane.showMessageDialog(this, "Player ID: " + playerID + "\nRank: " + rank, "Player Ranking", JOptionPane.INFORMATION_MESSAGE);
			}
		// Handles invalid input if the player ID is not a number
		} catch (NumberFormatException e) {
			statusLabel.setText("Please enter a valid Player ID");
		}
	}
}