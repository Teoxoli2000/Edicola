package it.unipv.po.edicola.view.panel;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSpinner;
import javax.swing.JTextField;

public class JPanelMoveProduct extends JPanel {
	private static final long serialVersionUID = -2126714936441635646L;
	private JTextField textField_1;
	private JTextField textField_2;

	/**
	 * Create the panel.
	 */
	public JPanelMoveProduct() {
			setLayout(null);
			
			JTextField textField = new JTextField();
			textField.setBounds(176, 8, 145, 20);
			add(textField);
			textField.setColumns(10);
			
			JLabel lblNewLabel = new JLabel("Inserisci l'articolo da spostare\r\n");
			lblNewLabel.setBounds(10, 11, 171, 14);
			add(lblNewLabel);
			
			JSpinner spinner = new JSpinner();
			spinner.setBounds(371, 8, 46, 20);
			add(spinner);
			
			JLabel lblQt = new JLabel("qt\u00E0");
			lblQt.setBounds(347, 11, 30, 14);
			add(lblQt);
			
			JButton btnSposta = new JButton("Sposta\r\n");
			btnSposta.setBounds(328, 36, 89, 23);
			add(btnSposta);
			
			textField_1 = new JTextField();
			textField_1.setColumns(10);
			textField_1.setBounds(75, 78, 155, 20);
			add(textField_1);
			
			textField_2 = new JTextField();
			textField_2.setColumns(10);
			textField_2.setBounds(253, 78, 164, 20);
			add(textField_2);
			
			JLabel lblSpostaloDa = new JLabel("Spostalo da\n");
			lblSpostaloDa.setBounds(10, 81, 89, 14);
			add(lblSpostaloDa);
			
			JLabel lblA = new JLabel("a\r\n");
			lblA.setBounds(243, 81, 11, 14);
			add(lblA);
			

		}
}


