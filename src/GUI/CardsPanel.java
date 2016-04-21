package GUI;

import java.awt.Color;
import java.awt.GridLayout;

import javax.swing.JPanel;

/**
 * 
 * @author Alessandro 
 * 
 * This class creates the panel that will receive the
 *         JButtons
 */
public class CardsPanel extends JPanel {

	/**
	 * Constructor
	 * 
	 * The layout is a grid 5x4, that will be populated automatically with JButtons
	 */
	public CardsPanel() {
		setBounds(44, 13, 950, 837);
		setBackground(Color.GREEN);
		setLayout(new GridLayout(5, 4, 5, 5));
	}

}
