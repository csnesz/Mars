package model.database;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

import model.database.bean.Student;
import model.database.dao.StudentDao;


public class DatabaseTest {

	public static void main(String[] args) {

//		Method method = null;
//		Object o = null;
//		try {
//			Class<?> c = Class.forName("database.DatabaseFassade");
//			method = DatabaseFassade.class.getMethod("getInstance");
//		    o = method.invoke(null);
//		} catch (Exception e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		} 
		
		
		DatabaseFassade dbfassade = (DatabaseFassade) DatabaseFassade.getInstance(); // Abstrakte Fabrik
		StudentDao studentDAO = new StudentDao();
		//IDatabaseFassade dbfassade = (IDatabaseFassade) o; // Abstrakte Fabrik
		
		dbfassade.openDatabaseConection(); //ok
//Student student;
		//	----------------------------
//	CREATE TABLE OK
//		dbfassade.createTableStudents();  //OK
//		-----------------------
//		DELETE Student OK
//		Student student=new Student(5, "Test", "Test", "Test", null, "Test", "Test", 0, 0, "Test", "Test");
//		 dbfassade.deleteStudent(student, 5 );
//		 System.out.println(student);
//		
//		----------------------
//		FIND Pass OK
//		 String userName="Baba";                         ;//Programban igen, tesztben nem ok
//		dbfassade.findStudentPassByUserN(userName);
//			Student student = new Student(0, userName, userName, userName, null, userName, userName, 0, 0, userName, userName);
//			System.out.println(student);
//		-------------------------
//		 
//		 INSERT OK
//		//# java.util.Date utilDate = new java.util.Date(12-12-2020);
//		//	java.sql.Date sqlDate = new java.sql.Date(utilDate.getTime());
			
//		     long p=2154656;
//		 
//			dbfassade.inserStundet("Test", "Test", "Test", p, "Test", "Test", p, 23130, "Test", "Test");
//		-----------------------
//		
//		STUDENT LIST OK
		List<Student> studentListe = dbfassade.selectAllStudents();
		System.out.println(Arrays.toString(studentListe.toArray())); 
//		-----------------------
//		 UPDATE  OK 
//	int	id=4;
//	 long p=215455656;
//	 Student student=new Student("Test", "Test", "Test", p, "Test", "Test", p, 210, "Test", "Test");
//
//	dbfassade.updateStudent(id, "Test", "Test", "Test", p, "Test", "Test", p, 210, "Test", "Test");
//		 
		 
		 
		 
		
		
		
		
		
	
		dbfassade.closeDatabaseConection();
		dbfassade = null;


}}