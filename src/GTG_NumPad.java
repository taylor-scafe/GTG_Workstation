import java.awt.BorderLayout;
import java.awt.Component;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JRadioButton;
import java.awt.FlowLayout;

import javax.swing.ButtonGroup;
import javax.swing.JTextPane;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;

public class GTG_NumPad extends JFrame {
	private JButton btnDigit1, btnDigit2, btnDigit3, btnDigit4, btnDigit5, btnDigit6, btnDigit7, btnDigit8, btnDigit9, btnDigit0;
	private JButton btnBlank, btnDecimal, btnADD, btnSUBTRACT, btnBackspace, btnMULTPLY, btnDIVIDE, btnClear, btnLeftParen, btnRightParen, btnExecute;
	JTextPane incomingData, currentExpr, result;
	JLabel lblOperator, lblEquals;
	private JPanel NumPad;
	private ButtonHandler bh;
	private JRadioButton rdbtnSet,rdbtnAdd,rdbtnSub;
	public GTG_NumPad() {

		NumPad = new JPanel();
		NumPad.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(NumPad);
		NumPad.setLayout(new BorderLayout(0, 0));


		//--------------Number Panel-----------------------------------------------
		ButtonHandler bh = new ButtonHandler();
		
		JPanel NumPadPanel = new JPanel();
		NumPad.add(NumPadPanel, BorderLayout.CENTER);
		NumPadPanel.setLayout(new GridLayout(0, 3, 0, 0));

		btnDigit1 = new JButton("1");
		NumPadPanel.add(btnDigit1);

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

		btnDecimal = new JButton("");
		btnDecimal.setEnabled(false);
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
		
		Component [] buttons = NumPadPanel.getComponents();
		for(Component c : buttons){
			JButton b = ((JButton)c);
			b.addActionListener(bh);
		}
		//--------------Operations Panel-------------------------------------------

		JPanel OperationPanel = new JPanel();
		NumPad.add(OperationPanel, BorderLayout.SOUTH);

		ButtonGroup operatorGroup = new ButtonGroup();
		OperationPanel.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));

		rdbtnSet = new JRadioButton("Set");
		rdbtnSet.setFont(new Font("Tahoma", Font.PLAIN, 16));
		operatorGroup.add(rdbtnSet);
		rdbtnSet.setSelected(true);
		OperationPanel.add(rdbtnSet);

		rdbtnAdd = new JRadioButton("Add");
		rdbtnAdd.setFont(new Font("Tahoma", Font.PLAIN, 16));
		operatorGroup.add(rdbtnAdd);
		OperationPanel.add(rdbtnAdd);

		rdbtnSub = new JRadioButton("Subtract");
		rdbtnSub.setFont(new Font("Tahoma", Font.PLAIN, 16));
		operatorGroup.add(rdbtnSub);
		OperationPanel.add(rdbtnSub);

		//--------------Data Panel--------------------------------------------------

		JPanel DatafieldPanel = new JPanel();
		NumPad.add(DatafieldPanel, BorderLayout.NORTH);

		incomingData = new JTextPane();
		incomingData.setEditable(false);
		incomingData.setText("0");
		DatafieldPanel.add(incomingData);

		lblOperator = new JLabel("set");
		DatafieldPanel.add(lblOperator);

		currentExpr = new JTextPane();
		currentExpr.setText("");
		DatafieldPanel.add(currentExpr);

		lblEquals = new JLabel("=");
		DatafieldPanel.add(lblEquals);

		result = new JTextPane();
		result.setEditable(false);
		result.setText("0");
		DatafieldPanel.add(result);

		pack();
		setVisible(true);

		//------------Action Handlers----------------------------------------------
	}
	private class ButtonHandler implements ActionListener{
		@Override
		public void actionPerformed(ActionEvent ea) {
			JButton buttonPressed = (JButton) ea.getSource();
			if(buttonPressed.getText()=="Clear"){
				currentExpr.setText("");
			}
			else if (buttonPressed.getText()=="Backspace"){
				currentExpr.setText(currentExpr.getText().substring(0, currentExpr.getText().length()-1));
			}
			else if(buttonPressed.getText() == "Execute"){
				if(!doMath()){
					JOptionPane.showMessageDialog(null, "Invalid Input");
				}
			}
			else{
				currentExpr.setText(currentExpr.getText()+buttonPressed.getText());
			}
		}
	}
	
	private boolean doMath(){
		String expr = currentExpr.getText();
		try{
			ArrayList<Character> aExpr = new ArrayList<Character>();
			for(int i = 0; i < expr.length(); i++){
				aExpr.add(expr.charAt(i));
			}
			int iResult = math.eval(aExpr);
			System.out.println("iResult: " + iResult);
			if(rdbtnSet.isSelected()){
				result.setText("" + iResult);
				currentExpr.setText("");
				return true;
			}
			else if(rdbtnAdd.isSelected()){
				int iIncoming = Integer.parseInt(incomingData.getText());
				int iFinal = iResult + iIncoming;
				result.setText("" + iFinal);
				currentExpr.setText("");
				return true;
			}
			else{
				int iIncoming = Integer.parseInt(incomingData.getText());
				int iFinal = iResult - iIncoming;
				result.setText("" + iFinal);
				currentExpr.setText("");
				return true;
			}
		}catch(Exception e){e.printStackTrace();}
		return false;
	}
}
