import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Toolkit;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;

@SuppressWarnings("serial")
public class GTG_MainGUI extends JFrame{
	private JPanel jpMaterialInventory, jpOrderManager, jpPointOfSale,jpOrderForm;
	private GTG_OrderForm mainOrderTable;
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
		jpOrderForm = new JPanel(new FlowLayout(FlowLayout.LEFT));
		
		JTabbedPane tabbedPane = new JTabbedPane();
		tabbedPane.addTab("Point of Sale", jpPointOfSale);
		tabbedPane.addTab("Material Inventory", jpMaterialInventory);
		tabbedPane.addTab("Order Manager", jpOrderManager);
		tabbedPane.addTab("Order Form", jpOrderForm);
		tabbedPane.setFont(new Font("Tahoma", Font.PLAIN, 20));
		tabbedPane.setSize(100, 100);
		

		//JScrollPane scrollPane = new JScrollPane(new GTG_TableDisplay(GTG_Utility.DB.getRSsizes()));
		JScrollPane scpInventory = new JScrollPane(new GTG_Inventory());
		jpOrderManager.add(scpInventory);
		mainOrderTable = new GTG_OrderForm();
		
		mainOrderTable.addOrderLine();
		mainOrderTable.addOrderLine();
		jpPointOfSale.add(new GTG_OrderForm());
		//JScrollPane orderScroll = new JScrollPane(mainOrderTable,JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
		//jpPointOfSale.add(orderScroll);
		//jpPointOfSale.add(new GTG_NumPad(0));
		//newOrderLine = new JButton("New Order Line");
		//jpPointOfSale.add(newOrderLine,BorderLayout.SOUTH);
		//jpMaterialInventory.add(new GTG_NumPad(0));
		
		add(tabbedPane);
		setVisible(true);
		
		
	}
	
}
