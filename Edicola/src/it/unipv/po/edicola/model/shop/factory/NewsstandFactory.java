package it.unipv.po.edicola.model.shop.factory;

import it.unipv.po.edicola.mapper.MapperFacade;
import it.unipv.po.edicola.model.member.MemberBook;
import it.unipv.po.edicola.model.shop.INewsstand;
import it.unipv.po.edicola.model.shop.Newsstand;

public class NewsstandFactory implements INewsstandFactory {

	public NewsstandFactory() {
		super();
		
	}

	@Override
	public INewsstand createNewsstand() {
		Newsstand result = new Newsstand();
		MapperFacade mapper = MapperFacade.getInstance();
		
		result.setWards(mapper.getInventory());
		result.setMainLocation(mapper.getMainLocation());
		result.setMemberBook(new MemberBook(mapper.getAllMembers()));
		
		return result;
	}

}
