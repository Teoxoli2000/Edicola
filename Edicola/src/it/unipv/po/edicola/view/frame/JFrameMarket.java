package it.unipv.po.edicola.view.frame;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import it.unipv.po.edicola.view.panel.JPanelMarket;

public class JFrameMarket extends JFrame {
	private static final long serialVersionUID = -3871936880964410879L;
	private JPanel contentPane;

	/**
	 * Create the frame.
	 */
	public JFrameMarket() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 561, 364);
		contentPane = new JPanelMarket();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
	}

}
