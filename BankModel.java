/**********************************************************************
 * The JTable that handles input from the GUI and controls all banking
 * functions.  
 * 
 * @authors Nathan Henriquez and Tyler Dubbs
 * @version Fall 2015
 *********************************************************************/
package project3;

import javax.swing.*;

import java.io.*;

import javax.swing.table.AbstractTableModel;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

public class BankModel extends AbstractTableModel{
	
	private static final long serialVersionUID = 1L;
	
	/**The ArrayList for the bank accounts.***************************/
	private ArrayList<Account> acts;
	
	/*****************************************************************
	 * Constructor that instantiates the ArrayList for the accounts.
	 ****************************************************************/
	public BankModel(){
		acts = new ArrayList<Account>();
	}
	
	/*****************************************************************
	 * Adds a new account to the JTable.
	 * @param a The account to add.
	 ****************************************************************/
	public void add(Account a){
		acts.add(a);
		fireTableRowsInserted(0, getSize()-1);
	}
	
	/*****************************************************************
	 * Deletes an account from the JTable.
	 * @param index The location of the account to delete
	 ****************************************************************/
	public void delete(int index){
		acts.remove(acts.get(index));
		if(acts.size()>0){
			fireTableRowsDeleted(0, getSize()-1);
		}else{
			fireTableRowsDeleted(0, getSize());
		}
	}
	
	/*****************************************************************
	 * Refreshes the JTable with any new changes
	 ****************************************************************/
	public void update(){
		//acts.add(a);
		fireTableRowsUpdated(0, getSize()-1);
	}
	
	/*****************************************************************
	 * Allows the user to sort the bank accounts alphabetically 
	 * by account owner.
	 ****************************************************************/
	public void sortByName(){
		Collections.sort(acts, new nameComparator());
		this.update();
	}
	
	/*****************************************************************
	 * Allows the user to sort the bank accounts numerically by 
	 * account number.
	 ****************************************************************/
	public void sortByNumber(){
		Collections.sort(acts, new numberComparator());
		this.update();
	}

	/*****************************************************************
	 * Allows the user to sort the bank accounts by the date they
	 * were opened.
	 ****************************************************************/
	public void sortByDate(){
		Collections.sort(acts, new dateComparator());
		this.update();
	}
	
	/*****************************************************************
	 * Getter for the bank accounts.
	 * @return acts The ArrayList of bank accounts.
	 ****************************************************************/
	public ArrayList getActs(){
		return acts;
	}
	
	/*****************************************************************
	 * Getter for the number of columns in the JTable
	 * @return 7 There are only seven columns in the JTable
	 ****************************************************************/
	public int getColumnCount(){
		return 7;
	}
	
	/*****************************************************************
	 * Getter for the number of rows in the JTable.
	 * @return The number of rows, and by extension the number of 
	 * bank accounts, in the JTable.
	 ****************************************************************/
	public int getRowCount(){
		return acts.size();
	}
	
	/*****************************************************************
	 * Getter to find the value at any point on the JTable.
	 * @param int x first number in the array to check
	 * @param int y second number in the array to check
	 * @return array[x][y] A point on the JTable in an account.
	 ****************************************************************/
	public Object getValueAt(int x, int y){
		String[][] array = new String[acts.size()][7];
		for (int i = 0; i < acts.size(); i++) {
		    array[i][0] = acts.get(i).getNumber();
		    array[i][1] = acts.get(i).getOwner();
		    array[i][2] = "" + acts.get(i).getDateOpened();
		    array[i][3] = "" + acts.get(i).getBalance();
		    array[i][4] = " ";
		    array[i][5] = " ";
		    array[i][6] = " ";
		    if(acts.get(i) instanceof CheckingAccount){
		    	CheckingAccount a = new CheckingAccount();
		    	a = (CheckingAccount)acts.get(i);
		    	array[i][4] = "" + a.getMonthlyFee();
		    }
		    if(acts.get(i) instanceof SavingsAccount){
		    	SavingsAccount a = new SavingsAccount();
		    	a = (SavingsAccount)acts.get(i);
		    	array[i][5] = "" + a.getMinBalance();
		    	array[i][6] = "" + a.getInterestRate();
		    }
		}
		return array[x][y];
	}
	
	/*****************************************************************
	 * Getter that determines the column name on the JTable.
	 * @param i integer to determine the column name
	 * @return the name of a column based on integer i
	 ****************************************************************/
	public String getColumnName(int i){
		if(i==0){
			return "Account Name";
		}else if(i==1){
			return "Name";
		}else if(i==2){
			return "Date";
		}else if(i==3){
			return "Balance";
		}else if(i==4){
			return "Monthly Fee";
		}else if(i==5){
			return "Minimum Balance";
		}else{
			return "Interest Rate";
		}
	}
	
