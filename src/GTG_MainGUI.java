import java.awt.BorderLayout;
import java.awt.Toolkit;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JScrollPane;

@SuppressWarnings("serial")
public class GTG_MainGUI extends JFrame{
	//Graphic Elements
	private GTG_NumPad numPad;
	private GTG_OrderTable orderTable;
	private JButton newOrderLine;
	
	//End of Graphic Elements
	public GTG_MainGUI(String credentials){
		//Initialize window
		super("GTG Main Program");
		getContentPane();
		Toolkit tk = Toolkit.getDefaultToolkit();
		int xSize = ((int) tk.getScreenSize().getWidth());
		int ySize = ((int) tk.getScreenSize().getHeight());
		setSize(xSize, ySize);
		setLayout(new BorderLayout());
		setVisible(true);
		//end initialization
		
		
		//JScrollPane scrollPane = new JScrollPane(new GTG_TableDisplay(resultSet));
		//add(scrollPane, BorderLayout.NORTH);
		GTG_OrderTable mainOrderTable = new GTG_OrderTable();
		add(mainOrderTable, BorderLayout.CENTER);
		
		newOrderLine = new JButton("New Order Line");
		
		
		
		
	}
}
