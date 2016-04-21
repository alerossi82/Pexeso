package GUI;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import javax.swing.JButton;
import javax.swing.JFrame;

/**
 * 
 * @author Alessandro
 * 
 *         This class creates a non-resizable JFrame A new MainWindow (Jpanel)
 *         is created an added to the frame
 * 
 *         Within this class, we also define two JButtons implementing the
 *         methods to start a new game or exit the application:
 * 
 *         These buttons are not added to the JFrame but they will be added to
 *         the MainWindow panel using their Getters
 */
public class Frame extends JFrame {

	private static JButton btnYes;
	private static JButton btnNo;

	public Frame() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1204, 908);
		setResizable(false);

		btnYes = new JButton("YES");
		btnYes.setBounds(450, 700, 97, 25);
		btnYes.addActionListener(new ButtonListener());

		btnNo = new JButton("NO");
		btnNo.setBounds(650, 700, 97, 25);
		btnNo.addActionListener(new ButtonListener());

		try {
			getContentPane().add(new MainWindow());
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static JButton getBtnYes() {
		return btnYes;
	}

	public static JButton getBtnNo() {
		return btnNo;
	}

	/**
	 * 
	 * @author Alessandro
	 * 
	 *         This is the ActionListener for BtnYes and BtnNo
	 * 
	 *         - btnYEs= removes all the content inside the frame and creates a
	 *         new instance of MainWindow
	 * 
	 *         - btnNo= exit the application
	 *
	 */

	private class ButtonListener implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent event) {
			if (event.getSource() == btnNo) {
				System.exit(0);
			}
			if (event.getSource() == btnYes) {
				getContentPane().removeAll();
				try {
					getContentPane().add(new MainWindow());
				} catch (IOException e) {
					e.printStackTrace();
				}
				revalidate();
				repaint();
			}
		}
	}
}
