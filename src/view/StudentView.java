package view;

import javax.swing.JFrame;
import control.MainControl;
import javax.swing.JLabel;
import java.awt.Font;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.awt.BorderLayout;
import javax.swing.SwingConstants;

import org.apache.derby.client.am.DateTime;

public class StudentView extends JFrame {
	private MainControl main;
	private JLabel lblWelcom;
	private JLabel lblDateTime;
	private DateTime dt;
	
	public StudentView() {
		setBounds(400,400, 609,416);
		getContentPane().setLayout(new BorderLayout(0, 0));
		getContentPane().add(getLblWelcom(), BorderLayout.NORTH);
		getContentPane().add(getLblDateTime(), BorderLayout.CENTER);
		
	}

		public void setControl(MainControl main) {
		this.main = main;

		
	}
	private JLabel getLblWelcom() {
		if (lblWelcom == null) {
			lblWelcom = new JLabel("Welcome Student");
			lblWelcom.setHorizontalAlignment(SwingConstants.CENTER);
			lblWelcom.setFont(new Font("Times New Roman", Font.PLAIN, 40));
		}
		return lblWelcom;
	}


	 Date date = Calendar.getInstance().getTime();  
	DateFormat dateFormat = new SimpleDateFormat("yyyy-mm-dd hh:mm:ss");  
	String strDate = dateFormat.format(date);  
	private JLabel getLblDateTime() {
		if (lblDateTime == null) {
			lblDateTime = new JLabel(strDate);
			lblDateTime.setFont(new Font("Times New Roman", Font.PLAIN, 30));
			lblDateTime.setHorizontalAlignment(SwingConstants.TRAILING);
		}
		return lblDateTime;
	}
}
