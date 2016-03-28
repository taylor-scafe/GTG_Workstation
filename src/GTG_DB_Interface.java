import java.util.ArrayList;

public class GTG_DB_Interface extends SQLDatabase{
	//Result Set Storage
	private Object[][] RSshirtTypes;
	private Object[][] RSsizes;
	private Object[][] RScolors;
	
	//SQL Queue
	private boolean updateNeeded;
	private ArrayList<String> updateList = new ArrayList<String>();
	
	public GTG_DB_Interface(String connectionURL) {
		super(connectionURL);
		//Open Connection
		//Capture all needed information
		//Close Connection
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
		boolean output = OpenSQLConnection();
		CloseSQLConnection();
		return output;
	}
	
}
