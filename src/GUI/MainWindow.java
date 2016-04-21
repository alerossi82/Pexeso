package GUI;

import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Random;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.Timer;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;

import java.awt.BorderLayout;

import javax.swing.BoxLayout;

/**
 * @author Alessandro
 *
 *         This class creates the main JPanel
 *
 *         This panel acts as a base for 3 more panels:
 * 
 *         - a panel from the CardsPanel class, receiving the JButtons
 *         representing the cards
 * 
 *         - a panel from the PointsPanel class, displaying the points for the
 *         players
 * 
 *         - a panel from the GameOverPanel class, that will pop-up once the all
 *         cards have been discovered
 * 
 *         and the two JButtons defined in the Frame class, that will pop-up
 *         once the all cards have been discovered
 * 
 *         The JButton[] receives the JButtons representing the cards
 * 
 *         The images associated with the cards were saved online, their address
 *         is collected in a URL[]
 * 
 *         An ImageIcon[] receives the icons from the paths defined in URL[]
 * 
 *         The String[] immagini is commented out as it would conflict with the
 *         URL[]; String[] immagini is a back-up to be used in case the icons
 *         uploaded on the internet become unavailable(all icons are saved
 *         inside this projects); in that case, String[] should be used instead
 *         of URL[]
 * 
 *         The Timer will fire an event that reset the initial image in case the
 *         cards' icons do not match
 */

public class MainWindow extends JPanel {

	private ImageIcon[] iconarray;
	private ArrayList<Integer> list1;
	private final int NUM_OF_BUTTONS = 20;
	private JButton[] buttonarray;
	private Random rand1;
	private JButton button1;
	private JButton button2;
	private Timer timer1;
	private CardsPanel cardspanel;
	private PointsPanel pointspanel;
	private GameOverPanel gameoverpanel;
	private final int NUM_OF_IMAGINES = 11;
	private URL[] immagini;
	// private String[] immagini;
	private final String path;
	private int counter;
	private boolean player1;
	private static int points1;
	private static int points2;

	/**
	 * 
	 * @throws IOException
	 * 
	 *             Constructor
	 * 
	 *             All variables are initalized here
	 * 
	 *             The ActionListener implemented by Timer1 is defined in a
	 *             dedicated private class
	 * 
	 *             Two methods are invoked here:
	 * 
	 *             - InitWindow(), that initializes the JPanel
	 * 
	 *             - InitImages(), that associates the images to the JButtons
	 * 
	 * 
	 */
	public MainWindow() throws IOException {
		iconarray = new ImageIcon[NUM_OF_IMAGINES];
		list1 = new ArrayList<Integer>();
		buttonarray = new JButton[NUM_OF_BUTTONS];
		rand1 = new Random();
		button1 = new JButton();
		button2 = new JButton();
		cardspanel = new CardsPanel();
		pointspanel = new PointsPanel();
		gameoverpanel = new GameOverPanel();
		// immagini = new String[NUM_OF_IMAGINES];
		immagini = new URL[NUM_OF_IMAGINES];
		path = new String("src/images/");
		counter = 1;
		player1 = true;
		points1 = 0;
		points2 = 0;
		timer1 = new Timer(2000, new TimerListener());

		initWindow();

		initImages();
	}

	/**
	 * 
	 * @return
	 * 
	 * 		These Getters are used to pass the values of points1 and points2
	 *         to the PointsPanel class
	 */

	public static int getPoints1() {
		return points1;
	}

	public static int getPoints2() {
		return points2;
	}

	/**
	 * This method sets up the JPanel
	 */

	private void initWindow() {
		setBounds(100, 100, 1204, 908);
		setBackground(Color.GREEN);
		setBorder(new EmptyBorder(50, 50, 50, 50));
		setLayout(null);

		add(cardspanel);
		add(pointspanel);
	}

