import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.Toolkit;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JScrollPane;

@SuppressWarnings("serial")
public class GTG_MainGUI extends JFrame{
	public static Object[][] resultSet;
	public static Object[][] inventorySelect;
	public static Object[][] purchaseSelect;
	public static Object[][] combobox1;
	public static boolean updateNeeded;
	public static ArrayList<String> updateList = new ArrayList<String>();
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
		try{
			for (String SQL : updateList){
				DB.executeINSERT(SQL);
			}
			updateList.clear();
			updateNeeded = false;
		}
		catch(Exception e){}
		resultSet = DB.executeSELECT("SELECT * FROM customer");
		combobox1 = DB.executeSELECT("SELECT DISTINCT firstName FROM customer ORDER BY firstName");
		DB.CloseSQLConnection();
		//System.out.println(credentials[4]);
		if (credentials[4] ==null){
			GTG_OpenMainWindow("management");
		}
		else if (credentials[4].equalsIgnoreCase("debug")){
			GTG_TestPanel();//Open Test area
		}
		else{
			GTG_OpenMainWindow(credentials[4]);
		}
		
		
	}
	private static void GTG_OpenMainWindow(String string) {
		// Open Main program GUI
		JFrame window = new JFrame();
		Toolkit tk = Toolkit.getDefaultToolkit();
		int xSize = ((int) tk.getScreenSize().getWidth());
		int ySize = ((int) tk.getScreenSize().getHeight());
		window.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		window.setSize(xSize, ySize);
		window.setVisible(true);
	}
	public static void GTG_TestPanel(){
	JFrame window = new JFrame();
	window.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
	window.getContentPane();
	window.setLayout(new BorderLayout());
	JScrollPane scrollPane = new JScrollPane(new GTG_TableDisplay(resultSet));
	window.add(scrollPane);
	window.setSize(1600, 600);
	
	window.setVisible(true);
	}
}
