import java.util.ArrayList;
import java.util.List;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.BufferedReader;

public class FileHandler
{
	
	public static List<Player> loadPlayers(String path)
	{
		//needs to read line by line.. BufferedReader?
		try{
			List<Player> list = new ArrayList<>();
			BufferedReader br = new BufferedReader( new FileReader(path) );
			String line;
			while((line = br.readLine()) != null)
			{
				line = line.trim();
				if(line.isEmpty()) {continue;}
				String[] parts = line.split("\\s+"); //splits on empty space
				if(parts.length != 2) {continue;}
				try {
					list.add(new Player(Integer.parseInt(parts[0]), Integer.parseInt(parts[1]) ) );
				}
				catch(NumberFormatException e)
				{e.printStackTrace();}
			}
			br.close();
			return list;
		}
		catch(IOException e)
		{
			e.printStackTrace();
		}
		return null;
	}
	
	public static void savePlayers(String path, List<Player> players)
	{

		try(PrintWriter pw = new PrintWriter(path))
		{
			for(Player p: players)
			{
				pw.println(p.getID() + " " + p.getScore());
			}
		}
		catch(IOException e)
		{
			e.printStackTrace();
		}

	}
}