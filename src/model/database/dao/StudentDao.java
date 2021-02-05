package model.database.dao;

import java.nio.file.attribute.UserPrincipalNotFoundException;
import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import control.MainControl;
import model.database.DatabaseFassade;
import model.database.Toolbox;
import model.database.bean.Student;
import model.database.dao.BasisDao;
import model.table.StudentTableModel;
import view.AdminStudent;
import view.Login;

public class StudentDao {

	// SQL Konstanten
	// create Table WISH_LIST
	private static final String sqlCreateString = "CREATE TABLE STUDENTS(ID INT NOT NULL GENERATED ALWAYS AS IDENTITY, FIRSTNAME VARCHAR(80) NOT NULL,"
			+ " LASTNAME VARCHAR(80) NOT NULL, USERNAME VARCHAR(50) NOT NULL, COURSE VARCHAR(80),  EMAIL VARCHAR(50) NOT NULL, "
			+ "PHONE INT NOT NULL,  POSTCODE INT NOT NULL, ADDRESS VARCHAR(200) NOT NULL, PASSWORD VARCHAR(80) NOT NULL,  BIRTHDATE INT NOT NULL)";

	private Login login = new Login();
	private MainControl main;
	private static DatabaseFassade dbf;
	private static Logger logger = Logger.getLogger(StudentDao.class.getCanonicalName());
	private static Toolbox tool = new Toolbox();

	public static void createTable(Connection con) {
		Statement stmt;
		try {
			if (doesTableExists("STUDENTS", con)) {
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

	public static void insertStudent(Student student) {

		try {
			Connection conn = dbf.getCon();
			PreparedStatement pst = conn
					.prepareStatement("INSERT INTO students(firstname, lastname, username, birthdate, course, "
							+ "email, phone, postcode, address, password) VALUES (?,?,?,?,?,?,?,?,?,?)");

			pst.setString(1, student.getFirstName());
			pst.setString(2, student.getLastName());
			pst.setString(3, student.getUserName());
			pst.setLong(4, student.getBirthDate());

			// pst.setString(4, birthdate);// sql date
			pst.setString(5, student.getCourse());
			pst.setString(6, student.getEmail());
			pst.setLong(7, student.getPhone());
			pst.setInt(8, student.getPostCode());
			pst.setString(9, student.getAddress());
			pst.setString(10, student.getPassword());

			pst.executeUpdate();

			JOptionPane.showMessageDialog(null, "Sucessfull create Student");
		} catch (SQLException ex) {
			logger.log(Level.SEVERE, null, ex);
		}
	}

	public String findPassByUserName(String username) {
		Connection conn = dbf.getCon();
		PreparedStatement pst;
		String query = "select password, username from students where username= ?";
		try  {
			
			pst = conn.prepareStatement(query);
			pst.setString(1, username);

			ResultSet rs = pst.executeQuery();
			if (rs.next()) {
				return rs.getString("password");

			}
		} catch (SQLException e) {
			logger.log(Level.SEVERE, null, e);
		}
		return null;
	}

	public static List<Student> selectAllStudent() {
		Statement stmt;
		List<Student> studentList = new ArrayList();

		dbf = DatabaseFassade.getInstance();

		try {
			Connection conn = dbf.getCon();
			stmt = conn.createStatement();

			String sqlSelect = "select * from students";

			System.out.println("sqlSelect:" + sqlSelect);
			ResultSet rs = stmt.executeQuery(sqlSelect);
			while (rs.next()) {

				int id = rs.getInt("id"); // 1 Spalte -> resultsets fangen mit 1
				String firstname = rs.getString("firstname");
				String lastname = rs.getString("lastname");
				String username = rs.getString("username");
				long birthdate = rs.getLong("birthdate");
				String course = rs.getString("course");
				String email = rs.getString("email");
				long phone = rs.getLong("phone");
				int postcode = rs.getInt("postcode");
				String address = rs.getString("address");
				String password = rs.getString("password");

				studentList.add(new Student(id, firstname, lastname, username, birthdate, course, email, phone,
						postcode, address, password));

			}
			rs.close();
			stmt.close();
		} catch (SQLException ex) {
			logger.log(Level.SEVERE, null, ex);
		}
//System.out.println(studentList);

		return studentList;
	}

	public void updateStudent(Student student, int id) {

		PreparedStatement pst;

		try {
			Connection conn = dbf.getCon();
			pst = conn.prepareStatement(
					"UPDATE Students SET firstname= ?, lastname= ?, username= ?, birthdate= ?, course=?, email=?, phone=?, postcode=?,  address= ?, password=? WHERE id ="
							+ id);

			pst.setString(1, student.getFirstName());
			pst.setString(2, student.getLastName());
			pst.setString(3, student.getUserName());
			pst.setLong(4, student.getBirthDate());

			// pst.setString(4, birthdate);// sql date
			pst.setString(5, student.getCourse());
			pst.setString(6, student.getEmail());
			pst.setLong(7, student.getPhone());
			pst.setInt(8, student.getPostCode());
			pst.setString(9, student.getAddress());
			pst.setString(10, student.getPassword());

			int anzahl = pst.executeUpdate();
			JOptionPane.showMessageDialog(null, "Student Data Updated");

			pst.close();
		} catch (SQLException ex) {
			logger.log(Level.SEVERE, null, ex);

		}
	}
//	
//public void deleteStudent(Integer id,String firstName, String lastName, ...String phone, String address, String password) {
//	
//
//	Connection con = dbf.getCon();
//	PreparedStatement ps;
//
//
//		try {
//			ps = con.prepareStatement("DELETE FROM Students WHERE id = ?");
//			ps.setInt(1, id);
//			if (ps.executeUpdate() > 0) {
//				JOptionPane.showMessageDialog(null, "Student Deleted");
//			}
//
//		} catch (SQLException ex) {
//			logger.log(Level.SEVERE, null, ex);
//		}
//	
//	}	
//
}