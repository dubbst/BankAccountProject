package Project3;

import java.util.Date;
import java.util.GregorianCalendar;

public class SavingsAccount extends Account{
	private static final long serialVersionUID = 1l;
	private double minBalance;
	private double interestRate;
	
	public SavingsAccount(){
		
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

	public void setDateOpened(GregorianCalendar d) {
		this.dateOpened = d.getTime();
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
	
	public double getMinBalance() {
		return minBalance;
	}

	public void setMinBalance(double minBalance) {
		this.minBalance = minBalance;
	}

	public double getInterestRate() {
		return interestRate;
	}

	public void setInterestRate(double interestRate) {
		this.interestRate = interestRate;
	}

	@Override
	public String toString() {
		return "Account [number=" + number + ", owner=" + owner + ", dateOpened=" + dateOpened + ", balance=" + balance
				+ " " + minBalance + " " + interestRate +"]";
	}
}
