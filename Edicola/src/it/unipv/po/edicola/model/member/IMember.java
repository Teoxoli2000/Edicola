package it.unipv.po.edicola.model.member;

public interface IMember {
	public Boolean sendMessage(String message) throws Exception;
	
	public Integer getMemberId();
	public void setMemberId(Integer memberId);

	public String getName();
	public void setName(String name);
	
	public String showInformation();
}
