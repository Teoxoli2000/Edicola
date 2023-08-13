package it.unipv.po.edicola.view.frame;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import it.unipv.po.edicola.view.panel.JPanelBuy;

public class JFrameBuy extends JFrame {
	private static final long serialVersionUID = -6442431985870502689L;
	private JPanel contentPane;

	/**
	 * Create the frame.
	 */
	public JFrameBuy() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 507, 300);
		contentPane = new JPanelBuy();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
	}

}
