package it.unipv.po.edicola.mapper.products;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.util.HashSet;

import it.unipv.po.edicola.model.product.IProduct;
import it.unipv.po.edicola.model.product.factory.ProductFactory;
import it.unipv.po.edicola.model.product.magazine.IMagazine;
import it.unipv.po.edicola.util.database.DBConnection;
import it.unipv.po.edicola.util.properties.PropertiesSingleton;

public class DBProductsMapper implements IProductsMapper{
	private static String SCHEMA_PROPERTYNAME = "database.schema.name";
	private String schema;
	private Connection connection;
	
	public DBProductsMapper() {
		super();
		try {
			schema = PropertiesSingleton.getInstance().getProperty(SCHEMA_PROPERTYNAME);
			connection = DBConnection.startConnection(connection, schema);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}


	@Override
	public HashSet<IProduct> getAllProducts() {
		HashSet<IProduct> result = new HashSet<IProduct>();
		
		try {
			Statement statement = connection.createStatement();
			String query = 
					"SELECT * FROM products";
			
			ResultSet resultSet = statement.executeQuery(query);
			while(resultSet.next()) {
				result.add(createProduct(resultSet));
			}
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
		return result;
	}

	@Override
	public HashSet<IProduct> searchProduct(String name) {
		HashSet<IProduct> result = new HashSet<IProduct>();
		
		try {
			Statement statement = connection.createStatement();
			String query = 
					"SELECT * "
					+ "FROM products "
					+ "WHERE name_product like '%"+name+"%'";
			
			ResultSet resultSet = statement.executeQuery(query);
			while (resultSet.next()) {
				result.add(createProduct(resultSet));
			}
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
		
		if(result.isEmpty()) {
			return null;
		}
		
		return result;
	}

	@Override
	public IProduct searchProduct(Integer idProduct) {
		IProduct result = null;
		try {
			Statement statement = connection.createStatement();
			String query = 
					"SELECT * "
					+ "FROM products "
					+ "WHERE product_id = " + idProduct;
			
			ResultSet resultSet = statement.executeQuery(query);
			while(resultSet.next()) {
				result = createProduct(resultSet);
			}
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
		return result;
	}

	@Override
	public Boolean updateProduct(IProduct product, Double prize) {
		try {
			Statement statement = connection.createStatement();
			String query = 
					"UPDATE products " + 
					"SET prize = " + prize +
					" WHERE product_id = " + product.getIdProduct();
			
			statement.executeUpdate(query);
			
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
		return true;
	}
	
	@Override
	public Boolean updateProduct(IProduct product, IProduct update) {
		
		try {
			Statement statement = connection.createStatement();
			String query = 
					"UPDATE products" + 
					"SET prize = " + update.getPrize() +
					", name_product = " + update.getName() +
					"WHERE product_id =" + product.getIdProduct();
			
			statement.executeUpdate(query);
			
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
		return true;
	}
	
	@Override
	public Boolean updateMagazine(IProduct product, IMagazine update) {
		try {
			Statement statement = connection.createStatement();
			String query = 
					"UPDATE products" + 
					" SET prize = " + update.getPrize() +
					", name_product = '" + update.getName() + "'" +
					", publication = '" + update.getDate() + "'" + 
					", periodicity = '" + update.getPeriod() + "' " +
					"WHERE product_id =" + product.getIdProduct();
			System.out.println(query);
			
			statement.executeUpdate(query);
			
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
		return true;
	}

	@Override
	public Boolean addProduct(IProduct product) {
		try {
			Statement statement = connection.createStatement();
			String query = 
					"INSERT INTO products VALUES "+
					"("+product.getIdProduct()+", '"+product.getName()+"', "+product.getPrize()+", null, null)";
			
			statement.executeUpdate(query);
			
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
		return true;		
	}
	
	@Override
	public Boolean addMagazine(IMagazine magazine) {
		try {
			Statement statement = connection.createStatement();
			String query = 
					"INSERT INTO products VALUES "+
					"("+magazine.getIdProduct()+", "
					+ "'"+magazine.getName()+"', "
					+magazine.getPrize()+",'"
					+magazine.getDate()+"', '"
					+magazine.getPeriod()+"')";
			
			statement.executeUpdate(query);
			
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
		return true;	
	}
	

	private IProduct createProduct(ResultSet resultSet) 
			throws NumberFormatException, FileNotFoundException, SQLException, IOException {
		IProduct result;
		ProductFactory.getInstanceFactory();

		if (resultSet.getString("publication") == null) {
		result = ProductFactory.createProduct(
				Double.valueOf(resultSet.getString("prize")), 
				Integer.valueOf(resultSet.getString("product_id")), 
				resultSet.getString("name_product"));
		return result;
		}
	
		result = ProductFactory.createProduct(
				Double.valueOf(resultSet.getString("prize")), 
				Integer.valueOf(resultSet.getString("product_id")), 
				resultSet.getString("name_product"), 
				LocalDate.parse(resultSet.getString("publication")), 
				PropertiesSingleton.getInstance().getProperty(resultSet.getString("periodicity")));

		
		return result;
	}
}
