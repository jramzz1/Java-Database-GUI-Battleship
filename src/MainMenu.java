import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class MainMenu extends JFrame{
	
	private JTextField usr1, usr2, pswd1, pswd2;
	private JLabel user1, user2, pass1, pass2, user, hscore, avg;
	private JFrame window,scorewindow;
	private ImageIcon backgroundImageIcon;
	private JLabel bkgImageContainer;
	private JButton startGame;
	
	private JTable table;
	private DefaultTableModel dm;
	private Object[][] data = {{"","",""}};
	private JTextField tf1, tf2, tf3, tf4, tf5;
	private String[] columnNames = {"Username", "Wins", "Loses"};
	private JScrollPane scroll;
	private JButton scores;
	
	BattleDataBase ci = new BattleDataBase();

	private volatile boolean isImageVisible;

	public MainMenu(JFrame theWindow){
		window = theWindow;
		backgroundImageIcon = new ImageIcon("Title.png");
		bkgImageContainer = new JLabel(backgroundImageIcon);
		window.setLocation(280, bkgImageContainer.getHeight() + 150);
		isImageVisible = true;
	}
	
	public void ScoreWindow(JFrame scoreWindow) {
		scorewindow = scoreWindow;
	}

	public void loadTitleScreen() throws SQLException, InstantiationException, IllegalAccessException, ClassNotFoundException {
		
		Class.forName("com.mysql.jdbc.Driver").newInstance();
		Connection connection = DriverManager.getConnection("jdbc:mysql://35.226.99.168:3306/battleship", "root", "1234qwer");
		Statement statement = connection.createStatement();
		ResultSet rs = statement.executeQuery("select * from BSScores");
		
		
		bkgImageContainer.setSize(window.getContentPane().getWidth(),
				window.getContentPane().getHeight()/2);
		bkgImageContainer.setLocation(0, 50); 
		bkgImageContainer.setVisible(true);
		
		user1 = new JLabel("Player 1: Username");
		user1.setSize(150,30);
		user1.setLocation(222,290);
		user1.setForeground(Color.white);
		window.add(user1);
		
		usr1 = new JTextField();
		usr1.setSize(200,40);
		usr1.setLocation(220,315);
		window.add(usr1);
		
		pass1 = new JLabel("Player1: Password");
		pass1.setSize(150,30);
		pass1.setLocation(222, 350);
		pass1.setForeground(Color.white);
		window.add(pass1);
		
		pswd1 = new JTextField();
		pswd1.setSize(200,40);
		pswd1.setLocation(222,375);
		window.add(pswd1);
		
		user2 = new JLabel("Player 2: Username");
		user2.setSize(150,30);
		user2.setLocation(482,290);
		user2.setForeground(Color.white);
		window.add(user2);
		
		usr2 = new JTextField();
		usr2.setSize(200,40);
		usr2.setLocation(480,315);
		window.add(usr2);
		
		pass2 = new JLabel("Player2: Password");
		pass2.setSize(150,30);
		pass2.setLocation(482, 350);
		pass2.setForeground(Color.white);
		window.add(pass2);
		
		pswd2 = new JTextField();
		pswd2.setSize(200,40);
		pswd2.setLocation(480,375);
		window.add(pswd2);
		
		String player1ID = usr1.getText();
		String player1PW = pswd1.getText();
		String player2ID = usr2.getText();
		String player2PW = pswd2.getText();
		
		scores = new JButton("Scores");
		scores.setSize(100, 40);
		scores.setLocation(750, bkgImageContainer.getHeight() + 220);// 150);
		scores.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent arg0) {

				setSize(600,400);
				setLocation(430, bkgImageContainer.getHeight() - 50);
				setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
				setLayout(null);
				
				table = new JTable();
				dm = new DefaultTableModel(data,columnNames);
				table.setModel(dm);
				scroll = new JScrollPane(table); 
				scroll.setSize(500, 270); 
				scroll.setLocation(50, 50); 
				add(scroll);
				
				tf1 = new JTextField();
				tf1.setSize(100,30);
				tf1.setLocation(100,400);
				add(tf1);
				
				tf2 = new JTextField();
				tf2.setSize(100,30);
				tf2.setLocation(100,400);
				add(tf2);
				
				tf3 = new JTextField();
				tf3.setSize(100,30);
				tf3.setLocation(100,400);
				add(tf3);
				
				tf4 = new JTextField();
				tf4.setSize(100,30);
				tf4.setLocation(100,400);
				add(tf4);
				
				tf5 = new JTextField();
				tf5.setSize(100,30);
				tf5.setLocation(100,400);
				add(tf5);
				
				try {
					dm.setDataVector(ci.getTable0(tf1.getText(),tf2.getText(),tf3.getText(),tf4.getText(),tf5.getText()),columnNames);
				} catch (InstantiationException | IllegalAccessException | ClassNotFoundException | SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
				dm.fireTableDataChanged();
				setVisible(true);
				
				
//				window.getContentPane().remove(startGame);
//				window.getContentPane().remove(scores);
//				window.getContentPane().remove(bkgImageContainer);
//				window.getContentPane().remove(user1);
//				window.getContentPane().remove(usr1);
//				window.getContentPane().remove(user2);
//				window.getContentPane().remove(usr2);
//				window.getContentPane().remove(pass1);
//				window.getContentPane().remove(pswd1);
//				window.getContentPane().remove(pass2);
//				window.getContentPane().remove(pswd2);
				
				
//				window.getContentPane().remove(gridSizeBtn);
//				window.getContentPane().remove(battleshipSize);
//				window.getContentPane().remove(cruiserSize);
//				window.getContentPane().remove(destroyerSize);
//				window.getContentPane().remove(submarineSize);
//				window.getContentPane().remove(battleshipCount);
//				window.getContentPane().remove(cruiserCount);
//				window.getContentPane().remove(destroyerCount);
//				window.getContentPane().remove(submarineCount);
//				window.getContentPane().revalidate();
//				window.getContentPane().repaint();
//				window.getContentPane().setBackground(new Color(30,55,65));
//				isImageVisible = false;
			}	
		});
		
		
		//boolean player1B = false, player2B = false;
		boolean player1B = BattleDataBase.logIn(player1ID, player1PW, 1);
		boolean player2B = BattleDataBase.logIn(player2ID, player2PW, 2);
		
		startGame = new JButton("Start Game");
		startGame.setSize(200, 80);
		startGame.setLocation(355, bkgImageContainer.getHeight() + 150);// 150);
		
		
		startGame.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent arg0) {
				
				String player1ID = usr1.getText();
				String player1PW = pswd1.getText();
				String player2ID = usr2.getText();
				String player2PW = pswd2.getText();
				
				
				//boolean player1B = false, player2B = false;
				boolean player1B = false;
				try {
					player1B = BattleDataBase.logIn(player1ID, player1PW, 1);
				} catch (InstantiationException | IllegalAccessException | ClassNotFoundException | SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				boolean player2B = false;
				try {
					player2B = BattleDataBase.logIn(player2ID, player2PW, 2);
				} catch (InstantiationException | IllegalAccessException | ClassNotFoundException | SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
				if((player1B == true && player2B == true))
				{
					window.getContentPane().remove(startGame);
					window.getContentPane().remove(bkgImageContainer);
					window.getContentPane().remove(user1);
					window.getContentPane().remove(usr1);
					window.getContentPane().remove(user2);
					window.getContentPane().remove(usr2);
					window.getContentPane().remove(pass1);
					window.getContentPane().remove(pswd1);
					window.getContentPane().remove(pass2);
					window.getContentPane().remove(pswd2);
					window.getContentPane().remove(scores);
					window.getContentPane().revalidate();
					window.getContentPane().repaint();
					window.getContentPane().setBackground(new Color(30,55,65));
					isImageVisible = false;
				}
			
				else if(player1B == false && player2B == false)
				{
					Component frame = null;

					JOptionPane.showMessageDialog(frame,
						    "PLayer 1 & 2 not found! Create?",
						    "Inane error",
						    JOptionPane.ERROR_MESSAGE);
					
					try {
						if((!player1ID.equals("") && !player1PW.equals("")) && (!player2ID.equals("") && !player2PW.equals("")))
						{
							boolean usr1 = BattleDataBase.userNameTaken(player1ID);
							boolean usr2 = BattleDataBase.userNameTaken(player2ID);
							
							if(!usr1 || !usr2)
							{
								BattleDataBase.Create(player1ID, player1PW);
								BattleDataBase.Create(player2ID, player2PW);
							}
						}
					} catch (InstantiationException | IllegalAccessException | ClassNotFoundException
							| SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					
				}
				else if(player1B == false)
				{
					Component frame = null;
					JOptionPane.showMessageDialog(frame,
						    "PLayer 1 not found! Create?",
						    "Inane error",
						    JOptionPane.ERROR_MESSAGE);
					try {
						if(!player1ID.equals("") && !player1PW.equals(""))
						{
							boolean usr1 = BattleDataBase.userNameTaken(player1ID);
							
							if(!usr1)
							{
								BattleDataBase.Create(player1ID, player1PW);
							}
						}
					} catch (InstantiationException | IllegalAccessException | ClassNotFoundException
							| SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
				else if(player2B == false)
				{
					Component frame = null;
					JOptionPane.showMessageDialog(frame,
						    "PLayer 2 not found! Create?",
						    "Inane error",
						    JOptionPane.ERROR_MESSAGE);
					try {
						if(!player2ID.equals("") && !player2PW.equals(""))
						{
							boolean usr2 = BattleDataBase.userNameTaken(player2ID);
							
							if(!usr2)
							{
								BattleDataBase.Create(player2ID, player2PW);
							}
						}
					} catch (InstantiationException | IllegalAccessException | ClassNotFoundException
							| SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
				}
				}
				
//				window.getContentPane().remove(startGame);
//				window.getContentPane().remove(bkgImageContainer);
//				window.getContentPane().remove(user1);
//				window.getContentPane().remove(usr1);
//				window.getContentPane().remove(user2);
//				window.getContentPane().remove(usr2);
//				window.getContentPane().remove(pass1);
//				window.getContentPane().remove(pswd1);
//				window.getContentPane().remove(pass2);
//				window.getContentPane().remove(pswd2);
//				window.getContentPane().revalidate();
//				window.getContentPane().repaint();
//				window.getContentPane().setBackground(new Color(30,55,65));
//				isImageVisible = false;
			}	
		});
		
		startGame.setVisible(true);

		window.getContentPane().add(startGame);
		window.getContentPane().add(bkgImageContainer);
		window.getContentPane().setBackground(Color.BLACK);
		
		scores.setVisible(true);
		window.getContentPane().add(scores);
		
		window.setVisible(true);
		window.getContentPane().revalidate();
		window.getContentPane().repaint();
	}

	public boolean isImageVisible(){
		return isImageVisible;
	}
	
}
