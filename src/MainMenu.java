import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class MainMenu{
	
	private JTextField usr1, usr2, pswd1, pswd2;
	private JLabel user1, user2,pass1,pass2;
	private JFrame window;
	private ImageIcon backgroundImageIcon;
	private JLabel bkgImageContainer;
//	private JButton gridSizeBtn;
	private JButton startGame;
	private JButton scores;
//	private JButton battleshipSize, cruiserSize, destroyerSize, submarineSize;
//	private JButton battleshipCount, cruiserCount, destroyerCount, submarineCount;
//	private JLabel errorMessage;
	private volatile boolean isImageVisible;
//	private static final int MAX_SHIP_SIZE = 8;
//	private static final int MAX_SHIP_COUNT = 5;
	
	public MainMenu(JFrame theWindow){
		window = theWindow;
		backgroundImageIcon = new ImageIcon("Title.png");
		bkgImageContainer = new JLabel(backgroundImageIcon);
		isImageVisible = true;
	}
	
//	public boolean canShipsFitOnBoard(){
//		int totalShipSize = (GameLogic.battleshipCount * GameLogic.battleshipSize) + 
//				(GameLogic.cruiserCount * GameLogic.cruiserSize) +
//				(GameLogic.destroyerCount * GameLogic.destroyerSize) + 
//				(GameLogic.submarineCount * GameLogic.submarineSize);
//		if (totalShipSize > GameLogic.boardSize*GameLogic.boardSize){
//			return false;
//		}
//		if (GameLogic.battleshipSize > GameLogic.boardSize){
//			return false;
//		}
//		if (GameLogic.cruiserSize > GameLogic.boardSize){
//			return false;
//		}
//		if (GameLogic.destroyerSize > GameLogic.boardSize){
//			return false;
//		}
//		if (GameLogic.submarineSize > GameLogic.boardSize){
//			return false;
//		}
//		return true;
//	}
	
	public void loadTitleScreen() {
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
		
//		errorMessage = new JLabel("Error: grid is too small to fit the selected ships");
//		errorMessage.setForeground(Color.RED);
//		errorMessage.setFont(new Font("Impact", Font.PLAIN, 24));
//		errorMessage.setSize(440, 40);
//		errorMessage.setLocation(window.getWidth()/2 - errorMessage.getWidth()/2,
//				window.getHeight()-errorMessage.getHeight() - 30);
//		errorMessage.setVisible(false);
		
		scores = new JButton("Scores");
		scores.setSize(100, 40);
		scores.setLocation(750, bkgImageContainer.getHeight() + 220);// 150);
		scores.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent arg0) {
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
		
		startGame = new JButton("Start Game");
		startGame.setSize(200, 80);
		startGame.setLocation(355, bkgImageContainer.getHeight() + 150);// 150);
		startGame.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent arg0) {
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
//				window.getContentPane().remove(gridSizeBtn);
//				window.getContentPane().remove(battleshipSize);
//				window.getContentPane().remove(cruiserSize);
//				window.getContentPane().remove(destroyerSize);
//				window.getContentPane().remove(submarineSize);
//				window.getContentPane().remove(battleshipCount);
//				window.getContentPane().remove(cruiserCount);
//				window.getContentPane().remove(destroyerCount);
//				window.getContentPane().remove(submarineCount);
				window.getContentPane().revalidate();
				window.getContentPane().repaint();
				window.getContentPane().setBackground(new Color(30,55,65));
				isImageVisible = false;
			}	
		});
		
//		gridSizeBtn = new JButton("Grid Width: " + GameLogic.boardSize);
//		gridSizeBtn.setSize(200, 100); 
//		gridSizeBtn.setLocation(360, bkgImageContainer.getHeight() + startGame.getHeight() + 50);
//		gridSizeBtn.addActionListener(new ActionListener(){
//			@Override
//			public void actionPerformed(ActionEvent arg0) {
//				if (GameLogic.boardSize < 18){
//					GameLogic.boardSize += 2;
//				}else{
//					GameLogic.boardSize = 6;
//				}
//				gridSizeBtn.setText("Grid Width: " + GameLogic.boardSize);
//				boolean shipsFit = canShipsFitOnBoard();
//				startGame.setEnabled(shipsFit);
//				errorMessage.setVisible(!shipsFit);
//			}	
//		});
		
