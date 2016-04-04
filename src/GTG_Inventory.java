import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JPanel;
import javax.swing.JTable;

@SuppressWarnings("serial")
public class GTG_Inventory extends JPanel {

	JPanel buttonPanel;
	JTable table;
	public GTG_Inventory() {
		setLayout(new BorderLayout());
		GTG_TableDisplay tableDisplay = new GTG_TableDisplay(GTG_Utility.DB.getRScolors());
		add(tableDisplay);
		table = tableDisplay.getTable();
		table.addMouseListener(new TableClick());
		JPanel optionPanel = new JPanel();
		optionPanel.setLayout(new FlowLayout());
		
	}
	private class TableClick implements MouseListener{

		@Override
		public void mouseClicked(MouseEvent e) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void mouseEntered(MouseEvent e) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void mouseExited(MouseEvent e) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void mousePressed(MouseEvent e) {
			// TODO Auto-generated method stub
			JTable target = (JTable) e.getSource();
			int row = target.getSelectedRow();
			int column = target.getSelectedColumn();
			int columnCount = target.getColumnCount();
			System.out.println(row+" | "+column);
			String[] selectedInfo = new String[columnCount];
		
			for(int i=0;i<columnCount;i++){
				selectedInfo[i] = (String) table.getValueAt(row, i);
				
			}
			
		}

		@Override
		public void mouseReleased(MouseEvent e) {
			// TODO Auto-generated method stub
			
		}
	}
	
}
