package project3;
import java.awt.*;

import javax.swing.*;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.util.GregorianCalendar;
import java.util.Scanner;
import java.io.*;

public class BankGUI extends JFrame{

	private static final long serialVersionUID = 1L;

	BankModel bank = new BankModel();

	JPanel panel;
	private JMenuBar menubar = new JMenuBar();

	JList list;

	private JMenu file = new JMenu("File");
	private JMenu newAccount = new JMenu("New Account");
	private JMenu accountOptions = new JMenu("Account Options");

	private JMenuItem saveBinary = new JMenuItem("Save Binary");
	private JMenuItem loadBinary = new JMenuItem("Load Binary");
	private JMenuItem saveText = new JMenuItem("Save Text");
	private JMenuItem loadText = new JMenuItem("Load Text");

	private JMenuItem checking = new JMenuItem("Checking");
	private JMenuItem saving = new JMenuItem("Savings");
	
	private JMenuItem update = new JMenuItem("Update");
	private JMenuItem delete = new JMenuItem("Delete");

	public BankGUI(){

		file.add(saveBinary);
		file.add(loadBinary);
		file.add(saveText);
		file.add(loadText);

		newAccount.add(checking);
		newAccount.add(saving);
		
		accountOptions.add(update);
		accountOptions.add(delete);

		menubar.add(file);
		menubar.add(newAccount);
		menubar.add(accountOptions);

		file.setMnemonic(KeyEvent.VK_F);
		newAccount.setMnemonic(KeyEvent.VK_A);

		saveBinary.addActionListener(new MenuActionListener());
		loadBinary.addActionListener(new MenuActionListener());
		saveText.addActionListener(new MenuActionListener());
		loadText.addActionListener(new MenuActionListener());
		update.addActionListener(new MenuActionListener());
		delete.addActionListener(new MenuActionListener());

		checking.addActionListener(new MenuActionListener());
		saving.addActionListener(new MenuActionListener());
		accountOptions.addActionListener(new MenuActionListener());
		

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
//				String num =JOptionPane.showInputDialog("Enter Number of Account");
//				a.setNumber(num);
//				String name =JOptionPane.showInputDialog("Enter Name of Account");
//				a.setOwner(name);
//				String year =JOptionPane.showInputDialog("Enter year of Account");
//				int y = Integer.parseInt(year);
//				String month =JOptionPane.showInputDialog("Enter month of Account");
//				int m = Integer.parseInt(month);
//				String day =JOptionPane.showInputDialog("Enter day of Account");
//				int d = Integer.parseInt(day);
//				GregorianCalendar date = new GregorianCalendar(y, m, d);
//				a.setDateOpened(date);
//				String bal =JOptionPane.showInputDialog("Enter Balance of Account");
//				double b = Double.parseDouble(bal);
//				a.setBalance(b);
//				String mFee =JOptionPane.showInputDialog("Enter Monthly Fee of Account");
//				double mf = Double.parseDouble(mFee);
//				a.setMonthlyFee(mf);
//				bank.add(a);
				
				JTextField acctNum = new JTextField(10);
				JTextField acctOwner = new JTextField(10);
				JTextField date = new JTextField(10);
				JTextField acctBal = new JTextField(10);
				JTextField fee = new JTextField(10);
				
				JPanel checkingPanel = new JPanel();
				checkingPanel.setLayout(new BoxLayout(checkingPanel, 
						BoxLayout.Y_AXIS));
				checkingPanel.add(new JLabel("Account Number: "));
				checkingPanel.add(acctNum);
				checkingPanel.add(new JLabel("Account Owner: "));
				checkingPanel.add(acctOwner);
				checkingPanel.add(new JLabel("Date Opened: "));
				checkingPanel.add(date);
				checkingPanel.add(new JLabel("Account Balance: "));
				checkingPanel.add(acctBal);
				checkingPanel.add(new JLabel("Monthly Fee: "));
				checkingPanel.add(fee);
				
				int result = JOptionPane.showConfirmDialog(null, 
						checkingPanel, "Enter Checking "
								+ "Account", 
								JOptionPane.OK_CANCEL_OPTION);

				
				if (result == JOptionPane.OK_OPTION) {
					String sAcctNum = acctNum.getText();
					a.setNumber(sAcctNum);
					String sAcctOwner = acctOwner.getText();
					a.setOwner(sAcctOwner);
					//GregorianCalendar date = new GregorianCalendar(y, m, d);
					//a.setDateOpened(date.toString());
					String bal = acctBal.getText();
					double b = Double.parseDouble(bal);
					a.setBalance(b);
					String sFee = fee.getText();
					double f = Double.parseDouble(sFee);
					a.setMonthlyFee(f);
					bank.add(a);
				}
				
			}
			if(e.getSource() == saving){
				SavingsAccount a = new SavingsAccount();
//				String num =JOptionPane.showInputDialog("Enter Number of Account");
//				a.setNumber(num);
//				String name =JOptionPane.showInputDialog("Enter Name of Account");
//				a.setOwner(name);
//				String year =JOptionPane.showInputDialog("Enter year of Account");
//				int y = Integer.parseInt(year);
//				String month =JOptionPane.showInputDialog("Enter month of Account");
//				int m = Integer.parseInt(month);
//				String day =JOptionPane.showInputDialog("Enter day of Account");
//				int d = Integer.parseInt(day);
//				GregorianCalendar date = new GregorianCalendar(y, m, d);
//				a.setDateOpened(date);
//				String bal =JOptionPane.showInputDialog("Enter Balance of Account");
//				double b = Double.parseDouble(bal);
//				a.setBalance(b);
//				String minBal =JOptionPane.showInputDialog("Enter Minimum Balance of Account");
//				double mb = Double.parseDouble(minBal);
//				a.setMinBalance(mb);
//				String rate =JOptionPane.showInputDialog("Enter Interest Rate of Account");
//				double r = Double.parseDouble(rate);
//				a.setInterestRate(r);
				
				JTextField acctNum = new JTextField(10);
				JTextField acctOwner = new JTextField(10);
				JTextField date = new JTextField(10);
				JTextField acctBal = new JTextField(10);
				JTextField minBal = new JTextField(10);
				JTextField intRate = new JTextField(10);
				
				JPanel checkingPanel = new JPanel();
				checkingPanel.setLayout(new BoxLayout(checkingPanel, 
						BoxLayout.Y_AXIS));
				checkingPanel.add(new JLabel("Account Number: "));
				checkingPanel.add(acctNum);
				checkingPanel.add(new JLabel("Account Owner: "));
				checkingPanel.add(acctOwner);
				checkingPanel.add(new JLabel("Date Opened: "));
				checkingPanel.add(date);
				checkingPanel.add(new JLabel("Account Balance: "));
				checkingPanel.add(acctBal);
				checkingPanel.add(new JLabel("Minimum Balance: "));
				checkingPanel.add(minBal);
				checkingPanel.add(new JLabel("Interest Rate: "));
				checkingPanel.add(intRate);
				
				int result = JOptionPane.showConfirmDialog(null, 
						checkingPanel, "Enter Checking "
								+ "Account", 
								JOptionPane.OK_CANCEL_OPTION);

				
				if (result == JOptionPane.OK_OPTION) {
					String sAcctNum = acctNum.getText();
					a.setNumber(sAcctNum);
					String sAcctOwner = acctOwner.getText();
					a.setOwner(sAcctOwner);
					//GregorianCalendar date = new GregorianCalendar(y, m, d);
					//a.setDateOpened(date.toString());
					String bal = acctBal.getText();
					double b = Double.parseDouble(bal);
					a.setBalance(b);
					String sMinBal = minBal.getText();
					double mb = Double.parseDouble(sMinBal);
					a.setMinBalance(mb);
					String sIntRate = intRate.getText();
					double ir = Double.parseDouble(sIntRate);
					a.setInterestRate(ir);
					
				
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
			
			if(e.getSource() == update){
				
			}
			
//			if(e.getSource() == delete){
//				int index = list.getSelectedIndex();
//				list.delete(index);
//				
//			}
		}
	}
	public void saveBinary(){
			
	}
	
	public void saveText(){
		
	}
	
	public void readBinary(){
		
	}
	
	public void readText(){
				
	}
}
}
