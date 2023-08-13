package it.unipv.po.edicola.view.panel;

import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JSpinner;
import java.awt.TextArea;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;


public class JPanelSell extends JPanel {
	
	private static final long serialVersionUID = -4758440369172888429L;
	private JTextField textField;
	private JTextField textField_1;
	/**
	 * Create the panel.
	 */
	public JPanelSell() {
		setLayout(null);
		
		textField = new JTextField();
		textField.setBounds(204, 8, 191, 20);
		add(textField);
		textField.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("Inserisci i prodotti da vendere");
		lblNewLabel.setBounds(23, 11, 171, 14);
		add(lblNewLabel);
		
		JSpinner spinner = new JSpinner();
		spinner.setBounds(475, 8, 46, 20);
		add(spinner);
		
		JLabel lblQt = new JLabel("qt\u00E0");
		lblQt.setBounds(435, 11, 30, 14);
		add(lblQt);
		
		JLabel lblNewLabel_1 = new JLabel("Carrello");
		lblNewLabel_1.setBounds(23, 52, 46, 14);
		add(lblNewLabel_1);
		
		TextArea textArea = new TextArea();
		textArea.setBounds(23, 72, 498, 160);
		add(textArea);
		
		JButton btnNewButton = new JButton("Pagamento");
		btnNewButton.setBounds(432, 266, 89, 23);
		add(btnNewButton);
		
		JButton btnAggiungi = new JButton("Aggiungi");
		btnAggiungi.setBounds(432, 37, 89, 23);
		add(btnAggiungi);
		
		JLabel lblNewLabel_2 = new JLabel("Totale");
		lblNewLabel_2.setBounds(419, 241, 46, 14);
		add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("0");
		lblNewLabel_3.setBounds(475, 241, 46, 14);
		add(lblNewLabel_3);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(100, 241, 112, 20);
		add(textField_1);
		
		JButton btnNewButton_1 = new JButton("Usa");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnNewButton_1.setBounds(123, 266, 89, 23);
		add(btnNewButton_1);
		
		JLabel lblNewLabel_4 = new JLabel("Codice Sconto");
		lblNewLabel_4.setBounds(23, 244, 112, 14);
		add(lblNewLabel_4);
		
		JLabel lblNewLabel_5 = new JLabel("Valido");
		lblNewLabel_5.setForeground(new Color(0, 128, 0));
		lblNewLabel_5.setBounds(222, 244, 46, 14);
		add(lblNewLabel_5);
		

	}
}

