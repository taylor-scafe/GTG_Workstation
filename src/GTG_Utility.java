import javax.swing.JComboBox;

public class GTG_Utility {
	
	public static JComboBox<String> SimpleSQLComboBox(Object[][] resultSet){

		JComboBox<String> returnBox = new JComboBox<String>();
		for(int i=1;i<resultSet.length;i++){
			returnBox.addItem(resultSet[i][0].toString());
		}
		returnBox.setSelectedIndex(0);
		return returnBox;
	}
	
}
