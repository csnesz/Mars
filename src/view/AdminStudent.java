package view;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFormattedTextField;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.table.TableModel;
import control.MainControl;
import model.database.bean.Student;
import model.table.StudentTableModel;
import java.awt.Cursor;
import java.awt.ComponentOrientation;



public class AdminStudent extends JFrame {

	private MainControl main;
	
	private JPanel panel;
	private JLabel lblId;
	private JLabel lblFirstName;
	private JLabel lblLastName;
	private JLabel lblUsername;
	private JLabel lblBirthDate;
	private JLabel lblCourse;
	private JLabel lblEmail;
	private JLabel lblPhone;
	private JLabel lblPostCode;
	private JLabel lblAddress;
	private JLabel lblPassword;

	private JTextField textFieldId;
	private JTextField textFieldFirstName;
	private JTextField textFieldLastName;
	private JTextField textFieldUserName;
	private JTextField textFieldBirthDate;
	private JTextField textFieldCourse;
	private JTextField textFieldEmail;
	private JTextField textFieldPhone;
	private JTextField textFieldPostCode;
	private JTextField textFieldAddress;
	private JTextField textFieldPassword;
	private JTextField textFieldSecurityPass;
	private JTextField txthash;
	
	private JButton btnEdit;
	private JButton btnDelete;
	private JButton btnSave;
	private JButton btnLoadStudent;
	private JButton btnExport;
	private JButton btnImport;
	private JButton btnSecurityPassword;

	private JTable table;
	private JPanel buttonPanel;
	private JPanel contentPane;

//	private	Student student;
	private TableModel dataModel;
	private JButton btnPrfung;
		
	
	
	public AdminStudent(){

		setBounds(700, 100, 500, 700);
		
		
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(500, 500, 500, 500));
		setContentPane(contentPane);
		contentPane.setLayout(null);
//		contentPane.add(getPanel());
		contentPane.add(getPanel());
		contentPane.add(getButtonPanel());
//		contentPane.add(getScrollPane(table));
		
		
//		getContentPane().setLayout(null);
//		getContentPane().add(getPanel());

	}

	public void setControl(control.MainControl main) {
		this.main = main;
	}

	
	
	
	@SuppressWarnings("unused")
	public JPanel getPanel() {
		if (panel == null) {
			panel = new JPanel();
			panel.setSize(475, 549);
			panel.setLocation(0, 0);

			panel.setBackground(Color.WHITE);
			panel.setLayout(null);
			// labels
			panel.add(getLblId());
			panel.add(getLblFirstName());
			panel.add(getLblLastName());
			panel.add(getLblUsername());
			panel.add(getLblBirthDate());
			panel.add(getLblCourse());
			panel.add(getLblEmail());
			panel.add(getLblPhone());
			panel.add(getLblPostCode());
			panel.add(getLblAdress());
			panel.add(getLblPassword());

			panel.add(getTextFieldId());
			panel.add(getTextFieldFirstName());
			panel.add(getTextFieldLastName());
			panel.add(getTextFieldUserName());
			panel.add(getTextFieldBirthDate());
			panel.add(getTextFieldCourse());
			panel.add(getTextFieldEmail());
			panel.add(getTextFieldPhone());
			panel.add(getTextFieldPostCode());
			panel.add(getTextFieldAddress());
			panel.add(getTextFieldPassword());
			panel.add(getBtnSecurityPassword());
			panel.add(getTextFieldSecurityPass());
			panel.add(getTxtHash());
//			panel.add(getScrollPane());
//			panel.add(getButtonPanel());
			panel.add(getTable());
			panel.add(getBtnPrfung());
//			panel.add(getBtnBack());

		}
		return panel;
	}

	private JPanel getButtonPanel() {

		if (buttonPanel == null) {
			buttonPanel = new JPanel();
			buttonPanel.setBounds(0, 539, 972, 200);
			buttonPanel.setLayout(null);

			buttonPanel.add(getBtnSave());
			buttonPanel.add(getBtnDelete());
			buttonPanel.add(getBtnLoadStudent());
			buttonPanel.add(getBtnUpdate());
			buttonPanel.add(getBtnExport());
			buttonPanel.add(getBtnImport());

		}
		return buttonPanel;
	}

