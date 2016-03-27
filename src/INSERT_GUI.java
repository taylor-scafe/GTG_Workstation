import java.awt.Container;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

@SuppressWarnings("serial")
public class INSERT_GUI extends JFrame{
	private Container window;
	private JLabel lbFirstName, lbLastName, lbPhoneNum, lbFaxNum,lbEmailAdd, lbResponce;
	private JTextField tfFirstName, tfLastName, tfPhoneNum, tfFaxNum,tfEmailAdd;
	private JButton btnExecute;
	public INSERT_GUI(){
		super("INSERT_GUI");
		lbFirstName = new JLabel();
		lbLastName = new JLabel();
		lbPhoneNum = new JLabel();
		lbFaxNum = new JLabel();
		lbEmailAdd = new JLabel();
		tfFirstName = new JTextField();
		tfLastName = new JTextField();
		tfPhoneNum = new JTextField();
		tfFaxNum = new JTextField();
		tfEmailAdd = new JTextField();
		btnExecute = new JButton();
		lbResponce = new JLabel();
		
		
		window = getContentPane();
		window.setLayout(new GridLayout(0,2));
		lbFirstName.setText("First Name");
		lbLastName.setText("Last Name");
		lbPhoneNum.setText("Phone Number");
		lbFaxNum.setText("Fax Number");
		lbEmailAdd.setText("Email Address");
		btnExecute.setText("Execute");
		btnExecute.addActionListener(new Execute());
		
		
		
		window.add(lbFirstName);
		window.add(tfFirstName);
		window.add(lbLastName);
		window.add(tfLastName);
		window.add(lbPhoneNum);
		window.add(tfPhoneNum);
		window.add(lbFaxNum);
		window.add(tfFaxNum);
		window.add(lbEmailAdd);
		window.add(tfEmailAdd);
		window.add(btnExecute);
		window.add(lbResponce);
		
		
		setSize(400, 400);
		setVisible(true);
		
	}
	private class Execute implements ActionListener{
		@Override
		public void actionPerformed(ActionEvent ea) {
			if(valadate(tfPhoneNum.getText())&&valadate(tfFaxNum.getText())&& tfFirstName.getText().length()>0 && tfLastName.getText().length()>0){
				String phoneNumber = tfPhoneNum.getText().replaceAll("[^0-9]", "");
				String faxNumber = tfFaxNum.getText().replaceAll("[^0-9]", "");
				SQLDatabase DB = new SQLDatabase("jdbc:sqlserver://acaddb.graceland.edu:1433;"
						+ "databaseName=JAVA_CLASS;user=JavaStudent;password=SQLisfun!");
				DB.OpenSQLConnection();
				DB.executeINSERT("INSERT INTO customer VALUES('"+tfFirstName.getText()+"','"+tfLastName.getText()+"','"+phoneNumber+"','"+faxNumber+"','"+tfEmailAdd.getText()+"');");
				//System.out.println("INSERT INTO customer VALUES('"+tfFirstName.getText()+"','"+tfLastName.getText()+"','"+phoneNumber+"','"+faxNumber+"','"+tfEmailAdd.getText()+"');");
				DB.CloseSQLConnection();
				lbResponce.setText("Insert Sucessful");
			}
			else{
				lbResponce.setText("Input Error");
			}
			//Scrub Fields
			//Create and execute INSERT IF fields match criteria
			//Handle an SQL Error
		}
	}
	private boolean valadate(String input){
		if (input.length()==0){
			return true;
		}
		input = input.replaceAll("[^0-9]", "");
		//System.out.println(input);
		if (input.length()!=10){
			return false;
		}
		else return true;
	}
}
