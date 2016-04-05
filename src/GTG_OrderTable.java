import java.awt.Component;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

@SuppressWarnings("serial")
public class GTG_OrderTable extends JPanel {
	private int y = 0;
	private int x = 0;
	GridBagLayout orderTable;
	public void GTG_OrderTable() {
		orderTable = new GridBagLayout();
		orderTable.columnWidths = new int[]{0, 0, 0};
		orderTable.rowHeights = new int[]{0, 0};
		orderTable.columnWeights = new double[]{0.0, 0.0, Double.MIN_VALUE};
		orderTable.rowWeights = new double[]{0.0, Double.MIN_VALUE};
		setLayout(orderTable);

		String[] headers = {"Quantity","Size","Shirt Style","Job Description","Color","Price","Total"};


		for(int i=0;i<headers.length;i++){
			JLabel jlbHeader = new JLabel();
			jlbHeader.setText(headers[i]);
			jlbHeader.setFont(new Font("Tahoma", Font.PLAIN, 20));
			add(jlbHeader, getConstraints(i,0));
		}
		y++;
		addOrderLine();
		addOrderLine();
		JPanel spacer = new JPanel();
		GridBagConstraints spacerC = getConstraints(0, 1000);
		spacerC.weighty = 1.0;
		add(spacer, spacerC);
	}
	public void addOrderLine(){
		x=0;
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
		x++;
		JButton jbnCopyLine = new JButton("Copy Line");
		jbnCopyLine.setFont(new Font("Tahoma", Font.PLAIN, 14));
		jbnCopyLine.setName(""+y);
		jbnCopyLine.addActionListener(new CopyLine());
		add(jbnCopyLine,getConstraints(x, y));
		x++;
		JButton jbnDeleteLine = new JButton("Delete Line");
		jbnDeleteLine.setFont(new Font("Tahoma", Font.PLAIN, 14));
		jbnDeleteLine.setName(""+y);
		jbnDeleteLine.addActionListener(new DeleteLine());
		add(jbnDeleteLine,getConstraints(x, y));
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
			revalidate();
			int nextRow = y-1;
			for(int i=0; i<x;i++){
				Component origin = null;
				Component copy = null;
				for (Component comp : getComponents()) {
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
			for (Component comp : getComponents()) {
				GridBagConstraints gbc = orderTable.getConstraints(comp);
				if (gbc.gridy == row) {
					remove(comp);
				}
			}
			revalidate();
			repaint();
		}
	}
}
