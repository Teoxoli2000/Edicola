package it.unipv.po.edicola.view.panel;

import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SpinnerNumberModel;
import javax.swing.JLabel;
import javax.swing.JSpinner;
import java.awt.TextArea;

import javax.swing.JButton;
import java.awt.Color;
import javax.swing.JRadioButton;
import javax.swing.JRadioButtonMenuItem;
import javax.swing.JComboBox;
import javax.swing.SwingConstants;


public class JPanelBuy extends JPanel {
	
	private static final long serialVersionUID = -4758440369172888429L;
	private JTextField productTxtField;
	private JSpinner nProductSpin;
	private TextArea shopingCartTxt;
	private JButton addProductBtn;
	private JButton doTransactionBtn;
	private JLabel totalTxt;
	private JComboBox<String> prodComboBox;
	private JComboBox<String> locComboBox;
	private JComboBox<String> dateComboBox;
	private JButton searchBtnS;
	private JButton btnAnnulla;
	private JLabel lblNewLabel_3_2;
	private JTextField textField;
	private JTextField textField_1;
	private JLabel lblNewLabel_3_3;


	/**
	 * Create the panel.
	 */
	public JPanelBuy() {
		setLayout(null);
		
		productTxtField = new JTextField();
		productTxtField.setBounds(135, 8, 287, 20);
		add(productTxtField);
		productTxtField.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("Cerca prodotti");
		lblNewLabel.setBounds(23, 11, 171, 14);
		add(lblNewLabel);
		
		nProductSpin = new JSpinner();
		nProductSpin.setBounds(432, 40, 46, 20);
		nProductSpin.setModel(new SpinnerNumberModel(1, 0, 1000, 1));
		add(nProductSpin);
		
		JLabel lblQt = new JLabel("qt\u00E0");
		lblQt.setBounds(405, 43, 30, 14);
		add(lblQt);
		
		JLabel lblNewLabel_1 = new JLabel("Carrello");
		lblNewLabel_1.setBounds(23, 162, 46, 14);
		add(lblNewLabel_1);
		
		shopingCartTxt = new TextArea();
		shopingCartTxt.setBounds(23, 182, 510, 160);
		add(shopingCartTxt);
		
		doTransactionBtn = new JButton("Fai la transazione");
		doTransactionBtn.setBounds(231, 358, 146, 23);
		add(doTransactionBtn);
		
		addProductBtn = new JButton("+");
		addProductBtn.setBounds(432, 135, 101, 23);
		add(addProductBtn);
		
		JLabel lblNewLabel_2 = new JLabel("Totale");
		lblNewLabel_2.setBounds(23, 362, 46, 14);
		add(lblNewLabel_2);
		
		totalTxt = new JLabel("0");
		totalTxt.setBounds(79, 362, 89, 14);
		add(totalTxt);
		
		prodComboBox = new JComboBox<String>();
		prodComboBox.setBounds(135, 39, 112, 22);
		add(prodComboBox);
		
		locComboBox = new JComboBox<String>();
		locComboBox.setBounds(283, 39, 112, 22);
		add(locComboBox);
		
		searchBtnS = new JButton("Cerca");
		searchBtnS.setBounds(432, 7, 101, 23);
		add(searchBtnS);
		
		JLabel lblNewLabel_3 = new JLabel("Inserisci prodotto");
		lblNewLabel_3.setBounds(23, 43, 102, 14);
		add(lblNewLabel_3);
		
		JLabel lblNewLabel_5 = new JLabel("in");
		lblNewLabel_5.setBounds(264, 43, 19, 14);
		add(lblNewLabel_5);
		
		JLabel lblNewLabel_3_1 = new JLabel("Rivista del");
		lblNewLabel_3_1.setBounds(23, 76, 102, 14);
		add(lblNewLabel_3_1);
		
		dateComboBox = new JComboBox<String>();
		dateComboBox.setBounds(135, 72, 112, 22);
		add(dateComboBox);
		
		btnAnnulla = new JButton("Annulla Transazione");
		btnAnnulla.setBounds(387, 358, 146, 23);
		add(btnAnnulla);
		
		lblNewLabel_3_2 = new JLabel("Prezzo");
		lblNewLabel_3_2.setBounds(23, 106, 102, 14);
		add(lblNewLabel_3_2);
		
		textField = new JTextField();
		textField.setEditable(false);
		textField.setColumns(10);
		textField.setBounds(135, 105, 287, 20);
		add(textField);
		
		textField_1 = new JTextField();
		textField_1.setEditable(false);
		textField_1.setColumns(10);
		textField_1.setBounds(135, 136, 287, 20);
		add(textField_1);
		
		lblNewLabel_3_3 = new JLabel("Nome del Fornitore");
		lblNewLabel_3_3.setBounds(23, 137, 102, 14);
		add(lblNewLabel_3_3);
		
		JRadioButton rdbtnNewRadioButton = new JRadioButton("Nuovo Prodotto");
		rdbtnNewRadioButton.setBounds(432, 72, 109, 23);
		add(rdbtnNewRadioButton);
		
	}

