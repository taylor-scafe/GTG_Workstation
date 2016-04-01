import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JTable;

import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

@SuppressWarnings("serial")
public class GTG_Inventory extends JPanel {

	JPanel buttonPanel;
	
	public GTG_Inventory() {
		setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		GTG_TableDisplay tableDisplay = new GTG_TableDisplay(GTG_Utility.DB.getRScolors());
		add(tableDisplay);
		JTable table = tableDisplay.getTable();
		table.addMouseListener(new TableClick());
		JPanel optionPanel = new JPanel();
		optionPanel.setLayout(new GridLayout());
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
			System.out.println(row+" | "+column);
		}

		@Override
		public void mouseReleased(MouseEvent e) {
			// TODO Auto-generated method stub
			
		}
	}
	
}
