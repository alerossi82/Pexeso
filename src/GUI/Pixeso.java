package GUI;

import java.awt.EventQueue;

/**
 * 
 * @author Alessandro
 * 
 *         This project creates a classic memory game, where the player should
 *         click on two different cards whose image is initially hidden. If the
 *         images of the two cards match, these cards can not be clicked on
 *         anymore, the player gains a point and can click on two more cards;
 *         otherwise, both cards turn on their back and play passes to second
 *         player - and so on, until all cards have been unveiled. Player's
 *         points are displayed in a dedicated panel. Once all cards have been
 *         matched, a blinking Game Over label will appear, and the player will
 *         be offered the option to play again or quit the application clicking
 *         the related button
 */

/**
 * 
 * @author Alessandro
 * 
 *         This class contains the main method, where an instance of Frame is
 *         created and set to visible
 */
public class Pixeso {

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Frame frame = new Frame();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

}
