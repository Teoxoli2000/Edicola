package it.unipv.po.edicola.view.panel;

import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SpinnerNumberModel;
import javax.swing.JLabel;
import javax.swing.JSpinner;
import java.awt.TextArea;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import java.awt.Color;
import javax.swing.JRadioButton;
import javax.swing.JRadioButtonMenuItem;
import javax.swing.JComboBox;
import javax.swing.SwingConstants;


public class JPanelMarket extends JPanel {
	
	private static final long serialVersionUID = -4758440369172888429L;
	private JTextField productTxtField;
	private JTextField couponTxtField;
	private JSpinner nProductSpin;
	private TextArea shopingCartTxt;
	private JButton addProductBtn;
	private JButton doTransactionBtn;
	private JButton addCouponBtn;
	private JLabel totalTxt;
	private JLabel couponInfTxt;
	private JRadioButton sellRBtn;
	private JRadioButton refundRBtn;
	private JComboBox<String> prodComboBox;
	private JComboBox<String> locComboBox;
	private JComboBox<String> dateComboBox;
	private JButton searchBtnS;
	private JButton cancelBtn;



	/**
	 * Create the panel.
	 */
	public JPanelMarket() {
		setLayout(null);
		
		productTxtField = new JTextField();
		productTxtField.setBounds(135, 8, 287, 20);
		add(productTxtField);
		productTxtField.setColumns(10);
		
		couponTxtField = new JTextField();
		couponTxtField.setColumns(10);
		couponTxtField.setBounds(100, 314, 112, 20);
		add(couponTxtField);
		
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
		lblNewLabel_1.setBounds(23, 131, 46, 14);
		add(lblNewLabel_1);
		
		shopingCartTxt = new TextArea();
		shopingCartTxt.setBounds(23, 151, 498, 160);
		add(shopingCartTxt);
		
		doTransactionBtn = new JButton("Fai la transazione");
		doTransactionBtn.setBounds(367, 336, 146, 23);
		add(doTransactionBtn);
		
		addProductBtn = new JButton("+");
		addProductBtn.setBounds(488, 39, 45, 23);
		add(addProductBtn);

		addCouponBtn = new JButton("Usa");
		addCouponBtn.setBounds(123, 336, 89, 23);
		add(addCouponBtn);
		
		JLabel lblNewLabel_2 = new JLabel("Totale");
		lblNewLabel_2.setBounds(367, 317, 46, 14);
		add(lblNewLabel_2);
		
		totalTxt = new JLabel("0");
		totalTxt.setBounds(405, 317, 89, 14);
		add(totalTxt);
		
		JLabel lblNewLabel_4 = new JLabel("Codice Sconto");
		lblNewLabel_4.setBounds(23, 317, 78, 14);
		add(lblNewLabel_4);
		
		couponInfTxt = new JLabel("Nessun codice inserito");
		couponInfTxt.setForeground(new Color(255, 128, 64));
		couponInfTxt.setBounds(222, 317, 135, 14);
		add(couponInfTxt);
		
		refundRBtn = new JRadioButton("Rimborso");
		refundRBtn.setBounds(135, 102, 78, 23);
		add(refundRBtn);
		
		sellRBtn = new JRadioButton("Vendita");
		sellRBtn.setBounds(222, 102, 78, 23);
		add(sellRBtn);
		sellRBtn.setSelected(true);
		
		JLabel lblNewLabel_6 = new JLabel("Tipo");
		lblNewLabel_6.setBounds(23, 106, 46, 14);
		add(lblNewLabel_6);
		
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
		
		cancelBtn = new JButton("Annulla Transazione");
		cancelBtn.setBounds(367, 363, 146, 23);
		add(cancelBtn);
		
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
	 * @return the couponTxtField
	 */
	public JTextField getCouponTxtField() {
		return couponTxtField;
	}

	/**
	 * @param couponTxtField the couponTxtField to set
	 */
	public void setCouponTxtField(JTextField couponTxtField) {
		this.couponTxtField = couponTxtField;
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
	 * @return the addCouponBtn
	 */
	public JButton getAddCouponBtn() {
		return addCouponBtn;
	}

	/**
	 * @param addCouponBtn the addCouponBtn to set
	 */
	public void setAddCouponBtn(JButton addCouponBtn) {
		this.addCouponBtn = addCouponBtn;
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
	 * @return the couponInfTxt
	 */
	public JLabel getCouponInfTxt() {
		return couponInfTxt;
	}

	/**
	 * @param couponInfTxt the couponInfTxt to set
	 */
	public void setCouponInfTxt(JLabel couponInfTxt) {
		this.couponInfTxt = couponInfTxt;
	}

	/**
	 * @return the sellRBtn
	 */
	public JRadioButton getSellRBtn() {
		return sellRBtn;
	}

	/**
	 * @param sellRBtn the sellRBtn to set
	 */
	public void setSellRBtn(JRadioButton sellRBtn) {
		this.sellRBtn = sellRBtn;
	}

	/**
	 * @return the refundRBtn
	 */
	public JRadioButton getRefundRBtn() {
		return refundRBtn;
	}

	/**
	 * @param refundRBtn the refundRBtn to set
	 */
	public void setRefundRBtn(JRadioButton refundRBtn) {
		this.refundRBtn = refundRBtn;
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
	
	/**
	 * @return the cancelBtn
	 */
	public JButton getCancelBtn() {
		return cancelBtn;
	}

	/**
	 * @param cancelBtn the cancelBtn to set
	 */
	public void setCancelBtn(JButton cancelBtn) {
		this.cancelBtn = cancelBtn;
	}
}

