import java.util.ArrayList;

import javax.swing.JOptionPane;

public class math{
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