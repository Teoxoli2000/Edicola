package it.unipv.po.edicola.view.panel;

import java.awt.TextArea;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSpinner;
import javax.swing.JTextField;

public class JPanelRefound extends JPanel {
	private static final long serialVersionUID = -2126714936441635646L;

	/**
	 * Create the panel.
	 */
	public JPanelRefound() {
			setLayout(null);
			
			JTextField textField = new JTextField();
			textField.setBounds(176, 8, 145, 20);
			add(textField);
			textField.setColumns(10);
			
			JLabel lblNewLabel = new JLabel("Inserisci i prodotti da rimborsare");
			lblNewLabel.setBounds(10, 11, 171, 14);
			add(lblNewLabel);
			
			JSpinner spinner = new JSpinner();
			spinner.setBounds(371, 8, 46, 20);
			add(spinner);
			
			JLabel lblQt = new JLabel("qt\u00E0");
			lblQt.setBounds(347, 11, 30, 14);
			add(lblQt);
			
			JLabel lblNewLabel_1 = new JLabel("Carrello");
			lblNewLabel_1.setBounds(23, 52, 46, 14);
			add(lblNewLabel_1);
			
			TextArea textArea = new TextArea();
			textArea.setBounds(23, 72, 395, 160);
			add(textArea);
			
			JButton btnNewButton = new JButton("Pagamento");
			btnNewButton.setBounds(328, 266, 89, 23);
			add(btnNewButton);
			
			JButton btnAggiungi = new JButton("Aggiungi");
			btnAggiungi.setBounds(328, 36, 89, 23);
			add(btnAggiungi);
			
			JLabel lblNewLabel_2 = new JLabel("Totale");
			lblNewLabel_2.setBounds(273, 238, 46, 14);
			add(lblNewLabel_2);
			
			JLabel lblNewLabel_3 = new JLabel("0");
			lblNewLabel_3.setBounds(328, 238, 46, 14);
			add(lblNewLabel_3);
			

		}
}