package it.unipv.po.edicola.controller.inventory;

import java.awt.TextField;

import it.unipv.po.edicola.model.exception.ProductNotFoundException;
import it.unipv.po.edicola.model.shop.Newsstand;

public class InventoryController {
	private Newsstand n;
	public void funzione() {
		try {
			String ricercaNome;
			Integer ricercaId = 0;
			//prendo Ricercanome
			try {
				//ricercaId = Integer.parseInt(ricercaNome);				
				n.searchProductInStore(ricercaId);
			} catch (NumberFormatException e) {
				//n.searchProductInStore(ricercaNome);
			}
		} catch (ProductNotFoundException e) {
			// TODO: handle exception
			// non ho trovato nessun prodotto ricercato nello store ma
			// i fornitori che lo forniscono sono:
			
			// prodotto non trovato nel sistema 
		}
	}
}
