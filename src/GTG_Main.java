import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class GTG_Main{
	public static GTG_DB_Interface DB;
	public static void main (String[] args) {
		String[] credentials;
		
		credentials = GTG_Utility.getLogin();
		do{
			credentials = GTG_Utility.promptLogin();
			DB = new GTG_DB_Interface("jdbc:sqlserver:"+credentials[0]+";databaseName="+credentials[1]+";user="+credentials[2]+";password="+credentials[3]); 
			if(!DB.isConnected()){
				JOptionPane.showMessageDialog(null, "Incorrect Username or Password","Input Error", JOptionPane.WARNING_MESSAGE);
				credentials[0]=null;
			}
		}while(credentials[0]==null);
		if(credentials[0]=="KILL"){
			DB = null;
			//EXIT PROGRAM! ABANDON ALL HOPE!!! (or someone forgot their password)
			System.out.println("Program Exit: Failed DB Connection");
		}
		else{
			GTG_MainGUI mainWindow = new GTG_MainGUI(credentials[5]);
			mainWindow.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		}
	}
}
