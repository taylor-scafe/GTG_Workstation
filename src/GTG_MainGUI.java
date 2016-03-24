import java.awt.FlowLayout;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

@SuppressWarnings("serial")
public class GTG_MainGUI extends JFrame{
	public static Object[][] resultSet;
	public static Object[][] inventorySelect;
	public static Object[][] purchaseSelect;
	public static Object[][] combobox1;
	public static void main (String[] args) {
		//GTG_NumPad numPad = new GTG_NumPad();
		//numPad.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		String[] credentials = GTG_Utility.getLogin();
//		while (credentials[0] == null){
//			credentials = GTG_Utility.promptLogin();
//			if(!DBConnect(credentials)){
//				JOptionPane.showMessageDialog(null, "Incorrect Username or Password","Input Error", JOptionPane.WARNING_MESSAGE);
//				credentials[0]=null;
//			}
//		}
		SQLDatabase DB = new SQLDatabase("jdbc:sqlserver:"+credentials[0]+";databaseName="+credentials[1]+";user="+credentials[2]+";password="+credentials[3]);
		DB.OpenSQLConnection();
		resultSet = DB.executeSELECT("SELECT * FROM customer");
		combobox1 = DB.executeSELECT("SELECT DISTINCT firstName FROM customer ORDER BY firstName");
		inventorySelect = DB.executeSELECT("select InventoryType.typeName,Inventory.color,Inventory.quantity from Inventory left join InventoryType on InventoryType.typeID = Inventory.typeID order by Inventory.quantity");
		purchaseSelect = DB.executeSELECT("SELECT Purchase.orderID, Customer.firstName, Customer.lastName, InventoryType.typeName, Inventory.color, Inventory.quantity FROM Purchase LEFT JOIN Customer ON Purchase.custID = Customer.custID LEFT JOIN Inventory ON  Purchase.invID = Inventory.invID LEFT JOIN InventoryType on InventoryType.typeID = Inventory.typeID");
		DB.CloseSQLConnection();
		GTG_TestPanel(resultSet);
	}	
	public static void GTG_TestPanel(Object[][] resultSet2){
	JFrame window = new JFrame();
	window.getContentPane();
	window.setLayout(new FlowLayout());
	window.add(new GTG_TableDisplay(resultSet2));
	window.add(new GTG_TableDisplay(inventorySelect));
	window.add(new GTG_TableDisplay(purchaseSelect));
	INSERT_GUI insert = new INSERT_GUI();
	//JComboBox<String> selectionBox = GTG_Utility.SimpleSQLComboBox(combobox1);
	//JComboBox<String> selectionBox2 = GTG_Utility.SimpleSQLComboBox(combobox1);
	//GTG_Utility.addSizeComboBox(selectionBox);
	//window.add(selectionBox);
	//GTG_Utility.addSizeComboBox(selectionBox2);
	//window.add(selectionBox2);
	//JScrollPane table = new JScrollPane(new GTG_TableDisplay(resultSet2));
	//table.setPreferredSize(window.getPreferredSize());
	//window.add(table);
	
	//JScrollPane scrollPane = new JScrollPane(table);
	//table.setFillsViewportHeight(true);
	window.setSize(1600, 600);
	
	window.setVisible(true);
	//GTG_Utility.addSize();
	}
/*	private static boolean DBConnect(String[] credentials){
		try{
		//System.out.println("jdbc:sqlserver:"+credentials[0]+";databaseName="+credentials[1]+";user="+credentials[2]+";password="+credentials[3]);
		SQLDatabase DB = new SQLDatabase("jdbc:sqlserver:"+credentials[0]+";databaseName="+credentials[1]+";user="+credentials[2]+";password="+credentials[3]);
		DB.OpenSQLConnection();
		resultSet = DB.executeSELECT("SELECT * FROM customer ORDER BY lastName");
		combobox1 = DB.executeSELECT("SELECT DISTINCT firstName FROM customer ORDER BY firstName");
		DB.CloseSQLConnection();
		return true;
		}
		catch(Exception e){return false;}
	}*/
}
