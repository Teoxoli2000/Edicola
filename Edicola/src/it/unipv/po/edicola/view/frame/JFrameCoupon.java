package it.unipv.po.edicola.view.frame;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import it.unipv.po.edicola.view.panel.JPanelCoupon;

public class JFrameCoupon extends JFrame {

	private static final long serialVersionUID = 6399689781269656014L;
	private JPanel contentPane;


	/**
	 * Create the frame.
	 */
	public JFrameCoupon() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 484, 331);
		contentPane = new JPanelCoupon();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
	}

}
