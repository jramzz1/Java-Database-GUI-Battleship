import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

import com.mysql.jdbc.PreparedStatement;

public class BattleDataBase {
//
//	public static void main(String[] args) {
//		
//	}
	
//		READY TO MANIPULATE
	public static void Display() throws InstantiationException, IllegalAccessException, ClassNotFoundException, SQLException
	{	
		Class.forName("com.mysql.jdbc.Driver").newInstance();
		Connection connection = DriverManager.getConnection("jdbc:mysql://35.226.99.168:3306/battleship", "root", "1234qwer");
		Statement statement = connection.createStatement();
		ResultSet rs = statement.executeQuery("select * from BSScores");
		System.out.println("ID" + "            "
				+ "Password" + "       "
				+ "Wins" + "     "
				+ "Loses" + "     "
				+ "W/L Ratio");
		
		String uID ="", uPW = "";
		int W = 0, L = 0;
		float WL = 0;
		while(rs.next())
		{	
			uID = rs.getString("userID");
			uPW = rs.getString("userPW");
			W = rs.getInt("wins");
			L = rs.getInt("loses");
			WL = rs.getFloat("KD");
			
			
			System.out.printf("%8s %10s %10s %10s %10s", uID, uPW, W, L, WL);
			System.out.println();
		}
		connection.close();
	}
	
	public static boolean logIn(String ID, String Pass) throws InstantiationException, IllegalAccessException, ClassNotFoundException, SQLException
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
		
//		INSERT INTO BSScores VALUES ('rigosans', 'passw', 10, 0, 10);
		int W = 0, L = 0;
		float KD = 0;
		String str = "INSERT INTO BSScore (userID, UserPW, wins, loses, KD)" + "VALUES(?,?,?,?,?)";
		PreparedStatement ps = (PreparedStatement) connection.prepareStatement(str);
		ps.setString(1, ID);
		ps.setString(2, Pass);
		ps.setInt(3, W);
		ps.setInt(4, L);
		ps.setFloat(5, KD);
		ps.executeUpdate();
		connection.close();
	}
	

}
