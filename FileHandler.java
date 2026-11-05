import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.BufferedReader;

public class FileHandler
{
	
	public static List<Player> LoadPlayers(String path)
	{
		//needs to read line by line.. BufferedReader?
		try{
			List<Player> list = new ArrayList<>();
			BufferedReader br = new BufferedReader( new FileReader(path) );
			String line;
			while((line = br.readLine()) != null)
			{
				Scanner s = new Scanner(line);
				int ID = s.nextInt();
				int score = s.nextInt();
				list.add(new Player(ID, score));
				s.close();
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
	
	public static void SavePlayers(String path, List<Player> Players)
	{

		try(PrintWriter pw = new PrintWriter(path))
		{
			Iterator<Player> it = Players.iterator();
			while(it.hasNext())
			{
				Player p = it.next();
				pw.println(p.getID() + " " + p.getScore());
			}
		}
		catch(IOException e)
		{
			e.printStackTrace();
		}

	}
}