package it.unipv.po.edicola.mapper.coupon;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.util.HashSet;

import it.unipv.po.edicola.model.market.coupon.FactoryCoupon;
import it.unipv.po.edicola.model.market.coupon.ICoupon;
import it.unipv.po.edicola.model.product.IProduct;
import it.unipv.po.edicola.model.product.factory.ProductFactory;
import it.unipv.po.edicola.util.database.DBConnection;
import it.unipv.po.edicola.util.properties.PropertiesSingleton;

public class DBCouponMapper implements ICouponMapper{
	private static String SCHEMA_PROPERTYNAME = "database.schema.name";
	private String schema;
	private Connection connection;

	public DBCouponMapper() {
		super();
		try {
			schema = PropertiesSingleton.getInstance().getProperty(SCHEMA_PROPERTYNAME);
			connection = DBConnection.startConnection(connection, schema);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public HashSet<IProduct> getCouponValidProducts(ICoupon c) {
		HashSet<IProduct> result = new HashSet<IProduct>();
		try {
			Statement statement = connection.createStatement();
			String query = 
					"SELECT product_id, prize, publication, name_product, periodicity "
							+ "FROM coupon_product JOIN products ON  coupon_product.product_id = products.product_id"
							+ "WHERE coupon_id = " + c.getCouponId();

			ResultSet rs = statement.executeQuery(query);

			while(rs.next()) {
				result.add(ProductFactory.createProduct(
						Double.valueOf(rs.getString("prize")), 
						Integer.valueOf(rs.getString("product_id")), 
						rs.getString("name_product"), 
						LocalDate.parse(rs.getString("publication")), 
						PropertiesSingleton.getInstance().getProperty(rs.getString("periodicity"))));
			}

		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}

		if (result.isEmpty())
			return null;

		return result;
	}

	@Override
	public Boolean addValidProductsToCoupon(ICoupon c, HashSet<IProduct> product) {
		try {
			Statement statement = connection.createStatement();
			for(IProduct p: product) {
				String query = 
						"INSERT INTO coupon_product VALUES ("+c.getCouponId()+", "+p.getIdProduct()+")";

				statement.executeUpdate(query);
			}

		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
		return true;
	}

	@Override
	public Boolean removeValidProductsToCoupon(ICoupon c, HashSet<IProduct> product) {
		try {
			Statement statement = connection.createStatement();
			for(IProduct p: product) {
				String query = 
						"DELETE coupon_product "
								+ "WHERE product_id = " + p.getIdProduct() 
								+ "AND coupon_id = " + c.getCouponId();

				statement.executeUpdate(query);
			}

		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
		return true;
	}

	
	public Boolean isNotUsedCoupon(String code) {
		try {
			Statement statement = connection.createStatement();
			String query = 
				"SELECT * "
				+ "FROM circulation_coupons"
				+ "WHERE coupon_code = " + code;

			ResultSet rs = statement.executeQuery(query);

			if (rs.next()) {
				return true;
			}

		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
		return true;
	}

	@Override
	public Boolean addCirculationCoupon(ICoupon c, String code) {
		try {
			Statement statement = connection.createStatement();

			String query = 
					"INSERT INTO circulation_coupons VALUES ('"+code+"',"+c.getCouponId()+")";

			statement.executeUpdate(query);

		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
		return true;
	}

	@Override
	public Boolean removeUsedCoupon(String code) {
		if(code.contains("%"))
			return false;

		try {
			Statement statement = connection.createStatement();

			String query = 
					"DELETE coupon_product "
							+ "WHERE product_id like '" + code + "'";

			statement.executeUpdate(query);

		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
		return true;
	}

	@Override
	public Boolean addCoupun(ICoupon c) {
		try {
			Statement statement = connection.createStatement();

			String query = 
					"INSERT INTO coupons VALUES ("+c.getCouponId()+", null, null, "+c.getDiscount()+", "+c.getDescription()+")";

			statement.executeUpdate(query);

		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
		return true;
	}

	@Override
	public Boolean addCoupun(ICoupon c, LocalDate expire, LocalDate begin) {
		try {
			Statement statement = connection.createStatement();

			String query = 
					"INSERT INTO coupons VALUES ("
							+c.getCouponId()+", "
							+ "'"+expire.toString()+"'"+ ", "
							+ "'"+expire.toString()+"'"+ ", "
							+c.getDiscount()+", "
							+c.getDescription()+")";

			statement.executeUpdate(query);

		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
		return true;
	}

	@Override
	public Boolean removeCoupun(ICoupon c) {
		try {
			Statement statement = connection.createStatement();

			String query = 
					"DELETE coupons WHERE coupons_id = " + c.getCouponId();

			statement.executeUpdate(query);

		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
		return true;
	}

	@Override
	public ICoupon getCoupun(Integer id) {
		ICoupon result = null;
		try {
			Statement statement = connection.createStatement();

			String query = 
					"SELECT *"
							+ "FROM coupons "
							+ "WHERE coupons_id = " + id;

			ResultSet rs = statement.executeQuery(query);

			while (rs.next()) {
				result = createCoupon(rs);
			}

		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
		return result;	}


	@Override
	public HashSet<ICoupon> getAllCoupons() {
		HashSet<ICoupon> result = new HashSet<ICoupon>();
		try {
			Statement statement = connection.createStatement();
			String query = 
					"SELECT * FROM coupons";

			ResultSet rs = statement.executeQuery(query);

			while (rs.next()) {
				result.add(createCoupon(rs));
			}

		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}

		if(result.isEmpty())
			return null;

		return result;	
	}

	private ICoupon createCoupon(ResultSet rs) throws NumberFormatException, SQLException {
		ICoupon result;
		result = FactoryCoupon.getInstanceFactory().createCoupon (
				rs.getString("coupon_id"), 
				Double.valueOf(rs.getString("discount")), 
				rs.getString("description_coupon")
				);

		result = FactoryCoupon.getInstanceFactory().addValidProducts(result, getCouponValidProducts(result));

		return result = FactoryCoupon.getInstanceFactory().addValidPeriod(
				result,
				LocalDate.parse(rs.getString("expire_coupon")),
				LocalDate.parse(rs.getString("begin_coupon")));
	}

}
