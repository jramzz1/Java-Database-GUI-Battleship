import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

import com.mysql.jdbc.PreparedStatement;

public class BattleDataBase {
	
	public Object[][] getTable0(String userName, String pass, String wins, String loses, String average) throws InstantiationException, IllegalAccessException, ClassNotFoundException, SQLException {
		
		Class.forName("com.mysql.jdbc.Driver").newInstance();
		Connection connection = DriverManager.getConnection("jdbc:mysql://35.226.99.168:3306/battleship", "root", "1234qwer");
		Statement statement = connection.createStatement();
		
		String update = "select * from BSScores ORDER BY wins DESC";
		ResultSet rs = statement.executeQuery(update);
		
		Object[][] data = new Object[100][8];
		int count = 0;
		
		while(rs.next()) {
			data[count][0] = rs.getString(1);
			data[count][1] = rs.getString(3);
			data[count][2] = rs.getString(4);
			//data[count][3] = rs.getString(5);
			++count;
		}
		connection.close();
		return data;
	}
//
//	public static void main(String[] args) {
//		
//	}
	
//		READY TO MANIPULATE
//	public void Display() throws InstantiationException, IllegalAccessException, ClassNotFoundException, SQLException
//	{	
//		Class.forName("com.mysql.jdbc.Driver").newInstance();
//		Connection connection = DriverManager.getConnection("jdbc:mysql://35.226.99.168:3306/battleship", "root", "1234qwer");
//		Statement statement = connection.createStatement();
//		ResultSet rs = statement.executeQuery("select * from BSScores");
//		System.out.println("ID" + "            "
//				+ "Password" + "       "
//				+ "Wins" + "     "
//				+ "Loses" + "     "
//				+ "W/L Ratio");
//		
//		String uID ="", uPW = "";
//		int W = 0, L = 0;
//		float WL = 0;
//		while(rs.next())
//		{	
//			uID = rs.getString("userID");
//			uPW = rs.getString("userPW");
//			W = rs.getInt("wins");
//			L = rs.getInt("loses");
//			WL = rs.getFloat("KD");
//			
//			
//			System.out.printf("%8s %10s %10s %10s %10s", uID, uPW, W, L, WL);
//			System.out.println();
//		}
//		connection.close();
//	}
	
