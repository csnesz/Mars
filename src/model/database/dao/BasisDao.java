package model.database.dao;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class BasisDao {

	public static  boolean  doesTableExists(String tableName, Connection conn) throws SQLException {
		DatabaseMetaData meta = conn.getMetaData();
		ResultSet result = meta.getTables(null, null, tableName.toUpperCase(), null);
	
		return result.next();
	}

	public void delete(int id,Connection con,String tableName ) {
		PreparedStatement stmt;
		int anzahl = 0;
		try {
		String sqlsdel = "delete from"+ tableName +"where ID = ?";  
			stmt = con.prepareStatement(sqlsdel);
			stmt.setInt(1, id);

			System.out.println("sqlsdel:" + sqlsdel);
			anzahl = stmt.executeUpdate();
			stmt.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}	
	
}
