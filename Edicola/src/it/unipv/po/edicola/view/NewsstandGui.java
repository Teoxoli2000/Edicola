package it.unipv.po.edicola.view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;

import it.unipv.po.edicola.view.frame.JFrameAccounting;
import it.unipv.po.edicola.view.frame.JFrameBuy;
import it.unipv.po.edicola.view.frame.JFrameCoupon;
import it.unipv.po.edicola.view.frame.JFrameInventory;
import it.unipv.po.edicola.view.frame.JFrameMoveProduct;
import it.unipv.po.edicola.view.frame.JFrameRefound;
import it.unipv.po.edicola.view.frame.JFrameSell;
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
	private JButton btnSupplies;
	private JButton btnRefound;
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
		
		btnSell = new JButton("Vendi");
		btnSell.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				EventQueue.invokeLater(new Runnable() {
					public void run() {
						try {
							JFrameSell frame = new JFrameSell();
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
		
		btnSupplies = new JButton("Rifornisci");
		btnSupplies.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				EventQueue.invokeLater(new Runnable() {
					public void run() {
						try {
							JFrameBuy frame = new JFrameBuy();
							frame.setVisible(true);
						} catch (Exception e) {
							e.printStackTrace();
						}
					}
				});
			}
		});
		GridBagConstraints gbc_btnSupplies = new GridBagConstraints();
		gbc_btnSupplies.fill = GridBagConstraints.HORIZONTAL;
		gbc_btnSupplies.insets = new Insets(0, 0, 5, 0);
		gbc_btnSupplies.gridx = 0;
		gbc_btnSupplies.gridy = 1;
		panel.add(btnSupplies, gbc_btnSupplies);
		
		btnRefound = new JButton("Rimborso");
		btnRefound.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				EventQueue.invokeLater(new Runnable() {
					public void run() {
						try {
							JFrameRefound frame = new JFrameRefound();
							frame.setVisible(true);
						} catch (Exception e) {
							e.printStackTrace();
						}
					}
				});
			}
		});
		GridBagConstraints gbc_btnRefound = new GridBagConstraints();
		gbc_btnRefound.fill = GridBagConstraints.HORIZONTAL;
		gbc_btnRefound.insets = new Insets(0, 0, 5, 0);
		gbc_btnRefound.gridx = 0;
		gbc_btnRefound.gridy = 2;
		panel.add(btnRefound, gbc_btnRefound);
		
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
		gbc_btnCoupon.gridy = 3;
		panel.add(btnCoupon, gbc_btnCoupon);
		
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
		gbc_btnAccounting.gridy = 4;
		panel.add(btnAccounting, gbc_btnAccounting);
		
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
		gbc_btnInventory.gridy = 5;
		panel.add(btnInventory, gbc_btnInventory);
		
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
		GridBagConstraints gbc_btnSupplier = new GridBagConstraints();
		gbc_btnSupplier.fill = GridBagConstraints.HORIZONTAL;
		gbc_btnSupplier.insets = new Insets(0, 0, 5, 0);
		gbc_btnSupplier.gridx = 0;
		gbc_btnSupplier.gridy = 6;
		panel.add(btnSupplier, gbc_btnSupplier);
		
		btnMember = new JButton("Iscritti");
		GridBagConstraints gbc_btnMember = new GridBagConstraints();
		gbc_btnMember.fill = GridBagConstraints.HORIZONTAL;
		gbc_btnMember.insets = new Insets(0, 0, 5, 0);
		gbc_btnMember.gridx = 0;
		gbc_btnMember.gridy = 7;
		panel.add(btnMember, gbc_btnMember);
		
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
		gbc_btnMoveProduct.gridy = 8;
		panel.add(btnMoveProduct, gbc_btnMoveProduct);

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
	 * @return the btnSupplies
	 */
	public JButton getBtnSupplies() {
		return btnSupplies;
	}

	/**
	 * @return the btnRefound
	 */
	public JButton getBtnRefound() {
		return btnRefound;
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

