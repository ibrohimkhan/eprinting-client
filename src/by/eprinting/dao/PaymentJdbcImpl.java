package by.eprinting.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import by.eprinting.beans.Payment;
import by.eprinting.services.db.OrderDBService;

public class PaymentJdbcImpl extends BaseDAO {

	@Override
	public <Payment> long insert(Payment t) {
		by.eprinting.beans.Payment pay = (by.eprinting.beans.Payment) t;
		String sql = "insert into payments(cents, token, chargeid, status, paid, date, orderid) values (?, ?, ?, ?, ?, ?, ?)";
		
		Connection connection = null;
		long id = 0;
		
		try {
			connection = getConnection();
			PreparedStatement ps = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
			
			ps.setLong(1, pay.getAmountInCents()); 
			ps.setString(2, pay.getToken()); 
			ps.setString(3, pay.getChargeId()); 
			ps.setString(4, pay.getStatus());
			ps.setBoolean(5, pay.isPaid());
			ps.setLong(6, pay.getDate());
			ps.setLong(7, pay.getOrder().getId()); 
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
	public Payment selectById(long id) {
		Payment payment = new Payment();
		String sql = "select * from payments where id = ?";
		Connection connection = null;
		
		try {
			connection = getConnection();
			PreparedStatement ps = connection.prepareStatement(sql);
			
			ps.setLong(1, id);
			ResultSet rs = ps.executeQuery();
			
			while (rs.next()) {
				payment.setId(rs.getInt("id"));
				payment.setOrder(OrderDBService.findOrderById(rs.getLong("orderid")));
				payment.setAmountInCents(rs.getLong("cents"));
				payment.setToken(rs.getString("token"));
				payment.setChargeId(rs.getString("chargeid"));
				payment.setStatus(rs.getString("status"));
				payment.setPaid(rs.getBoolean("paid"));
				payment.setDate(rs.getLong("date"));
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
			
		} finally {
			closeConnection(connection);
		}
		
		return payment;
	}

	@Override
	public <Payment> void delete(Payment t) {
		by.eprinting.beans.Payment pay = (by.eprinting.beans.Payment) t;
		
		String sql = "delete from payments where id = ?";
		Connection connection = null;
		
		try {
			connection = getConnection();
			PreparedStatement ps = connection.prepareStatement(sql);
			
			ps.setLong(1, pay.getId());
			ps.executeUpdate();
						
		} catch (SQLException e) {
			e.printStackTrace();
			
		} finally {
			closeConnection(connection);
		}
	}
}
