package by.eprinting.dao;

import java.nio.file.Paths;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import by.eprinting.beans.Document;

public class DocumentJdbcImpl extends BaseDAO {

	@Override
	public <Document> long insert(Document document) {
		String sql = "insert into documents(name, path, format, pages) values (?, ?, ?, ?)";
		
		Connection connection = null;
		long id = 0;
		
		try {
			connection = getConnection();
			PreparedStatement ps = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
			
			ps.setString(1,	((by.eprinting.beans.Document) document).getName());
			ps.setString(2,	((by.eprinting.beans.Document) document).getPath().toAbsolutePath().toString());
			ps.setString(3,	((by.eprinting.beans.Document) document).getFormat());
			ps.setInt(4, ((by.eprinting.beans.Document) document).getTotalPage());
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
	public Document selectById(long id) {
		Document document = new Document();
		String sql = "select * from documents where id = ?";
		Connection connection = null;
		
		try {
			connection = getConnection();
			PreparedStatement ps = connection.prepareStatement(sql);
			
			ps.setLong(1, id);
			ResultSet rs = ps.executeQuery();
			
			while (rs.next()) {
				document.setId(rs.getInt("id"));
				document.setName(rs.getString("name"));
				document.setPath(Paths.get(rs.getString("path")));
				document.setFormat(rs.getString("format"));
				document.setTotalPage(rs.getInt("pages"));
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
			
		} finally {
			closeConnection(connection);
		}
		
		return document;
	}

	@Override
	public <Document> void delete(Document t) {
		by.eprinting.beans.Document document = (by.eprinting.beans.Document) t;
		
		String sql = "delete from documents where id = ?";
		Connection connection = null;
		
		try {
			connection = getConnection();
			PreparedStatement ps = connection.prepareStatement(sql);
			
			ps.setLong(1, document.getId());
			ps.executeUpdate();
						
		} catch (SQLException e) {
			e.printStackTrace();
			
		} finally {
			closeConnection(connection);
		}
	}
}
