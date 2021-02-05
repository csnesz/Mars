package view;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import java.awt.BorderLayout;
import java.awt.SystemColor;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Color;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class Login extends JFrame {

	private control.MainControl main;
	private JPanel panel;
	private JLabel lblLogin;
	private JLabel lblUserName;
	private JLabel lblPassword;
	private JTextField txtuUserName;
	private JButton btnCancel;
	private JButton btnLogin;
	private JPasswordField passwordField;

	public Login() {
		
		System.out.println("login megnyit");
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				main.doExit();
			}
		});

		setBounds(600, 350, 450, 300);
		setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);

		getContentPane().add(getPanel(), BorderLayout.CENTER);
	}

	
	private JPanel getPanel() {
		if (panel == null) {
			panel = new JPanel();
			panel.setForeground(SystemColor.text);
			panel.setBackground(SystemColor.inactiveCaption);
			panel.setLayout(null);
			panel.add(getLblLogin());
			panel.add(getLblUserName());
			panel.add(getLblPassword());
			panel.add(getTxtuUserName());
			panel.add(getBtnCancel());
			panel.add(getBtnLogin());
			panel.add(getPasswordField());

		}
		return panel;
	}

	private JLabel getLblLogin() {
		if (lblLogin == null) {
			lblLogin = new JLabel("Login");
			lblLogin.setBounds(166, 5, 100, 47);
			lblLogin.setForeground(Color.BLACK);
			lblLogin.setFont(new Font("Times New Roman", Font.BOLD, 40));
		}
		return lblLogin;
	}

	private JLabel getLblUserName() {
		if (lblUserName == null) {
			lblUserName = new JLabel("User Name");
			lblUserName.setFont(new Font("Times New Roman", Font.BOLD, 24));
			lblUserName.setBounds(30, 87, 133, 29);
		}
		return lblUserName;
	}

	public JLabel getLblPassword() {
		if (lblPassword == null) {
			lblPassword = new JLabel("Password");
			lblPassword.setFont(new Font("Times New Roman", Font.BOLD, 24));
			lblPassword.setBounds(30, 129, 133, 29);
		}
		return lblPassword;
	}

	public JTextField getTxtuUserName() {
		if (txtuUserName == null) {
			txtuUserName = new JTextField();
			txtuUserName.setFont(new Font("Times New Roman", Font.PLAIN, 20));
			txtuUserName.setBounds(172, 87, 172, 28);
			txtuUserName.setColumns(10);
		}
		return txtuUserName;
	}

	
	
	
	public JPasswordField getPasswordField() {
		if (passwordField == null) {
			passwordField = new JPasswordField();
			passwordField.setBounds(172, 129, 172, 28);
		}
		return passwordField;
	}


	public JButton getBtnCancel() {
		if (btnCancel == null) {
			btnCancel = new JButton("Cancel");
			btnCancel.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {
					main.doExit();
				}
			});
			btnCancel.setFont(new Font("Times New Roman", Font.BOLD, 20));
			btnCancel.setBounds(105, 216, 99, 25);
		}
		return btnCancel;
	}

	public JButton getBtnLogin() {

		if (btnLogin == null) {
			btnLogin = new JButton("Login");
			btnLogin.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					if (txtuUserName.getText().equals("admin")) {
						main.loginAdmin(txtuUserName, passwordField);
					} else {
						main.loginStudent(txtuUserName, passwordField);
					}
				}	});

			btnLogin.setFont(new Font("Times New Roman", Font.BOLD, 20));
			btnLogin.setBounds(227, 216, 99, 25);
		}
		return btnLogin;
	}

	public void setControl(control.MainControl main) {
		this.main = main;
	}

	@Override
	public String toString() {
		return "Login [getTxtuUserName()=" + getTxtuUserName() + "]";
	}

	
	

}
