package by.eprinting.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import by.eprinting.beans.Order;
import by.eprinting.services.db.DocumentDBService;

public class OrderJdbcImpl extends BaseDAO {
	
	@Override
	public <Order> long insert(Order order) {
		String sql = "insert into orders(name, email, phone, address, date, documentid) values (?, ?, ?, ?, ?, ?)";
		
		Connection connection = null;
		long id = 0;
		
		try {
			connection = getConnection();
			PreparedStatement ps = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
			
			ps.setString(1,	((by.eprinting.beans.Order) order).getFullName());
			ps.setString(2,	((by.eprinting.beans.Order) order).getEmail());
			ps.setString(3,	((by.eprinting.beans.Order) order).getPhone());
			ps.setString(4,	((by.eprinting.beans.Order) order).getAddress());
			ps.setDate(5, new Date(((by.eprinting.beans.Order) order).getDate().getTime()));
			ps.setLong(6, ((by.eprinting.beans.Order) order).getDocument().getId());
			ps.executeUpdate();

			ResultSet rs = ps.getGeneratedKeys();
			while (rs.next()) id = rs.getInt("id");
			
		} catch (SQLException e) {
			e.printStackTrace();
			
		} finally {
			closeConnection(connection);
		}
		
		return id;
	}
	
	@Override
	public Order selectById(long id) {
		Order order = new Order();
		String sql = "select * from orders where id = ?";
		Connection connection = null;
		
		try {
			connection = getConnection();
			PreparedStatement ps = connection.prepareStatement(sql);
			
			ps.setLong(1, id);
			ResultSet rs = ps.executeQuery();
			
			while (rs.next()) {
				order.setId(rs.getInt("id"));
				order.setFullName(rs.getString("name"));
				order.setEmail(rs.getString("email"));
				order.setPhone(rs.getString("phone"));
				order.setAddress(rs.getString("address"));
				order.setDate(rs.getDate("date"));
				order.setDocument(DocumentDBService.findDocumentById(rs.getInt("documentid")));				
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
			
		} finally {
			closeConnection(connection);
		}
		
		return order;
	}

	@Override
	public <Order> void delete(Order t) {
		by.eprinting.beans.Order order = (by.eprinting.beans.Order) t;
		
		String sql = "delete from orders where id = ?";
		Connection connection = null;
		
		try {
			connection = getConnection();
			PreparedStatement ps = connection.prepareStatement(sql);
			
			ps.setLong(1, order.getId());
			ps.executeUpdate();
						
		} catch (SQLException e) {
			e.printStackTrace();
			
		} finally {
			closeConnection(connection);
		}
	}
}
