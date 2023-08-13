package it.unipv.po.edicola.model.member.strategy;

import it.unipv.po.edicola.model.member.Member;

public class EMailMember extends Member {
	private String email;
	
	public EMailMember(Integer memberId, String name) {
		super(memberId, name);
	}
	
	public EMailMember(Integer memberId, String name, String email) {
		super(memberId, name);
		this.email = email;
	}

	@Override
	public Boolean sendMessage(String message) throws Exception {
		System.out.println(message);
		System.out.println(email);
		return true;
	}

	@Override
	public String showInformation() {
		return super.getName() +"  "+ super.getMemberId() +"  "+ email;
	}

}
