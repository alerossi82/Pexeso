package GUI;

import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

/**
 * 
 * @author Alessandro
 * 
 *         This class defines the panel displaying the points for player 1 and
 *         player 2
 */
public class PointsPanel extends JPanel {

	private final JLabel points1;
	private final JLabel points2;
	private final JLabel player1;
	private final JLabel player2;

	/**
	 * Constructor
	 * 
	 * The layout for this panel is a grid 2x2
	 */
	public PointsPanel() {
		setBounds(1020, 373, 152, 58);
		setForeground(Color.WHITE);
		setBackground(Color.LIGHT_GRAY);
		setBorder(new EmptyBorder(0, 0, 0, 0));
		setLayout(new GridLayout(2, 2, 0, 0));

		player1 = new JLabel("Player 1");
		player1.setHorizontalAlignment(SwingConstants.CENTER);
		player1.setFont(new Font("Tahoma", Font.PLAIN, 16));
		player1.setBackground(Color.WHITE);
		add(player1);

		player2 = new JLabel("Player 2");
		player2.setHorizontalAlignment(SwingConstants.CENTER);
		player2.setFont(new Font("Tahoma", Font.PLAIN, 16));
		player2.setBackground(Color.WHITE);
		add(player2);

		points1 = new JLabel("0");
		points1.setHorizontalAlignment(SwingConstants.CENTER);
		points1.setForeground(Color.RED);
		points1.setFont(new Font("Tahoma", Font.PLAIN, 16));
		points1.setBackground(Color.WHITE);
		add(points1);

		points2 = new JLabel("0");
		points2.setHorizontalAlignment(SwingConstants.CENTER);
		points2.setForeground(Color.RED);
		points2.setFont(new Font("Tahoma", Font.PLAIN, 16));
		points2.setBackground(Color.WHITE);
		add(points2);
	}

	/**
	 * 
	 * @return
	 * 
	 * 		The getters are used to pass the values of points1 and points2 to
	 *         MainWindow
	 */
	public JLabel getLabel1() {
		return points1;
	}

	public JLabel getLabel2() {
		return points2;
	}

}
