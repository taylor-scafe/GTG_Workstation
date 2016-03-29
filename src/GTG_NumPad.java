import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;

import javax.swing.JRadioButton;
import javax.swing.JTextField;

import java.awt.FlowLayout;

import javax.swing.ButtonGroup;
import javax.swing.JTextPane;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
/*
 * TO DO LIST:
 * 	-MAKE lblOperator LABLE CHANGE WITH RADIO BTN SELECTED
 * 	-BIND KEYS TO INPUT
 * 	-INCREASE DEFAULT SIZE OF INPUT BLANK
 * 	-SUPPORT NEGITIVES
 *  -INCREASE FONT SIZE
 *  -SWITCH TO JPANEL
 *  -MAKE CALCULATION LIVE
 */
@SuppressWarnings("serial")
public class GTG_NumPad extends JPanel {
	
	private JButton btnDigit1, btnDigit2, btnDigit3, btnDigit4, btnDigit5, btnDigit6, btnDigit7, btnDigit8, btnDigit9, btnDigit0;
	private JButton btnADD, btnSUBTRACT, btnBackspace, btnMULTPLY, btnClear, btnLeftParen, btnRightParen, btnExecute;
	JTextField currentExpr,incomingData, result;
	JLabel lblOperator, lblEquals;
	
	private ButtonHandler bh;
	private JRadioButton rdbtnSet,rdbtnAdd,rdbtnSub;
	private ButtonGroup operatorGroup;
	public GTG_NumPad() {
		//super("GTG Calculator");
		setBackground(Color.BLUE);
		setBorder(new EmptyBorder(5, 5, 5, 5));
		setLayout(new BorderLayout(0, 0));


		//--------------Number Panel-----------------------------------------------
		this.bh = new ButtonHandler();
		this.addKeyListener(bh);
		JPanel NumPadPanel = new JPanel();
		add(NumPadPanel, BorderLayout.CENTER);
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

		//btnBlank = new JButton("");
		//btnBlank.setEnabled(false);
		//NumPadPanel.add(btnBlank);

		btnDigit0 = new JButton("0");
		NumPadPanel.add(btnDigit0);

		//btnDecimal = new JButton("");
		//btnDecimal.setEnabled(false);
		//NumPadPanel.add(btnDecimal);

		btnADD = new JButton("+");
		NumPadPanel.add(btnADD);

		btnSUBTRACT = new JButton("-");
		NumPadPanel.add(btnSUBTRACT);

		btnMULTPLY = new JButton("*");
		NumPadPanel.add(btnMULTPLY);

		//btnDIVIDE = new JButton("");
		//btnDIVIDE.setEnabled(false);
		//NumPadPanel.add(btnDIVIDE);

		btnLeftParen = new JButton("(");
		NumPadPanel.add(btnLeftParen);

		btnRightParen = new JButton(")");
		NumPadPanel.add(btnRightParen);

		btnBackspace = new JButton("Backspace");
		//btnBackspace.setEnabled(false);
		NumPadPanel.add(btnBackspace);
		
		btnClear = new JButton("Clear");
		NumPadPanel.add(btnClear);
		
		btnExecute = new JButton("Execute");
		
		NumPadPanel.add(btnExecute);
		
		Component [] buttons = NumPadPanel.getComponents();
		for(Component c : buttons){
			JButton b = ((JButton)c);
			b.addActionListener(bh);
			b.setBackground(Color.lightGray);
			b.setFont(new Font("Tahoma", Font.PLAIN, 20));
		}
		//--------------Operations Panel-------------------------------------------

		JPanel OperationPanel = new JPanel();
		add(OperationPanel, BorderLayout.SOUTH);

		operatorGroup = new ButtonGroup();
		OperationPanel.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));

		rdbtnSet = new JRadioButton("Set");
		rdbtnSet.setFont(new Font("Tahoma", Font.PLAIN, 20));
		rdbtnSet.setBackground(new Color(51,204,255));
		operatorGroup.add(rdbtnSet);
		rdbtnSet.setSelected(true);
		OperationPanel.add(rdbtnSet);

		rdbtnAdd = new JRadioButton("Add");
		rdbtnAdd.setBackground(new Color(51,204,255));
		rdbtnAdd.setFont(new Font("Tahoma", Font.PLAIN, 20));
		operatorGroup.add(rdbtnAdd);
		OperationPanel.add(rdbtnAdd);

		rdbtnSub = new JRadioButton("Subtract");
		rdbtnSub.setBackground(new Color(51,204,255));
		rdbtnSub.setFont(new Font("Tahoma", Font.PLAIN, 20));
		operatorGroup.add(rdbtnSub);
		OperationPanel.add(rdbtnSub);
		OperationPanel.setBackground(new Color(51,204,255));

		//--------------Data Panel--------------------------------------------------

		JPanel DatafieldPanel = new JPanel();
		DatafieldPanel.setBackground(new Color(51,204,255));
		add(DatafieldPanel, BorderLayout.NORTH);

		incomingData = new JTextField(6);
		incomingData.setBackground(Color.lightGray);
		incomingData.setFont(new Font("Tahoma", Font.PLAIN, 20));
		incomingData.setEditable(false);
		incomingData.setText("0");
		DatafieldPanel.add(incomingData);

		lblOperator = new JLabel("set");
		lblOperator.setFont(new Font("Tahoma", Font.PLAIN, 20));
		DatafieldPanel.add(lblOperator);

		currentExpr = new JTextField(6);
		currentExpr.setBackground(Color.lightGray);

		currentExpr.setFont(new Font("Tahoma", Font.PLAIN, 20));
		currentExpr.setText("");
		currentExpr.setEditable(false);
		DatafieldPanel.add(currentExpr);

		lblEquals = new JLabel("=");
		DatafieldPanel.add(lblEquals);

		result =  new JTextField(6);
		result.setBackground(Color.lightGray);
		result.setFont(new Font("Tahoma", Font.PLAIN, 20));
		result.setEditable(false);
		result.setText("0");
		DatafieldPanel.add(result);

		//pack();
		setVisible(true);

		//------------Action Handlers----------------------------------------------
	}
	private class ButtonHandler implements ActionListener,KeyListener{
		@Override
		public void actionPerformed(ActionEvent ea) {
			if(rdbtnSet.isSelected()){
				
			}
			else if(rdbtnAdd.isSelected()){
				
			}
			else{
				
			}
			JButton buttonPressed = (JButton) ea.getSource();
			if(buttonPressed.getText()=="Clear"){
				currentExpr.setText("");
			}
			else if (buttonPressed.getText()=="Backspace"){
				//Backspacing when it was empty broke it
				try{
					currentExpr.setText(currentExpr.getText().substring(0, currentExpr.getText().length()-1));
				}catch(Exception e){}
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

		@Override
		public void keyTyped(KeyEvent e) {
			System.out.println("Char: " + e.getKeyChar());
			
		}

		@Override
		public void keyPressed(KeyEvent e) {System.out.println("Char: " + e.getKeyChar());}
	
		@Override
		public void keyReleased(KeyEvent e) {System.out.println("Char: " + e.getKeyChar());}
	}
	
	private boolean doMath(){
		String expr = currentExpr.getText();
		try{
			ArrayList<Character> aExpr = new ArrayList<Character>();
			for(int i = 0; i < expr.length(); i++){
				aExpr.add(expr.charAt(i));
			}
			int iResult = math.eval(aExpr);
			//System.out.println("iResult: " + iResult);
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
	

	private static class math{
		private static final String numbers = "1234567890";
		private static final String symbols = "+-*/()";
		
		public static int eval(ArrayList<Character> aExpr) throws NumberFormatException{
			int iResult = 0;
			boolean notDone = true;
			while(notDone){
				//___________________PARENTHESES_____________________
				if(aExpr.indexOf('(') != -1){
					try{
						if(!symbols.contains("" + aExpr.get(aExpr.indexOf('(') -1))){
							aExpr.add(aExpr.indexOf('('), '*');
						}
					}catch(Exception e){}
					int iBegin = aExpr.indexOf('(');
					int iEnd = aExpr.indexOf(')');
					if(iEnd == -1){
						throw new NumberFormatException();
					}
					int iLen = iEnd - iBegin;
					ArrayList<Character> newList = new ArrayList<Character>();
					//Removes '('
					aExpr.remove(iBegin);
					for(int i = 0; i < iLen - 1; i++){
						newList.add(aExpr.remove(iBegin));
					}
					//Removes ')'
					aExpr.remove(iBegin);
					//INSERT SOMEWHERE INTO CURRENT INSTANCE
					//Recursive call
					int iSubResult = math.eval(newList);
					String sResult = "" + (iSubResult);
					//System.out.println(sResult);
					for(int i = sResult.length()-1; i >= 0; i-- ){
						aExpr.add(iBegin, sResult.charAt(i));
					}
				}
				//___________________MULTIPLICATION_____________________
				
				else if(aExpr.indexOf('*') != -1){	
		
					try{
						int iopLocation = (aExpr.indexOf('*'));
						int iStart = iopLocation -1;
						
						//GETS FIRST OPPERANT
						while(true){
							try{
								Integer.parseInt("" + aExpr.get(iStart -1));
								iStart--;
							}catch(Exception e){break;}
						}
						//int iOperand1 = Integer.parseInt(""+(aExpr.remove(iStart)));
						String sOperand1 = "";
						for(int i = 0; i < iopLocation-iStart; i++){
							sOperand1 += aExpr.remove(iStart);
						}
						//System.out.println("op 1 :" + sOperand1);
						int iOperand1 = Integer.parseInt(sOperand1);
						
						//System.out.println("op1: " + iOperand1);
						
						//REMOVES OPERATOR
						aExpr.remove(iStart);
						
						int iEnd = iStart;
						//GETS SECOND OPPERANT
						while(true){
							try{
								Integer.parseInt("" + aExpr.get(iEnd +1));
								iEnd++;
							}catch(Exception e){break;}
						}
						
						String sOperand2 = "";
						for(int i = 0; i <= iEnd-iStart; i++){
							sOperand2 += aExpr.remove(iStart);
						}
						//System.out.println("op 2 :" + sOperand2);
						int iOperand2 = Integer.parseInt(sOperand2);
						
						//int iOperand2 = Integer.parseInt(""+(aExpr.remove(iStart)));
						//System.out.println("op2: " + iOperand2);
						
						
						
						String sResult = "" + (iOperand1 * iOperand2);
						//System.out.println(sResult);
						for(int i = sResult.length() - 1; i >= 0; i-- ){
							//System.out.println("I:" + i + " Char @: "  + sResult.charAt(i));
							aExpr.add(iStart, sResult.charAt(i));
						}
					}catch(NumberFormatException e){
						JOptionPane.showMessageDialog(null, "Invalid Input");
					}
	
				}
				
				
				//___________________ADDITION AND SUBTRACTION_____________________
			
				else if(aExpr.indexOf('+') != -1 || aExpr.indexOf('-') != -1){
					//Addition
					//If + symbol comes before - or if there is a + and no -
					if((aExpr.indexOf('+') != -1 && aExpr.indexOf('+') < aExpr.indexOf('-'))
					   ||(aExpr.indexOf('+') != -1 && aExpr.indexOf('-') == -1)){
						
						try{
							int iopLocation = (aExpr.indexOf('+'));
							int iStart = iopLocation -1;
							
							//GETS FIRST OPPERANT
							while(true){
								try{
									Integer.parseInt("" + aExpr.get(iStart -1));
									iStart--;
								}catch(Exception e){break;}
							}
							//int iOperand1 = Integer.parseInt(""+(aExpr.remove(iStart)));
							String sOperand1 = "";
							for(int i = 0; i < iopLocation-iStart; i++){
								sOperand1 += aExpr.remove(iStart);
							}
							//System.out.println("op 1 :" + sOperand1);
							int iOperand1 = Integer.parseInt(sOperand1);
							
							//System.out.println("op1: " + iOperand1);
							
							//REMOVES OPERATOR
							aExpr.remove(iStart);
							
							int iEnd = iStart;
							//GETS SECOND OPPERANT
							while(true){
								try{
									Integer.parseInt("" + aExpr.get(iEnd +1));
									iEnd++;
								}catch(Exception e){break;}
							}
							
							String sOperand2 = "";
							for(int i = 0; i <= iEnd-iStart; i++){
								sOperand2 += aExpr.remove(iStart);
							}
							//System.out.println("op 2 :" + sOperand2);
							int iOperand2 = Integer.parseInt(sOperand2);							String sResult = "" + (iOperand1 + iOperand2);
							//System.out.println(sResult);
							for(int i = sResult.length() - 1; i >= 0; i-- ){
								aExpr.add(iStart, sResult.charAt(i));
							}
							//System.out.println("A-L len: " + aExpr.size());
						}catch(NumberFormatException e){
							JOptionPane.showMessageDialog(null, "Invalid Input");
						}
						
					}
					//SUB
					else{
						try{
							int iopLocation = (aExpr.indexOf('-'));
							int iStart = iopLocation -1;
							
							//GETS FIRST OPPERANT
							while(true){
								try{
									Integer.parseInt("" + aExpr.get(iStart -1));
									iStart--;
								}catch(Exception e){break;}
							}
							//int iOperand1 = Integer.parseInt(""+(aExpr.remove(iStart)));
							String sOperand1 = "";
							for(int i = 0; i < iopLocation-iStart; i++){
								sOperand1 += aExpr.remove(iStart);
							}
							//System.out.println("op 1 :" + sOperand1);
							int iOperand1 = Integer.parseInt(sOperand1);
							
							//System.out.println("op1: " + iOperand1);
							
							//REMOVES OPERATOR
							aExpr.remove(iStart);
							
							int iEnd = iStart;
							//GETS SECOND OPPERANT
							while(true){
								try{
									Integer.parseInt("" + aExpr.get(iEnd +1));
									iEnd++;
								}catch(Exception e){break;}
							}
							
							String sOperand2 = "";
							for(int i = 0; i <= iEnd-iStart; i++){
								sOperand2 += aExpr.remove(iStart);
							}
							//System.out.println("op 2 :" + sOperand2);
							int iOperand2 = Integer.parseInt(sOperand2);
							String sResult = "" + (iOperand1 - iOperand2);
							//System.out.println(sResult);
							for(int i = sResult.length() - 1; i >= 0; i-- ){
								aExpr.add(iStart, sResult.charAt(i));
							}
							//System.out.println("A-L len: " + aExpr.size());
						}catch(NumberFormatException e){
							JOptionPane.showMessageDialog(null, "Invalid Input");
						}
					}
				}
				else{
					//System.out.println("test3");
					for(char c : aExpr){
						if(math.numbers.indexOf( "" + c) == -1 ){
							//System.out.println("test1");
							throw new NumberFormatException();
						}
						else{
							//System.out.println("test2 :" + c);
							String sResult = "";
							for(int i = 0; i < aExpr.size(); i++){
								sResult += aExpr.get(i);
							}
							iResult = Integer.parseInt(sResult);
						}
					}
					notDone = false;
				}
						
			}
			return iResult;
		}
	}
}
