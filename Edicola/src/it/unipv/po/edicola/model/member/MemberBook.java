package it.unipv.po.edicola.model.member;

import java.util.Collection;
import java.util.HashSet;

import it.unipv.po.edicola.model.exception.MemberNotFoundException;
import it.unipv.po.edicola.model.market.coupon.ICoupon;
import it.unipv.po.edicola.model.member.excpetion.AddEmailMemberException;
import it.unipv.po.edicola.model.member.excpetion.AddNullMemberException;
import it.unipv.po.edicola.model.member.excpetion.RemoveMemberException;

public class MemberBook {
	private HashSet<IMember> members;
	
	/**
	 * @param members
	 */
	public MemberBook(Collection<IMember> members) {
		super();
		this.members = new HashSet<IMember>();
		this.members.addAll(members);
	}
	
	public MemberBook() {
		super();
		this.members = new HashSet<IMember>();
	}

	public Integer sendCoupon(ICoupon c) throws Exception {
		Integer result = 0;
		for (IMember m: members) {
			if (m.sendMessage (
					c.getDescription() + "\n" +
					"[" + c.getCouponId() + "]"
					))
				result++;
		}
		return result;
	}
	
	public HashSet<IMember> searchMember(String search) throws MemberNotFoundException {
		HashSet<IMember> result = new HashSet<IMember>();
		for (IMember m: members) {
			if (m.getName().contains(search))
				result.add(m);
		}
		
		if (result.isEmpty())
			throw new MemberNotFoundException();
		
		return result;
	}
	
	public IMember searchMember(Integer search) throws MemberNotFoundException {
		for (IMember m: members) {
			if (m.getMemberId().compareTo(search) == 0)
				return m;
		}
		
		throw new MemberNotFoundException();
	}
	/**
	 * @return the members
	 */
	public HashSet<IMember> getMembers() {
		return members;
	}
	
	/**
	 * @param members the members to set
	 */
	public void setMembers(HashSet<IMember> members) {
		this.members = members;
	}
	
	/**
	 * @param c the member to add
	 */
	public void addMember(IMember c) throws AddNullMemberException{
		members.add(c);
		throw new AddNullMemberException();
		
	}

	
	public void addMember(IMember c, String email) 
			throws AddNullMemberException, AddEmailMemberException {
		if (email == null) {
			addMember(c);
			return;
			}
		
		members.add(c);
		throw new AddEmailMemberException();
		
	}
	
	/**
	 * @param c the member to remove
	 */
	public void removeMember(IMember c) throws RemoveMemberException{
		members.remove(c);
		throw new RemoveMemberException();
	}
}
