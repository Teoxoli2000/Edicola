package it.unipv.po.edicola.view.panel;


import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import java.awt.Color;
import java.awt.TextArea;

public class JPanelSupplier extends JPanel {
	private static final long serialVersionUID = -2126714936441635646L;

	/**
	 * Create the panel.
	 */
	public JPanelSupplier() {
			setLayout(null);
			
			JTextField textField = new JTextField();
			textField.setBounds(133, 8, 181, 20);
			add(textField);
			textField.setColumns(10);

			JButton btnAggiungi = new JButton("Cerca");
			btnAggiungi.setBounds(329, 8, 89, 23);
			add(btnAggiungi);
			
			JLabel lblFindSupplier = new JLabel("Cerca Fornitore\r\n");
			lblFindSupplier.setBounds(37, 8, 86, 14);
			add(lblFindSupplier);
			
			
			JLabel lblNewLabel = new JLabel("Codice Fornitore");
			lblNewLabel.setBounds(37, 46, 86, 14);
			add(lblNewLabel);
			
			JLabel lblNome = new JLabel("Nome");
			lblNome.setBounds(37, 61, 86, 14);
			add(lblNome);
			
			JLabel lblNome_1 = new JLabel("Numero di telefono");
			lblNome_1.setBounds(37, 76, 105, 14);
			add(lblNome_1);
			
			JLabel lblNome_1_1 = new JLabel("Indirizzo");
			lblNome_1_1.setBounds(37, 91, 86, 14);
			add(lblNome_1_1);
			
			JLabel lblNewLabel_1 = new JLabel("null");
			lblNewLabel_1.setForeground(new Color(0, 128, 0));
			lblNewLabel_1.setBounds(143, 46, 86, 14);
			add(lblNewLabel_1);
			
			JLabel lblNewLabel_1_1 = new JLabel("null");
			lblNewLabel_1_1.setForeground(new Color(0, 128, 0));
			lblNewLabel_1_1.setBounds(143, 61, 86, 14);
			add(lblNewLabel_1_1);
			
			JLabel lblNewLabel_1_1_1 = new JLabel("null");
			lblNewLabel_1_1_1.setForeground(new Color(0, 128, 0));
			lblNewLabel_1_1_1.setBounds(143, 76, 86, 14);
			add(lblNewLabel_1_1_1);
			
			JLabel lblNewLabel_1_1_1_1 = new JLabel("null");
			lblNewLabel_1_1_1_1.setForeground(new Color(0, 128, 0));
			lblNewLabel_1_1_1_1.setBounds(143, 91, 86, 14);
			add(lblNewLabel_1_1_1_1);
			
			TextArea textArea = new TextArea();
			textArea.setEditable(false);
			textArea.setBounds(37, 123, 381, 148);
			add(textArea);
			
			JLabel lblNome_1_1_1 = new JLabel("Prodotti forniti");
			lblNome_1_1_1.setBounds(37, 106, 86, 14);
			add(lblNome_1_1_1);
			
			JLabel lblNewLabel_2 = new JLabel("Nessun Fornitore trovato");
			lblNewLabel_2.setForeground(new Color(255, 0, 0));
			lblNewLabel_2.setBounds(288, 39, 130, 14);
			add(lblNewLabel_2);
			

		}
}
