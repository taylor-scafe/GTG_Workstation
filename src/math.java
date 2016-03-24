import java.util.ArrayList;

public class math{
		private static final String numbers = "1234567890";
		private static final String symbols = "+-*/()";
		
		public static int eval(ArrayList<Character> aExpr) throws NumberFormatException{
			int iResult = 0;
			boolean notDone = true;
			while(notDone){
				//___________________PARENTHESES_____________________
				if(aExpr.indexOf('(') != -1){
					if(!symbols.contains("" + aExpr.get(aExpr.indexOf('(') -1))){
						aExpr.add(aExpr.indexOf('('), '*');
					}
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
					for(int i = sResult.length(); i > 0; i-- ){
						aExpr.add(iBegin, sResult.charAt(i));
					}
				}
				//___________________MULTIPLICATION AND DIVISION_____________________
				else if(aExpr.indexOf('*') != -1 || aExpr.indexOf('/') != -1){
					//MULT
					//If * symbol comes before / or if there is a * and no /
					if((aExpr.indexOf('*') != -1 && aExpr.indexOf('*') < aExpr.indexOf('/'))
					   ||(aExpr.indexOf('*') != -1 && aExpr.indexOf('/') == -1)){
						
						try{
							int iStart = (aExpr.indexOf('*')-1);
							int iOperand1 = Integer.parseInt(""+(aExpr.remove(iStart)));
							//System.out.println("op1: " + iOperand1);
							aExpr.remove(iStart);
							int iOperand2 = Integer.parseInt(""+(aExpr.remove(iStart)));
							//System.out.println("op2: " + iOperand2);
							String sResult = "" + (iOperand1 * iOperand2);
							//System.out.println(sResult);
							for(int i = sResult.length() - 1; i >= 0; i-- ){
								//System.out.println("I:" + i + " Char @: "  + sResult.charAt(i));
								aExpr.add(iStart, sResult.charAt(i));
							}
						}catch(NumberFormatException e){
							System.out.println("Invalid Input");
						}
						
					}
					//DIV
					else{
						try{
							int iStart = (aExpr.indexOf('/')-1);
							int iOperand1 = Integer.parseInt(""+(aExpr.remove(iStart)));
							//System.out.println("op1: " + iOperand1);
							aExpr.remove(iStart);
							int iOperand2 = Integer.parseInt(""+(aExpr.remove(iStart)));
							//System.out.println("op2: " + iOperand2);
							String sResult = "" + (iOperand1 / iOperand2);
							//System.out.println(sResult);
							for(int i = sResult.length() - 1; i >= 0; i-- ){
								//System.out.println("I:" + i + " Char @: "  + sResult.charAt(i));
								aExpr.add(iStart, sResult.charAt(i));
							}
						}catch(NumberFormatException e){
							System.out.println("Invalid Input");
						}
					}
				}
				
				
				//___________________ADDITION AND SUBTRACTION_____________________
			
				else if(aExpr.indexOf('+') != -1 || aExpr.indexOf('-') != -1){
					//Addition
					//If + symbol comes before - or if there is a + and no -
					if((aExpr.indexOf('+') != -1 && aExpr.indexOf('+') < aExpr.indexOf('-'))
					   ||(aExpr.indexOf('+') != -1 && aExpr.indexOf('-') == -1)){
						
						try{
							int iStart = aExpr.indexOf('+')-1;
							//CHANGE TO SUPPORT NON_SINGLE DIGIT NUMBERS!
							int iOperand1 = Integer.parseInt(""+aExpr.remove(iStart));
							aExpr.remove(iStart);
							int iOperand2 = Integer.parseInt(""+aExpr.remove(iStart));
							String sResult = "" + (iOperand1 + iOperand2);
							System.out.println(sResult);
							for(int i = sResult.length() - 1; i >= 0; i-- ){
								aExpr.add(iStart, sResult.charAt(i));
							}
							//System.out.println("A-L len: " + aExpr.size());
						}catch(NumberFormatException e){
							System.out.println("Invalid Input");
						}
						
					}
					//SUB
					else{
						try{
							int iStart = aExpr.indexOf('-')-1;
							//CHANGE TO SUPPORT NON_SINGLE DIGIT NUMBERS!
							int iOperand1 = Integer.parseInt(""+aExpr.remove(iStart));
							aExpr.remove(iStart);
							int iOperand2 = Integer.parseInt(""+aExpr.remove(iStart));
							String sResult = "" + (iOperand1 - iOperand2);
							System.out.println(sResult);
							for(int i = sResult.length() - 1; i >= 0; i-- ){
								aExpr.add(iStart, sResult.charAt(i));
							}
							//System.out.println("A-L len: " + aExpr.size());
						}catch(NumberFormatException e){
							System.out.println("Invalid Input");
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