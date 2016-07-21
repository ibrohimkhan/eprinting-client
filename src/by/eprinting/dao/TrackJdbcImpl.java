package by.eprinting.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import by.eprinting.beans.Track;
import by.eprinting.services.db.PaymentDBService;

public class TrackJdbcImpl extends BaseDAO {

	@Override
	public <Track> long insert(Track t) {
		by.eprinting.beans.Track track = (by.eprinting.beans.Track) t;
		String sql = "insert into tracks(tracknumber, serialnumber, state, startdate, enddate, paymentid) values (?, ?, ?, ?, ?, ?)";
		
		Connection connection = null;
		long id = 0;
		
		try {
			connection = getConnection();
			PreparedStatement ps = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
			
			ps.setString(1,	track.getTrackNumber());
			ps.setString(2,	track.getSerial());
			ps.setString(3,	track.getState());
			ps.setLong(4, track.getStartDate());
			ps.setLong(5, track.getEndDate());
			ps.setLong(6, track.getPayment().getId());
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
	public Track selectById(long id) {
		Track track = new Track();
		String sql = "select * from tracks where id = ?";
		Connection connection = null;
		
		try {
			connection = getConnection();
			PreparedStatement ps = connection.prepareStatement(sql);
			
			ps.setLong(1, id);
			ResultSet rs = ps.executeQuery();

			while (rs.next()) {
				track.setId(rs.getInt("id"));
				track.setTrackNumber(rs.getString("tracknumber"));
				track.setState(rs.getString("state"));
				track.setStartDate(rs.getLong("startdate"));
				track.setEndDate(rs.getLong("enddate"));
				track.setPayment(PaymentDBService.findPaymentById(rs.getLong("paymentid")));
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
			
		} finally {
			closeConnection(connection);
		}
		
		return track;
	}

	@Override
	public <Track> void delete(Track t) {
		by.eprinting.beans.Track track = (by.eprinting.beans.Track) t;
		
		String sql = "delete from tracks where id = ?";
		Connection connection = null;
		
		try {
			connection = getConnection();
			PreparedStatement ps = connection.prepareStatement(sql);
			
			ps.setLong(1, track.getId());
			ps.executeUpdate();
						
		} catch (SQLException e) {
			e.printStackTrace();
			
		} finally {
			closeConnection(connection);
		}
	}
	
	@Override
	public <Track> void update(Track t) {
		by.eprinting.beans.Track track = (by.eprinting.beans.Track) t;
		String sql = "update tracks set tracknumber = ?, serialnumber = ?, state = ?, startdate = ?, enddate = ?, paymentid = ? where id = ?";
		
		Connection connection = null;
		
		try {
			connection = getConnection();
			PreparedStatement ps = connection.prepareStatement(sql);
			
			ps.setString(1,	track.getTrackNumber());
			ps.setString(2,	track.getSerial());
			ps.setString(3,	track.getState());
			ps.setLong(4, track.getStartDate());
			ps.setLong(5, track.getEndDate());
			ps.setLong(6, track.getPayment().getId());
			ps.setLong(7, track.getId());
			ps.executeUpdate();
						
		} catch (SQLException e) {
			e.printStackTrace();
			
		} finally {
			closeConnection(connection);
		}
	}
	
	@Override
	public <Track, String> Track findBy(String t) {
		java.lang.String sql = (java.lang.String) "select * from tracks where serialnumber = ?";
		by.eprinting.beans.Track track = null;
		
		Connection connection = null;
		
		try {
			connection = getConnection();
			PreparedStatement ps = connection.prepareStatement(sql);
			
			ps.setString(1,	(java.lang.String) t);
			ResultSet rs = ps.executeQuery();
			
			if (rs.next()) {
				track = new by.eprinting.beans.Track();
				track.setId(rs.getInt("id"));
				track.setTrackNumber(rs.getString("tracknumber"));
				track.setState(rs.getString("state"));
				track.setStartDate(rs.getLong("startdate"));
				track.setEndDate(rs.getLong("enddate"));
				track.setPayment(PaymentDBService.findPaymentById(rs.getLong("paymentid")));
			}
						
		} catch (SQLException e) {
			e.printStackTrace();
			
		} finally {
			closeConnection(connection);
		}
		
		return (Track) track;
	}
}