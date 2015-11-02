package Project3;
import java.io.Serializable;
import java.util.Date;
import java.util.GregorianCalendar;

public abstract class Account implements Serializable{
	private static final long serialVersionUID = 1l;
	protected String number;
	protected String owner;
	protected Date dateOpened;
	protected double balance;
	protected String acntType;
	
	public Account(){
		
	}

	public String getNumber() {
		return number;
	}

	public void setNumber(String number) {
		this.number = number;
	}

	public String getOwner() {
		return owner;
	}

	public void setOwner(String owner) {
		this.owner = owner;
	}

	public Date getDateOpened() {
		return dateOpened;
	}

	public void setDateOpened(Date d) {
		this.dateOpened = null;
	}

	public double getBalance() {
		return balance;
	}

	public void setBalance(double balance) {
		this.balance = balance;
	}

	public boolean equals(Account a){
		//put code
		return true;
	}
	
	public String getAcntType(){
		return acntType;
	}
	
	@Override
	public String toString() {
		return "Account [number=" + number + ", owner=" + owner + ", dateOpened=" + dateOpened + ", balance=" + balance
				+ "]";
	}
}