	/*****************************************************************
	 * Getter that finds an object in the account ArrayList
	 * @param arg0 integer of an index in the ArrayList
	 * @return An object in the ArrayList
	 ****************************************************************/
	public Object getElementAt(int arg0){
		return acts.get(arg0);
	}
	
	/*****************************************************************
	 * Getter used to determine the size of the ArrayList of accounts
	 * @return length of the ArrayList
	 ****************************************************************/
	public int getSize(){
		return acts.size();
	}
	
	/*****************************************************************
	 * Method that saves the entire ArrayList to a text file.
	 ****************************************************************/
	public void saveToText(){
		String fileName = "bank.txt";
				
		try {
        	
            FileWriter fileWriter =
                new FileWriter(fileName);

            
            PrintWriter PrintWriter =
                new PrintWriter(fileWriter);

            
           // bufferedWriter.write(bankCopy.toString());
            for(int i=0;i<acts.size();i++){
            	PrintWriter.println(acts.get(i).getAcntType());
            	PrintWriter.println(acts.get(i).getNumber());
            	PrintWriter.println(acts.get(i).getOwner());
            	PrintWriter.println(""+acts.get(i).getBalance());
            	PrintWriter.println(""+acts.get(i).getDateOpened());
            	if(acts.get(i) instanceof CheckingAccount){
            		CheckingAccount a = new CheckingAccount();
            		a = (CheckingAccount) acts.get(i);
            		PrintWriter.println(""+a.getMonthlyFee());
            	}else{
            		SavingsAccount b = new SavingsAccount();
            		b = (SavingsAccount) acts.get(i);
            		PrintWriter.println(""+b.getMinBalance());
            		PrintWriter.println(""+b.getInterestRate());
            	}
            }
            
            PrintWriter.close();
        }
        catch(IOException ex) {
            System.out.println(
                "Error writing to file '"
                + fileName + "'");
        }

	}
	
	/*****************************************************************
	 * Method that loads an ArrayList of bank accounts from a text 
	 * file.
	 ****************************************************************/
	public void LoadFromText() {
		String fileName = "bank.txt";
		
        SimpleDateFormat parserSDF=
        		new SimpleDateFormat("EEE MMM d HH:mm:ss zzz yyyy");

        try (BufferedReader br = 
        		new BufferedReader(new FileReader("bank.txt"))) {
            String line;
            ArrayList<String> temp = new ArrayList<String>();
            Account a;
            while ((line = br.readLine()) != null) {
               System.out.println(line);
               temp.add(line);
            }
            br.close();
            System.out.println(temp);
            
        
            
            for(int i=0;i<temp.size();i++){
            	if(temp.get(i).equals("Checking")){
            		a=new CheckingAccount();
            		a.setNumber(temp.get(i+1));
            		a.setOwner(temp.get(i+2));
            		a.setBalance(Double.parseDouble(temp.get(i+3)));
            		try {
						a.setDateOpened(parserSDF.parse(temp.get(i+4)));
					} catch (ParseException e) {
						e.printStackTrace();
					}
            		
            		
            		((CheckingAccount) a).setMonthlyFee(
            				Double.parseDouble(temp.get(i+5)));
            		this.add(a);
            		i+=5;
            		
            	}else if(temp.get(i).equals("Savings")){
            		a=new SavingsAccount();
            		a.setNumber(temp.get(i+1));
            		a.setOwner(temp.get(i+2));
            		a.setBalance(Double.parseDouble(temp.get(i+3)));
            		try {
            		a.setDateOpened(parserSDF.parse(temp.get(i+4)));
            		} catch (ParseException e) {
						e.printStackTrace();
					}
            		((SavingsAccount) a).setMinBalance(
            				Double.parseDouble(temp.get(i+5)));
            		((SavingsAccount) a).setInterestRate(
            				Double.parseDouble(temp.get(i+6)));
            		this.add(a);
            		i+=6;
            	}
        }
            
        }
        
        catch(FileNotFoundException ex) {
            System.out.println(
                "Unable to open file '" + 
                fileName + "'");                
        }
        
        catch(IOException ex) {
            System.out.println(
                "Error reading file '" 
                + fileName + "'");                 
        }
	}

