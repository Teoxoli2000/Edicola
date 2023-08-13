package it.unipv.po.edicola.util.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * La classe DBConnection gestisce la connessione con il database dell'edicola
 * 
 * */
public class DBConnection {
	
	public DBConnection() {
		super();
	}
	
	/**
	 * restituisce true se è aperta la connesione è nulla
	 * @param c connessione da verificare che non sia nulla
	 * @return true se non è nulla
	 */
	public static boolean isOpen(Connection c) {
		if (c == null) return false;
		return true;
	}
	
	/**
	 * apre la connessione con un preciso schema
	 * @param c connessione da aprire
	 * @param schema nome dello schema del database con cui ci si vuole connettere
	 * @return una Connection con lo schema del database
	 */
	public static Connection startConnection(Connection c, String schema) {
		String DbDriver = "com.mysql.cj.jdbc.Driver";
		String DbURL = "jdbc:mysql://localhost:3306/" + schema;
		String usr = "root";
		String password = "R@panello1969";

		if (isOpen(c)) 
			closeConnection(c);
		
		try {
			Class.forName(DbDriver);
			c = DriverManager.getConnection(DbURL, usr, password);
		} catch(Exception e) {
			e.printStackTrace();
			return null;
		}
		return c;
	}

	/**
	 * chiude la connessione con il database
	 * @param c connessione che si vuol chiudere
	 * @return true se l'operazione è andata bene
	 */
	public static boolean closeConnection(Connection c) {
		if(!isOpen(c)) 
			return false;
	
		try {
			c.close();
			c = null;
		} catch(SQLException e) {
			e.printStackTrace();
			return false;
		}
		return true;
	}	
	
}
