package GUI;

import java.awt.Color;
import java.awt.Frame;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.Timer;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.SwingConstants;
import javax.swing.JButton;

/**
 * 
 * @author Alessandro
 *
 *         This class defines the panel triggered by the check_end method in
 *         MainWindow
 * 
 *         The panel contains three labels
 * 
 *         The text of label wins changes according to the player who scored
 *         more points
 * 
 *         A Timer is created to produce the blinking effect on the Game Over
 *         label
 */
public class GameOverPanel extends JPanel {
	private JLabel GameOver;
	private JLabel wins;
	private JLabel PlayAgain;
	private Timer blinking;

	/**
	 * Constructor
	 * 
	 * The text of the JLabel wins is defined by checkWinner()
	 */
	public GameOverPanel() {
		setBounds(450, 325, 437, 336);
		setBackground(Color.GREEN);
		setLayout(null);

		GameOver = new JLabel("GAME OVER!");
		GameOver.setHorizontalAlignment(SwingConstants.LEFT);
		GameOver.setForeground(Color.RED);
		GameOver.setFont(new Font("AR BLANCA", Font.BOLD, 60));
		GameOver.setBounds(12, 13, 388, 51);
		add(GameOver);

		wins = new JLabel(checkWinner());
		wins.setHorizontalAlignment(SwingConstants.LEFT);
		wins.setForeground(Color.YELLOW);
		wins.setFont(new Font("AR BLANCA", Font.BOLD, 50));
		wins.setBounds(12, 108, 413, 36);
		add(wins);

		PlayAgain = new JLabel("PLAY AGAIN?");
		PlayAgain.setHorizontalAlignment(SwingConstants.LEFT);
		PlayAgain.setFont(new Font("AR BLANCA", Font.BOLD, 50));
		PlayAgain.setForeground(Color.BLUE);
		PlayAgain.setBounds(12, 183, 388, 51);
		add(PlayAgain);

		blinking = new Timer(700, new TimerListener());
		blinking.start();
	}

	/**
	 * 
	 * @return
	 * 
	 * 		This method checks the values of the variables Points1 and
	 *         Points2 from class MainWindow and returns a string accordingly
	 */
	public String checkWinner() {
		if (MainWindow.getPoints1() > MainWindow.getPoints2())
			return "PLAYER 1 WINS!";
		else
			return "PLAYER 2 WINS!";
	}

	/**
	 * 
	 * @author Alessandro
	 * 
	 *         This is the ActionListener for the Timer
	 * 
	 * 
	 */
	private class TimerListener implements ActionListener {
		/**
		 * This method changes the color of the text in the JLabel from red to
		 * green and viceversa. Since the background color of MainWindow is
		 * green, and this JLabel is not opaque, this simulates a blinking
		 * effect
		 * 
		 * 
		 */
		@Override
		public void actionPerformed(ActionEvent e) {
			if (GameOver.getForeground() == Color.RED) {
				GameOver.setForeground(Color.GREEN);
			} else {
				GameOver.setForeground(Color.RED);
			}
		}

	}
}