	/*****************************************************************
	 * Method that writes the ArrayList to a serialized file.
	 ****************************************************************/
	public void saveToBinary(){
		try{
			FileOutputStream f_out = 
					new FileOutputStream("binFile.ser");

			ObjectOutputStream obj_out = new
					ObjectOutputStream (f_out);

			for(int i=0;i<acts.size();i++){
				if(acts.get(i) instanceof CheckingAccount){
					obj_out.writeObject (acts.get(i));
				}else if(acts.get(i)instanceof SavingsAccount){
					obj_out.writeObject (acts.get(i));
				}
				}
			f_out.close();
		}
		catch(IOException exception){
			System.out.println("Something went wrong!");
		}
	}

	/*****************************************************************
	 * Method that reads the ArrayList from a serialized file.
	 ****************************************************************/
	public void LoadFromBinary(){

		// Read from disk using FileInputStream
		FileInputStream f_in;
		Object obj;
		try{
			f_in = new FileInputStream("binFile.ser");
			// Read object using ObjectInputStream
			ObjectInputStream obj_in = 
					new ObjectInputStream (f_in);

			// Read an object
			try {
				obj = obj_in.readObject();
			
			if (obj instanceof SavingsAccount){
				SavingsAccount sa = new SavingsAccount();
				sa = (SavingsAccount) obj;
				this.add(sa);
			}
			if(obj instanceof CheckingAccount){
				CheckingAccount ca = new CheckingAccount();
				ca = (CheckingAccount) obj;
				this.add(ca);
			}
			f_in.close();
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
			}
		}
			
		catch(IOException exception){
			System.out.println("What happened?!");
		}

	}
	
	/*****************************************************************
	 * Method that saves the ArrayList to an XML file 
	 ****************************************************************/
	public void SaveToXML(){
		
		String fileName = "bank.xml";
		
		try {
        	
            FileWriter fileWriter =
                new FileWriter(fileName);

            
            PrintWriter PrintWriter =
                new PrintWriter(fileWriter);

            PrintWriter.println("<?xml version=\"1.0\" "
            		+ "standalone=\"yes\"?>");
            
            for(int i=0;i<acts.size();i++){
            	PrintWriter.println("<Account Type>"
            			+acts.get(i).getAcntType()+"</Account Type>");
            	PrintWriter.println("\t"+"<Number>"
            			+acts.get(i).getNumber()+"</Number>");
            	PrintWriter.println("\t"+"<Owner>"
            			+acts.get(i).getOwner()+"</Owner>");
            	PrintWriter.println("\t"+"<Balance>"
            			+acts.get(i).getBalance()+"</Balance>");
            	PrintWriter.println("\t"+"<Date>"
            			+acts.get(i).getDateOpened()+"</Date>");
            	if(acts.get(i) instanceof CheckingAccount){
            		CheckingAccount a = new CheckingAccount();
            		a = (CheckingAccount) acts.get(i);
            		PrintWriter.println("\t"+"<Monthly Fee>"
            				+a.getMonthlyFee()+"</Monthly Fee>");
            	}else{
            		SavingsAccount b = new SavingsAccount();
            		b = (SavingsAccount) acts.get(i);
            		PrintWriter.println("\t"+"<Minimum Balance>"
            				+b.getMinBalance()+"</Minimum Balance>");
            		PrintWriter.println("\t"+"<Interest Rate>"
            				+b.getInterestRate()+"</Interest Rate>");
            	}
            }
            
            PrintWriter.close();
        }
        catch(IOException ex) {
            System.out.println(
                "Error writing to file '"
                + fileName + "'");
        }
	}
	
	/*****************************************************************
	 * Method that loads the ArrayList from an XML file.
	 ****************************************************************/
	public void LoadFromXML(){
		
	}
	
}

/*****************************************************************
 * A class that is used to arrange the accounts in alphabetical
 * order
 * @param s1 the first account to compare
 * @param s2 the second account to compare
 * @return the accounts in alphabetical order
 ****************************************************************/
class nameComparator implements Comparator<Account>{
	public int compare(Account s1, Account s2){
		return s1.getOwner().compareTo(s2.getOwner());
	}
}

/*****************************************************************
 * A class that is used to arrange the accounts in numerical
 * order
 * @param s1 the first account to compare
 * @param s2 the second account to compare
 * @return the accounts in numerical order 
 ****************************************************************/
class numberComparator implements Comparator<Account>{
	public int compare(Account s1, Account s2){
		return s1.getNumber().compareTo(s2.getNumber());
	}
}

/*****************************************************************
 * A class that is used to arrange the accounts in chronological
 * order
 * @param s1 the first account to compare
 * @param s2 the second account to compare
 * @return the accounts in chronological order 
 ****************************************************************/
class dateComparator implements Comparator<Account>{
	public int compare(Account s1, Account s2){
		return s1.getDateOpened().compareTo(s2.getDateOpened());
	}
}
