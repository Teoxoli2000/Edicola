package it.unipv.po.edicola.mapper.member;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashSet;

import it.unipv.po.edicola.model.member.IMember;
import it.unipv.po.edicola.model.member.factory.MemberFactory;
import it.unipv.po.edicola.util.database.DBConnection;
import it.unipv.po.edicola.util.properties.PropertiesSingleton;

public class DBMemberMapper implements IMemberMapper {
	private static String SCHEMA_PROPERTYNAME = "database.schema.name";
	private String schema;
	private Connection connection;
	
	public DBMemberMapper() {
		super();
		try {
			schema = PropertiesSingleton.getInstance().getProperty(SCHEMA_PROPERTYNAME);
			connection = DBConnection.startConnection(connection, schema);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	@Override
	public Boolean addMember(IMember member) {
		try {
			Statement statement = connection.createStatement();
			String query = 
					"INSERT INTO members VALUES ("
					+ member.getMemberId() + ","
					+ "'" + member.getName() + "',"
					+ "null)"
					;
			
			statement.executeUpdate(query);
			
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
		return true;	
	}
	
	@Override
	public Boolean addEmailMember(IMember member, String email) {
		try {
			Statement statement = connection.createStatement();
			String query = 
					"INSERT INTO members VALUES ("
					+ member.getMemberId() + ","
					+ "'" + member.getName() + "',"
					+ "'" + email + "')"
					;
			
			statement.executeUpdate(query);
			
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
		return true;	
	}

	@Override
	public Boolean removeMember(IMember member) {
		try {
			Statement statement = connection.createStatement();
			String query = 
					"DELETE FROM members "
					+ "WHERE member_id ="+ member.getMemberId()+"";

			statement.executeUpdate(query);

		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
		return true;
	}

	@Override
	public HashSet<IMember> getAllMembers() {
		HashSet<IMember> result = new HashSet<IMember>();
		
		try {
			Statement statement = connection.createStatement();
			String query = 
					"SELECT * FROM members";
			
			ResultSet resultSet = statement.executeQuery(query);
			while(resultSet.next()) {
				result.add(createMember(resultSet));
			}
		} catch (Exception e) {
			e.printStackTrace();
			return null;
	}
	return result;
	}

	private IMember createMember(ResultSet resultSet) throws NumberFormatException, SQLException {
		MemberFactory.getInstance();
		return MemberFactory.createMember(
				Integer.valueOf(resultSet.getString("member_id")), 
				resultSet.getString("name_member"), 
				resultSet.getString("email"));
	}

}
