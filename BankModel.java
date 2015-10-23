package Project3;

import javax.swing.*;
import java.util.*;

public class BankModel extends AbstractListModel{
	private ArrayList<Account> acts;
	
	public BankModel(){
		acts = new ArrayList<Account>();
	}
	
	public void add(Account a){
		acts.add(a);
		fireIntervalAdded(a, 0, getSize());
	}
	
	public void delete(Account a){
		acts.remove(a);
		fireIntervalRemoved(a, 0, getSize());
	}
	
	public void Update(Account a){
		acts.add(a);
		fireContentsChanged(a, 0, getSize());
	}
	
	public ArrayList getActs(){
			return acts;
	}
	
	public Object getElementAt(int arg0){
		return acts.get(arg0);
	}
	
	public int getSize(){
		return acts.size();
	}
}
