package model.table;

import java.awt.Event;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import javax.swing.event.EventListenerList;
import javax.swing.event.TableModelListener;
import javax.swing.table.AbstractTableModel;

import model.database.DatabaseFassade;
import model.database.bean.Student;

public class StudentTableModel extends AbstractTableModel {

	private static final String[] COLUMNS = new String[] {

			"id", "firstName", "lastName", "userName", "birthDate", "course", "email", "phone", "postcode", "address",
			"password" };

	private static final String[] columnNames = new String[] {

			"ID", "First Name", "Last Name", "User Name", "Birthate", 
			"Course", "Email", "Phone", "Postcode", "Address",
			"Password" };

	private static List<Student> studentList;
	private Map<String, Function<Student, Object>> rowMapper;
	private DatabaseFassade dbf;
	
	public StudentTableModel(List<Student> studentList) {
		this.studentList = studentList;
		rowMapper = new LinkedHashMap<>();
		rowMapper.put("id", Student::getId);
		rowMapper.put("firstName", Student::getFirstName);
		rowMapper.put("lastName", Student::getLastName);
		rowMapper.put("userName", Student::getUserName);
		rowMapper.put("birthDate", Student::getBirthDate);
		rowMapper.put("course", Student::getCourse);
		rowMapper.put("email", Student::getEmail);
		rowMapper.put("phone", Student::getPhone);
		rowMapper.put("postcode", Student::getPostCode);
		rowMapper.put("address", Student::getAddress);
		rowMapper.put("password", Student::getPassword);
	}

	public static void emptyList() {
		studentList.clear();
	}
	

	 
	public void add(Student student) {
		dbf=DatabaseFassade.getInstance();
		studentList=dbf.selectAllStudents();
		
//		System.out.println("in studenttablemodel   add  ++++++++++++++++++++++");          
//		for(StackTraceElement st : Thread.currentThread().getStackTrace()) {
//			System.out.println(st);
//		}
		studentList.add(student);
		int row = studentList.indexOf(student);
		fireTableRowsInserted(row,row);
	}
	public void addAll() {
		
	}
	public void remove(Student student) {
		if(studentList.contains(student)) {
			int row = studentList.indexOf(student);
			studentList.remove(row);
			fireTableRowsDeleted(row, row);
		}
	}
	
	public void remove(int id) {
		Student toRemove = null;
		for(Student book : studentList) {
			if(book.getId() == id) {
				toRemove=book;
			}
		}
		int row = studentList.indexOf(toRemove);
		studentList.remove(toRemove);
		fireTableRowsDeleted(row, row);
	}
	
	@Override
	public int getRowCount() {
		return studentList.size();
	}

	@Override
	public int getColumnCount() {
		return COLUMNS.length;
	}

	@Override
	public String getColumnName(int column) {
		return columnNames[column];
	}

	@Override
	public Object getValueAt(int rowIndex, int columnIndex) {
		
		return rowMapper.get(COLUMNS[columnIndex]).apply(studentList.get(rowIndex));
	}

	public void setValueAt(String value, int rowIndex, int columnIndex) {
		Student student = studentList.get(rowIndex);
	    switch (columnIndex) {
	    	
	    	case 0: 
	    		student.setId(Integer.valueOf(value));
	    		fireTableRowsUpdated(rowIndex, rowIndex);
	    		break;
	        case 1: 
	        	student.setFirstName((String)value);
	        	fireTableRowsUpdated(rowIndex, rowIndex);
	        	break;
	        case 2: 
	        	student.setLastName((String)value);
	        	fireTableRowsUpdated(rowIndex, rowIndex);
	        	break;
	        	
	        case 3: 
	        	student.setUserName((String)value);
	        	fireTableRowsUpdated(rowIndex, rowIndex);
	        	break;
	        case 4: 
	        	student.setBirthDate(Long.valueOf(value));
	        	fireTableRowsUpdated(rowIndex, rowIndex);
	        	break;
	        case 5: 
	        	student.setCourse((String)value);
	        	fireTableRowsUpdated(rowIndex, rowIndex);
	        	break;
	        case 6: 
	        	student.setEmail((String)value);
	        	fireTableRowsUpdated(rowIndex, rowIndex);
	        	break;
	        case 7: 
	        	student.setPhone(Long.valueOf(value));
	        	fireTableRowsUpdated(rowIndex, rowIndex);
	        	break;
	        case 8: 
	        	student.setPostCode(Integer.valueOf(value));
	        	fireTableRowsUpdated(rowIndex, rowIndex);
	        	break;
	        case 9: 
	        	student.setAddress((String)value);
	        	fireTableRowsUpdated(rowIndex, rowIndex);
	        	break;
	        case 10: 
	        	student.setPassword((String)value);
	        	fireTableRowsUpdated(rowIndex, rowIndex);
	        	break;
	    }
	}
	public List<Student> getStudents(){
		return studentList;
	}
}