//		battleshipSize = new JButton("Length of Battleship: " + GameLogic.battleshipSize);
//		battleshipSize.setSize(200, 50); 
//		battleshipSize.setLocation(window.getContentPane().getWidth() - battleshipSize.getWidth() - 300, 
//				bkgImageContainer.getHeight() + 50);
//		battleshipSize.addActionListener(new ActionListener(){
//			@Override
//			public void actionPerformed(ActionEvent arg0) {
//				if (GameLogic.battleshipSize < MAX_SHIP_SIZE){
//					GameLogic.battleshipSize += 1;
//				}else{
//					GameLogic.battleshipSize = 1;
//				}
//				battleshipSize.setText("Length of Battleship: " + GameLogic.battleshipSize);
//				boolean shipsFit = canShipsFitOnBoard();
//				startGame.setEnabled(shipsFit);
//				errorMessage.setVisible(!shipsFit);
//			}	
//		});
		
		
//		battleshipCount = new JButton("Number of Battleships: " + GameLogic.battleshipCount);
//		battleshipCount.setSize(200, 50); 
//		battleshipCount.setLocation(window.getContentPane().getWidth() - battleshipCount.getWidth() - 100, 
//				bkgImageContainer.getHeight() + 50);
//		battleshipCount.addActionListener(new ActionListener(){
//			@Override
//			public void actionPerformed(ActionEvent arg0) {
//				if (GameLogic.battleshipCount  < MAX_SHIP_COUNT){
//					GameLogic.battleshipCount += 1;
//				}else{
//					GameLogic.battleshipCount = 1;
//				}
//				battleshipCount.setText("Number of Battleships: " + GameLogic.battleshipCount);
//				boolean shipsFit = canShipsFitOnBoard();
//				startGame.setEnabled(shipsFit);
//				errorMessage.setVisible(!shipsFit);
//			}	
//		});
		
		
//		cruiserSize = new JButton("Length of Cruiser: " + GameLogic.cruiserSize);
//		cruiserSize.setSize(200, 50); 
//		cruiserSize.setLocation(window.getContentPane().getWidth() - cruiserSize.getWidth() - 300, 
//				bkgImageContainer.getHeight() + battleshipSize.getHeight() + 50);
//		cruiserSize.addActionListener(new ActionListener(){
//			@Override
//			public void actionPerformed(ActionEvent arg0) {
//				if (GameLogic.cruiserSize < MAX_SHIP_SIZE){
//					GameLogic.cruiserSize += 1;
//				}else{
//					GameLogic.cruiserSize = 1;
//				}
//				cruiserSize.setText("Length of Cruiser: " + GameLogic.cruiserSize);
//				boolean shipsFit = canShipsFitOnBoard();
//				startGame.setEnabled(shipsFit);
//				errorMessage.setVisible(!shipsFit);
//			}	
//		});
		
		
//		cruiserCount = new JButton("Number of Cruisers: " + GameLogic.cruiserCount);
//		cruiserCount.setSize(200, 50); 
//		cruiserCount.setLocation(window.getContentPane().getWidth() - cruiserCount.getWidth() - 100, 
//				bkgImageContainer.getHeight() + battleshipCount.getHeight() + 50);
//		cruiserCount.addActionListener(new ActionListener(){
//			@Override
//			public void actionPerformed(ActionEvent arg0) {
//				if (GameLogic.cruiserCount  < MAX_SHIP_COUNT){
//					GameLogic.cruiserCount += 1;
//				}else{
//					GameLogic.cruiserCount = 1;
//				}
//				cruiserCount.setText("Number of Cruisers: " + GameLogic.cruiserCount);
//				boolean shipsFit = canShipsFitOnBoard();
//				startGame.setEnabled(shipsFit);
//				errorMessage.setVisible(!shipsFit);
//			}	
//		});
		
		
//		destroyerSize = new JButton("Length of Destroyer: " + GameLogic.destroyerSize);
//		destroyerSize.setSize(200, 50); 
//		destroyerSize.setLocation(window.getContentPane().getWidth() - battleshipSize.getWidth() - 300, 
//				bkgImageContainer.getHeight() + battleshipSize.getHeight() + cruiserSize.getHeight() + 50);
//		destroyerSize.addActionListener(new ActionListener(){
//			@Override
//			public void actionPerformed(ActionEvent arg0) {
//				if (GameLogic.destroyerSize < MAX_SHIP_SIZE){
//					GameLogic.destroyerSize += 1;
//				}else{
//					GameLogic.destroyerSize = 1;
//				}
//				destroyerSize.setText("Length of Destroyer: " + GameLogic.destroyerSize);
//				boolean shipsFit = canShipsFitOnBoard();
//				startGame.setEnabled(shipsFit);
//				errorMessage.setVisible(!shipsFit);
//			}	
//		});
		
		
//		destroyerCount = new JButton("Number of Destroyers: " + GameLogic.destroyerCount);
//		destroyerCount.setSize(200, 50); 
//		destroyerCount.setLocation(window.getContentPane().getWidth() - destroyerCount.getWidth() - 100, 
//				bkgImageContainer.getHeight() +
//				battleshipCount.getHeight() + 
//				cruiserCount.getHeight() + 50);
//		destroyerCount.addActionListener(new ActionListener(){
//			@Override
//			public void actionPerformed(ActionEvent arg0) {
//				if (GameLogic.destroyerCount  < MAX_SHIP_COUNT){
//					GameLogic.destroyerCount += 1;
//				}else{
//					GameLogic.destroyerCount = 1;
//				}
//				destroyerCount.setText("Number of Destroyers: " + GameLogic.destroyerCount);
//				boolean shipsFit = canShipsFitOnBoard();
//				startGame.setEnabled(shipsFit);
//				errorMessage.setVisible(!shipsFit);
//			}	
//		});
		
		
//		submarineSize = new JButton("Length of Submarine: " + GameLogic.submarineSize);
//		submarineSize.setSize(200, 50); 
//		submarineSize.setLocation(window.getContentPane().getWidth() - submarineSize.getWidth() - 300, 
//				bkgImageContainer.getHeight() + 
//				battleshipSize.getHeight() + 
//				cruiserSize.getHeight() + 
//				destroyerSize.getHeight() + 50);
//		submarineSize.addActionListener(new ActionListener(){
//			@Override
//			public void actionPerformed(ActionEvent arg0) {
//				if (GameLogic.submarineSize < MAX_SHIP_SIZE){
//					GameLogic.submarineSize += 1;
//				}else{
//					GameLogic.submarineSize = 1;
//				}
//				submarineSize.setText("Length of Submarine: " + GameLogic.submarineSize);
//				boolean shipsFit = canShipsFitOnBoard();
//				startGame.setEnabled(shipsFit);
//				errorMessage.setVisible(!shipsFit);
//			}	
//		});
		
