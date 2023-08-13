package it.unipv.po.edicola.mapper.member;

import java.util.HashSet;

import it.unipv.po.edicola.model.member.IMember;

public interface IMemberMapper {	
	public Boolean addMember(IMember member);
	public Boolean removeMember(IMember member);
	public Boolean addEmailMember(IMember member, String email);
	
	public HashSet<IMember> getAllMembers();
}
