/************************************
 * Authors: Nathan and Tyler
 * *********************************/
package Project3;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;

import javax.swing.BoxLayout;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;

import com.toedter.calendar.JCalendar;
import com.toedter.calendar.JDateChooser;
public class BankGUI extends JFrame{
	
	BankModel bank = new BankModel();
	
	JPanel panel;
	private JMenuBar menubar = new JMenuBar();
	
	//JList list;
	JTable table;
	
	private JMenu file = new JMenu("File");
	private JMenu newAccount = new JMenu("New Account");
	private JMenu sortMenu = new JMenu("Sort");
	
	private JMenuItem saveBinary = new JMenuItem("Save Binary");
	private JMenuItem loadBinary = new JMenuItem("Load Binary");
	private JMenuItem saveText = new JMenuItem("Save Text");
	private JMenuItem loadText = new JMenuItem("Load Text");
	
	private JMenuItem checking = new JMenuItem("Checkings");
	private JMenuItem saving = new JMenuItem("Savings");
	
	private JMenuItem nameSort = new JMenuItem("Sort by Name");
	private JMenuItem numberSort = new JMenuItem("Sort by Account");
	private JMenuItem dateSort = new JMenuItem("Sort by Date");
	
	JCalendar calendar;
	
	public BankGUI(){
		
		//calendar = new JCalendar();
		
		//JDateChooser dateChooser=new JDateChooser();
		//dateChooser.setBounds(20, 20, 200, 20);
		//add(dateChooser);
		
		file.add(saveBinary);
		file.add(loadBinary);
		file.add(saveText);
		file.add(loadText);
		
		newAccount.add(checking);
		newAccount.add(saving);
		
		sortMenu.add(nameSort);
		sortMenu.add(numberSort);
		sortMenu.add(dateSort);
		
		menubar.add(file);
		menubar.add(newAccount);
		menubar.add(sortMenu);
		
		file.setMnemonic(KeyEvent.VK_F);
		newAccount.setMnemonic(KeyEvent.VK_F);
		
		saveBinary.addActionListener(new MenuActionListener());
		loadBinary.addActionListener(new MenuActionListener());
		saveText.addActionListener(new MenuActionListener());
		loadText.addActionListener(new MenuActionListener());
		
		checking.addActionListener(new MenuActionListener());
		saving.addActionListener(new MenuActionListener());
		
		nameSort.addActionListener(new MenuActionListener());
		numberSort.addActionListener(new MenuActionListener());
		dateSort.addActionListener(new MenuActionListener());
		
		add(menubar);
		
		//list = new JList(bank.getActs().toArray());
		//list.setModel(bank);
		
		table = new JTable(bank);
		
		//add(new JScrollPane(list));
		
		add(new JScrollPane(table));
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
//			String num =JOptionPane.showInputDialog("Enter Number of Account");
//			a.setNumber(num);
//			String name =JOptionPane.showInputDialog("Enter Name of Account");
//			a.setOwner(name);
//			String year =JOptionPane.showInputDialog("Enter year of Account");
//			int y = Integer.parseInt(year);
//			String month =JOptionPane.showInputDialog("Enter month of Account");
//			int m = Integer.parseInt(month);
//			String day =JOptionPane.showInputDialog("Enter day of Account");
//			int d = Integer.parseInt(day);
//			GregorianCalendar date = new GregorianCalendar(y, m, d);
//			a.setDateOpened(date);
//			String bal =JOptionPane.showInputDialog("Enter Balance of Account");
//			double b = Double.parseDouble(bal);
//			a.setBalance(b);
//			String mFee =JOptionPane.showInputDialog("Enter Monthly Fee of Account");
//			double mf = Double.parseDouble(mFee);
//			a.setMonthlyFee(mf);
//			bank.add(a);
			
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
			//checkingPanel.add(date);
			JDateChooser dateChooser=new JDateChooser();
			dateChooser.setBounds(20, 20, 200, 20);
			checkingPanel.add(dateChooser);
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
				a.setDateOpened(dateChooser.getDate());
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
//			String num =JOptionPane.showInputDialog("Enter Number of Account");
//			a.setNumber(num);
//			String name =JOptionPane.showInputDialog("Enter Name of Account");
//			a.setOwner(name);
//			String year =JOptionPane.showInputDialog("Enter year of Account");
//			int y = Integer.parseInt(year);
//			String month =JOptionPane.showInputDialog("Enter month of Account");
//			int m = Integer.parseInt(month);
//			String day =JOptionPane.showInputDialog("Enter day of Account");
//			int d = Integer.parseInt(day);
//			GregorianCalendar date = new GregorianCalendar(y, m, d);
//			a.setDateOpened(date);
//			String bal =JOptionPane.showInputDialog("Enter Balance of Account");
//			double b = Double.parseDouble(bal);
//			a.setBalance(b);
//			String minBal =JOptionPane.showInputDialog("Enter Minimum Balance of Account");
//			double mb = Double.parseDouble(minBal);
//			a.setMinBalance(mb);
//			String rate =JOptionPane.showInputDialog("Enter Interest Rate of Account");
//			double r = Double.parseDouble(rate);
//			a.setInterestRate(r);
			
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
			//checkingPanel.add(date);
			JDateChooser dateChooser=new JDateChooser();
			dateChooser.setBounds(20, 20, 200, 20);
			checkingPanel.add(dateChooser);
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
				a.setDateOpened(dateChooser.getDate());
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
	    }
	    if(e.getSource() == saveBinary){
	
	    }
	    if(e.getSource() == loadBinary){
	
	    }
	    if(e.getSource() == saveText){
	
	    }
	    if(e.getSource() == loadText){
	
	    }
	    if(e.getSource() == nameSort){
	    	bank.sortByName();
	    }
	    if(e.getSource() == numberSort){
	    	bank.sortByNumber();
	    }
	    if(e.getSource() == dateSort){
	    	bank.sortByDate();
	    }
	  }
}
}
