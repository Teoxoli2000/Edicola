package it.unipv.po.edicola.controller.market;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDate;

import javax.swing.SpinnerNumberModel;

import it.unipv.po.edicola.mapper.MapperFacade;
import it.unipv.po.edicola.model.exception.ProductNotFoundException;
import it.unipv.po.edicola.model.market.payment.IPayment;
import it.unipv.po.edicola.model.market.shoppingcart.ShoppingCart;
import it.unipv.po.edicola.model.product.IProduct;
import it.unipv.po.edicola.model.product.magazine.IMagazine;
import it.unipv.po.edicola.model.product.magazine.Magazine;
import it.unipv.po.edicola.model.shop.ILocation;
import it.unipv.po.edicola.model.shop.INewsstand;
import it.unipv.po.edicola.model.shop.factory.NewsstandAbstractFactory;
import it.unipv.po.edicola.util.properties.PropertiesSingleton;
import it.unipv.po.edicola.view.frame.JFrameMarket;
import it.unipv.po.edicola.view.panel.JPanelMarket;

public class PaymentController {

	private INewsstand tempModel;
	private INewsstand model;
	private ShoppingCart shoppingCart;
	private Double prize = 0.0;
 
	private JPanelMarket view;
	
	private static String PAYMENT_PROPERTYNAME="payment.class";
	private static String SELL_PROPERTYNAME="it.unipv.po.edicola.model.market.payment.strategy.Entrance";
	private static String REFUND_PROPERTYNAME="it.unipv.po.edicola.model.market.payment.strategy.Refund";
	
	public PaymentController(INewsstand model, JFrameMarket view) {
		super();
		this.model = model;
		this.shoppingCart = new ShoppingCart("temp");
		this.view = (JPanelMarket) view.getContentPane();
		
		tempModel = NewsstandAbstractFactory.getNewsstandFactory().createNewsstand();
		
		setListener();
	}
	
	
	public void setListener() {
		
		/**
		 * Qua si annulla la transazione per farlo resetto tutto
		 */
		view.getCancelBtn().addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				view.getLocComboBox().removeAllItems(); 
				view.getProdComboBox().removeAllItems();
				view.getDateComboBox().removeAllItems();
				tempModel = NewsstandAbstractFactory.getNewsstandFactory().createNewsstand();
				view.getShopingCartTxt().setText("");
				shoppingCart = new ShoppingCart("temp");
				view.getTotalTxt().setText("0");
			}
		});
		
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
						System.out.println(p.getName());
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

				try {
					for (ILocation l :tempModel.searchProductInStore(selection).keySet())
						view.getLocComboBox().addItem(l.getName());
				} catch (ProductNotFoundException e1) {

				}

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
		
		view.getLocComboBox().addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				setMaxSpinner();
			}
		});
	

		view.getRefundRBtn().addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				view.getSellRBtn().setSelected(false);
				setMaxSpinner();
				
			}
		});
		
		view.getSellRBtn().addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				view.getRefundRBtn().setSelected(false);
				setMaxSpinner();
			}
		});
		
		/**
		 * Parte di codice dove inizializzo lo shoppingCart, prendo i dati forniti dai JComboBox e
		 * da nProductSpin, sposto i prodotti dal newwstand temporaneo all'interno del carello
		 * mostro i prodotti nel carrello in shoppingCartTxt (mostrando id, nome prodotto e quantità)
		 * e aggiorno il totale 
		 * */
		view.getAddProductBtn().addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				ILocation selectLoc = null;
				LocalDate selectDate = null;
				IProduct selectProd = null;
				Integer selectQta = 0;
				prize = 0.0;
				


				for(ILocation l: tempModel.getWards()) {
					if (l.getName().equals((String) view.getLocComboBox().getSelectedItem()))
						selectLoc = l;
				}

				for(IProduct p: selectLoc.getProducts().keySet()) {
					if(p.getName().equals((String) view.getProdComboBox().getSelectedItem())) {
						selectProd = p;
					}
				}
				
				if(selectProd == null)
					return;

				if (view.getDateComboBox().getSelectedItem() != null) {
					selectDate = LocalDate.parse((String)view.getDateComboBox().getSelectedItem());
				}
				selectQta = (Integer) view.getnProductSpin().getValue();


				view.getShopingCartTxt().append(createLineShoppinCart(selectProd, selectDate, selectQta));


				try {
					shoppingCart.moveProduct(selectLoc, selectProd, selectQta);
				} catch (ProductNotFoundException e1) { 
				}

				setMaxSpinner();
				for (IProduct p: shoppingCart.getProducts().keySet()) {
					prize += p.getPrize() * shoppingCart.getProducts().get(p);
				}
				view.getTotalTxt().setText(prize.toString());
			} 
		});
		
		view.getDoTransactionBtn().addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				try {
					if (view.getSellRBtn().isSelected()) {
						PropertiesSingleton.getInstance().setProperty(PAYMENT_PROPERTYNAME, SELL_PROPERTYNAME);
					}
					if(view.getRefundRBtn().isSelected()) {
						PropertiesSingleton.getInstance().setProperty(PAYMENT_PROPERTYNAME, REFUND_PROPERTYNAME);
					}
					System.out.println(PropertiesSingleton.getInstance().getProperty(PAYMENT_PROPERTYNAME));
					IPayment payment = shoppingCart.generatePayment();
					
					System.out.println(payment.getShoppingCart().getName());
					payment.setTotal(prize);
					payment.setPaymentId(model.getAccounting().genereteIdPayment());
					
					payment.changeNewsstandAccounting(model);
					
					payment.changeNewsstandInventory(model, tempModel);
					
					for (IProduct p: shoppingCart.getTakens().keySet()) {
						for (ILocation l: shoppingCart.getTakens().get(p).keySet()) {
							MapperFacade.getInstance().updateInventory(
									l, // location da cui è stato preso il prodotto
									p, // prodotto
									-shoppingCart.getTakens().get(p).get(l)); //quantità
							System.out.println(l.getProducts().get(p));
							System.out.println(p.getIdProduct());
							System.out.println(l.getName() );
						}
					}
					
					System.out.println();
					
				} catch (Exception ex) {
					ex.printStackTrace();
				}
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

	private void setMaxSpinner() {
		ILocation selectLoc = null;
		
		for(ILocation l: tempModel.getWards()) {
			if (l.getName().equals((String) view.getLocComboBox().getSelectedItem()))
				selectLoc = l;
		}
		if (selectLoc == null) return;

		for(IProduct p: selectLoc.getProducts().keySet()) {
			if(p.getName().equals((String) view.getProdComboBox().getSelectedItem())) {
				int max = selectLoc.getProducts().get(p);
				view.getnProductSpin().setModel(new SpinnerNumberModel(1, 0, max, 1));
			}
		}
	}
}
