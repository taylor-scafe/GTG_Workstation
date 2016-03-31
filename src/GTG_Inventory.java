import javax.swing.JButton;
import javax.swing.JPanel;
import java.awt.FlowLayout;
import java.awt.GridLayout;

@SuppressWarnings("serial")
public class GTG_Inventory extends JPanel {

	JPanel buttonPanel;
	
	public GTG_Inventory() {
		setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		Object[][] rsInventory;
		add(new GTG_TableDisplay(rsInventory = GTG_Utility.DB.getRScolors()));
		System.out.println(rsInventory.length);
		buttonPanel = new JPanel();
		buttonPanel.setLayout(new GridLayout(0,1));

		buttonPanel.setVisible(true);
		for (int i=1;i<rsInventory.length;i++){
			JButton temp = new JButton("Line "+i);
			buttonPanel.add(temp);
		}
		add(buttonPanel);
	}

}
