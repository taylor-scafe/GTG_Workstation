import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class GTG_Main {

	public static void main(String[] args) {
		String[] credentials;
		credentials = GTG_Utility.getLogin();
		GTG_Utility.DB = new GTG_DB_Interface("jdbc:sqlserver:"+credentials[0]+";databaseName="+credentials[1]+";user="+credentials[2]+";password="+credentials[3]); 
		do{
			if(credentials[0]=="KILL"){
				break;
			}
			else if(!GTG_Utility.DB.isConnected()){
				credentials = GTG_Utility.promptLogin();
				GTG_Utility.DB = new GTG_DB_Interface("jdbc:sqlserver:"+credentials[0]+";databaseName="+credentials[1]+";user="+credentials[2]+";password="+credentials[3]); 
				JOptionPane.showMessageDialog(null, "Incorrect Username or Password","Input Error", JOptionPane.WARNING_MESSAGE);
				credentials[0]=null;
			}
		}while(credentials[0]==null);
		if(credentials[0]=="KILL"){
			GTG_Utility.DB = null;
			//EXIT PROGRAM! ABANDON ALL HOPE!!! (or someone forgot their password)
			System.out.println("Program Exit: Failed DB Connection");
		}
		else{
			GTG_MainGUI mainWindow = new GTG_MainGUI(credentials[4]);
			//GTG_TestGUI testWindow = new GTG_TestGUI(credentials[5]); //Uncomment this line and next line to activate GTG_TestGUI
			//testWindow.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
			mainWindow.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		}
	}
}
