package it.unipv.po.edicola.controller.member;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import it.unipv.po.edicola.mapper.MapperFacade;
import it.unipv.po.edicola.model.exception.MemberNotFoundException;
import it.unipv.po.edicola.model.member.IMember;
import it.unipv.po.edicola.model.member.MemberBook;
import it.unipv.po.edicola.model.member.excpetion.AddEmailMemberException;
import it.unipv.po.edicola.model.member.excpetion.AddNullMemberException;
import it.unipv.po.edicola.model.member.excpetion.RemoveMemberException;
import it.unipv.po.edicola.model.member.strategy.EMailMember;
import it.unipv.po.edicola.model.member.strategy.NullMember;
import it.unipv.po.edicola.view.frame.JFrameMember;
import it.unipv.po.edicola.view.panel.JPanelMember;

public class MemberController {

	private MemberBook book;
	private JPanelMember view;
	
	/**
	 * @param book
	 * @param view
	 */
	public MemberController(MemberBook book, JFrameMember view) {
		super();
		this.book = book;
		this.view = (JPanelMember) view.getContentPane();
		setListener();
	}
	
	public void setListener() {
		view.getBtnSearch().addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				view.getLblError().setText("");
				view.getTextArea().setText("");
				view.getLblError().setForeground(Color.RED);
				
				String searchByName = view.getTextName().getText();
				Integer searchById = null;
				
				try {
					if (!view.getTextID().getText().isEmpty()) {
						searchById = Integer.valueOf(view.getTextID().getText());
						IMember m = book.searchMember(searchById);
						view.getTextArea().setText(m.showInformation());
						return;
					}
				} catch (NumberFormatException ex) {
					view.getLblError().setText("La ricerca tramite ID permette l'inserimento di soli numeri");
					return;
				} catch (MemberNotFoundException ex) {
					if(searchByName.isEmpty()) {
						view.getLblError().setText("Nessun iscritto trovato con l'ID inserito");
						return;
						}
				}
				
				try {
					if(!searchByName.isEmpty()) {
						for (IMember m: book.searchMember(searchByName)) {
							view.getTextArea().append(m.showInformation());
							view.getTextArea().append("\n");
						}
						return;
					}
				} catch (MemberNotFoundException ex) {
					view.getLblError().setText("Nessun iscritto trovato con l'ID o nome inserito");
					return;
				}

				
				
				for (IMember m: book.getMembers()) {
					view.getLblError().setForeground(new Color(255, 204, 0));
					view.getLblError().setText("Nessun criterio di ricerca inserito");
					view.getTextArea().append(m.showInformation());
					view.getTextArea().append("\n");
				}
			}
		}
				);

		view.getBtnAdd().addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				view.getLblError().setForeground(Color.GREEN);
				view.getLblError().setText("Iscritto inserito correttamente");
				view.getTextArea().setText("");
				
				String name = view.getTextName().getText();
				Integer id = generateID();
				String email = view.getTextEmail().getText();
				
			
				if (!view.getTextID().getText().isEmpty()) {
					view.getLblError().setForeground(new Color(255, 204, 0));
					view.getLblError().setText("L'ID viene generato casualmente, l'ID inserito viene ignorato");
				}
				
				
				if (name.isEmpty()) {
					view.getLblError().setForeground(Color.RED);
					view.getLblError().setText("Inserire un nome");
					return;
				}
				
				view.getTextArea().append("Id del nuovo iscritto è " + id.toString());
				view.getTextArea().append("\n");

				
				if (!email.isEmpty()) {
					EMailMember tempM = new EMailMember(id, name, email);
					try {
						book.addMember(tempM, email);
					} catch (AddNullMemberException e1) {
						MapperFacade.getInstance().addMember(tempM);
					} catch (AddEmailMemberException e1) {
						MapperFacade.getInstance().addEmailMember(tempM, email);
					}
					return;
				}

				NullMember tempM = new NullMember(id, name);
				try {
					book.addMember(tempM);
				} catch (AddNullMemberException e1) {
					MapperFacade.getInstance().addMember(tempM);
				}
			}
		}
		
				);
		
		view.getBtnRemove().addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				view.getLblError().setText("Iscritto rimosso correttamente");
				view.getLblError().setForeground(Color.GREEN);
				view.getTextArea().setText("");
				
				Integer id = null;
				IMember remove = null;
				
				try {
					id = Integer.valueOf(view.getTextID().getText());
				} 
				catch (NumberFormatException ex) 
				{
					view.getLblError().setForeground(Color.RED);
					
					if (view.getTextID().getText().isEmpty()) {
						view.getLblError().setText("Se si vuole eliminare un iscritto bisogna inserire un ID");
						return;
						}
					
					view.getLblError().setText("Inserire un ID con il formato corretto");
					return;
				}
				
				for (IMember m: book.getMembers()) {
					if (m.getMemberId().compareTo(id) == 0) {
						remove = m;
					}
				}
				
				if (remove == null) {
					view.getLblError().setForeground(Color.RED);
					view.getLblError().setText("Nessun iscritto con l'ID inserito, riprovare");
					return;
				}

				try {
					book.removeMember(remove);
				} catch (RemoveMemberException e1) {
					MapperFacade.getInstance().removeMember(remove);
				}
			}
		}
				);
		
	}
	
	private Integer generateID() {
		Integer result = (int) Math.round(Math.random() * 10000);
		for(IMember m: book.getMembers()) {
			if(m.getMemberId() == result) {
				return generateID();
			}
		}
		return result;
	}
}

