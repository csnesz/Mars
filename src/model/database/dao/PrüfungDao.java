package model.database.dao;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.database.DatabaseFassade;
import model.database.bean.Pr�fung;

public class Pr�fungDao {

		
	private static final String sqlCreateString = "CREATE TABLE T_DBVERSION(Name varchar (50))";

	

	private static DatabaseFassade dbf;
	private static Logger logger = Logger.getLogger(Pr�fungDao.class.getCanonicalName());
	
	
	
	
	public static void createTable(Connection con) {
		Statement stmt;
		try {
			if (doesTableExists("T_DBVERSION", con)) {
				System.out.println("DROP Tabelle ja/nein");
			} else {
				stmt = con.createStatement();
				stmt.execute(sqlCreateString);
				stmt.close();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public static boolean doesTableExists(String tableName, Connection con) throws SQLException {
		DatabaseMetaData meta = con.getMetaData();
		ResultSet result = meta.getTables(null, null, tableName.toUpperCase(), null);

		return result.next();
	}

	public static List<Pr�fung> selectAllTDbVersion() {
		Statement stmt;
		List<Pr�fung> pr�fungList = new ArrayList();

		dbf = DatabaseFassade.getInstance();

		try {
			Connection conn = dbf.getCon();
			stmt = conn.createStatement();

			String sqlSelect = "select * from T_DBVERSION";

			System.out.println("sqlSelect:" + sqlSelect);
			ResultSet rs = stmt.executeQuery(sqlSelect);
			while (rs.next()) {
				
				String name = rs.getString("name");
				

				pr�fungList.add(new Pr�fung(name));

			}
			rs.close();
			stmt.close();
		} catch (SQLException ex) {
			logger.log(Level.SEVERE, null, ex);
		}

		return pr�fungList;
	}
	
}
