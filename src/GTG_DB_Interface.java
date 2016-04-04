import java.util.ArrayList;

public class GTG_DB_Interface{
	//Result Set Storage
	private Object[][] RSshirtTypes;
	private Object[][] RSsizes;
	private Object[][] RScolors;
	private SQLDatabase GTG_DB;
	private Object[][] RSinventory;
	private Object[][] RSstates;
	//SQL Queue
	private boolean updateNeeded;
	private ArrayList<String> updateList = new ArrayList<String>();
	
	
	public GTG_DB_Interface(String connectionURL) {
		
		GTG_DB = new SQLDatabase(connectionURL);
		if(GTG_DB.OpenSQLConnection()){
			RSsizes = GTG_DB.executeSELECT("SELECT sizeName FROM size");
			RScolors = GTG_DB.executeSELECT("SELECT colorName FROM color");
			RSinventory = GTG_DB.executeSELECT("SELECT * FROM inventory");
			RSstates = GTG_DB.executeSELECT("select postalCode from state");
			GTG_DB.CloseSQLConnection();
		}
		else{
			GTG_DB.CloseSQLConnection();
		}
	}
	public void runQueue(){
		//Open Connection
		//Run all SQL in queue
		//Clear Queue
		//Set updateNeeded = false
		//Close Connection
	}
	public Object[][] getRSshirtTypes() {
		return RSshirtTypes;
	}
	public Object[][] getRSsizes() {
		return RSsizes;
	}
	public Object[][] getRScolors() {
		return RScolors;
	}
	public Object[][] getRSstates() {
		return RSstates;
	}
	public Object[][] getInventory() {
		return RSinventory;
	}
	public void setUpdateNeeded(boolean input) {
		updateNeeded = input;
	}
	public boolean getUpdateNeeded(){
		return updateNeeded;
	}
	public void addTOupdateList(String input){
		updateList.add(input);
	}
	public boolean isConnected() {
		boolean output = GTG_DB.OpenSQLConnection();
		GTG_DB.CloseSQLConnection();
		return output;
	}
	
}
