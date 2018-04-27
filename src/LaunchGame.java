import java.sql.SQLException;

public class LaunchGame {
	public static void main(String[] args) throws InstantiationException, IllegalAccessException, ClassNotFoundException, SQLException {
		new GameLogic().setUpWindow();
	}
}