	/**
	 * @return the dateComboBox
	 */
	public JComboBox<String> getDateComboBox() {
		return dateComboBox;
	}

	/**
	 * @param dateComboBox the dateComboBox to set
	 */
	public void setDateComboBox(JComboBox<String> dateComboBox) {
		this.dateComboBox = dateComboBox;
	}

	/**
	 * @return the prodComboBox
	 */
	public JComboBox<String> getProdComboBox() {
		return prodComboBox;
	}

	/**
	 * @param prodComboBox the prodComboBox to set
	 */
	public void setProdComboBox(JComboBox<String> prodComboBox) {
		this.prodComboBox = prodComboBox;
	}

	/**
	 * @return the locComboBox
	 */
	public JComboBox<String> getLocComboBox() {
		return locComboBox;
	}

	/**
	 * @param locComboBox the locComboBox to set
	 */
	public void setLocComboBox(JComboBox<String> locComboBox) {
		this.locComboBox = locComboBox;
	}

	/**
	 * @return the productTxtField
	 */
	public JTextField getProductTxtField() {
		return productTxtField;
	}

	/**
	 * @param productTxtField the productTxtField to set
	 */
	public void setProductTxtField(JTextField productTxtField) {
		this.productTxtField = productTxtField;
	}

	/**
	 * @return the nProductSpin
	 */
	public JSpinner getnProductSpin() {
		return nProductSpin;
	}

	/**
	 * @param nProductSpin the nProductSpin to set
	 */
	public void setnProductSpin(JSpinner nProductSpin) {
		this.nProductSpin = nProductSpin;
	}

	/**
	 * @return the shopingCartTxt
	 */
	public TextArea getShopingCartTxt() {
		return shopingCartTxt;
	}

	/**
	 * @param shopingCartTxt the shopingCartTxt to set
	 */
	public void setShopingCartTxt(TextArea shopingCartTxt) {
		this.shopingCartTxt = shopingCartTxt;
	}

	/**
	 * @return the addProductBtn
	 */
	public JButton getAddProductBtn() {
		return addProductBtn;
	}

	/**
	 * @param addProductBtn the addProductBtn to set
	 */
	public void setAddProductBtn(JButton addProductBtn) {
		this.addProductBtn = addProductBtn;
	}

	/**
	 * @return the doTransactionBtn
	 */
	public JButton getDoTransactionBtn() {
		return doTransactionBtn;
	}

	/**
	 * @param doTransactionBtn the doTransactionBtn to set
	 */
	public void setDoTransactionBtn(JButton doTransactionBtn) {
		this.doTransactionBtn = doTransactionBtn;
	}


	/**
	 * @return the totalTxt
	 */
	public JLabel getTotalTxt() {
		return totalTxt;
	}

	/**
	 * @param totalTxt the totalTxt to set
	 */
	public void setTotalTxt(JLabel totalTxt) {
		this.totalTxt = totalTxt;
	}

	/**
	 * @return the searchBtnS
	 */
	public JButton getSearchBtnS() {
		return searchBtnS;
	}

	/**
	 * @param searchBtnS the searchBtnS to set
	 */
	public void setSearchBtnS(JButton searchBtnS) {
		this.searchBtnS = searchBtnS;
	}
}

