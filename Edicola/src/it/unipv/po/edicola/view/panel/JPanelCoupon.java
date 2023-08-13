package it.unipv.po.edicola.view.panel;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JCheckBox;
import java.awt.TextArea;

public class JPanelCoupon extends JPanel {
	private static final long serialVersionUID = -2126714936441635646L;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;

	/**
	 * Create the panel.
	 */
	public JPanelCoupon() {
			setLayout(null);
			
			JTextField textField = new JTextField();
			textField.setBounds(147, 8, 167, 20);
			add(textField);
			textField.setColumns(10);
			
			JLabel lblNewLabel = new JLabel("Inserisci il codice sconto");
			lblNewLabel.setBounds(20, 11, 171, 14);
			add(lblNewLabel);
			
			JButton btnAggiungi = new JButton("+");
			btnAggiungi.setBounds(328, 7, 41, 23);
			add(btnAggiungi);
			
			JLabel lblNewLabel_4 = new JLabel("Periodo di validit\u00E0");
			lblNewLabel_4.setBounds(20, 70, 89, 14);
			add(lblNewLabel_4);
			
			textField_1 = new JTextField();
			textField_1.setBounds(147, 39, 53, 20);
			add(textField_1);
			textField_1.setColumns(10);
			
			JLabel lblNewLabel_4_1 = new JLabel("Inserisci lo sconto");
			lblNewLabel_4_1.setBounds(20, 39, 89, 14);
			add(lblNewLabel_4_1);
			
			textField_2 = new JTextField();
			textField_2.setColumns(10);
			textField_2.setBounds(147, 67, 63, 20);
			add(textField_2);
			
			textField_3 = new JTextField();
			textField_3.setColumns(10);
			textField_3.setBounds(251, 67, 63, 20);
			add(textField_3);
			
			JCheckBox chckbxNewCheckBox = new JCheckBox("Ad uso singolo");
			chckbxNewCheckBox.setBounds(320, 66, 97, 23);
			add(chckbxNewCheckBox);
			
			textField_4 = new JTextField();
			textField_4.setColumns(10);
			textField_4.setBounds(147, 98, 167, 20);
			add(textField_4);
			
			JLabel lblNewLabel_4_2 = new JLabel("Valido sul Prodotto");
			lblNewLabel_4_2.setBounds(20, 101, 117, 14);
			add(lblNewLabel_4_2);
			
			TextArea textArea = new TextArea();
			textArea.setBounds(20, 148, 397, 136);
			add(textArea);
			
			JLabel lblNewLabel_4_2_1 = new JLabel("Coupon aggiunto con successo");
			lblNewLabel_4_2_1.setBounds(251, 39, 171, 14);
			add(lblNewLabel_4_2_1);
			
			JButton btnAggiungi_1 = new JButton("-");
			btnAggiungi_1.setBounds(376, 7, 41, 23);
			add(btnAggiungi_1);
			
			JLabel lblNewLabel_4_2_2 = new JLabel("Coupon attivi");
			lblNewLabel_4_2_2.setBounds(20, 128, 117, 14);
			add(lblNewLabel_4_2_2);
			

		}
}