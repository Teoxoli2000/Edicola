package it.unipv.po.edicola.view.panel;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import java.awt.Color;
import java.awt.TextArea;

public class JPanelMember extends JPanel {
	private static final long serialVersionUID = -2126714936441635646L;
	private JTextField textEmail;
	private JTextField textName;
	private JButton btnSearch;
	private TextArea textArea;
	private JButton btnAdd;
	private JButton btnRemove;
	private JLabel lblError;
	private JTextField textID;

	/**
	 * Create the panel.
	 */
	public JPanelMember() {
			setLayout(null);
			
			textName = new JTextField();
			textName.setBounds(68, 8, 251, 20);
			add(textName);
			textName.setColumns(10);
			
			JLabel lblFindSupplier = new JLabel("Nome");
			lblFindSupplier.setBounds(25, 11, 98, 14);
			add(lblFindSupplier);
			
			JLabel lblListSuppliers = new JLabel("Elenco Abbonati\r\n");
			lblListSuppliers.setForeground(new Color(0, 0, 0));
			lblListSuppliers.setBounds(25, 116, 104, 14);
			add(lblListSuppliers);
			
			btnSearch = new JButton("Cerca");
			btnSearch.setBounds(329, 38, 89, 23);
			add(btnSearch);
			
			textArea = new TextArea();
			textArea.setEditable(false);
			textArea.setBounds(25, 136, 393, 127);
			add(textArea);
			
			btnAdd = new JButton("+");
			btnAdd.setBackground(new Color(0, 128, 0));
			btnAdd.setBounds(329, 66, 41, 23);
			add(btnAdd);
			
			
			btnRemove = new JButton("-");
			btnRemove.setBackground(new Color(255, 0, 0));
			btnRemove.setBounds(380, 66, 38, 23);
			add(btnRemove);
			
			lblError = new JLabel("");
			lblError.setForeground(Color.RED);
			lblError.setBounds(25, 100, 393, 14);
			add(lblError);
			
			JLabel lblEmail = new JLabel("E-Mail");
			lblEmail.setBounds(25, 70, 98, 14);
			add(lblEmail);
			
			textEmail = new JTextField();
			textEmail.setColumns(10);
			textEmail.setBounds(68, 67, 251, 20);
			add(textEmail);
			
			JLabel lblId = new JLabel("ID");
			lblId.setBounds(25, 42, 98, 14);
			add(lblId);
			
			textID = new JTextField();
			textID.setColumns(10);
			textID.setBounds(68, 39, 251, 20);
			add(textID);
		}

	/**
	 * @return the textEmail
	 */
	public JTextField getTextEmail() {
		return textEmail;
	}

	/**
	 * @return the textName
	 */
	public JTextField getTextName() {
		return textName;
	}

	/**
	 * @return the btnSearch
	 */
	public JButton getBtnSearch() {
		return btnSearch;
	}

	/**
	 * @return the textArea
	 */
	public TextArea getTextArea() {
		return textArea;
	}

	/**
	 * @return the btnAdd
	 */
	public JButton getBtnAdd() {
		return btnAdd;
	}

	/**
	 * @return the btnRemove
	 */
	public JButton getBtnRemove() {
		return btnRemove;
	}

	/**
	 * @return the lblError
	 */
	public JLabel getLblError() {
		return lblError;
	}

	/**
	 * @return the textID
	 */
	public JTextField getTextID() {
		return textID;
	}
	
}
