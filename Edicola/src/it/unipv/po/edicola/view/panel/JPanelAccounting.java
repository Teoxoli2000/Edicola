package it.unipv.po.edicola.view.panel;

import javax.swing.JPanel;
import javax.swing.border.BevelBorder;
import java.awt.TextArea;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JLabel;
import java.awt.Color;

public class JPanelAccounting extends JPanel {
	private static final long serialVersionUID = 1L;
	private JTextField textField;
	private JTextField textField_1;

	/**
	 * Create the panel.
	 */
	public JPanelAccounting() {
		setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(0, 0, 450, 1);
		panel.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		add(panel);
		panel.setLayout(null);
		
		TextArea textArea = new TextArea();
		textArea.setBounds(10, 79, 210, 211);
		textArea.setForeground(new Color(0, 128, 0));
		textArea.setEditable(false);
		add(textArea);
		
		textField = new JTextField();
		textField.setBounds(240, 13, 78, 20);
		add(textField);
		textField.setColumns(10);
		
		JButton btnNewButton = new JButton("Ricerca");
		btnNewButton.setBounds(328, 12, 89, 23);
		add(btnNewButton);
		
		textField_1 = new JTextField();
		textField_1.setBounds(152, 13, 78, 20);
		textField_1.setColumns(10);
		add(textField_1);
		
		JLabel lblNewLabel = new JLabel("Inserisci periodo di ricerca");
		lblNewLabel.setBounds(10, 16, 155, 14);
		add(lblNewLabel);
		
		TextArea textArea_1 = new TextArea();
		textArea_1.setBounds(226, 79, 210, 211);
		textArea_1.setForeground(new Color(255, 0, 0));
		textArea_1.setEditable(false);
		add(textArea_1);
		
		JLabel lblEntrate = new JLabel("Entrate");
		lblEntrate.setBounds(10, 59, 155, 14);
		lblEntrate.setForeground(new Color(0, 128, 0));
		add(lblEntrate);
		
		JLabel lblNewLabel_1_1 = new JLabel("Uscite");
		lblNewLabel_1_1.setBounds(226, 59, 155, 14);
		lblNewLabel_1_1.setForeground(new Color(255, 0, 0));
		add(lblNewLabel_1_1);
		
		TextArea textArea_1_1 = new TextArea();
		textArea_1_1.setBounds(442, 79, 210, 211);
		textArea_1_1.setForeground(Color.RED);
		textArea_1_1.setEditable(false);
		add(textArea_1_1);
		
		JLabel lblNewLabel_1_1_1 = new JLabel("Rimborsi");
		lblNewLabel_1_1_1.setBounds(442, 59, 155, 14);
		lblNewLabel_1_1_1.setForeground(new Color(0, 0, 255));
		add(lblNewLabel_1_1_1);

	}
}
