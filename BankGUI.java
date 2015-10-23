/************************************
 * Authors: Nathan and Tyler
 * *********************************/
package Project3;
import java.awt.*;
import javax.swing.*;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.util.GregorianCalendar;
public class BankGUI extends JFrame{
	
	BankModel bank = new BankModel();
	
	JPanel panel;
	private JMenuBar menubar = new JMenuBar();
	
	JList list;
	
	private JMenu file = new JMenu("File");
	private JMenu newAccount = new JMenu("New Account");
	
	private JMenuItem saveBinary = new JMenuItem("Save Binary");
	private JMenuItem loadBinary = new JMenuItem("Load Binary");
	private JMenuItem saveText = new JMenuItem("Save Text");
	private JMenuItem loadText = new JMenuItem("Load Text");
	
	private JMenuItem checking = new JMenuItem("Checkings");
	private JMenuItem saving = new JMenuItem("Savings");
	
	public BankGUI(){
		
		file.add(saveBinary);
		file.add(loadBinary);
		file.add(saveText);
		file.add(loadText);
		
		newAccount.add(checking);
		newAccount.add(saving);
		
		menubar.add(file);
		menubar.add(newAccount);
		
		file.setMnemonic(KeyEvent.VK_F);
		newAccount.setMnemonic(KeyEvent.VK_F);
		
		saveBinary.addActionListener(new MenuActionListener());
		loadBinary.addActionListener(new MenuActionListener());
		saveText.addActionListener(new MenuActionListener());
		loadText.addActionListener(new MenuActionListener());
		
		checking.addActionListener(new MenuActionListener());
		saving.addActionListener(new MenuActionListener());
		
		add(menubar);
		
		list = new JList(bank.getActs().toArray());
		list.setModel(bank);
		
		add(new JScrollPane(list));
		setJMenuBar(menubar);
		
		this.setTitle("Bank");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setSize(600, 400);
		this.setVisible(true);
	}


class MenuActionListener implements ActionListener {
	  public void actionPerformed(ActionEvent e) {
	    System.out.println("Selected: " + e.getActionCommand());
	    if(e.getSource() == checking){
	    	CheckingAccount a = new CheckingAccount();
	    	String num =JOptionPane.showInputDialog("Enter Number of Account");
	    	a.setNumber(num);
	    	String name =JOptionPane.showInputDialog("Enter Name of Account");
	    	a.setOwner(name);
	    	String year =JOptionPane.showInputDialog("Enter year of Account");
	    	int y = Integer.parseInt(year);
	    	String month =JOptionPane.showInputDialog("Enter month of Account");
	    	int m = Integer.parseInt(month);
	    	String day =JOptionPane.showInputDialog("Enter day of Account");
	    	int d = Integer.parseInt(day);
	    	GregorianCalendar date = new GregorianCalendar(y, m, d);
	    	a.setDateOpened(date);
	    	String bal =JOptionPane.showInputDialog("Enter Balance of Account");
	    	double b = Double.parseDouble(bal);
	    	a.setBalance(b);
	    	String mFee =JOptionPane.showInputDialog("Enter Monthly Fee of Account");
	    	double mf = Double.parseDouble(mFee);
	    	a.setMonthlyFee(mf);
	    	bank.add(a);
	    }
	    if(e.getSource() == saving){
	    	SavingsAccount a = new SavingsAccount();
	    	String num =JOptionPane.showInputDialog("Enter Number of Account");
	    	a.setNumber(num);
	    	String name =JOptionPane.showInputDialog("Enter Name of Account");
	    	a.setOwner(name);
	    	String year =JOptionPane.showInputDialog("Enter year of Account");
	    	int y = Integer.parseInt(year);
	    	String month =JOptionPane.showInputDialog("Enter month of Account");
	    	int m = Integer.parseInt(month);
	    	String day =JOptionPane.showInputDialog("Enter day of Account");
	    	int d = Integer.parseInt(day);
	    	GregorianCalendar date = new GregorianCalendar(y, m, d);
	    	a.setDateOpened(date);
	    	String bal =JOptionPane.showInputDialog("Enter Balance of Account");
	    	double b = Double.parseDouble(bal);
	    	a.setBalance(b);
	    	String minBal =JOptionPane.showInputDialog("Enter Minimum Balance of Account");
	    	double mb = Double.parseDouble(minBal);
	    	a.setMinBalance(mb);
	    	String rate =JOptionPane.showInputDialog("Enter Interest Rate of Account");
	    	double r = Double.parseDouble(rate);
	    	a.setInterestRate(r);
	    	bank.add(a);
	    }
	    if(e.getSource() == saveBinary){
	
	    }
	    if(e.getSource() == loadBinary){
	
	    }
	    if(e.getSource() == saveText){
	
	    }
	    if(e.getSource() == loadText){
	
	    }
	  }
}
}
