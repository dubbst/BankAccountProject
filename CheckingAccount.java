/**********************************************************************
 * A child class that extends Account.  It adds a variable for the 
 * monthly fee of the account.  It also contains an updated toString 
 * reflecting this additional variable.
 *********************************************************************/
package project3;

import java.util.Date;
import java.util.GregorianCalendar;

public class CheckingAccount extends Account{
	private static final long serialVersionUID = 1l;
	
	/**The monthly fee associated with a checking account************/
	private double monthlyFee;
	
	/*****************************************************************
	 * Default empty constructor 
	 ****************************************************************/
	public CheckingAccount(){
		
	}
	
	/*****************************************************************
	 * Getter used for account number
	 * @return number The account number
	 ****************************************************************/
	public String getNumber() {
		return number;
	}

	/*****************************************************************
	 * Setter used to set the account number
	 * @param number A string representing the account number
	 ****************************************************************/
	public void setNumber(String number) {
		this.number = number;
	}

	/*****************************************************************
	 * Getter for the account owner
	 * @return owner String for the account owner
	 ****************************************************************/
	public String getOwner() {
		return owner;
	}

	/*****************************************************************
	 * Setter for the account owner
	 * @param owner String representing the account owner
	 ****************************************************************/
	public void setOwner(String owner) {
		this.owner = owner;
	}

	/*****************************************************************
	 * Getter for the date the account was opened
	 * @return dateOpened Long representing the date for the account
	 ****************************************************************/
	public long getDateOpened() {
		return dateOpened;
	}

	/*****************************************************************
	 * Setter for the date the account was opened
	 * @param d Date the account was opened
	 ****************************************************************/
	public void setDateOpened(Date date) {
		this.dateOpened = date.getTime();
	}

	/*****************************************************************
	 * Getter for the account balance
	 * @return balance Double representing the balance of the account
	 ****************************************************************/
	public double getBalance() {
		return balance;
	}

	/*****************************************************************
	 * Setter for the balance on the account
	 * @param balance Double to set the account balance equal to
	 ****************************************************************/
	public void setBalance(double balance) {
		this.balance = balance;
	}

	/*****************************************************************
	 * 
	 ****************************************************************/
	public boolean equals(Account a){
		//put code
		return true;
	}
	
	/*****************************************************************
	 * Getter that returns the monthly fee for the checking account
	 * @return monthlyFee Double that is the monthly fee for the
	 * account
	 ****************************************************************/
	public double getMonthlyFee() {
		return monthlyFee;
	}

	/*****************************************************************
	 * Setter for the monthly fee of the checking account
	 * @param monthlyFee Double that the monthly fee is set to
	 ****************************************************************/
	public void setMonthlyFee(double monthlyFee) {
		this.monthlyFee = monthlyFee;
	}
	
	/*****************************************************************
	 * Method that overrides toString in order to display the account
	 * information in a meaningful manner.
	 * @return String that summarizes the account information
	 ****************************************************************/
	@Override
	public String toString() {
		return "Checking Account [Account Number: " + number + "; "
				+ "Account Owner:" + owner + "; Date Opened:" 
				+ dateOpened + "; Balance = " + balance
				+ "; Monthly Fee: " + monthlyFee + "]" +"\r\n";
	}
}
