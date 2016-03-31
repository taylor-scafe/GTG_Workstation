import java.awt.Font;

import javax.swing.JScrollPane;
import javax.swing.JTable;

@SuppressWarnings("serial")
public class GTG_TableDisplay extends JScrollPane {//Creates a scrollable Table Pane
	
	public GTG_TableDisplay(Object[][] resultSet) {//Takes in a 2D Object Array
		
		Object[] strHeaders = new Object[resultSet[0].length];

		for(int i =0;i<resultSet[0].length;i++){//Takes headers from recordset and moves them to header object list
			strHeaders[i] = resultSet[0][i];
		}
		System.out.println();
		Object[][] outputTable = new Object[resultSet.length-1][resultSet[0].length];//Removes the header info from recordset
		for (int x = 0; x<resultSet[0].length;x++){
			for (int y= 1; y<resultSet.length;y++){
				outputTable[y-1][x]= resultSet[y][x];
			}
		}
		JTable table = new JTable(outputTable, strHeaders);
		table.setEnabled(false);
		table.setRowHeight(24);
		table.setFont(new Font("Tahoma", Font.PLAIN, 20));
		setViewportView(table);//Adds table to scroll panel
	}

}
