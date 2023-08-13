package it.unipv.po.edicola.model.member.factory;

import it.unipv.po.edicola.model.member.IMember;
import it.unipv.po.edicola.model.member.strategy.EMailMember;
import it.unipv.po.edicola.model.member.strategy.NullMember;

public class MemberFactory {

	private static MemberFactory instance;
	
	private MemberFactory() {
		super();
	}
	
	public static MemberFactory getInstance() {
		if(instance == null) {
			instance = new MemberFactory();
		}
		return instance;
	}
	
	public static IMember createMember(Integer memberId, String name, String email) {
		if(email == null)
			return new NullMember(memberId, name);
		return new EMailMember(memberId, name, email);
	}
	
}