//		submarineCount = new JButton("Number of Submarines: " + GameLogic.submarineCount);
//		submarineCount.setSize(200, 50); 
//		submarineCount.setLocation(window.getContentPane().getWidth() - submarineCount.getWidth() - 100, 
//				bkgImageContainer.getHeight() +
//				battleshipCount.getHeight() + 
//				cruiserCount.getHeight() + 
//				destroyerCount.getHeight() + 50);
//		submarineCount.addActionListener(new ActionListener(){
//			@Override
//			public void actionPerformed(ActionEvent arg0) {
//				if (GameLogic.submarineCount  < MAX_SHIP_COUNT){
//					GameLogic.submarineCount += 1;
//				}else{
//					GameLogic.submarineCount = 1;
//				}
//				submarineCount.setText("Number of Submarines: " + GameLogic.submarineCount);
//				boolean shipsFit = canShipsFitOnBoard();
//				startGame.setEnabled(shipsFit);
//				errorMessage.setVisible(!shipsFit);
//			}	
//		});
		
		startGame.setVisible(true);
		scores.setVisible(true);
//		gridSizeBtn.setVisible(true);
//		battleshipSize.setVisible(true);
//		cruiserSize.setVisible(true);
//		destroyerSize.setVisible(true);
//		submarineSize.setVisible(true);
//		battleshipCount.setVisible(true);
//		cruiserCount.setVisible(true);
//		destroyerCount.setVisible(true);
//		submarineCount.setVisible(true);
		
//		window.getContentPane().add(errorMessage);
		window.getContentPane().add(startGame);
		window.getContentPane().add(scores);
		window.getContentPane().add(bkgImageContainer);
//		window.getContentPane().add(gridSizeBtn);
//		window.getContentPane().add(battleshipSize);
//		window.getContentPane().add(cruiserSize);
//		window.getContentPane().add(destroyerSize);
//		window.getContentPane().add(submarineSize);
//		window.getContentPane().add(battleshipCount);
//		window.getContentPane().add(cruiserCount);
//		window.getContentPane().add(destroyerCount);
//		window.getContentPane().add(submarineCount);
		
		window.getContentPane().setBackground(Color.BLACK);
		window.setVisible(true);
		window.getContentPane().revalidate();
		window.getContentPane().repaint();
	}

	public boolean isImageVisible(){
		return isImageVisible;
	}
	
}
