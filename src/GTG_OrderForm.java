import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BoxLayout;
import javax.swing.ButtonGroup;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

@SuppressWarnings("serial")
public class GTG_OrderForm extends JPanel implements ActionListener{
	
	
	private JLabel lexistingCust,ldiffBillTo,ldiffShipTo,firstName,lastName,phoneNum,faxNum,email,customerPONum,
	billTo,btAddr,btCity,btState,btZip,shipTo,stAddr,stCity,stState,stZip,lCustState,
	lcustAddr,lcustCity,lcustZip;
	
	private JTextField tfirstName,tlastName,tphoneNum,tfaxNum,temail,tcustomerPONum,
	tbillTo,tbtAddr,tbtCity,tbtZip,tshipTo,tstAddr,tstCity,tstZip,
	custAddr,custCity,custZip;
	
	private JPanel custInfo,billInfo,shipInfo,shipInfoSub1,shipInfoSub2,billInfoSub1,billInfoSub2,
	custInfoSub3,custInfoSub1,custInfoSub2,custInfoSub0,shipInfoSub0,billInfoSub0;
	
	private JCheckBox existingCust,diffBillTo,diffShipTo;
	
	
	
	private JComboBox<String> jcbCustState,jcbBillToState,jcbShipToState;
	
	public GTG_OrderForm(){
		
		custInfo = new JPanel();
		billInfo = new JPanel();
		shipInfo = new JPanel();
		
		
		lexistingCust = new JLabel("Existing Customer:");
		existingCust = new JCheckBox();
		existingCust.addActionListener(this);
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
		lcustAddr = new JLabel("Address:");
		custAddr = new JTextField(15);
		lcustCity = new JLabel("City:");
		custCity = new JTextField(8);
		lCustState = new JLabel("State:");
		jcbCustState = GTG_Utility.SimpleSQLComboBox(GTG_Utility.DB.getRSstates());
		jcbCustState.setBackground(Color.white);
		lcustZip = new JLabel("Zip:");
		custZip = new JTextField(5);
		
		ldiffBillTo = new JLabel("Different Billing Address:");
		diffBillTo = new JCheckBox();
		diffBillTo.addActionListener(this);
		billTo = new JLabel("Bill To:");
		tbillTo = new JTextField(15);
		btAddr = new JLabel("Address:");
		tbtAddr = new JTextField(20);
		btCity = new JLabel("City:");
		tbtCity = new JTextField(8);
		btState = new JLabel("State");
		jcbBillToState  = GTG_Utility.SimpleSQLComboBox(GTG_Utility.DB.getRSstates());
		jcbBillToState.setBackground(Color.white);
		btZip = new JLabel("Zip:");
		tbtZip = new JTextField(5);
		
		ldiffShipTo = new JLabel("Different Shipping Address:");
		diffShipTo = new JCheckBox();
		diffShipTo.addActionListener(this);
		shipTo = new JLabel("Ship To:");
		tshipTo = new JTextField(15);
		stAddr = new JLabel("Address:");
		tstAddr = new JTextField(20);
		stCity = new JLabel("City");
		tstCity= new JTextField(8);
		stState = new JLabel("State");
		jcbShipToState = GTG_Utility.SimpleSQLComboBox(GTG_Utility.DB.getRSstates());
		jcbShipToState.setBackground(Color.white);
		stZip = new JLabel("Zip:");
		tstZip= new JTextField(5);
		
		custInfoSub0 = new JPanel();
		custInfoSub1 = new JPanel();
		custInfoSub2 = new JPanel();
		custInfoSub3 = new JPanel();
		
		custInfoSub0.add(lexistingCust);
		custInfoSub0.add(existingCust);
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
		custInfoSub3.add(lcustAddr);
		custInfoSub3.add(custAddr);
		custInfoSub3.add(lcustCity);
		custInfoSub3.add(custCity);
		custInfoSub3.add(lCustState);
		custInfoSub3.add(jcbCustState);
		custInfoSub3.add(lcustZip);
		custInfoSub3.add(custZip);
		
		custInfoSub0.setLayout(new FlowLayout(FlowLayout.LEFT));
		custInfoSub1.setLayout(new FlowLayout(FlowLayout.LEFT));
		custInfoSub2.setLayout(new FlowLayout(FlowLayout.LEFT));
		custInfoSub3.setLayout(new FlowLayout(FlowLayout.LEFT));
		
		custInfo.add(custInfoSub0);
		custInfo.add(custInfoSub1);
		custInfo.add(custInfoSub2);
		custInfo.add(custInfoSub3);
		
		
		
		billInfoSub0 = new JPanel();
		billInfoSub1 = new JPanel();
		billInfoSub2 = new JPanel();
		
		billInfoSub0.add(ldiffBillTo);
		billInfoSub0.add(diffBillTo);
		billInfoSub1.add(billTo);
		billInfoSub1.add(tbillTo);
		billInfoSub1.add(btAddr);
		billInfoSub1.add(tbtAddr);
		billInfoSub2.add(btCity);
		billInfoSub2.add(tbtCity);
		billInfoSub2.add(btState);
		billInfoSub2.add(jcbBillToState);
		billInfoSub2.add(btZip);
		billInfoSub2.add(tbtZip);
		
		billInfoSub0.setLayout(new FlowLayout(FlowLayout.LEFT));
		billInfoSub1.setLayout(new FlowLayout(FlowLayout.LEFT));
		billInfoSub2.setLayout(new FlowLayout(FlowLayout.LEFT));
		
		billInfo.add(billInfoSub0);
		billInfo.add(billInfoSub1);
		billInfo.add(billInfoSub2);
		
		shipInfoSub0 = new JPanel();
		shipInfoSub1 = new JPanel();
		shipInfoSub2 = new JPanel();
		
		shipInfoSub0.add(ldiffShipTo);
		shipInfoSub0.add(diffShipTo);
		shipInfoSub1.add(shipTo);
		shipInfoSub1.add(tshipTo);
		shipInfoSub1.add(stAddr);
		shipInfoSub1.add(tstAddr);
		shipInfoSub2.add(stCity);
		shipInfoSub2.add(tstCity);
		shipInfoSub2.add(stState);
		shipInfoSub2.add(jcbShipToState);
		shipInfoSub2.add(stZip);
		shipInfoSub2.add(tstZip);
		
		
		jcbCustState.setEditable(false);
		jcbBillToState.setEditable(false);
		jcbShipToState.setEditable(false);
		jcbBillToState.setEnabled(false);
		jcbShipToState.setEnabled(false);
		tbillTo.setEditable(false);
		tbtAddr.setEditable(false);
		tbtCity.setEditable(false);
		tbtZip.setEditable(false);
		tshipTo.setEditable(false);
		tstAddr.setEditable(false);
		tstCity.setEditable(false);
		tstZip.setEditable(false);
		
		
		shipInfoSub0.setLayout(new FlowLayout(FlowLayout.LEFT));
		shipInfoSub1.setLayout(new FlowLayout(FlowLayout.LEFT));
		shipInfoSub2.setLayout(new FlowLayout(FlowLayout.LEFT));
		
		shipInfo.add(shipInfoSub0);
		shipInfo.add(shipInfoSub1);
		shipInfo.add(shipInfoSub2);
		
		custInfo.setLayout(new BoxLayout(custInfo, BoxLayout.Y_AXIS));
		billInfo.setLayout(new BoxLayout(billInfo, BoxLayout.Y_AXIS));
		shipInfo.setLayout(new BoxLayout(shipInfo, BoxLayout.Y_AXIS));
		
		add(custInfo);
		add(new JPanel());
		add(new JPanel());
		add(billInfo);
		add(new JPanel());
		add(new JPanel());
		add(shipInfo);
		
		setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
		
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
		aOut[3] = ((String)jcbBillToState.getSelectedItem());
		aOut[4] = tbtZip.getText();
		return aOut;
	}
	public String [] getShippingInfo(){
		String [] aOut = new String[5];
		aOut[0] = tshipTo.getText();
		aOut[1] = tstAddr.getText();
		aOut[2] = tstCity.getText();
		aOut[3] = ((String)jcbShipToState.getSelectedItem());
		aOut[4] = tstZip.getText();
		return aOut;
	}

	
	@Override
	public void actionPerformed(ActionEvent e) {
		JCheckBox b = ((JCheckBox)e.getSource());
		if(b.equals(existingCust)){
			//WRITE REAL LOGIC HERE
			int i = 5;
		}
		else if(b.equals(diffBillTo)){
			if(b.isSelected()){
				tbillTo.setEditable(true);
				tbtAddr.setEditable(true);
				tbtCity.setEditable(true);
				tbtZip.setEditable(true);
				jcbBillToState.setEnabled(true);
			}
			else{
				tbillTo.setEditable(false);
				tbtAddr.setEditable(false);
				tbtCity.setEditable(false);
				tbtZip.setEditable(false);
				jcbBillToState.setEnabled(false);
			}
		}
		else{
			if(b.isSelected()){
				tshipTo.setEditable(true);
				tstAddr.setEditable(true);
				tstCity.setEditable(true);
				tstZip.setEditable(true);
				jcbShipToState.setEnabled(true);
			}
			else{
				tshipTo.setEditable(false);
				tstAddr.setEditable(false);
				tstCity.setEditable(false);
				tstZip.setEditable(false);
				jcbShipToState.setEnabled(false);
			}
		}
		
	}
}











