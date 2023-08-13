package it.unipv.po.edicola.controller;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import it.unipv.po.edicola.controller.member.MemberController;
import it.unipv.po.edicola.model.shop.Newsstand;
import it.unipv.po.edicola.model.shop.factory.NewsstandAbstractFactory;
import it.unipv.po.edicola.view.NewsstandGui;
import it.unipv.po.edicola.view.frame.JFrameMember;

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
							
							MemberController controller = new MemberController(model.getMemberBook(), frame);
							
						} catch (Exception e) {
							e.printStackTrace();
						}
					}
				});
			}
		});
	}
	
	public static void main(String[] args) {
		Newsstand news = (Newsstand) NewsstandAbstractFactory.getNewsstand().createNewsstand();
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
		NewsstandGuiController controller = new NewsstandGuiController(window, news);
	}
}