	/**
	 * @throws MalformedURLException
	 * 
	 *             This method assigns the icons to the JButtons in several
	 *             steps:
	 * 
	 *             - all the URLs where the icons were stored are collected in
	 *             an URL[]
	 * 
	 *             - as an alternative, it is possible to use a String[] to
	 *             store the paths of the image saved locally (this part was
	 *             commented out)
	 */
	private void initImages() throws MalformedURLException {

		immagini[0] = new URL("http://i.imgur.com/421DcmK.jpg");
		immagini[1] = new URL("http://i.imgur.com/mpx0yXN.jpg");
		immagini[2] = new URL("http://i.imgur.com/9i8UkrI.jpg");
		immagini[3] = new URL("http://i.imgur.com/KN86BKv.jpg");
		immagini[4] = new URL("http://m.uploadedit.com/ba3k/1443648656327.jpg");
		immagini[5] = new URL("http://i.imgur.com/mS3dRj7.jpg");
		immagini[10] = new URL("http://i.imgur.com/7vdVgHa.jpg");
		immagini[7] = new URL("http://i.imgur.com/njAuT7Q.jpg");
		immagini[8] = new URL("http://i.imgur.com/5hWZQG8.jpg");
		immagini[9] = new URL("http://i.imgur.com/bwZAiyL.jpg");
		immagini[6] = new URL("http://i.imgur.com/rHbAnOD.jpg");

		/*
		 * inserisco le immagini in uno string[] immagini[0] = new String(path +
		 * "butterfly.jpg"); immagini[1] = new String(path + "city.jpg");
		 * immagini[2] = new String(path + "desert.jpg"); immagini[3] = new
		 * String(path + "flower.jpg"); immagini[4] = new String(path +
		 * "flowers.jpg"); immagini[5] = new String(path + "night.jpg");
		 * immagini[10] = new String(path + "questionmark.jpg"); immagini[7] =
		 * new String(path + "sunset.jpg"); immagini[8] = new String(path +
		 * "surf.jpg"); immagini[9] = new String(path + "tiger.jpg");
		 * immagini[6] = new String(path + "water.jpg");
		 */

		/**
		 * - for each element of URL[], a new ImageIcon object is created and
		 * stored in ImageIcon[] iconarray
		 * 
		 * - ArrayList<Integer> list1 is initialized (with as many 0 as the
		 * number of images)
		 */
		for (int i = 0; i < NUM_OF_IMAGINES; i++) {
			iconarray[i] = new ImageIcon(immagini[i]);
			list1.add(0);
		}

		/**
		 * - the JButtons are created, initalized with the back image and added
		 * to cardspanel
		 * 
		 * - each button is added to JButton[]buttonarray
		 * 
		 * - an ActionListener is added to each JButton
		 */

		for (int i = 0; i < NUM_OF_BUTTONS; i++) {
			cardspanel.add(new JButton(iconarray[10]));
			buttonarray[i] = (JButton) cardspanel.getComponent(i);
			buttonarray[i].addActionListener(new ImageButtonListener());
		}

		/**
		 * a number between 0 and 9 is randomly assigned to each button in
		 * JButton[], but no number can be assigned to more than two buttons:
		 * 
		 * - a random number x (between 0 and 9) is generated
		 * 
		 * - the list1 element in position x(random number) is increased by 1
		 * 
		 * - if the value of the list1[x] int is no higher than 2, the number x
		 * is parsed to a string and set as name of the JButton[y] element; y is
		 * then increased by 1
		 * 
		 * - the cicle repeats until all buttons receives an image (all ints in
		 * list1 are set to 2)
		 * 
		 */
		for (int y = 0; y < NUM_OF_BUTTONS;) {
			Integer x = rand1.nextInt(10);
			list1.set(x, list1.get(x).intValue() + 1);
			if (list1.get(x) <= 2) {
				buttonarray[y].setName(x.toString());
				y++;
			}
		}

	}

