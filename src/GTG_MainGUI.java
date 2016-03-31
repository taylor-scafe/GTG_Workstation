import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Toolkit;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;

@SuppressWarnings("serial")
public class GTG_MainGUI extends JFrame{
	//Graphic Elements
	private JButton newOrderLine;
	private GTG_OrderTable mainOrderTable;
	private JPanel jpMaterialInventory, jpOrderManager, jpPointOfSale;
	
	//End of Graphic Elements
	public GTG_MainGUI(String credentials){
		//Initialize window
		super("GTG Main Program");
		getContentPane();
		Toolkit tk = Toolkit.getDefaultToolkit();
		int xSize = ((int) tk.getScreenSize().getWidth());
		int ySize = ((int) tk.getScreenSize().getHeight());
		setSize(xSize, ySize-50);
		setLayout(new FlowLayout());
		//setVisible(true);
		//end initialization
		jpMaterialInventory = new JPanel();
		jpOrderManager = new JPanel();
		jpPointOfSale = new JPanel();
		jpPointOfSale.setLayout(new BorderLayout());
		
		JTabbedPane tabbedPane = new JTabbedPane();
		tabbedPane.addTab("Point of Sale", jpPointOfSale);
		tabbedPane.addTab("Material Inventory", jpMaterialInventory);
		tabbedPane.addTab("Order Manager", jpOrderManager);
		tabbedPane.setFont(new Font("Tahoma", Font.PLAIN, 20));
		tabbedPane.setSize(100, 100);
		

		//JScrollPane scrollPane = new JScrollPane(new GTG_TableDisplay(GTG_Utility.DB.getRSsizes()));
		JScrollPane scpInventory = new JScrollPane(new GTG_Inventory());
		jpOrderManager.add(scpInventory);
		mainOrderTable = new GTG_OrderTable();
		jpPointOfSale.add(mainOrderTable,BorderLayout.CENTER);
		mainOrderTable.addOrderLine();
		mainOrderTable.addOrderLine();
		newOrderLine = new JButton("New Order Line");
		jpPointOfSale.add(newOrderLine,BorderLayout.SOUTH);
		jpMaterialInventory.add(new GTG_NumPad());

		add(tabbedPane);
		setVisible(true);
		
		
	}
	
}
