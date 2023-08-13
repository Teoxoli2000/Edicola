package it.unipv.po.edicola.model.member;

public abstract class Member implements IMember {
	private Integer memberId;
	private String name;
	
	/**
	 * @param memberId
	 * @param name
	 */
	public Member(Integer memberId, String name) {
		super();
		this.memberId = memberId;
		this.name = name;
	}

	/**
	 * @return the memberId
	 */
	public Integer getMemberId() {
		return memberId;
	}

	/**
	 * @param memberId the memberId to set
	 */
	public void setMemberId(Integer memberId) {
		this.memberId = memberId;
	}

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}
	
	
}
