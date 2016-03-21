import java.awt.Container;
import java.awt.GridLayout;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

@SuppressWarnings("serial")
public class SELECT_GUI extends JFrame{
	private Container window;
	public SELECT_GUI(ArrayList<Object[]> input){
		super("SELECT Output");
		window = getContentPane();
		window.setLayout(new GridLayout(input.size(),input.get(0).length));
		
		for(Object[] column:input){
			for (Object data : column){
				System.out.println(data.getClass());
				JLabel temp = new JLabel( data+ "");
				window.add(temp);
			}
		}
		pack();
		setVisible(true);
	}
}