	/**
	 * 
	 * @author Alessandro
	 * 
	 *         This class contains the ActionListener for the JButtons
	 *
	 *         This class contains three methods:
	 * 
	 *         - the ActionListener, that shows the image for the clicked button
	 *         and copies the buttons clicked in the button1 and button2
	 *         variables
	 * 
	 *         - compareicons(), that checks if the cards that were clicked are
	 *         the same and, if yes, add a point to the player, otherwise the
	 *         players are switched
	 * 
	 *         - check_end(), that cheks if all cards have been disabled; if
	 *         yes, it clears up the frame and gets the GameOverPanel and the
	 *         JButton BtnYes and BtnNo (from the Frame class)
	 */

	private class ImageButtonListener implements ActionListener {

		/**
		 * 
		 * @author Alessandro
		 * 
		 *         This is the ActionListener for the JButtons in button[]
		 * 
		 *         - first, the method checks if the Timer is running; if yes,
		 *         it does not start
		 * 
		 *         - the name of the button is parsed back to a number x, and
		 *         its icon is set to the element iconarray[x]
		 * 
		 *         - if this is the first clicked button in the player's turn,
		 *         the variable button1 received a copy of this button and the
		 *         value of counter is increased
		 * 
		 *         - if this is the second clicked button, and the same button
		 *         was not clicked twice, the variable button2 received a copy
		 *         of this button
		 * 
		 *         - compareicons() is invoked
		 */

		@Override
		public void actionPerformed(ActionEvent e) {
			if (timer1.isRunning())
				return;

			for (int i = 0; i < NUM_OF_BUTTONS; i++)
				if (e.getSource() == buttonarray[i]) {
					int x = Integer.parseInt(buttonarray[i].getName());
					buttonarray[i].setIcon(iconarray[x]);

					if (counter == 1) {
						button1 = buttonarray[i];
						counter++;
					}

					if (counter == 2 && buttonarray[i] != button1) {
						button2 = buttonarray[i];
						compareicons();
					}
				}
		}

		/**
		 * If the icons saved in button1 and button2 are the same:
		 * 
		 * - the JButtons are disabled
		 * 
		 * - depending on the player, the value of point1 or points2 is
		 * increased by 1 and the text in Label1 or Label2 is updated
		 * 
		 * - check_end() is invoked
		 * 
		 * If the cards do not match, the player is switched, the timer is
		 * triggered and the counter is reset to 0
		 */

		public void compareicons() {
			if (button1.getIcon() == button2.getIcon()) {
				button1.setEnabled(false);
				button2.setEnabled(false);

				if (player1) {
					points1++;
					pointspanel.getLabel1().setText(Integer.toString(points1));
				} else {
					points2++;
					pointspanel.getLabel2().setText(Integer.toString(points2));
				}

				check_end();
			}

			else {
				player1 = !player1;
				timer1.start();
			}
			counter = 1;
		}

		/**
		 * This method checks the status of the JButtons and increases the
		 * variable count by 1 for each button that was disabled; if the value
		 * of count reaches the tot. number of the buttons, the following
		 * happens:
		 * 
		 * - all elements are removed from MainWindow;
		 * 
		 * - gameoverpanel is added to MainWindow;
		 * 
		 * - BtnYes and BtnNo are added to MainWindow (from the Frame class)
		 */
		private void check_end() {
			int count = 0;
			for (JButton b : buttonarray)
				if (b.isEnabled() == false) {
					count++;
					if (count == NUM_OF_BUTTONS) {
						removeAll();
						add(gameoverpanel);
						add(Frame.getBtnYes());
						add(Frame.getBtnNo());
						repaint();
					}

				}
		}
	}

	/**
	 * 
	 * @author Alessandro
	 * 
	 *         This is the ActionListener implemented by the Timer
	 */
	private class TimerListener implements ActionListener {

		/**
		 * after the between-event delay, this method resets the images of the
		 * buttons to their back image, then it stops the timer
		 */

		public void actionPerformed(ActionEvent e) {
			button1.setIcon(iconarray[10]);
			button2.setIcon(iconarray[10]);
			timer1.stop();
		}
	}
}
