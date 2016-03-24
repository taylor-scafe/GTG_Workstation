import java.awt.FlowLayout;
import javax.swing.JComboBox;
import javax.swing.JFrame;

@SuppressWarnings("serial")
public class GTG_MainGUI extends JFrame{
	public static Object[][] resultSet;
	public static Object[][] combobox1;
	public static void main (String[] args) {
		//GTG_NumPad numPad = new GTG_NumPad();
		//numPad.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		SQLDatabase DB = new SQLDatabase("jdbc:sqlserver://acaddb.graceland.edu:1433;"
				+ "databaseName=JAVA_CLASS;user=JavaStudent;password=SQLisfun!");
		DB.OpenSQLConnection();
		resultSet = DB.executeSELECT("SELECT * FROM customer ORDER BY lastName");
		combobox1 = DB.executeSELECT("SELECT DISTINCT firstName FROM customer ORDER BY firstName");
		DB.CloseSQLConnection();
		GTG_TestPanel(resultSet);
	}	
	public static void GTG_TestPanel(Object[][] resultSet2){
	JFrame window = new JFrame();
	window.getContentPane();
	window.setLayout(new FlowLayout());
	window.add(new GTG_TableDisplay(resultSet2));
	JComboBox<String> selectionBox = GTG_Utility.SimpleSQLComboBox(combobox1);
	JComboBox<String> selectionBox2 = GTG_Utility.SimpleSQLComboBox(combobox1);
	GTG_Utility.addSizeComboBox(selectionBox);
	window.add(selectionBox);
	GTG_Utility.addSizeComboBox(selectionBox2);
	window.add(selectionBox2);
	//JScrollPane table = new JScrollPane(new GTG_TableDisplay(resultSet2));
	//table.setPreferredSize(window.getPreferredSize());
	//window.add(table);
	
	//JScrollPane scrollPane = new JScrollPane(table);
	//table.setFillsViewportHeight(true);
	window.setSize(800, 800);
	
	window.setVisible(true);
	GTG_Utility.addSize();
	}
}
