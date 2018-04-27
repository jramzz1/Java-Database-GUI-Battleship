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
			++count;
		}
		connection.close();
		return data;
	}
	
	public static void updateL(int a, int b, String user) throws InstantiationException, IllegalAccessException, ClassNotFoundException, SQLException
	{
		Class.forName("com.mysql.jdbc.Driver").newInstance();
		Connection connection = DriverManager.getConnection("jdbc:mysql://35.226.99.168:3306/battleship", "root", "1234qwer");
		Statement statement = connection.createStatement();
		ResultSet bs = statement.executeQuery("select * from BSScores");
		
		String str2 = "UPDATE BSScores SET loses =";
		
		while(bs.next())
		{
			// This updates if user1 wins
			if(b == bs.getInt("LoggedIN") && user.equals("usr1"))
			{
				int loses =  bs.getInt("loses");
				loses += 1;
				str2 += " '" + loses + "' WHERE LoggedIN = " + b;
			}
		
			// This updates if user2 wins
			if(a == (bs.getInt("LoggedIN")) && user.equals("usr2"))
			{

				int loses =  bs.getInt("loses");
				loses += 1;
				str2 += " '" + loses + "' WHERE LoggedIN = " + a;
			}
		}
		
		// Update Wins and Loses
		statement.executeUpdate(str2);
		connection.close();
	}
	
	public static void updateW(int a, int b, String user) throws InstantiationException, IllegalAccessException, ClassNotFoundException, SQLException
	{
		Class.forName("com.mysql.jdbc.Driver").newInstance();
		Connection connection = DriverManager.getConnection("jdbc:mysql://35.226.99.168:3306/battleship", "root", "1234qwer");
		Statement statement = connection.createStatement();
		ResultSet results = statement.executeQuery("select * from BSScores");
		
		String str = "UPDATE BSScores SET wins =";
		
		while(results.next())
		{
			// This updates if user1 wins
			if(a == results.getInt("LoggedIN") && user.equals("usr1"))
			{
				int wins = results.getInt("wins");
				wins += 1;
				str += " '" + wins + "' WHERE LoggedIN = '" + a + "'";
				
				updateL(1,2,"usr1");
			}
		
			// This updates if user2 wins
			if(b == (results.getInt("LoggedIN")) && user.equals("user2"))
			{
				int wins = results.getInt("wins");
				wins += 1;
				str += " '" + wins + "' WHERE LoggedIN = " + b;
				
				updateL(1,2,"usr2");
			}
		}
		
		// Update Wins and Loses
		statement.executeUpdate(str);
		
		// Update logged in.
		str = "UPDATE BSScores SET LoggedIN = '0' WHERE LoggedIN = " + a ;
		statement.executeUpdate(str);
		
		str = "UPDATE BSScores SET LoggedIN = '0' WHERE LoggedIN = " + b;
		statement.executeUpdate(str);
		connection.close();
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
