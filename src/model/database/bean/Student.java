package model.database.bean;


public class Student {

	private int id = -1;
	private String firstName;
	private String lastName;
	private String userName;
	private long birthDate;
	private String course;
	private String email;
	private long phone;
	private int postCode;
	private String address;
	private String password;


	
	public Student(int id, String firstName, String lastName, String userName, long birthDate, String course,
			String email, long phone, int postCode, String address, String password) {
		super();
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.userName = userName;
		this.birthDate = birthDate;
		this.course = course;
		this.email = email;
		this.phone = phone;
		this.postCode = postCode;
		this.address = address;
		this.password = password;
	}
	

	public Student(String firstName, String lastName, String userName, long birthDate, String course, String email,
			long phone, int postCode, String address, String password) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.userName = userName;
		this.birthDate = birthDate;
		this.course = course;
		this.email = email;
		this.phone = phone;
		this.postCode = postCode;
		this.address = address;
		this.password = password;
	}


	public static int getAnzahlFelder() {
		return 11;
	}

	public static String getColumnName(int column) {
		switch (column) {
		case 0:
			return "id";
		case 1:
			return "firstName";
		case 2:
			return "lastName";
		case 3:
			return "userName";
		case 4:
			return "birthDate";
		case 5:
			return "course";
		case 6:
			return "email";
		case 7:
			return "phone";
		case 8:
			return "postCode";
		case 9:
			return "address";
		default:
			return "password";
		}
	}


	public Student(int id, String firstName, String lastName, String userName, long birthDate, String course,
			String email, long phone, int postCode, String address, String password, String user) {
		super();

		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.userName = userName;
		this.birthDate = birthDate;
		this.course = course;
		this.email = email;
		this.phone = phone;
		this.postCode = postCode;
		this.address = address;
		this.password = password;

	}




	public Student() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return "Student [id=" + id + ", firstName=" + firstName + ", lastName=" + lastName + ", userName=" + userName
				+ ", birthDate=" + birthDate + ", course=" + course + ", email=" + email + ", phone=" + phone
				+ ", postCode=" + postCode + ", address=" + address + ", password=" + password + "]";
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public long getBirthDate() {
		return birthDate;
	}

	public void setBirthDate(long birthDate) {
		this.birthDate = birthDate;
	}

	public String getCourse() {
		return course;
	}

	public void setCourse(String course) {
		this.course = course;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public long getPhone() {
		return phone;
	}

	public void setPhone(long phone) {
		this.phone = phone;
	}

	public int getPostCode() {
		return postCode;
	}

	public void setPostCode(int postCode) {
		this.postCode = postCode;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

}