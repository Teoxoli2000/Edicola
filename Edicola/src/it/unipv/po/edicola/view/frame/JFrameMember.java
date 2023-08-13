package it.unipv.po.edicola.view.frame;

import javax.swing.JFrame;
import javax.swing.border.EmptyBorder;

import it.unipv.po.edicola.view.panel.JPanelMember;

public class JFrameMember extends JFrame {
	private static final long serialVersionUID = 6033565453026948809L;
	
	/*
	 * Create the frame.
	 */
	public JFrameMember() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 450, 330);
		JPanelMember panel = new JPanelMember();
		panel.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(panel);
	}
}