public JTable getTable() {
	if (table == null) {
		table = new JTable(dataModel);
		table.setRowSelectionAllowed(false);
		table.setSelectionMode(ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);
//		scrollPane.setViewportView(table);
		table.setAutoCreateRowSorter(true);
		}
	return table;
}
	// labels
private JLabel getLblId() {
	if (lblId == null) {
		lblId = new JLabel("Id:");
		lblId.setBounds(83, 70, 93, 22);
		lblId.setHorizontalAlignment(SwingConstants.RIGHT);
		lblId.setFont(new Font("Times New Roman", Font.BOLD, 24));
	}
	return lblId;
}

private JLabel getLblFirstName() {
	if (lblFirstName == null) {
		lblFirstName = new JLabel("First Name:");
		lblFirstName.setBounds(12, 105, 164, 22);
		lblFirstName.setHorizontalAlignment(SwingConstants.RIGHT);
		lblFirstName.setFont(new Font("Times New Roman", Font.BOLD, 24));
	}
	return lblFirstName;
}

private JLabel getLblLastName() {
	if (lblLastName == null) {
		lblLastName = new JLabel("Last Name:");
		lblLastName.setBounds(12, 148, 164, 22);
		lblLastName.setHorizontalAlignment(SwingConstants.RIGHT);
		lblLastName.setFont(new Font("Times New Roman", Font.BOLD, 24));
	}
	return lblLastName;
}

private JLabel getLblUsername() {
	if (lblUsername == null) {
		lblUsername = new JLabel("User Name:");
		lblUsername.setBounds(12, 195, 164, 22);
		lblUsername.setHorizontalAlignment(SwingConstants.RIGHT);
		lblUsername.setFont(new Font("Times New Roman", Font.BOLD, 24));
	}
	return lblUsername;
}

private JLabel getLblBirthDate() {
	if (lblBirthDate == null) {
		lblBirthDate = new JLabel("Birthdate:");
		lblBirthDate.setBounds(12, 238, 164, 22);
		lblBirthDate.setHorizontalAlignment(SwingConstants.RIGHT);
		lblBirthDate.setFont(new Font("Times New Roman", Font.BOLD, 24));
	}
	return lblBirthDate;
}

private JLabel getLblCourse() {
	if (lblCourse == null) {
		lblCourse = new JLabel("Course:");
		lblCourse.setBounds(12, 282, 164, 22);
		lblCourse.setHorizontalAlignment(SwingConstants.RIGHT);
		lblCourse.setFont(new Font("Times New Roman", Font.BOLD, 24));
	}
	return lblCourse;
}

private JLabel getLblEmail() {
	if (lblPhone == null) {
		lblPhone = new JLabel("Email:");
		lblPhone.setBounds(12, 322, 164, 22);
		lblPhone.setHorizontalAlignment(SwingConstants.RIGHT);
		lblPhone.setFont(new Font("Times New Roman", Font.BOLD, 24));
	}
	return lblPhone;
}

private JLabel getLblPhone() {
	if (lblEmail == null) {
		lblEmail = new JLabel("Phone: ");
		lblEmail.setBounds(12, 357, 164, 22);
		lblEmail.setHorizontalAlignment(SwingConstants.RIGHT);
		lblEmail.setFont(new Font("Times New Roman", Font.BOLD, 24));
	}
	return lblEmail;
}

private JLabel getLblPostCode() {
	if (lblPostCode == null) {
		lblPostCode = new JLabel("Post Code:");
		lblPostCode.setBounds(12, 392, 164, 22);
		lblPostCode.setHorizontalAlignment(SwingConstants.RIGHT);
		lblPostCode.setFont(new Font("Times New Roman", Font.BOLD, 24));
	}
	return lblPostCode;
}

private JLabel getLblAdress() {
	if (lblAddress == null) {
		lblAddress = new JLabel("Address:");
		lblAddress.setBounds(12, 427, 164, 22);
		lblAddress.setHorizontalAlignment(SwingConstants.RIGHT);
		lblAddress.setFont(new Font("Times New Roman", Font.BOLD, 24));
	}
	return lblAddress;
}

