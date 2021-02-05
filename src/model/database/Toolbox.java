package model.database;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import model.database.bean.Student;
import model.table.StudentTableModel;

public class Toolbox {
	private List<String> studentList = new ArrayList<String>(); 
	private static DatabaseFassade dbf=DatabaseFassade.getInstance();
	private Student student=new Student();
	private static StudentTableModel m= new StudentTableModel(null);
	
	public static void delete(String sqlsdel, int id, Connection con) {
		PreparedStatement stmt;
		int anzahl = 0;
		try {
			stmt = con.prepareStatement(sqlsdel);
			stmt.setInt(1, id);

			System.out.println("sqlsdel:" + sqlsdel);
			anzahl = stmt.executeUpdate();
			stmt.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}
	
	public static void deleteFromTable(String tableName, int id, Connection con) {
		String sqlsdel = "delete from " + tableName + " where id = ?";
		delete(sqlsdel, id, con);
		
	}
	
	
	public static List<Student> importJson(String path) {
		List <Student> students=new ArrayList<>();
		System.out.println(students);
		
        JSONParser jsonParser = new JSONParser();
        try (InputStreamReader reader = new InputStreamReader(new FileInputStream(path), "utf-8"))
        {
            Object obj = jsonParser.parse(reader);
            JSONArray studentList = (JSONArray) obj;
            for(Object student : studentList) {
            	Student st = new Student();
            	JSONObject stJson = (JSONObject) student;
            	JSONObject stObject = (JSONObject)stJson.get("student");
            	
            	st.setId((int) ((Long)stObject.get("id")).intValue());
				st.setFirstName((String) stObject.get("firstname"));
				st.setLastName((String) stObject.get("lastname"));
				st.setUserName((String) stObject.get("username"));
				st.setBirthDate(((Long)stObject.get("birthdate")).longValue());
				st.setCourse((String) stObject.get("course"));
				st.setEmail((String) stObject.get("email"));
				st.setPhone(((Long)stObject.get("phone")).longValue());
				st.setPostCode((int) ((Long)stObject.get("postcode")).intValue());
				st.setAddress((String) stObject.get("address"));
				st.setPassword((String) stObject.get("password"));
				
				students.add(st);
            }
 
        } catch (FileNotFoundException e) {
           JOptionPane.showMessageDialog(null, "File not fund");
        } catch (IOException e) {
        	JOptionPane.showMessageDialog(null, "File read error");
        } catch (ParseException e) {
        	JOptionPane.showMessageDialog(null, "Damaged file");
        }
        return students;
	}
	
	
	@SuppressWarnings("unchecked")
	public static void exportJson(String path) {
		List<Student> studentList =dbf.selectAllStudents();
		System.out.println(studentList);
        JSONArray stList = new JSONArray();
	
	    for(Student st: studentList) {
	    	JSONObject studentListObj = new JSONObject();
		    JSONObject stObj = new JSONObject();
		    stObj.put("id", st.getId());
		    stObj.put("firstname", st.getFirstName());
		    stObj.put("lastname", st.getLastName());
		    stObj.put("username", st.getUserName());
		    stObj.put("birthdate", st.getBirthDate());
		    stObj.put("course", st.getCourse());
		    stObj.put("email", st.getEmail());
		    stObj.put("phone", st.getPhone());
		    stObj.put("postcode", st.getPostCode());
		    stObj.put("address", st.getAddress());
		    stObj.put("password", st.getPassword());
		    
		    studentListObj.put("student", stObj);
		    stList.add(studentListObj);
	    }
 
        try (BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(path), "UTF-8"))) {
            writer.write(stList.toJSONString());
            writer.flush();
        } catch (IOException e) {
        	JOptionPane.showMessageDialog(null, "File write error");
        
        }
       	}
	
	
	
//	
//	
//	public static void saveObjekt(Serializable d, File file) {
//		// Objekserialierung Java
//		// Quelle:http://openbook.rheinwerk-verlag.de/javainsel9/javainsel_17_010.htm#mj69bf799342565da382851751b8405c7a
//		OutputStream fos = null;
//
//		try {
//			fos = new FileOutputStream(file);
//			ObjectOutputStream o = new ObjectOutputStream(fos);
//			o.writeObject(d);
//
//		} catch (IOException e) {
//			System.err.println(e);
//		} finally {
//			try {
//				fos.close();
//			} catch (Exception e) {
//				e.printStackTrace();
//			}
//		}
//	}
//
//	public static Object loadObject(File file) {
//		Object d = null;
//		// Kopieren vom Internet
//		InputStream fis = null;
//
//		try {
//			fis = new FileInputStream(file);
//			ObjectInputStream o = new ObjectInputStream(fis);
//			d =  o.readObject();
//
//		} catch (IOException e) {
//			System.err.println(e);
//		} catch (ClassNotFoundException e) {
//			System.err.println(e);
//		} finally {
//			try {
//				fis.close();
//			} catch (Exception e) {
//				e.printStackTrace();
//			}
//		}
//		return d;
//	}
//	
//	
//	
//	public void exportToExcel(String fileName) {
//		// Objekt für Microsoft Dokument erzeugen
//        
//		Workbook wb = new XSSFWorkbook(); // Excel
//
//		// Excel
//		Sheet sheet = wb.createSheet("StudentList");
//
//		for (int i = 0; i < studentList.size(); i++) {
//			Row row = sheet.createRow(i);
//			Cell cell = row.createCell(0);
//			cell.setCellValue(studentList.get(i));
//		}
//		// In die Datei schreiben
//		try (OutputStream fileOut = new FileOutputStream(fileName)) {
//			wb.write(fileOut);
//		} catch (Exception e1) {
//			e1.printStackTrace();
//		}
//		try {
//			wb.close();
//		} catch (IOException e) {
//			e.printStackTrace();
//		}
//}
		
}