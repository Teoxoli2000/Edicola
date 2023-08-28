package it.unipv.po.edicola.controller.market;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDate;

import it.unipv.po.edicola.model.exception.ProductNotFoundException;
import it.unipv.po.edicola.model.market.shoppingcart.ShoppingCart;
import it.unipv.po.edicola.model.product.IProduct;
import it.unipv.po.edicola.model.product.Product;
import it.unipv.po.edicola.model.product.magazine.IMagazine;
import it.unipv.po.edicola.model.product.magazine.Magazine;
import it.unipv.po.edicola.model.shop.ILocation;
import it.unipv.po.edicola.model.shop.INewsstand;
import it.unipv.po.edicola.model.shop.Newsstand;
import it.unipv.po.edicola.view.frame.JFrameBuy;
import it.unipv.po.edicola.view.panel.JPanelBuy;

public class BuyController {
	public INewsstand tempModel;
	public INewsstand model;
	ShoppingCart shoppingCart;
 
	public JPanelBuy view;
	
	public BuyController(INewsstand model, JFrameBuy view) {
		super();
		this.model = model;
		tempModel = new Newsstand();
		tempModel.setAccounting(model.getAccounting());
		tempModel.setWards(model.getWards());
		shoppingCart = new ShoppingCart("ShoppingCart");
		
		this.view = (JPanelBuy) view.getContentPane();
		setListener();
	}
	
	
	public void setListener() {
		
		
		/** 
		 * In questa parte di codice si gestisce cosa deve fare searchBtnS, cioè
		 * il bottone cerca all'interno del modello il prodotto con il nome inserito all'interno
		 * della productTxtField e se la ricerca ha successo deve cambiare i tre JComboBox nella seguente maniera:
		 * - prodComboBox deve avere il prodotto cercato
		 * - locComboBox devono esserci i posti in cui si trova il prodotto
		 * - dateComboBox nel caso sia un periodico ci devono essere le date di uscita del prodotto,
		 * 	              se no non mostrare nulla
		 * 
		 * Nel caso non ci siano campi di ricerca o la ricerca non va a buon fine
		 * vengono mostrati tutti i prodotti nella prodComboBox,  quando si seleziona un prodotto dal componente
		 * gli altri JComboBox vengono aggiornati con le informazioni varie del prodotto selezionato
		 * 
		 */
		view.getSearchBtnS().addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				ILocation inventory = tempModel.getInventory();
				String pSearch = view.getProductTxtField().getText();

				view.getLocComboBox().removeAllItems(); 
				view.getProdComboBox().removeAllItems();
				view.getDateComboBox().removeAllItems();
				
				if (pSearch.equals("")) {
					for (IProduct p: inventory.getProducts().keySet()) {
						view.getProdComboBox().addItem(p.getName());
						}
				} else {
					try {
						for (IProduct p: tempModel.searchProductInStore(pSearch).values()) {
							if (p.getClass() == Class.forName("it.unipv.po.edicola.model.product.magazine.Magazine")) {
								IMagazine mag =  (Magazine) p;
								
								view.getDateComboBox().addItem(mag.getDate().toString());
								view.getProdComboBox().addItem(mag.getName());
								//TODO un po' buggato ma va bene lo stesso
							} else {
								view.getProdComboBox().addItem(p.getName());
							}
						}
					} catch (ProductNotFoundException e1) {
						for (IProduct p: inventory.getProducts().keySet()) 
							view.getProdComboBox().addItem(p.getName());
					} catch (ClassNotFoundException e1) {
						e1.printStackTrace();
					}	
				}
				
			}
		});

		view.getProdComboBox().addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				String selection = (String) view.getProdComboBox().getSelectedItem();
				view.getLocComboBox().removeAllItems();
				view.getDateComboBox().removeAllItems();

				for (ILocation l :tempModel.getWards())
					view.getLocComboBox().addItem(l.getName());


				try {
					for (IProduct p: tempModel.searchProductInStore(selection).values()) {
						if (p.getClass() == Class.forName("it.unipv.po.edicola.model.product.magazine.Magazine")) {
							IMagazine mag =  (Magazine) p;

							view.getDateComboBox().addItem(mag.getDate().toString());
							//TODO un po' buggato ma va bene lo stesso
						}
					}
				} catch (ClassNotFoundException ex) {
					ex.printStackTrace();
				} catch (ProductNotFoundException e1) {
	
				}

			}
		});
		
		/**
		 * In questo punto viene gestito nProductSpin e i tre JRadioButton,
		 * può essere selzionato solo un JRadioButton quindi quando uno viene selezionato gli altri due 
		 * vengono deselezionati, in più quando uno viene selezionato viene settato il numero massimo di
		 * nProductSpin, il massimo dipende dal prodotto e dal posto selezionati nelle tre JComboBox, solo nel
		 * caso in cui viene selezionato buyRBtn il massimo viene impostato a 1000
		 * 
		 * La funzione di settare il massimo viene gestita dal metodo setMaxSpinner
		 * 
		 * Il massimo cambia quando cambia locComboBox e tre JRadioButton
		 */
		
	
	
		
		view.getAddProductBtn().addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				ILocation selectLoc = null;
				LocalDate selectDate = null;
				IProduct selectProd = null;
				Integer selectQta = 0;
				Double prize = 0.0;


				for(ILocation l: tempModel.getWards()) {
					if (l.getName().equals((String) view.getLocComboBox().getSelectedItem()))
						selectLoc = l;
				}

				for(IProduct p: selectLoc.getProducts().keySet()) {
					if(p.getName().equals((String) view.getProdComboBox().getSelectedItem())) {
						selectProd = p;
					}
				}
				if (selectProd == null) {
					selectProd = new Product(prize, selectQta, null);
				}

				if (view.getDateComboBox().getSelectedItem() != null) {
					selectDate = LocalDate.parse((String)view.getDateComboBox().getSelectedItem());
				}
				selectQta = (Integer) view.getnProductSpin().getValue();


				view.getShopingCartTxt().append(createLineShoppinCart(selectProd, selectDate, selectQta));

			} 
		});
	}

	private String createLineShoppinCart(IProduct prod, LocalDate date, Integer qta) {
		if(prod.getName() == null)
			return "";
		if(date == null)
			return prod.getName() + " [" + prod.getIdProduct() +"] x " + qta + "\n";
		return prod.getName() +" "+ date.toString()+ " [" + prod.getIdProduct() +"] x " + qta + "\n";
	}
}

