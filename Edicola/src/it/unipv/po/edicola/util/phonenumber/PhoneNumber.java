package it.unipv.po.edicola.util.phonenumber;

/**
 * La classe PhoneNumber rappresenta il numero telefonico di una persona,
 * il numero telefonico viene rappresentato da un prefisso e da un numero
 * nel costruttore se non viene inserito il prefisso viene usato il prefisso italiano(39)
 * 
 * */
public class PhoneNumber {
	public Integer prefix; 
	public Integer number; 
	
	public final static Integer italyPrefix = 39;
	
	public PhoneNumber(Integer prefix, Integer number) {
		super();
		this.prefix = prefix;
		this.number = number;
	}
	
	public PhoneNumber(Integer number) {
		super();
		this.prefix = italyPrefix;
		this.number = number;
	}

	/**
	 * @return the prefix
	 */
	public Integer getPrefix() {
		return prefix;
	}

	/**
	 * @param prefix the prefix to set
	 */
	public void setPrefix(Integer prefix) {
		this.prefix = prefix;
	}

	/**
	 * @return the number
	 */
	public Integer getNumber() {
		return number;
	}

	/**
	 * @param number the number to set
	 */
	public void setNumber(Integer number) {
		this.number = number;
	}

	/**
	 * @return the italyprefix
	 */
	public static Integer getItalyprefix() {
		return italyPrefix;
	}
	
}
