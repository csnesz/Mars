package model.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.List;
import javax.swing.JOptionPane;
import control.MainControl;
import model.database.bean.Prüfung;
import model.database.bean.Student;
import model.database.dao.PrüfungDao;
import model.database.dao.StudentDao;
import view.Login;




public class DatabaseFassade {

	private static final String driver = "org.apache.derby.jdbc.ClientDriver"; // aus Doku
	private static final String connectionURL = "jdbc:derby://localhost:1527/mars;create=true";
	private static final String Connection = null;

	private static DatabaseFassade instance = new DatabaseFassade();
	private static Connection con=getCon();
//	private static Login login;
	private MainControl main;
	private static StudentDao studentDao= new StudentDao();
	
	///
	private PrüfungDao prüfungDao=new PrüfungDao();
	private Toolbox tool = new Toolbox();
	private DatabaseFassade() {
		try {
			// 1 Treiber Laden
			Class.forName(driver);
			System.out.println("Treiber geladen");

		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}

	}


	public  void openDatabaseConection() {
		try {
			setCon(DriverManager.getConnection(connectionURL, "admin", "a"));
			System.out.println("Database geöffnet");
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null, "Database connection error");
			e.printStackTrace();
		}
	
return;
	}
public void SetControl(MainControl main) {
	this.main=main;
}

	public void closeDatabaseConection() {
		try {
			getCon().close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public static DatabaseFassade getInstance() {
		return instance;

	}

	public static void createTableStudents() {
		studentDao.createTable(getCon());

	}
	//STUDENT
	//CREATE
	public void insertStundet(Student student) {
		studentDao.insertStudent(student);
	}
	
	//READ
	public List<Student> selectAllStudents() {
		return studentDao.selectAllStudent();
	}
	
	public void findStudentPassByUserN(String userName) {
//		StudentDao studentdao = new StudentDao();
		 studentDao.findPassByUserName(userName);
	}

	//UPDATE
	public void updateStudent(Student student, int id) {
		studentDao.updateStudent(student, id);
		
	}
	//DELETE
	public void deleteStudent(int id) {
		Toolbox.delete("delete from Students where id = ?",id, getCon());
		JOptionPane.showMessageDialog(null, "Student successfully deleted");
	}
	
	
	
	
	
	//CONNECTION
	public static Connection getCon() {
		return con;
	}

	public static void setCon(Connection con) {
		DatabaseFassade.con = con;
	}
	
	
	
	//PRÜFUNG
	
	public List <Prüfung> selectAllPrüfung(){
		return prüfungDao.selectAllTDbVersion();
	}
}