private JLabel getLblPassword() {
	if (lblPassword == null) {
		lblPassword = new JLabel("Password:");
		lblPassword.setBounds(12, 462, 164, 22);
		lblPassword.setHorizontalAlignment(SwingConstants.RIGHT);
		lblPassword.setFont(new Font("Times New Roman", Font.BOLD, 24));
	}
	return lblPassword;
}

public JTextField getTextFieldId() {
	if (textFieldId == null) {
		textFieldId = new JTextField();
		textFieldId.setBounds(200, 73, 190, 22);
		textFieldId.setColumns(10);
	}
	return textFieldId;
}

public JTextField getTextFieldFirstName() {
	if (textFieldFirstName == null) {
		textFieldFirstName = new JTextField();
		textFieldFirstName.setBounds(200, 108, 190, 22);
		textFieldFirstName.setColumns(10);
	}
	return textFieldFirstName;
}

public JTextField getTextFieldLastName() {
	if (textFieldLastName == null) {
		textFieldLastName = new JTextField();
		textFieldLastName.setBounds(200, 151, 190, 22);
		textFieldLastName.setColumns(10);
	}
	return textFieldLastName;
}

public JTextField getTextFieldUserName() {
	if (textFieldUserName == null) {
		textFieldUserName = new JTextField();
		textFieldUserName.setBounds(200, 198, 190, 22);
		textFieldUserName.setColumns(10);
	}
	return textFieldUserName;
}

public JTextField getTextFieldBirthDate() {
	if (textFieldBirthDate == null) {
		textFieldBirthDate = new JFormattedTextField();
		textFieldBirthDate.setBounds(200, 241, 190, 22);
		textFieldBirthDate.setColumns(10);
	}
	return textFieldBirthDate;
}

public JTextField getTextFieldCourse() {
	if (textFieldCourse == null) {
		textFieldCourse = new JTextField();
		textFieldCourse.setBounds(200, 285, 190, 22);
		textFieldCourse.setColumns(10);
	}
	return textFieldCourse;
}

public JTextField getTextFieldEmail() {
	if (textFieldEmail == null) {
		textFieldEmail = new JTextField();
		textFieldEmail.setBounds(200, 325, 190, 22);
		textFieldEmail.setColumns(10);
	}
	return textFieldEmail;
}

public JTextField getTextFieldPhone() {
	if (textFieldPhone == null) {
		textFieldPhone = new JTextField();
		textFieldPhone.setBounds(200, 360, 190, 22);
		textFieldPhone.setColumns(10);
	}
	return textFieldPhone;
}

public JTextField getTextFieldPostCode() {
	if (textFieldPostCode == null) {
		textFieldPostCode = new JTextField();
		textFieldPostCode.setBounds(200, 395, 190, 22);
		textFieldPostCode.setColumns(10);
	}
	return textFieldPostCode;
}

public JTextField getTextFieldAddress() {
	if (textFieldAddress == null) {
		textFieldAddress = new JTextField();
		textFieldAddress.setBounds(200, 430, 190, 22);
		textFieldAddress.setColumns(10);
	}
	return textFieldAddress;
}

public JTextField getTextFieldPassword() {
	if (textFieldPassword == null) {
		textFieldPassword = new JTextField();
		textFieldPassword.setBounds(200, 465, 190, 22);
		textFieldPassword.setColumns(10);

	}
	return textFieldPassword;
}

	// buttons
	private JButton getBtnSave() {
		if (btnSave == null) {
			btnSave = new JButton("Add Student");
			btnSave.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {

					main.addStudent();
				}
			});
			btnSave.setBounds(300, 15, 171, 32);

			btnSave.setFont(new Font("Times New Roman", Font.BOLD, 24));
		}
		return btnSave;
	}

	private JButton getBtnUpdate() {
		if (btnEdit == null) {
			btnEdit = new JButton("Update");
			btnEdit.setBounds(165, 15, 131, 32);
			btnEdit.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
				main.updateStudent();

				}
			});
			btnEdit.setFont(new Font("Times New Roman", Font.BOLD, 24));
		}
		return btnEdit;
	}

	private JButton getBtnDelete() {
		if (btnDelete == null) {
			btnDelete = new JButton("Delete");
			btnDelete.setBounds(12, 15, 146, 32);
			btnDelete.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {

					int id = Integer.parseInt(textFieldId.getText());
						main.delStudentYesNo(id);
					}
				
			});
			btnDelete.setFont(new Font("Times New Roman", Font.BOLD, 24));
		}
		return btnDelete;
	}

	

