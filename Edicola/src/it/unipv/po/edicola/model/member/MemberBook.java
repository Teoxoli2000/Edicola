package it.unipv.po.edicola.model.member;

import java.util.Collection;
import java.util.HashSet;

import it.unipv.po.edicola.mapper.MapperFacade;
import it.unipv.po.edicola.model.exception.MemberNotFoundException;
import it.unipv.po.edicola.model.market.coupon.ICoupon;

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
	public void addMember(IMember c) {
		members.add(c);
		MapperFacade.getInstance().addMember(c);
	}

	
	public void addMember(IMember c, String email) {
		if (email == null) {
			addMember(c);
			return;
			}
		
		members.add(c);
		MapperFacade.getInstance().addEmailMember(c, email);
	}
	
	/**
	 * @param c the member to remove
	 */
	public void removeMember(IMember c) {
		members.remove(c);
		MapperFacade.getInstance().removeMember(c);
	}
}
