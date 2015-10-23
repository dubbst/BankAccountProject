package Project3;

import java.util.Date;
import java.util.GregorianCalendar;

public class CheckingAccount extends Account{
	private static final long serialVersionUID = 1l;
	private double monthlyFee;
	
	public CheckingAccount(){
		
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

	public void setDateOpened(GregorianCalendar dateOpened) {
		this.dateOpened = dateOpened.getTime();
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
	
	public double getMonthlyFee() {
		return monthlyFee;
	}

	public void setMonthlyFee(double monthlyFee) {
		this.monthlyFee = monthlyFee;
	}
	
	@Override
	public String toString() {
		return "Account [number=" + number + ", owner=" + owner + ", dateOpened=" + dateOpened + ", balance=" + balance
				+ " " + monthlyFee + " " + "]";
	}
}
