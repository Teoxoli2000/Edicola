package it.unipv.po.edicola.model.member.strategy;

import it.unipv.po.edicola.model.member.Member;

public class NullMember extends Member {

	public NullMember(Integer memberId, String name) {
		super(memberId, name);
	}

	@Override
	public Boolean sendMessage(String message) throws Exception {
		System.out.println(message);
		return true;
	}

	@Override
	public String showInformation() {
		return super.getName() +"  "+ super.getMemberId();
	}
}
