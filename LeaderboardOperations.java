import java.util.List;

//Would be the operations the leaderboard would support and implemented by LeaderboardController

public interface LeaderboardOperations {
//adds a player or  updates their score
boolean uploadScore(int ID, int score);
// returns players with highest score
  List<Player> getTopN(int n);
//retunrs a player leaderboard rank
  int getPlayerRank (int ID);
//returns all store players
List<Player> getAllPlayers();

}
