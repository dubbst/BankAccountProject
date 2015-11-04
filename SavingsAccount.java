/**********************************************************************
 * A child class that extends Account.  It adds variables for the 
 * minimum balance and interest rate for the account.  It also 
 * contains an updated toString reflecting this additional information.
 *********************************************************************/
package project3;

import java.util.Date;
import java.util.GregorianCalendar;

public class SavingsAccount extends Account{
	
	private static final long serialVersionUID = 1l;
	
	/**The minimum balance for the savings account********************/ 
	private double minBalance;
	
	/**The intereste rate for the savings account*********************/
	private double interestRate;
	
	/*****************************************************************
	 * Default empty constructor 
	 ****************************************************************/
	public SavingsAccount(){
		
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
	public void setDateOpened(Date d) {
		this.dateOpened = d.getTime();
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
	 * Getter that returns the minimum balance someone can have in
	 * the account
	 * @return minBalance Double that is the lowest amount allowed in 
	 * the savings account
	 ****************************************************************/
	public double getMinBalance() {
		return minBalance;
	}

	/*****************************************************************
	 * Setter that sets the minimum balance for the account
	 * @param minBalance Double that represents the minimum amount
	 * to be in a savings account
	 ****************************************************************/
	public void setMinBalance(double minBalance) {
		this.minBalance = minBalance;
	}

	/*******************************************************************
	 * Getter that returns the interest rate on the account
	 * @return interestRate Double that represents the interest rate
	 * on the account
	 ****************************************************************/
	public double getInterestRate() {
		return interestRate;
	}

	/*****************************************************************
	 * Setter that sets the interest rate for the account
	 * @param interestRate Double that represents the interest rate 
	 * for the account
	 ****************************************************************/
	public void setInterestRate(double interestRate) {
		this.interestRate = interestRate;
	}

	/*****************************************************************
	 * Method that overrides toString in order to display the account
	 * information in a meaningful manner.
	 * @return String that summarizes the account information
	 ****************************************************************/
	@Override
	public String toString() {
		return "Savings Account [Account Number: " + number + "; "
				+ "Account Owner: " + owner + "; Date Opened: " 
				+ dateOpened + "; Balance: " + balance
				+ "; Minimum Balance: " + minBalance + "; "
						+ "Interest Rate: " + interestRate +"]" + 
				"\r\n";
	}
}
