package it.unipv.po.edicola.view.frame;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import it.unipv.po.edicola.view.panel.JPanelRefound;

public class JFrameRefound extends JFrame {
	private static final long serialVersionUID = -5225492347445480118L;
	private JPanel contentPane;

	/**
	 * Create the frame.
	 */
	public JFrameRefound() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanelRefound();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
	}

}
