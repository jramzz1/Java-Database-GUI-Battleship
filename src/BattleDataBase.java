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
		
		String update = "select * from BSScores ORDER BY KD DESC";
		ResultSet rs = statement.executeQuery(update);
		
		Object[][] data = new Object[100][8];
		int count = 0;
		
		while(rs.next()) {
			data[count][0] = rs.getString(1);
			data[count][1] = rs.getString(3);
			data[count][2] = rs.getString(4);
			data[count][3] = rs.getString(5);
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
	
	public static void updateW() throws InstantiationException, IllegalAccessException, ClassNotFoundException, SQLException
	{
		
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
		
		String str = "INSERT INTO BSScores (userID, UserPW, wins, loses, KD, LoggedIN)" + "VALUES('" + ID + "','" + Pass + "','0','0','0','0')";
		statement.executeUpdate(str);
		connection.close();
	}
	

}
