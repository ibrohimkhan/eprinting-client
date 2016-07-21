package by.eprinting.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import by.eprinting.beans.Rate;

public class RateJdbcImpl extends BaseDAO {

	@Override
	public <Rate> long insert(Rate rate) {
		String sql = "insert into rates(format, price) values (?, ?)";
		
		Connection connection = null;
		long id = 0;
		
		try {
			connection = getConnection();
			PreparedStatement ps = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
			
			ps.setString(1,	((by.eprinting.beans.Rate) rate).getFormat());
			ps.setDouble(2,	((by.eprinting.beans.Rate) rate).getPrice());
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
	public Rate selectById(long id) {
		Rate rate = new Rate();
		String sql = "select * from rates where id = ?";
		Connection connection = null;
		
		try {
			connection = getConnection();
			PreparedStatement ps = connection.prepareStatement(sql);
			
			ps.setLong(1, id);
			ResultSet rs = ps.executeQuery();
			
			while (rs.next()) {
				rate.setId(rs.getInt("id"));
				rate.setFormat(rs.getString("format"));
				rate.setPrice(rs.getDouble("price"));
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
			
		} finally {
			closeConnection(connection);
		}
		
		return rate;
	}

	@Override
	public <Rate> void delete(Rate rate) {
		String sql = "delete from rates where id = ?";
		Connection connection = null;
		
		try {
			connection = getConnection();
			PreparedStatement ps = connection.prepareStatement(sql);
			
			ps.setLong(1, ((by.eprinting.beans.Rate) rate).getId());
			ps.executeUpdate();
						
		} catch (SQLException e) {
			e.printStackTrace();
			
		} finally {
			closeConnection(connection);
		}
	}
	
	public Rate findByFormat(String format) {
		String sql = "select * from rates where format = ?";
		Rate rate = new Rate();
		Connection connection = null;
		
		try {
			connection = getConnection();
			PreparedStatement ps = connection.prepareStatement(sql);
			
			ps.setString(1,	format.toUpperCase());
			ResultSet rs = ps.executeQuery();
			
			while (rs.next()) {
				rate.setId(rs.getInt("id"));
				rate.setFormat(rs.getString("format"));
				rate.setPrice(rs.getDouble("price"));
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
			
		} finally {
			closeConnection(connection);
		}
		
		return rate;
	}
}