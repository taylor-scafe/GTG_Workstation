import java.awt.BorderLayout;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JRadioButton;
import java.awt.FlowLayout;

import javax.swing.ButtonGroup;
import javax.swing.JTextPane;
import javax.swing.JLabel;
import java.awt.Font;

public class GTG_NumPad extends JFrame {
	private JButton btnDigit1, btnDigit2, btnDigit3, btnDigit4, btnDigit5, btnDigit6, btnDigit7, btnDigit8, btnDigit9, btnDigit0;
	private JButton btnBlank, btnDecimal, btnADD, btnSUBTRACT, btnBackspace, btnMULTPLY, btnDIVIDE, btnClear, btnLeftParen, btnRightParen, btnExecute;
	JTextPane txtpnCurrentData, txtpnNewData, txtpnFinalData;
	JLabel lblOperator, lblEquals;
	private JPanel NumPad;
	public GTG_NumPad() {

		NumPad = new JPanel();
		NumPad.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(NumPad);
		NumPad.setLayout(new BorderLayout(0, 0));


		//--------------Number Panel-----------------------------------------------

		JPanel NumPadPanel = new JPanel();
		NumPad.add(NumPadPanel, BorderLayout.CENTER);
		NumPadPanel.setLayout(new GridLayout(0, 3, 0, 0));

		btnDigit1 = new JButton("1");
		NumPadPanel.add(btnDigit1);
		//btnDigit1.addActionListener(numberPress);

		btnDigit2 = new JButton("2");
		NumPadPanel.add(btnDigit2);

		btnDigit3 = new JButton("3");
		NumPadPanel.add(btnDigit3);

		btnDigit4 = new JButton("4");
		NumPadPanel.add(btnDigit4);

		btnDigit5 = new JButton("5");
		NumPadPanel.add(btnDigit5);

		btnDigit6 = new JButton("6");
		NumPadPanel.add(btnDigit6);

		btnDigit7 = new JButton("7");
		NumPadPanel.add(btnDigit7);

		btnDigit8 = new JButton("8");
		NumPadPanel.add(btnDigit8);

		btnDigit9 = new JButton("9");
		NumPadPanel.add(btnDigit9);

		btnBlank = new JButton("");
		btnBlank.setEnabled(false);
		NumPadPanel.add(btnBlank);

		btnDigit0 = new JButton("0");
		NumPadPanel.add(btnDigit0);

		btnDecimal = new JButton(".");
		NumPadPanel.add(btnDecimal);

		btnADD = new JButton("+");
		NumPadPanel.add(btnADD);

		btnSUBTRACT = new JButton("-");
		NumPadPanel.add(btnSUBTRACT);

		btnBackspace = new JButton("Backspace");
		//btnBackspace.setEnabled(false);
		NumPadPanel.add(btnBackspace);

		btnMULTPLY = new JButton("*");
		NumPadPanel.add(btnMULTPLY);

		btnDIVIDE = new JButton("/");
		NumPadPanel.add(btnDIVIDE);

		btnClear = new JButton("Clear");
		NumPadPanel.add(btnClear);

		btnLeftParen = new JButton("(");
		NumPadPanel.add(btnLeftParen);

		btnRightParen = new JButton(")");
		NumPadPanel.add(btnRightParen);

		btnExecute = new JButton("Execute");
		NumPadPanel.add(btnExecute);

		//--------------Operations Panel-------------------------------------------

		JPanel OperationPanel = new JPanel();
		NumPad.add(OperationPanel, BorderLayout.SOUTH);

		ButtonGroup operatorGroup = new ButtonGroup();
		OperationPanel.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));

		JRadioButton rdbtnSet = new JRadioButton("Set");
		rdbtnSet.setFont(new Font("Tahoma", Font.PLAIN, 16));
		operatorGroup.add(rdbtnSet);
		rdbtnSet.setSelected(true);
		OperationPanel.add(rdbtnSet);

		JRadioButton rdbtnAdd = new JRadioButton("Add");
		rdbtnAdd.setFont(new Font("Tahoma", Font.PLAIN, 16));
		operatorGroup.add(rdbtnAdd);
		OperationPanel.add(rdbtnAdd);

		JRadioButton rdbtnSubtract = new JRadioButton("Subtract");
		rdbtnSubtract.setFont(new Font("Tahoma", Font.PLAIN, 16));
		operatorGroup.add(rdbtnSubtract);
		OperationPanel.add(rdbtnSubtract);

		//--------------Data Panel--------------------------------------------------

		JPanel DatafieldPanel = new JPanel();
		NumPad.add(DatafieldPanel, BorderLayout.NORTH);

		txtpnCurrentData = new JTextPane();
		txtpnCurrentData.setEditable(false);
		txtpnCurrentData.setText("Incoming Data");
		DatafieldPanel.add(txtpnCurrentData);

		lblOperator = new JLabel("set");
		DatafieldPanel.add(lblOperator);

		txtpnNewData = new JTextPane();
		txtpnNewData.setText("0");
		DatafieldPanel.add(txtpnNewData);

		lblEquals = new JLabel("=");
		DatafieldPanel.add(lblEquals);

		txtpnFinalData = new JTextPane();
		txtpnFinalData.setEditable(false);
		txtpnFinalData.setText("0");
		DatafieldPanel.add(txtpnFinalData);

		pack();
		setVisible(true);

		//------------Action Handlers----------------------------------------------
	}
	public class numberPress implements ActionListener{
		@Override
		public void actionPerformed(ActionEvent ea) {
			JButton buttonPressed = (JButton) ea.getSource();
			if(buttonPressed.getText()=="Clear"){
				txtpnNewData.setText("");
			}
			else if (buttonPressed.getText()=="Backspace"){
				txtpnNewData.setText(txtpnNewData.getText().substring(0, txtpnNewData.getText().length()-1));
			}
			else{
				txtpnNewData.setText(txtpnNewData.getText()+buttonPressed.getText());
			}
		}
	}
}