	public static void updateW(int a, int b, String user) throws InstantiationException, IllegalAccessException, ClassNotFoundException, SQLException
	{
		Class.forName("com.mysql.jdbc.Driver").newInstance();
		Connection connection = DriverManager.getConnection("jdbc:mysql://35.226.99.168:3306/battleship", "root", "1234qwer");
		Statement statement = connection.createStatement();
		ResultSet rs = statement.executeQuery("select * from BSScores");
		ResultSet bs = statement.executeQuery("select * from BSScores");
		
		String str = "UPDATE BSScores SET wins =";
		String str2 = "UPDATE BSScores SET loses =";
		boolean player1won = false;
		boolean player2won = false;
//		String str3 = "UPDATE BSScores SET KD =";
//		String str4 = "UPDATE BSScores SET KD =";
		
		while(rs.next())
		{
			// This updates if user1 wins
			if(a == (rs.getInt("LoggedIN")) && user.equals("usr1"))
			{
				int wins = rs.getInt("wins");
				wins += 1;
				str += " '" + wins + "' WHERE LoggedIN = '" + a + "'";
				
				player1won = true;
				
				while(bs.next())
				{
					if(player1won == true && bs.getInt("LoggedIn") == b)
					{
						int loses =  bs.getInt("loses");
						loses += 1;
						str2 += " '" + loses + "' WHERE LoggedIN = '" + b + "'";
						break;
					}
				}
				break;
				
//				int loses =  rs.getInt("loses");
//				loses += 1;
//				str2 += " '" + loses + "' WHERE LoggedIN = '" + b + "'";
				
//				float avg =  rs.getFloat("KD");
//				if(rs.getInt("loses") == 0)
//					avg = wins / 1;
//				else if(rs.getInt("loses") > 0)
//					avg = wins / loses;
//				str3 += " '" + avg + "' WHERE LoggedIN = '" + a + "'";
				
//				ResultSet s = statement.executeQuery("select * from BSScores where LoggedIn = '" + b + "'");
//				float avg2 =  s.getFloat("KD");
//				avg2 = wins / loses;
//				str4 += " '" + avg2 + "' WHERE LoggedIN = '" + b + "'";
			}
		

			
			// This updates if user2 wins
			if(b == (rs.getInt("LoggedIN")) && user.equals("user2"))
			{
				int wins = rs.getInt("wins");
				wins += 1;
				str += " '" + wins + "' WHERE LoggedIN = '" + b + "'";
				
				player2won = true;
				
				while(bs.next())
				{
					if(player2won == true && bs.getInt("LoggedIn") == a)
					{
						int loses =  bs.getInt("loses");
						loses += 1;
						str2 += " '" + loses + "' WHERE LoggedIN = '" + a + "'";
						break;
					}
				}
				break;
				
//				int loses =  rs.getInt("loses");
//				loses += 1;
//				str2 += " '" + loses + "' WHERE LoggedIN = '" + a + "'";
				
//				float avg =  rs.getFloat("KD");
				
//				if(rs.getInt("loses") == 0)
//					avg = wins / 1;
//				else if(rs.getInt("loses") > 0)
//					avg = wins / loses;
//
//				str3 += " '" + avg + "' WHERE LoggedIN = '" + b + "'";
				
//				ResultSet s = statement.executeQuery("select * from BSScores where LoggedIn = '" + a + "'");
//				float avg2 =  s.getFloat("KD");
//				avg2 = wins / loses;
//				str4 += " '" + avg2 + "' WHERE LoggedIN = '" + a + "'";
			}
		}
		
		// Update Wins and Loses
		statement.executeUpdate(str);
		statement.executeUpdate(str2);
		//statement.executeUpdate(str3);
		//statement.executeUpdate(str4);
		
		// Update logged in.
		str = "UPDATE BSScores SET LoggedIN = '0' WHERE LoggedIN = '" + a + "'";
		statement.executeUpdate(str);
		
		str = "UPDATE BSScores SET LoggedIN = '0' WHERE LoggedIN = '" + b + "'";
		statement.executeUpdate(str);
	}
	
	public static boolean logIn(String ID, String Pass, int a) throws InstantiationException, IllegalAccessException, ClassNotFoundException, SQLException
	{	
		Class.forName("com.mysql.jdbc.Driver").newInstance();
		Connection connection = DriverManager.getConnection("jdbc:mysql://35.226.99.168:3306/battleship", "root", "1234qwer");
		Statement statement = connection.createStatement();
		ResultSet rs = statement.executeQuery("select * from BSScores");
		Boolean verified = false;
		while(rs.next())
		{
			if( ID.equals(rs.getString("userID")) && Pass.equals(rs.getString("userPW")))
			{
				verified = true;
				String str = "UPDATE BSScores SET LoggedIN = '" + a + "' WHERE userID = '" + ID + "'";
				statement.executeUpdate(str);
				break;
			}
		}
		connection.close();
		return verified;
	}
	
	public static boolean userNameTaken(String ID) throws InstantiationException, IllegalAccessException, ClassNotFoundException, SQLException
	{	
		Class.forName("com.mysql.jdbc.Driver").newInstance();
		Connection connection = DriverManager.getConnection("jdbc:mysql://35.226.99.168:3306/battleship", "root", "1234qwer");
		Statement statement = connection.createStatement();
		ResultSet rs = statement.executeQuery("select * from BSScores");
		Boolean taken = false;				//NOT TAKEN
		while(rs.next())
		{
			if( ID.equals(rs.getString("userID")))
			{
				taken = true;
				break;
			}
		}
		connection.close();
		return taken;
	}
	
	public static void Create(String ID, String Pass) throws InstantiationException, IllegalAccessException, ClassNotFoundException, SQLException
	{	
		Class.forName("com.mysql.jdbc.Driver").newInstance();
		Connection connection = DriverManager.getConnection("jdbc:mysql://35.226.99.168:3306/battleship", "root", "1234qwer");
		Statement statement = connection.createStatement();
		
		String str = "INSERT INTO BSScores (userID, UserPW, wins, loses, KD, LoggedIN)" + "VALUES('" + ID + "','" + Pass + "','0','0','0')";
		statement.executeUpdate(str);
		connection.close();
	}
	

}
