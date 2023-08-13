package it.unipv.po.edicola.view.panel;

import java.awt.TextArea;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import java.awt.Color;

public class JPanelInventory extends JPanel {
	private static final long serialVersionUID = -2126714936441635646L;

	/**
	 * Create the panel.
	 */
	public JPanelInventory() {
			setLayout(null);
			
			JTextField textField = new JTextField();
			textField.setBounds(177, 8, 145, 20);
			add(textField);
			textField.setColumns(10);
			
			JLabel lblNewLabel = new JLabel("Inserisci il prodotto da cercare\r\n\r\n");
			lblNewLabel.setBounds(23, 11, 150, 14);
			add(lblNewLabel);
			
			JButton btnAggiungi = new JButton("Cerca");
			btnAggiungi.setBounds(332, 7, 89, 23);
			add(btnAggiungi);
			
			TextArea textArea = new TextArea();
			textArea.setBounds(23, 90, 398, 183);
			add(textArea);
			
			JLabel lblNewLabel_1 = new JLabel("Prodotto non disponibile in negozio, fornitori che lo forniscono: ");
			lblNewLabel_1.setEnabled(false);
			lblNewLabel_1.setForeground(Color.RED);
			lblNewLabel_1.setBounds(23, 70, 304, 14);
			add(lblNewLabel_1);
			

		}
}