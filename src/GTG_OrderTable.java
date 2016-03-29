import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;

import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

@SuppressWarnings("serial")
public class GTG_OrderTable extends JPanel {
	private int y = 0;
	public GTG_OrderTable() {
		GridBagLayout orderTable = new GridBagLayout();
		orderTable.columnWidths = new int[]{0, 0, 0};
		orderTable.rowHeights = new int[]{0, 0};
		orderTable.columnWeights = new double[]{0.0, 0.0, Double.MIN_VALUE};
		orderTable.rowWeights = new double[]{0.0, Double.MIN_VALUE};
		setLayout(orderTable);

		String[] headers = {"Quantity","Size","Shirt Style","Job Description","Color","Price","Total"};


		for(int x=0;x<headers.length;x++){
			JLabel jlbHeader = new JLabel();
			jlbHeader.setText(headers[x]);
			jlbHeader.setFont(new Font("Tahoma", Font.PLAIN, 20));
			add(jlbHeader, getConstraints(x,0));
		}
		y++;
		addOrderLine();
	}
	public void addOrderLine(){
		int x=0;
		JTextField jtfQuantity = new JTextField(2);
		jtfQuantity.setFont(new Font("Tahoma", Font.PLAIN, 20));
		add(jtfQuantity, getConstraints(x,y));
		x++;
		JComboBox<String> jcbSize = GTG_Utility.SimpleSQLComboBox(GTG_Utility.DB.getRSsizes());
		add(jcbSize, getConstraints(x,y));
		x++;
		JComboBox<String> jcbShirtStyle = GTG_Utility.SimpleSQLComboBox(GTG_Utility.DB.getRScolors());
		add(jcbShirtStyle, getConstraints(x,y));
		x++;
		JTextField jtfDescription = new JTextField(20);
		jtfDescription.setFont(new Font("Tahoma", Font.PLAIN, 20));
		add(jtfDescription, getConstraints(x,y));
		x++;
		JComboBox<String> jcbColor = GTG_Utility.SimpleSQLComboBox(GTG_Utility.DB.getRScolors());
		add(jcbColor, getConstraints(x,y));
		x++;
		JTextField jtfPrice = new JTextField(10);
		jtfPrice.setFont(new Font("Tahoma", Font.PLAIN, 20));
		add(jtfPrice, getConstraints(x,y));
		x++;
		JTextField jtfTotal = new JTextField(10);
		jtfTotal.setFont(new Font("Tahoma", Font.PLAIN, 20));
		add(jtfTotal, getConstraints(x,y));
		y++;
	}

	private GridBagConstraints getConstraints(int x, int y) {
		GridBagConstraints temp = new GridBagConstraints();
		temp.gridx = x;
		temp.gridy = y;
		temp.insets = new Insets(5,5,5,5);
		//temp.weighty = 0;
		temp.anchor = GridBagConstraints.BELOW_BASELINE;
		//System.out.println(x + " "+y);
		return temp;
	}

}
