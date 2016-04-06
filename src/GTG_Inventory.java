//import java.awt.BorderLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;

@SuppressWarnings("serial")
public class GTG_Inventory extends JPanel{

	private GTG_NumPad numpad;
	private JTable table;
	private JButton saveButtonFromCalc;
	private int iCalcResult,iSelectedRow;
	private GTG_TableDisplay tableDisplay;
	private GTG_DB_Interface dbInterface;
	private String[] selectedInfo;
	
	public GTG_Inventory() {
		setLayout(new GridBagLayout());		
		dbInterface = GTG_Utility.DB;
		
		tableDisplay = new GTG_TableDisplay(GTG_Utility.DB.getInventory());
		table = tableDisplay.getTable();
		table.addMouseListener(new TableClick());
		JScrollPane tableScroll = new JScrollPane(tableDisplay,JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
		add(tableScroll,getConstraints(0,0,0));
		
		numpad = new GTG_NumPad();
		saveButtonFromCalc = numpad.getSaveButton();
		saveButtonFromCalc.addActionListener(new calcSaveListener());
		numpad.setSize(50, 50);
		this.add(numpad,getConstraints(1,0,0));
		this.add(new JPanel(), getConstraints(3,1,1));
	}
	
	private void updateSelectedRow(){
		//RUNS UPDATE
		dbInterface.addTOupdateList("update inventory set quantity = "
				+ iCalcResult + " where invID = " + (iSelectedRow + 1) +";");
		dbInterface.runQueue();
		
		//updates GUI View
		table.setValueAt("" + iCalcResult, iSelectedRow, 3);
		
	}
	
	private GridBagConstraints getConstraints(int x, int y,int fillValue) {
		GridBagConstraints temp = new GridBagConstraints();
		temp.fill = GridBagConstraints.HORIZONTAL;
		temp.gridx = x;
		temp.gridy = y;
		temp.fill = fillValue;
		//System.out.println(GridBagConstraints.BOTH + " " + GridBagConstraints.NONE);
		temp.insets = new Insets(5,5,5,5);
		//System.out.println(x+" "+y);
		temp.anchor = GridBagConstraints.NORTH;
		temp.weighty = 0;
		//temp.weighty = 0;
		//temp.anchor = GridBagConstraints.NORTH;
		//System.out.println(x + " "+y);
		return temp;
	}
	
	private class TableClick implements MouseListener{

		@Override
		public void mouseClicked(MouseEvent e) {}
		@Override
		public void mouseEntered(MouseEvent e) {}
		@Override
		public void mouseExited(MouseEvent e) {}
		@Override
		public void mousePressed(MouseEvent e) {
			// TODO Auto-generated method stub
			JTable target = (JTable) e.getSource();
			int row = target.getSelectedRow();
			int column = target.getSelectedColumn();
			int columnCount = target.getColumnCount();
			//System.out.println(row+" | "+column);
			selectedInfo = new String[columnCount];

			for(int i=0;i<columnCount;i++){
				selectedInfo[i] = "" + table.getValueAt(row, i);
			}
			iSelectedRow = row;
			numpad.setIncoming(Integer.parseInt(selectedInfo[3]));
			numpad.doMath();
			
		}

		@Override
		public void mouseReleased(MouseEvent e) {}
	}

	private class calcSaveListener implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			iCalcResult = numpad.getResult();
			updateSelectedRow();
		}
		
	}
	
}
