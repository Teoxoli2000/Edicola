package it.unipv.po.edicola.view.frame;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import it.unipv.po.edicola.view.panel.JPanelAccounting;

public class JFrameAccounting extends JFrame {
	private static final long serialVersionUID = 2735773352202980401L;
	private JPanel contentPane;

	/**
	 * Create the frame.
	 */
	public JFrameAccounting() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 689, 346);
		contentPane = new JPanelAccounting();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
	}
}
