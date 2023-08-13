package it.unipv.po.edicola.view.frame;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import it.unipv.po.edicola.view.panel.JPanelMoveProduct;

public class JFrameMoveProduct extends JFrame {
	private static final long serialVersionUID = -6762545663528296829L;
	private JPanel contentPane;

	/**
	 * Create the frame.
	 */
	public JFrameMoveProduct() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 450, 163);
		contentPane = new JPanelMoveProduct();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
	}

}
