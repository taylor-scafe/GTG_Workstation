import java.awt.Color;
import java.awt.Component;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollBar;
import javax.swing.JScrollPane;
import javax.swing.JTextField;

@SuppressWarnings("serial")
public class GTG_OrderForm extends JScrollPane implements ActionListener{
	private int y = 0;
	private int x = 0;
	private GridBagLayout orderTable;

	private JLabel lexistingCust,ldiffBillTo,ldiffShipTo,firstName,lastName,phoneNum,faxNum,email,customerPONum,
	billTo,btAddr,btCity,btState,btZip,shipTo,stAddr,stCity,stState,stZip,lCustState,
	lcustAddr,lcustCity,lcustZip,existingCustsLabel;

	private JTextField tfirstName,tlastName,tphoneNum,tfaxNum,temail,tcustomerPONum,
	tbillTo,tbtAddr,tbtCity,tbtZip,tshipTo,tstAddr,tstCity,tstZip,
	custAddr,custCity,custZip;

	private JPanel custInfo,billInfo,shipInfo,shipInfoSub1,shipInfoSub2,billInfoSub1,billInfoSub2,
	custInfoSub3,custInfoSub1,custInfoSub2,custInfoSub0,shipInfoSub0,billInfoSub0,orderArea,
	customerForm,spacer,spacer1,masterPanel,customerFormCheckPane,existCustDropDownPane;

	private JCheckBox existingCust,diffBillTo,diffShipTo;

	private JComboBox<String> jcbCustState,jcbBillToState,jcbShipToState,jcbCustomers;

	public JScrollBar vertical;
	
	private JButton addNewRecord;
	
	private String sCurrentCust;

