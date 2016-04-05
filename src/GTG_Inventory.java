import java.awt.BorderLayout;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;

@SuppressWarnings("serial")
public class GTG_Inventory extends JPanel{

	private JPanel numpad;
	private JTable table;
	public GTG_Inventory() {
		setLayout(new BorderLayout());
		GTG_TableDisplay tableDisplay = new GTG_TableDisplay(GTG_Utility.DB.getInventory());
		
		table = tableDisplay.getTable();
		table.addMouseListener(new TableClick());
		JScrollPane tableScroll = new JScrollPane(tableDisplay,JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
		add(tableScroll,BorderLayout.CENTER);
		
		numpad = new numPad();
		numpad.setSize(50, 50);
		add(numpad, BorderLayout.EAST);
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
	
	private class numPad extends GTG_NumPad{
		
	}
}
