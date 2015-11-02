package Project3;

import javax.swing.*;

import java.io.*;

import javax.swing.table.AbstractTableModel;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

public class BankModel extends AbstractTableModel{
	private ArrayList<Account> acts;
	
	public BankModel(){
		acts = new ArrayList<Account>();
	}
	
	public void add(Account a){
		acts.add(a);
		fireTableRowsInserted(0, getSize()-1);
	}
	
	public void delete(int index){
		acts.remove(acts.get(index));
		if(acts.size()>0){
			fireTableRowsDeleted(0, getSize()-1);
		}else{
			fireTableRowsDeleted(0, getSize());
		}
	}
	
	public void update(){
		//acts.add(a);
		fireTableRowsUpdated(0, getSize()-1);
	}
	
	public void sortByName(){
		Collections.sort(acts, new nameComparator());
		this.update();
	}
	
	public void sortByNumber(){
		Collections.sort(acts, new numberComparator());
		this.update();
	}

	public void sortByDate(){
		Collections.sort(acts, new dateComparator());
		this.update();
	}
	
	public ArrayList getActs(){
		return acts;
	}
	public int getColumnCount(){
		return 7;
	}
	
	public int getRowCount(){
		return acts.size();
	}
	
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
	
	public Object getElementAt(int arg0){
		return acts.get(arg0);
	}
	
	public int getSize(){
		return acts.size();
	}
	
	public void saveToText(){
		String fileName = "bank.txt";
		ArrayList<Account> bankCopy = new ArrayList<Account>();
		bankCopy = acts;
		
		
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
	
	public void LoadFromText() {
		String fileName = "bank.txt";
		
		Account ca = new CheckingAccount();
		Account sa = new SavingsAccount();
        //String line = null;
        ArrayList<String> inActs = 
        		new ArrayList<String>();
        SimpleDateFormat parserSDF=new SimpleDateFormat("EEE MMM d HH:mm:ss zzz yyyy");

//        try {
//            
//            FileReader fileReader = 
//                new FileReader(fileName);
//
//            
//            BufferedReader bufferedReader = 
//                new BufferedReader(fileReader);
//
//            while((line = bufferedReader.readLine())
//            		!= null) {
//                //ca.setNumber(bufferedReader.readLine());
//            	//bank.add(ca);
//            	inActs.add(line);
//            	Iterator<String> it = inActs.iterator();
//            	while(it.hasNext()){
//            		inActs.add(it.next());
//            		System.out.println(inActs);
//            	}
//            }   
//
//            
//            bufferedReader.close();         
//        }
        
        try (BufferedReader br = new BufferedReader(new FileReader("bank.txt"))) {
            String line;
            ArrayList<String> temp = new ArrayList<String>();
            Account a;
            while ((line = br.readLine()) != null) {
               System.out.println(line);
               temp.add(line);
            }
            br.close();
            System.out.println(temp);
            int place=0;
        
            
            for(int i=0;i<temp.size();i++){
            	if(temp.get(i).equals("Checking")){
            		a=new CheckingAccount();
            		a.setNumber(temp.get(i+1));
            		a.setOwner(temp.get(i+2));
            		a.setBalance(Double.parseDouble(temp.get(i+3)));
            		try {
						a.setDateOpened(parserSDF.parse(temp.get(i+4)));
					} catch (ParseException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
            		
            		
            		((CheckingAccount) a).setMonthlyFee(Double.parseDouble(temp.get(i+5)));
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
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
            		((SavingsAccount) a).setMinBalance(Double.parseDouble(temp.get(i+5)));
            		((SavingsAccount) a).setInterestRate(Double.parseDouble(temp.get(i+6)));
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

	public void saveToBinary(){
		try{
			FileOutputStream f_out = 
					new FileOutputStream("binFile.ser");

			// Write object with ObjectOutputStream
			ObjectOutputStream obj_out = new
					ObjectOutputStream (f_out);

			// Write object out to disk
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
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
			
		catch(IOException exception){
			System.out.println("What happened?!");
		}

	}
}

class nameComparator implements Comparator<Account>{
	public int compare(Account s1, Account s2){
		return s1.getOwner().compareTo(s2.getOwner());
	}
}

class numberComparator implements Comparator<Account>{
	public int compare(Account s1, Account s2){
		return s1.getNumber().compareTo(s2.getNumber());
	}
}

class dateComparator implements Comparator<Account>{
	public int compare(Account s1, Account s2){
		return s1.getDateOpened().compareTo(s2.getDateOpened());
	}
}
