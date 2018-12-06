package com.myapp.DAO;

import java.io.IOException;
import java.io.InputStream;
import java.sql.*;
import java.util.Properties;


public class DBConnection {
	protected Connection conn = null;
	protected PreparedStatement ps = null;
	protected ResultSet rs = null;

	protected Connection getConnection() throws ClassNotFoundException,
	IOException, SQLException {
	final Properties prop = new Properties();
	final InputStream inputStream = DBConnection.class.getClassLoader()
			.getResourceAsStream("db.properties");
	prop.load(inputStream);
	Class.forName(prop.getProperty("driver"));
	final Connection connection = DriverManager.getConnection(prop.getProperty("url"), 
			prop.getProperty("user"), prop.getProperty("password"));
	return connection;
	}

	protected void dispose(Connection conn, PreparedStatement ps, ResultSet rs) {
		try {
			if (rs != null && !rs.isClosed()) {
				rs.close();
			}
			if (ps != null && !ps.isClosed()) {
				ps.close();
			}
			if (conn != null && !conn.isClosed()) {
				conn.close();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
