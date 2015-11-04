/*********************************************************************
 * The parent class for all types of accounts in the package.  It 
 * contains information shared across all accounts: the account
 * number, account owner, date the account was opened, account
 * balance, and the account type.  There is an overridden toString
 * method that customizes the output for the account information.
 ********************************************************************/
package project3;
import java.io.Serializable;
import java.util.Date;
import java.util.GregorianCalendar;

public abstract class Account implements Serializable{
	private static final long serialVersionUID = 1l;
	
	/**The account number*********************************************/
	protected String number;
	
	/**The account owner**********************************************/
	protected String owner;
	
	/**The date the account was opened********************************/
	protected Date dateOpened;
	
	/**The account balance********************************************/
	protected double balance;
	
	/**The type of account opened*************************************/
	protected String acntType;
	
	/*****************************************************************
	 * Default empty constructor 
	 ****************************************************************/
	public Account(){
		
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
	public Date getDateOpened() {
		return dateOpened;
	}

	/*****************************************************************
	 * Setter for the date the account was opened
	 * @param d Date the account was opened
	 ****************************************************************/
	public void setDateOpened(Date d) {
		this.dateOpened = d;
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
	 * Getter that returns the type of account 
	 * @return acntType String that describes if the account is 
	 * checking or savings
	 ****************************************************************/
	public String getAcntType(){
		return acntType;
	}
	
	/*****************************************************************
	 * Method that overrides toString in order to display the account
	 * information in a meaningful manner.
	 * @return String that summarizes the account information
	 ****************************************************************/
	@Override
	public String toString() {
		return "Account [number= " + number + ", owner= " + owner + ", "
				+ "dateOpened= " + dateOpened + ", balance= " + balance
				+ "]" + ";";
	}
}
