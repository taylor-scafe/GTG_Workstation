import java.util.ArrayList;

import javax.swing.JComboBox;
import javax.swing.JOptionPane;
public class GTG_Utility {
final static int maxsizeSize = 4;
final static int maxsizeColor = 20;
private static ArrayList<JComboBox<String>> sizeComboBoxes = new ArrayList<JComboBox<String>>();
private static ArrayList<JComboBox<String>> colorComboBoxes = new ArrayList<JComboBox<String>>();
public static JComboBox<String> jcbSizeTemplate;
public static JComboBox<String> jcbColorTemplate;
public static boolean updateNeeded;
public static ArrayList<String> updateList = new ArrayList<String>();

	
//--------------------  ComboBoxes ---------------------------------------
//--------------------- 3/24/2016 ----------------------------------------
//-------------------- Taylor Scafe --------------------------------------

	public static JComboBox<String> SimpleSQLComboBox(Object[][] resultSet){

		JComboBox<String> returnBox = new JComboBox<String>();
		for(int i=1;i<resultSet.length;i++){
			returnBox.addItem(resultSet[i][0].toString());
		}
		returnBox.setSelectedIndex(0);
		return returnBox;
	}
//---------------------SIZE COMBOBOX--------------------------------------
	
	public static void addSizeComboBox(JComboBox<String> newComboBox){
		if (sizeComboBoxes.size()==0){
			jcbSizeTemplate = newComboBox;
		}
		sizeComboBoxes.add(newComboBox);
	}
	public static void addSize(){
		String strNewSize = (String)JOptionPane.showInputDialog("Enter New Size");
		boolean boolDuplicate = false;
		if(strNewSize != null && !strNewSize.equals("") && strNewSize.length()<=maxsizeSize){
			strNewSize = strNewSize.toUpperCase();
			for(int i=0;i<jcbSizeTemplate.getItemCount();i++){
				if (jcbSizeTemplate.getItemAt(i).toString().equals(strNewSize)){
					boolDuplicate = true;
				}
			}
			if (boolDuplicate){
				JOptionPane.showMessageDialog(null, "Duplacate Entry: Enter a New Unique Size","Input Error", JOptionPane.WARNING_MESSAGE);
				addSize();
			}
			else{
				int doubleCheck = JOptionPane.showConfirmDialog(null, "Confirm New Size: "+strNewSize,"Confirm Entry",JOptionPane.YES_NO_OPTION);
				System.out.println(doubleCheck);
				if (doubleCheck == 0){
					for(JComboBox<String> comboBox:sizeComboBoxes){
						comboBox.addItem(strNewSize);
					}
					updateNeeded = true;
					updateList.add("INSERT INTO Sizes VALUES("+strNewSize+")");
				}
			}
		}
		else if(strNewSize != null && strNewSize.equals("")){
			JOptionPane.showMessageDialog(null, "Blank Entry: Enter a New Unique Size","Input Error", JOptionPane.WARNING_MESSAGE);
			addSize();
		}
		else if (strNewSize != null && strNewSize.length()>maxsizeSize){
			JOptionPane.showMessageDialog(null, "Entry to long: 4 character max \nEnter a New Unique Size","Input Error", JOptionPane.WARNING_MESSAGE);
			addSize();
		}
	}
	
//---------------------COLOR COMBOBOX--------------------------------------	
	
	public static void addColorComboBox(JComboBox<String> newComboBox){
		if (colorComboBoxes.size()==0){
			jcbColorTemplate = newComboBox;
		}
		colorComboBoxes.add(newComboBox);
	}
	public static void addColor(){
		String strNewColor = (String)JOptionPane.showInputDialog("Enter New Color");
		boolean boolDuplicate = false;
		if(strNewColor != null && !strNewColor.equals("") && strNewColor.length()<=maxsizeColor){
			strNewColor = strNewColor.toUpperCase();
			for(int i=0;i<jcbSizeTemplate.getItemCount();i++){
				if (jcbSizeTemplate.getItemAt(i).toString().equals(strNewColor)){
					boolDuplicate = true;
				}
			}
			if (boolDuplicate){
				JOptionPane.showMessageDialog(null, "Duplacate Entry: Enter a New Unique Color","Input Error", JOptionPane.WARNING_MESSAGE);
				addColor();
			}
			else{
				int doubleCheck = JOptionPane.showConfirmDialog(null, "Confirm New Color: "+strNewColor,"Confirm Entry",JOptionPane.YES_NO_OPTION);
				System.out.println(doubleCheck);
				if (doubleCheck == 0){
					for(JComboBox<String> comboBox:sizeComboBoxes){
						comboBox.addItem(strNewColor);
					}
					updateNeeded = true;
					updateList.add("INSERT INTO Colors VALUES("+strNewColor+")");
				}
			}
		}
		else if(strNewColor != null && strNewColor.equals("")){
			JOptionPane.showMessageDialog(null, "Blank Entry: Enter a New Unique Color","Input Error", JOptionPane.WARNING_MESSAGE);
			addColor();
		}
		else if (strNewColor != null && strNewColor.length()>maxsizeColor){
			JOptionPane.showMessageDialog(null, "Entry to long: 20 character max \nEnter a New Unique Color","Input Error", JOptionPane.WARNING_MESSAGE);
			addColor();
		}
	}	
//---------------------END OF COMBOBOXES-----------------------------------	
	
}