	public GTG_OrderForm(){
		super(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
		masterPanel = new JPanel();
		masterPanel.setLayout(new BoxLayout(masterPanel, BoxLayout.Y_AXIS));
		GTG_CustomerForm();
		spacer = new JPanel();
		spacer1 = new JPanel();
		masterPanel.add(spacer);
		masterPanel.add(spacer1);
		addNewRecord = new JButton("Add new record");
		addNewRecord.addActionListener(new AddLine());
		masterPanel.add(addNewRecord);
		GTG_OrderTable();
		
		
		this.setViewportView(masterPanel);
		vertical = getVerticalScrollBar();
		this.setVisible(true);
	}


	private void mirrorToBilling(){
		String [] custInfo = getCustomerInfo();
		tbtAddr.setText(custInfo[6]);
		tbtCity.setText(custInfo[7]);
		jcbBillToState.setSelectedIndex(jcbCustState.getSelectedIndex());
		tbtZip.setText(custInfo[9]);
	}
	private void mirrorToShipping(){
		String [] custInfo = getCustomerInfo();
		tstAddr.setText(custInfo[6]);
		tstCity.setText(custInfo[7]);
		jcbShipToState.setSelectedIndex(jcbCustState.getSelectedIndex());
		tstZip.setText(custInfo[9]);
	}
	private void GTG_CustomerForm(){
		customerForm = new JPanel();
		
		custInfo = new JPanel();
		billInfo = new JPanel();
		shipInfo = new JPanel();


		lexistingCust = new JLabel("Existing Customer:");
		existingCust = new JCheckBox();
		existingCust.addActionListener(this);
		
		customerFormCheckPane = new JPanel(new FlowLayout(FlowLayout.LEFT));
		customerFormCheckPane.add(lexistingCust);
		customerFormCheckPane.add(existingCust);
		
		customerForm.add(customerFormCheckPane);
		
		firstName = new JLabel("First Name:");
		tfirstName = new JTextField(8);
		tfirstName.addKeyListener(new typeListener());
		lastName = new JLabel("Last Name:");
		tlastName= new JTextField(8);
		tlastName.addKeyListener(new typeListener());
		phoneNum = new JLabel("Phone Number:");
		tphoneNum = new JTextField(9);
		tphoneNum.addKeyListener(new typeListener());
		faxNum = new JLabel("Fax Number:");
		tfaxNum = new JTextField(9);
		tfaxNum.addKeyListener(new typeListener());
		email = new JLabel("Email:");
		temail = new JTextField(20);
		temail.addKeyListener(new typeListener());
		customerPONum = new JLabel("Customer PO#");
		tcustomerPONum = new JTextField(8);		
		tcustomerPONum.addKeyListener(new typeListener());
		lcustAddr = new JLabel("Address:");
		custAddr = new JTextField(15);
		custAddr.addKeyListener(new typeListener());
		lcustCity = new JLabel("City:");
		custCity = new JTextField(8);
		custCity.addKeyListener(new typeListener());
		lCustState = new JLabel("State:");
		jcbCustState = GTG_Utility.SimpleSQLComboBox(GTG_Utility.DB.getRSstates());
		jcbCustState.setBackground(Color.white);
		jcbCustState.setSelectedItem("MO");
		jcbCustState.addActionListener(new typeListener());
		lcustZip = new JLabel("Zip:");
		custZip = new JTextField(5);
		custZip.addKeyListener(new typeListener());

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
		jcbBillToState.setSelectedItem("MO");
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
		jcbShipToState.setSelectedItem("MO");
		stZip = new JLabel("Zip:");
		tstZip= new JTextField(5);

		custInfoSub0 = new JPanel();
		custInfoSub1 = new JPanel();
		custInfoSub2 = new JPanel();
		custInfoSub3 = new JPanel();
				
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

		customerForm.setLayout(new BoxLayout(customerForm,BoxLayout.Y_AXIS));
		customerForm.add(custInfo);
		customerForm.add(new JPanel());
		customerForm.add(new JPanel());
		customerForm.add(billInfo);
		customerForm.add(new JPanel());
		customerForm.add(new JPanel());
		customerForm.add(shipInfo);

		customerForm.setVisible(true);
		
		masterPanel.add(customerForm);
		
		String SQL = "select lastName,firstName from customer order by lastName";
		jcbCustomers = GTG_Utility.SimpleSQLComboBox(GTG_Utility.DB.executeSELECT(SQL));
		jcbCustomers.addActionListener(new CustListListener());
		
		
		existingCustsLabel = new JLabel("Customer List:");
	}

	private void fillCustInfo(){
		String [] name = sCurrentCust.split(",");
		String SQL = "select * from fullCustInfo where firstName ="
				+ " '"+ name[1] +"' and lastName = '" +name[0] +  "'";
		Object [][] results = GTG_Utility.DB.executeSELECT(SQL);
		String [] cInfo = new String [9];
		for(int i = 0; i < 9; i ++){
			cInfo[i] = results[1][i] + "";
		}
		tfirstName.setText(cInfo[0]);
		tlastName.setText(cInfo[1]);
		if(!cInfo[2].equals("null")){
			tphoneNum.setText(cInfo[2]);
		}
		if(!cInfo[3].equals("null")){
			System.out.println(cInfo[3]);
			tfaxNum.setText(cInfo[3]);
		}
		if(!cInfo[4].equals("null")){
			temail.setText(cInfo[4]);
		}
		//IMPLEMENT CUSTOMER PO NUMBER!!!
		
		custAddr.setText(cInfo[5]);
		custCity.setText(cInfo[6]);
		jcbCustState.setSelectedIndex(Integer.parseInt(cInfo[7])-1);
		custZip.setText(cInfo[8]);
	}
	
	//custInfo,billInfo,shipInfo,
	public String [] getCustomerInfo(){
		String [] aOut = new String[10];
		aOut[0] = tfirstName.getText();
		aOut[1] = tlastName.getText();
		aOut[2] = tphoneNum.getText();
		aOut[3] = tfaxNum.getText();
		aOut[4] = temail.getText();
		aOut[5] = tcustomerPONum.getText();
		aOut[6] = custAddr.getText();
		aOut[7] = custCity.getText();
		aOut[8] = ((String)jcbCustState.getSelectedItem());
		aOut[9] = custZip.getText();
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


	private void GTG_OrderTable() {
		orderArea = new JPanel();
		orderTable = new GridBagLayout();
		orderTable.columnWidths = new int[]{0, 0, 0};
		orderTable.rowHeights = new int[]{0, 0};
		orderTable.columnWeights = new double[]{0.0, 0.0, Double.MIN_VALUE};
		orderTable.rowWeights = new double[]{0.0, Double.MIN_VALUE};
		orderArea.setLayout(orderTable);
		orderArea.setVisible(true);
		String[] headers = {"Quantity","Size","Shirt Style","Job Description","Color","Price","Total"};


		for(int i=0;i<headers.length;i++){
			JLabel jlbHeader = new JLabel();
			jlbHeader.setText(headers[i]);
			jlbHeader.setFont(new Font("Tahoma", Font.PLAIN, 20));
			orderArea.add(jlbHeader, getConstraints(i,0));
		}
		y++;
		addOrderLine();
		addOrderLine();
		JPanel spacer = new JPanel();
		GridBagConstraints spacerC = getConstraints(0, 1000);
		spacerC.weighty = 1.0;
		orderArea.add(spacer, spacerC);
		masterPanel.add(orderArea);
		//orderScroll.setAlignmentX(Component.CENTER_ALIGNMENT);
	}
	public void addOrderLine(){
		x=0;
		JTextField jtfQuantity = new JTextField(2);
		jtfQuantity.setFont(new Font("Tahoma", Font.PLAIN, 20));
		orderArea.add(jtfQuantity, getConstraints(x,y));
		x++;
		JComboBox<String> jcbSize = GTG_Utility.SimpleSQLComboBox(GTG_Utility.DB.getRSsizes());
		orderArea.add(jcbSize, getConstraints(x,y));
		x++;
		JComboBox<String> jcbShirtStyle = GTG_Utility.SimpleSQLComboBox(GTG_Utility.DB.getRScolors());
		orderArea.add(jcbShirtStyle, getConstraints(x,y));
		x++;
		JTextField jtfDescription = new JTextField(17);
		jtfDescription.setFont(new Font("Tahoma", Font.PLAIN, 20));
		orderArea.add(jtfDescription, getConstraints(x,y));
		x++;
		JComboBox<String> jcbColor = GTG_Utility.SimpleSQLComboBox(GTG_Utility.DB.getRScolors());
		orderArea.add(jcbColor, getConstraints(x,y));
		x++;
		JTextField jtfPrice = new JTextField(7);
		jtfPrice.setFont(new Font("Tahoma", Font.PLAIN, 20));
		orderArea.add(jtfPrice, getConstraints(x,y));
		x++;
		JTextField jtfTotal = new JTextField(7);
		jtfTotal.setFont(new Font("Tahoma", Font.PLAIN, 20));
		orderArea.add(jtfTotal, getConstraints(x,y));
		x++;
		JButton jbnCopyLine = new JButton("Copy Line");
		jbnCopyLine.setFont(new Font("Tahoma", Font.PLAIN, 14));
		jbnCopyLine.setName(""+y);
		jbnCopyLine.addActionListener(new CopyLine());
		orderArea.add(jbnCopyLine,getConstraints(x, y));
		x++;
		JButton jbnDeleteLine = new JButton("Delete Line");
		jbnDeleteLine.setFont(new Font("Tahoma", Font.PLAIN, 14));
		jbnDeleteLine.setName(""+y);
		jbnDeleteLine.addActionListener(new DeleteLine());
		orderArea.add(jbnDeleteLine,getConstraints(x, y));
		y++;
	}

	private GridBagConstraints getConstraints(int x, int y) {
		GridBagConstraints temp = new GridBagConstraints();
		temp.fill = GridBagConstraints.HORIZONTAL;
		temp.gridx = x;
		temp.gridy = y;
		temp.insets = new Insets(5,5,5,5);
		//System.out.println(x+" "+y);
		temp.anchor = GridBagConstraints.NORTH;
		temp.weighty = 0;
		//temp.weighty = 0;
		//temp.anchor = GridBagConstraints.NORTH;
		//System.out.println(x + " "+y);
		return temp;
	}
	private class CopyLine implements ActionListener{
		@Override
		public void actionPerformed(ActionEvent ea) {
			JButton selectedButton = (JButton) ea.getSource();
			int row = Integer.parseInt(selectedButton.getName());
			addOrderLine();
			orderArea.revalidate();
			vertical.setValue(vertical.getMaximum());
			int nextRow = y-1;
			for(int i=0; i<x;i++){
				Component origin = null;
				Component copy = null;
				for (Component comp : orderArea.getComponents()) {
					GridBagConstraints gbc = orderTable.getConstraints(comp);
					if (gbc.gridx == i && gbc.gridy == row) {
						origin = comp;
					}
					else if(gbc.gridx == i && gbc.gridy == nextRow){
						copy = comp;
						break;
					}
				}
				try{
					JTextField jtfOrigin = (JTextField) origin;
					JTextField jtfCopy = (JTextField) copy;
					jtfCopy.setText(jtfOrigin.getText());
				}catch(Exception e){
					//System.out.println("text fail");

				}
				try{
					JComboBox<?> jcbOrigin = (JComboBox<?>) origin;
					JComboBox<?> jcbCopy = (JComboBox<?>) copy;
					jcbCopy.setSelectedIndex(jcbOrigin.getSelectedIndex());
				}catch(Exception e){
					//System.out.println("combo fail");
				}

			}
		}
	}
	private class DeleteLine implements ActionListener{
		@Override
		public void actionPerformed(ActionEvent ea) {
			JButton selected = (JButton) ea.getSource();
			int row = Integer.parseInt(selected.getName());
			for (Component comp : orderArea.getComponents()){
				GridBagConstraints gbc = orderTable.getConstraints(comp);
				if (gbc.gridy == row) {
					orderArea.remove(comp);
				}
			}
			orderArea.revalidate();
			orderArea.repaint();
			vertical.setValue(vertical.getMaximum());
		}
	}
	private class AddLine implements ActionListener{
		@Override
		public void actionPerformed(ActionEvent ea) {
			addOrderLine();
			orderArea.revalidate();
			orderArea.repaint();
			vertical.setValue(vertical.getMaximum());
		}
	}
	private class CustListListener implements ActionListener{
		@Override
		public void actionPerformed(ActionEvent e) {
			@SuppressWarnings("rawtypes")
			JComboBox b = (JComboBox)e.getSource();
			sCurrentCust = ((String)b.getSelectedItem());
			fillCustInfo();
			mirrorToBilling();
			mirrorToShipping();
		}
		
	}
	private class typeListener implements KeyListener,ActionListener{

		@Override
		public void keyTyped(KeyEvent e) {
			if(!diffBillTo.isSelected()){
				mirrorToBilling();
			}
			if(!diffShipTo.isSelected()){
				mirrorToShipping();
			}
		}
		@Override
		public void keyPressed(KeyEvent e) {
			if(!diffBillTo.isSelected()){
				mirrorToBilling();
			}
			if(!diffShipTo.isSelected()){
				mirrorToShipping();
			}
		}
		@Override
		public void keyReleased(KeyEvent e) {
			if(!diffBillTo.isSelected()){
				mirrorToBilling();
			}
			if(!diffShipTo.isSelected()){
				mirrorToShipping();
			}
		}
		@Override
		public void actionPerformed(ActionEvent e) {
			if(!diffBillTo.isSelected()){
				mirrorToBilling();
			}
			if(!diffShipTo.isSelected()){
				mirrorToShipping();
			}
		}
		
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		JCheckBox b = ((JCheckBox)e.getSource());
		if(b.equals(existingCust)){
			if(b.isSelected()){
				existCustDropDownPane = new JPanel(new FlowLayout(FlowLayout.LEFT));
				existCustDropDownPane.add(existingCustsLabel);
				existCustDropDownPane.add(jcbCustomers);
				customerForm.add(existCustDropDownPane,1);
				customerForm.setVisible(false);
				customerForm.setVisible(true);
			}
			else{
				customerForm.remove(existCustDropDownPane);
				customerForm.setVisible(false);
				customerForm.setVisible(true);
			}
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
				mirrorToBilling();
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
				mirrorToShipping();
				tshipTo.setEditable(false);
				tstAddr.setEditable(false);
				tstCity.setEditable(false);
				tstZip.setEditable(false);
				jcbShipToState.setEnabled(false);
			}
		}

		
		
	}
}