//	private void tableModelChanged() {
//		TableModelEvent event = new TableModelEvent(dataModel);
//
//	}

	@Override
	public String toString() {
		return "AdminStudent [textFieldFirstName=" + textFieldFirstName + ", textFieldLastName=" + textFieldLastName
				+ ", textFieldUserName=" + textFieldUserName + ", textFieldBirthDate=" + textFieldBirthDate
				+ ", textFieldEmail=" + textFieldEmail + ", textFieldPhone=" + textFieldPhone + ", textFieldPostCode="
				+ textFieldPostCode + ", textFieldAddress=" + textFieldAddress + ", textFieldCourse=" + textFieldCourse
				+ ", textFieldPassword=" + textFieldPassword + "]";
	}
	
	

	public JButton getBtnLoadStudent() {
		if (btnLoadStudent == null) {
			btnLoadStudent = new JButton("Load Student");
			btnLoadStudent.setBounds(300, 65, 180, 32);
			btnLoadStudent.addActionListener(new ActionListener() {

				public void actionPerformed(ActionEvent e) {
					main.loadData();

				}
			});
			btnLoadStudent.setFont(new Font("Times New Roman", Font.BOLD, 24));
		}
		return btnLoadStudent;
	}

	

	private JButton getBtnExport() {
		if (btnExport == null) {
			btnExport = new JButton("Export");
			btnExport.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					
					main.exportStudent();
				}
			});
			btnExport.setFont(new Font("Times New Roman", Font.BOLD, 24));
			btnExport.setBounds(12, 65, 146, 32);
		}
		return btnExport;
	}

	public void setData(List<Student> studentList) {

		dataModel = new StudentTableModel(studentList);
		System.out.println(studentList);
		getTable().setModel(dataModel);
		JDialog d = new JDialog();
		JTable table = new JTable();
		
		
		table.setModel(dataModel);
		d.getContentPane().add(new JScrollPane(table));

		d.pack();
		d.setVisible(true);
	}
//		f.getT
//		JOptionPane.showMessageDialog(null, getScrollPane(getTable()));
//		this.invalidate();

	
	public JButton getBtnSecurityPassword() {
		if (btnSecurityPassword == null) {
			btnSecurityPassword = new JButton("Security Password");
			btnSecurityPassword.setBounds(0, 2, 256, 37);
			btnSecurityPassword.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					main.secPass();
				}
			});
			btnSecurityPassword.setFont(new Font("Times New Roman", Font.BOLD, 24));
		}
		return btnSecurityPassword;
	}
	public JTextField getTextFieldSecurityPass() {
		if (textFieldSecurityPass == null) {
			textFieldSecurityPass = new JTextField();
			textFieldSecurityPass.setBounds(263, 2, 212, 37);
			textFieldSecurityPass.setColumns(10);
		}
		return textFieldSecurityPass;
	}
	public JTextField getTxtHash() {
		if (txthash == null) {
			txthash = new JTextField();
			txthash.setComponentOrientation(ComponentOrientation.RIGHT_TO_LEFT);
			txthash.setEditable(false);
			
			txthash.setBounds(0, 40, 455, 29);
			txthash.setCursor(Cursor.getPredefinedCursor(Cursor.TEXT_CURSOR));
			txthash.setHorizontalAlignment(SwingConstants.RIGHT);
			txthash.setFont(new Font("Times New Roman", Font.BOLD, 12));
		}
		return txthash;
	}
	private JButton getBtnImport() {
		if (btnImport == null) {
			btnImport = new JButton("Import");
			btnImport.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					main.importStudent();
				}
			});
			btnImport.setFont(new Font("Times New Roman", Font.BOLD, 24));
			btnImport.setBounds(165, 65, 131, 32);
		}
		return btnImport;
	}
	private JButton getBtnPrfung() {
		if (btnPrfung == null) {
			btnPrfung = new JButton("Pr\u00FCfung");
			btnPrfung.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					main.showPrüfung();
				}
			});
			btnPrfung.setFont(new Font("Times New Roman", Font.BOLD, 29));
			btnPrfung.setBounds(30, 492, 445, 44);
		}
		return btnPrfung;
	}
}
