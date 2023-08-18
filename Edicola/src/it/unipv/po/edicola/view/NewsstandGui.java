package it.unipv.po.edicola.view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;

import it.unipv.po.edicola.view.frame.JFrameAccounting;
import it.unipv.po.edicola.view.frame.JFrameCoupon;
import it.unipv.po.edicola.view.frame.JFrameInventory;
import it.unipv.po.edicola.view.frame.JFrameMoveProduct;
import it.unipv.po.edicola.view.frame.JFrameMarket;
import it.unipv.po.edicola.view.frame.JFrameSupplier;

import java.awt.BorderLayout;
import java.awt.Color;
import javax.swing.JButton;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;


public class NewsstandGui {
	private JFrame frame;
	
	private JButton btnSell;
	private JButton btnCoupon;
	private JButton btnAccounting;
	private JButton btnInventory;
	private JButton btnSupplier;
	private JButton btnMember;
	private JButton btnMoveProduct;

	/**
	 * Create the application.
	 */
	public NewsstandGui() {
		initialize();
	}
	
	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 614, 361);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(255, 128, 64));
		frame.getContentPane().add(panel, BorderLayout.WEST);
		GridBagLayout gbl_panel = new GridBagLayout();
		gbl_panel.columnWidths = new int[]{89, 0};
		gbl_panel.rowHeights = new int[]{23, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
		gbl_panel.columnWeights = new double[]{0.0, Double.MIN_VALUE};
		gbl_panel.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		panel.setLayout(gbl_panel);
		
		btnSell = new JButton("Transazioni");
		btnSell.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				EventQueue.invokeLater(new Runnable() {
					public void run() {
						try {
							JFrameMarket frame = new JFrameMarket();
							frame.setVisible(true);
						} catch (Exception e) {
							e.printStackTrace();
						}
					}
				});
			}
		});
		GridBagConstraints gbc_btnSell = new GridBagConstraints();
		gbc_btnSell.fill = GridBagConstraints.HORIZONTAL;
		gbc_btnSell.insets = new Insets(0, 0, 5, 0);
		gbc_btnSell.anchor = GridBagConstraints.NORTH;
		gbc_btnSell.gridx = 0;
		gbc_btnSell.gridy = 0;
		panel.add(btnSell, gbc_btnSell);
		
		btnAccounting = new JButton("Contabilit\u00E0");
		btnAccounting.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				EventQueue.invokeLater(new Runnable() {
					public void run() {
						try {
							JFrameAccounting frame = new JFrameAccounting();
							frame.setVisible(true);
						} catch (Exception e) {
							e.printStackTrace();
						}
					}
				});
			}
		});
		GridBagConstraints gbc_btnAccounting = new GridBagConstraints();
		gbc_btnAccounting.fill = GridBagConstraints.HORIZONTAL;
		gbc_btnAccounting.insets = new Insets(0, 0, 5, 0);
		gbc_btnAccounting.gridx = 0;
		gbc_btnAccounting.gridy = 1;
		panel.add(btnAccounting, gbc_btnAccounting);
		
		btnCoupon = new JButton("Sconti");
		btnCoupon.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				EventQueue.invokeLater(new Runnable() {
					public void run() {
						try {
							JFrameCoupon frame = new JFrameCoupon();
							frame.setVisible(true);
						} catch (Exception e) {
							e.printStackTrace();
						}
					}
				});
			}
		});
		GridBagConstraints gbc_btnCoupon = new GridBagConstraints();
		gbc_btnCoupon.fill = GridBagConstraints.HORIZONTAL;
		gbc_btnCoupon.insets = new Insets(0, 0, 5, 0);
		gbc_btnCoupon.gridx = 0;
		gbc_btnCoupon.gridy = 2;
		panel.add(btnCoupon, gbc_btnCoupon);
		
		btnSupplier = new JButton("Fornitori");
		btnSupplier.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				EventQueue.invokeLater(new Runnable() {
					public void run() {
						try {
							JFrameSupplier frame = new JFrameSupplier();
							frame.setVisible(true);
						} catch (Exception e) {
							e.printStackTrace();
						}
					}
				});
			}
		});
		
		btnMoveProduct = new JButton("Sposta Prodotto");
		btnMoveProduct.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				EventQueue.invokeLater(new Runnable() {
					public void run() {
						try {
							JFrameMoveProduct frame = new JFrameMoveProduct();
							frame.setVisible(true);
						} catch (Exception e) {
							e.printStackTrace();
						}
					}
				});
			}
		});
		GridBagConstraints gbc_btnMoveProduct = new GridBagConstraints();
		gbc_btnMoveProduct.insets = new Insets(0, 0, 5, 0);
		gbc_btnMoveProduct.fill = GridBagConstraints.HORIZONTAL;
		gbc_btnMoveProduct.gridx = 0;
		gbc_btnMoveProduct.gridy = 3;
		panel.add(btnMoveProduct, gbc_btnMoveProduct);
		GridBagConstraints gbc_btnSupplier = new GridBagConstraints();
		gbc_btnSupplier.fill = GridBagConstraints.HORIZONTAL;
		gbc_btnSupplier.insets = new Insets(0, 0, 5, 0);
		gbc_btnSupplier.gridx = 0;
		gbc_btnSupplier.gridy = 4;
		panel.add(btnSupplier, gbc_btnSupplier);
		
		btnMember = new JButton("Iscritti");
		GridBagConstraints gbc_btnMember = new GridBagConstraints();
		gbc_btnMember.fill = GridBagConstraints.HORIZONTAL;
		gbc_btnMember.insets = new Insets(0, 0, 5, 0);
		gbc_btnMember.gridx = 0;
		gbc_btnMember.gridy = 5;
		panel.add(btnMember, gbc_btnMember);
		
		btnInventory = new JButton("Inventario");
		btnInventory.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				EventQueue.invokeLater(new Runnable() {
					public void run() {
						try {
							JFrameInventory frame = new JFrameInventory();
							frame.setVisible(true);
						} catch (Exception e) {
							e.printStackTrace();
						}
					}
				});
			}
		});
		GridBagConstraints gbc_btnInventory = new GridBagConstraints();
		gbc_btnInventory.fill = GridBagConstraints.HORIZONTAL;
		gbc_btnInventory.insets = new Insets(0, 0, 5, 0);
		gbc_btnInventory.gridx = 0;
		gbc_btnInventory.gridy = 6;
		panel.add(btnInventory, gbc_btnInventory);

	}
	
	/**
	 * @return the frame
	 */
	public JFrame getFrame() {
		return frame;
	}

	/**
	 * @return the btnSell
	 */
	public JButton getBtnSell() {
		return btnSell;
	}

	/**
	 * @return the btnCoupon
	 */
	public JButton getBtnCoupon() {
		return btnCoupon;
	}

	/**
	 * @return the btnAccounting
	 */
	public JButton getBtnAccounting() {
		return btnAccounting;
	}

	/**
	 * @return the btnInventory
	 */
	public JButton getBtnInventory() {
		return btnInventory;
	}

	/**
	 * @return the btnSupplier
	 */
	public JButton getBtnSupplier() {
		return btnSupplier;
	}

	/**
	 * @return the btnMember
	 */
	public JButton getBtnMember() {
		return btnMember;
	}

	/**
	 * @return the btnMoveProduct
	 */
	public JButton getBtnMoveProduct() {
		return btnMoveProduct;
	}

}

