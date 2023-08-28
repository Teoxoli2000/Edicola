package it.unipv.po.edicola.controller;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Hashtable;

import javax.swing.JPanel;

import it.unipv.po.edicola.controller.market.BuyController;
import it.unipv.po.edicola.controller.market.PaymentController;
import it.unipv.po.edicola.controller.member.MemberController;
import it.unipv.po.edicola.model.product.IProduct;
import it.unipv.po.edicola.model.shop.ILocation;
import it.unipv.po.edicola.model.shop.Newsstand;
import it.unipv.po.edicola.model.shop.factory.NewsstandAbstractFactory;
import it.unipv.po.edicola.view.NewsstandGui;
import it.unipv.po.edicola.view.frame.JFrameBuy;
import it.unipv.po.edicola.view.frame.JFrameMarket;
import it.unipv.po.edicola.view.frame.JFrameMember;
import it.unipv.po.edicola.view.panel.JPanelAccounting;
import it.unipv.po.edicola.view.panel.JPanelMarket;

public class NewsstandGuiController {
	private NewsstandGui gui;
	private Newsstand model;
	
	public NewsstandGuiController(NewsstandGui gui, Newsstand model) {
		super();
		this.gui = gui;
		this.model = model;
		setListener();
	}
	
	public void setListener() {
		gui.getBtnMember().addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				EventQueue.invokeLater(new Runnable() {
					public void run() {
						try {
							JFrameMember frame = new JFrameMember();
							frame.setVisible(true);
							
							@SuppressWarnings("unused")
							MemberController controller = new MemberController(model.getMemberBook(), frame);
							
						} catch (Exception e) {
							e.printStackTrace();
						}
					}
				});
			}
		});
		
		gui.getBtnSell().addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				EventQueue.invokeLater(new Runnable() {
					public void run() {
						try {
							JFrameMarket frame = new JFrameMarket();
							frame.setVisible(true);

							@SuppressWarnings("unused")
							PaymentController controller = new PaymentController(model, frame);
						}

						catch (Exception e) {
							e.printStackTrace();
						}
					}
				});
			}
		});
	
	gui.getBtnBuy().addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			EventQueue.invokeLater(new Runnable() {
				public void run() {
					try {
						JFrameBuy frame = new JFrameBuy();
						frame.setVisible(true);

						@SuppressWarnings("unused")
						BuyController controller = new BuyController(model, frame);
					}

					catch (Exception e) {
						e.printStackTrace();
					}
				}
			});
		}
	});
}
	
	public static void main(String[] args) {
		Newsstand news = (Newsstand) NewsstandAbstractFactory.getNewsstandFactory().createNewsstand();
		NewsstandGui window = new NewsstandGui();
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					window.getFrame().setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
		@SuppressWarnings("unused")
		NewsstandGuiController controller = new NewsstandGuiController(window, news);
	}
}
