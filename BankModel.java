package Project3;

import javax.swing.*;
import javax.swing.table.AbstractTableModel;

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
	
	public void delete(Account a){
		acts.remove(a);
		fireTableRowsDeleted(0, getSize()-1);
	}
	
	public void Update(Account a){
		acts.add(a);
		fireTableRowsUpdated(0, getSize()-1);
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
}
