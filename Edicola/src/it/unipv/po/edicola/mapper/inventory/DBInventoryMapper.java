package it.unipv.po.edicola.mapper.inventory;

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
import it.unipv.po.edicola.model.shop.ILocation;
import it.unipv.po.edicola.model.shop.Storage;
import it.unipv.po.edicola.util.database.DBConnection;
import it.unipv.po.edicola.util.properties.PropertiesSingleton;

public class DBInventoryMapper implements IInventoryMapper {
	private static String SCHEMA_PROPERTYNAME = "database.schema.name";
	private String schema;
	private Connection connection;
	
	public DBInventoryMapper() {
		super();
		try {
			schema = PropertiesSingleton.getInstance().getProperty(SCHEMA_PROPERTYNAME);
			connection = DBConnection.startConnection(connection, schema);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public HashSet<ILocation> getInventory() {
		HashSet<ILocation> result = new HashSet<ILocation>();
		Statement statement1;
		Statement statement2;
		
		try {
			statement1 = connection.createStatement();
			String query1 = 
					"SELECT * FROM storages";
			ResultSet rsStorage = statement1.executeQuery(query1);
			
			while (rsStorage.next()) {
				ILocation temp = new Storage(rsStorage.getString("storage_id"));
				String query2 =
						  "SELECT prize, products.product_id, name_product, quantity, storage_id, publication, periodicity "
						+ "FROM inventory JOIN products ON inventory.product_id = products.product_id "
						+ "WHERE storage_id like " + "'"+rsStorage.getString("storage_id")+"'";
				statement2 = connection.createStatement();
				ResultSet rsInventory = statement2.executeQuery(query2);
				
				while (rsInventory.next()) {
					temp.addProduct(
							createProduct(rsInventory), 
							Integer.valueOf(rsInventory.getString("quantity")));
				}
				result.add(temp);
			}
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
		return result;
	}

	@Override
	public Boolean addStorage(ILocation location) {
		try {
			Statement statement = connection.createStatement();
			String query = 
					"INSERT INTO storages VALUES "+
					"('" + location.getName() + "', null)";
			
			statement.executeUpdate(query);
			
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
		
		return true;	
	}

	@Override
	public Boolean removeStorage(ILocation location) {
		try {
			Statement statement = connection.createStatement();
			String query = 
					"DELETE FROM storages WHERE storage_id like '"+location.getName()+"'";
			
			statement.executeUpdate(query);
			
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
		return true;	
	}

	@Override
	public Boolean updateStorage(ILocation location, String name, Integer priority) {
		try {
			Statement statement = connection.createStatement();
			String query = 
					"UPDATE storages "
					+ "SET storage_id = '" + name + "'"
					+ "SET priority = " + priority
					+ "WHERE storage_id like '" + location.getName()+"'";
			
			statement.executeUpdate(query);
			
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
		return true;
	}

	@Override
	public Boolean updateInventory(ILocation location, IProduct product, Integer quantity) {	
		try {
			Statement statement = connection.createStatement();
			String query = 
					"UPDATE inventory "
					+ "SET quantity = " + location.getProducts().get(product) + quantity;
			
			statement.executeUpdate(query);
			
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
		return true;
	}
	
	
	@Override
	public Boolean addProductInInventory(ILocation location, IProduct product, Integer quantity) {
		try {
			Statement statement = connection.createStatement();
			String query = 
					"INSERT INTO inventory "
					+ "VALUES ('" + location.getName() +"', " + product.getIdProduct() + ", " + quantity + ")" ;
			
			statement.executeUpdate(query);

		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
		return true;
	}

	
	@Override
	public Boolean removeProductFromInventory(ILocation location, IProduct product) {
		try {
			Statement statement = connection.createStatement();
			String query = 
					"DELETE FROM storages "
							+ "WHERE storage_id like '"+location.getName()+"'" 
							+ "AND product_id = " + product.getIdProduct();

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

	@Override
	public ILocation getMainLocation() {
		Storage result = null;
		try {
			Statement statement = connection.createStatement();
			String query = 
					"SELECT *"
					+ " FROM storages"
					+ " WHERE priority = (SELECT max(priority) FROM storages)";
			ResultSet rs = statement.executeQuery(query);
			rs.next();
			result = new Storage(rs.getString("storage_id"));
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return result;
	}
}
