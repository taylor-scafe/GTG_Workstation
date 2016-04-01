import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.GridLayout;

import javax.swing.BoxLayout;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class GTG_OrderForm extends JPanel{
	
	
	private JLabel firstName,lastName,phoneNum,faxNum,email,customerPONum,
	billTo,btAddr,btCity,btState,btZip,shipTo,stAddr,stCity,stState,stZip;
	
	private JTextField tfirstName,tlastName,tphoneNum,tfaxNum,temail,tcustomerPONum,
	tbillTo,tbtAddr,tbtCity,tbtState,tbtZip,tshipTo,tstAddr,tstCity,tstState,tstZip;
	
	private JPanel custInfo,billInfo,shipInfo,shipInfoSub1,shipInfoSub2,billInfoSub1,billInfoSub2,
	custInfoSub1,custInfoSub2;
	
	public GTG_OrderForm(){
		
		custInfo = new JPanel();
		billInfo = new JPanel();
		shipInfo = new JPanel();
		
		firstName = new JLabel("First Name:");
		tfirstName = new JTextField(8);
		lastName = new JLabel("Last Name:");
		tlastName= new JTextField(8);
		phoneNum = new JLabel("Phone Number:");
		tphoneNum = new JTextField(9);
		faxNum = new JLabel("Fax Number:");
		tfaxNum = new JTextField(9);
		email = new JLabel("Email:");
		temail = new JTextField(20);
		customerPONum = new JLabel("Customer PO#");
		tcustomerPONum = new JTextField(8);
		billTo = new JLabel("Bill To:");
		tbillTo = new JTextField(15);
		btAddr = new JLabel("Address:");
		tbtAddr = new JTextField(20);
		btCity = new JLabel("City:");
		tbtCity = new JTextField(8);
		btState = new JLabel("State:");
		tbtState = new JTextField(2);
		btZip = new JLabel("Zip:");
		tbtZip = new JTextField(5);
		shipTo = new JLabel("Ship To:");
		tshipTo = new JTextField(15);
		stAddr = new JLabel("Address:");
		tstAddr = new JTextField(20);
		stCity = new JLabel("City");
		tstCity= new JTextField(8);
		stState = new JLabel("State");
		tstState= new JTextField(2);
		stZip = new JLabel("Zip:");
		tstZip= new JTextField(5);
		
		custInfoSub1 = new JPanel();
		custInfoSub2 = new JPanel();
		
		custInfoSub1.add(firstName);
		custInfoSub1.add(tfirstName);
		custInfoSub1.add(lastName);
		custInfoSub1.add(tlastName);
		custInfoSub1.add(phoneNum);
		custInfoSub1.add(tphoneNum);
		custInfoSub2.add(faxNum);
		custInfoSub2.add(tfaxNum);
		custInfoSub2.add(email);
		custInfoSub2.add(temail);
		custInfoSub2.add(customerPONum);
		custInfoSub2.add(tcustomerPONum);
		
		custInfoSub1.setLayout(new FlowLayout(FlowLayout.LEFT));
		custInfoSub2.setLayout(new FlowLayout(FlowLayout.LEFT));
		
		custInfo.add(custInfoSub1);
		custInfo.add(custInfoSub2);
		
		billInfoSub1 = new JPanel();
		billInfoSub2 = new JPanel();
		billInfoSub1.add(billTo);
		billInfoSub1.add(tbillTo);
		billInfoSub1.add(btAddr);
		billInfoSub1.add(tbtAddr);
		billInfoSub2.add(btCity);
		billInfoSub2.add(tbtCity);
		billInfoSub2.add(btState);
		billInfoSub2.add(tbtState);
		billInfoSub2.add(btZip);
		billInfoSub2.add(tbtZip);
		
		billInfoSub1.setLayout(new FlowLayout(FlowLayout.LEFT));
		billInfoSub2.setLayout(new FlowLayout(FlowLayout.LEFT));
		
		billInfo.add(billInfoSub1);
		billInfo.add(billInfoSub2);
		
		shipInfoSub1 = new JPanel();
		shipInfoSub2 = new JPanel();
		shipInfoSub1.add(shipTo);
		shipInfoSub1.add(tshipTo);
		shipInfoSub1.add(stAddr);
		shipInfoSub1.add(tstAddr);
		shipInfoSub2.add(stCity);
		shipInfoSub2.add(tstCity);
		shipInfoSub2.add(stState);
		shipInfoSub2.add(tstState);
		shipInfoSub2.add(stZip);
		shipInfoSub2.add(tstZip);
		
		shipInfoSub1.setLayout(new FlowLayout(FlowLayout.LEFT));
		shipInfoSub2.setLayout(new FlowLayout(FlowLayout.LEFT));
		
		shipInfo.add(shipInfoSub1);
		shipInfo.add(shipInfoSub2);
		
		custInfo.setLayout(new BoxLayout(custInfo, BoxLayout.Y_AXIS));
		billInfo.setLayout(new BoxLayout(billInfo, BoxLayout.Y_AXIS));
		shipInfo.setLayout(new BoxLayout(shipInfo, BoxLayout.Y_AXIS));
		
		add(custInfo);
		add(billInfo);
		add(shipInfo);
		
		setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
		
		setSize(660,220);
		setVisible(true);
	}
	
	//custInfo,billInfo,shipInfo,
	public String [] getCustomerInfo(){
		String [] aOut = new String[6];
		aOut[0] = tfirstName.getText();
		aOut[1] = tlastName.getText();
		aOut[2] = tphoneNum.getText();
		aOut[3] = tfaxNum.getText();
		aOut[4] = temail.getText();
		aOut[5] = tcustomerPONum.getText();
		return aOut;
	}
	public String [] getBillingInfo(){
		String [] aOut = new String[5];
		aOut[0] = tbillTo.getText();
		aOut[1] = tbtAddr.getText();
		aOut[2] = tbtCity.getText();
		aOut[3] = tbtState.getText();
		aOut[4] = tbtZip.getText();
		return aOut;
	}
	public String [] getShippingInfo(){
		String [] aOut = new String[5];
		aOut[0] = tshipTo.getText();
		aOut[1] = tstAddr.getText();
		aOut[2] = tstCity.getText();
		aOut[3] = tstState.getText();
		aOut[4] = tstZip.getText();
		return aOut;
	}
}











