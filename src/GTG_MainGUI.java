import java.awt.BorderLayout;
import java.awt.Toolkit;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JScrollPane;

@SuppressWarnings("serial")
public class GTG_MainGUI extends JFrame{
	//Graphic Elements
	private JButton newOrderLine;
	GTG_OrderTable mainOrderTable;
	
	//End of Graphic Elements
	public GTG_MainGUI(String credentials){
		//Initialize window
		super("GTG Main Program");
		getContentPane();
		Toolkit tk = Toolkit.getDefaultToolkit();
		int xSize = ((int) tk.getScreenSize().getWidth());
		int ySize = ((int) tk.getScreenSize().getHeight());
		setSize(xSize, ySize-50);
		setLayout(new BorderLayout());
		//setVisible(true);
		//end initialization
		
		
		//JScrollPane scrollPane = new JScrollPane(new GTG_TableDisplay(resultSet));
		//add(scrollPane, BorderLayout.NORTH);
		mainOrderTable = new GTG_OrderTable();
		add(mainOrderTable, BorderLayout.CENTER);
		mainOrderTable.addOrderLine();
		mainOrderTable.addOrderLine();
		
		newOrderLine = new JButton("New Order Line");
		add(newOrderLine, BorderLayout.SOUTH);
		setVisible(true);
		
		
	}
	
}
