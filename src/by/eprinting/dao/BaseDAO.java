package by.eprinting.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public abstract class BaseDAO {
	
	static {
		try {
			Class.forName("org.postgresql.Driver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
	
	final Connection getConnection() throws SQLException {
		return DriverManager.getConnection("jdbc:postgresql://localhost:5432/eprinting", "postgres", "root");
	}
	
	final void closeConnection(Connection connection) {
		try {
			if (connection != null) connection.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public abstract <T> long insert(T t);
	public abstract <T> T selectById(long id);
	public abstract <T> void delete(T t); 
	public <T> void update(T t) {}
	public <T, S> T findBy(S t) { return null; }
}
