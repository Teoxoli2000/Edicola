package it.unipv.po.edicola.view.panel;

import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JSpinner;
import java.awt.TextArea;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import java.awt.Color;
import javax.swing.JRadioButton;


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
	private JRadioButton buyRBtn;
	
	/**
	 * Create the panel.
	 */
	public JPanelMarket() {
		setLayout(null);
		
		productTxtField = new JTextField();
		productTxtField.setBounds(204, 8, 191, 20);
		add(productTxtField);
		productTxtField.setColumns(10);
		
		couponTxtField = new JTextField();
		couponTxtField.setColumns(10);
		couponTxtField.setBounds(100, 241, 112, 20);
		add(couponTxtField);
		
		JLabel lblNewLabel = new JLabel("Inserisci i prodotti");
		lblNewLabel.setBounds(23, 11, 171, 14);
		add(lblNewLabel);
		
		nProductSpin = new JSpinner();
		nProductSpin.setBounds(475, 8, 46, 20);
		add(nProductSpin);
		
		JLabel lblQt = new JLabel("qt\u00E0");
		lblQt.setBounds(435, 11, 30, 14);
		add(lblQt);
		
		JLabel lblNewLabel_1 = new JLabel("Carrello");
		lblNewLabel_1.setBounds(23, 52, 46, 14);
		add(lblNewLabel_1);
		
		shopingCartTxt = new TextArea();
		shopingCartTxt.setBounds(23, 72, 498, 160);
		add(shopingCartTxt);
		
		doTransactionBtn = new JButton("Fai la transazione");
		doTransactionBtn.setBounds(397, 266, 124, 23);
		add(doTransactionBtn);
		
		addProductBtn = new JButton("Aggiungi");
		addProductBtn.setBounds(432, 37, 89, 23);
		add(addProductBtn);

		addCouponBtn = new JButton("Usa");
		addCouponBtn.setBounds(123, 266, 89, 23);
		add(addCouponBtn);
		
		JLabel lblNewLabel_2 = new JLabel("Totale");
		lblNewLabel_2.setBounds(397, 244, 46, 14);
		add(lblNewLabel_2);
		
		totalTxt = new JLabel("0");
		totalTxt.setBounds(434, 244, 87, 14);
		add(totalTxt);
		
		JLabel lblNewLabel_4 = new JLabel("Codice Sconto");
		lblNewLabel_4.setBounds(23, 244, 78, 14);
		add(lblNewLabel_4);
		
		couponInfTxt = new JLabel("Nessun codice inserito");
		couponInfTxt.setForeground(new Color(255, 128, 64));
		couponInfTxt.setBounds(222, 244, 135, 14);
		add(couponInfTxt);
		
		buyRBtn = new JRadioButton("Rifornimento");
		buyRBtn.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				refundRBtn.setSelected(false);
				sellRBtn.setSelected(false);
			}
		});
		buyRBtn.setBounds(75, 28, 109, 23);
		add(buyRBtn);
		
		refundRBtn = new JRadioButton("Rimborso");
		refundRBtn.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				sellRBtn.setSelected(false);
				buyRBtn.setSelected(false);
			}
		});
		refundRBtn.setBounds(186, 28, 109, 23);
		add(refundRBtn);
		
		sellRBtn = new JRadioButton("Vendita");
		sellRBtn.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				refundRBtn.setSelected(false);
				buyRBtn.setSelected(false);
			}
		});
		sellRBtn.setBounds(297, 28, 109, 23);
		add(sellRBtn);
		
		JLabel lblNewLabel_6 = new JLabel("Tipo");
		lblNewLabel_6.setBounds(23, 32, 46, 14);
		add(lblNewLabel_6);


	}
}

