package it.unibo.oop.lab04.bank2;

import it.unibo.oop.lab04.bank.BankAccount;

public abstract class AbstractBankAccount implements BankAccount {
	
	private int usrID;
	private double balance;
	private int NTransactions;
	public static final double TRANSACTION_FEE = 0.1;
	public static final double MANAGEMENT_FEE = 5;
	public static final double ATM_TRANSACTION_FEE = 1;
	
	public AbstractBankAccount(int usrID, double balance, int nTransactions) {
		super();
		this.usrID = usrID;
		this.balance = balance;
		NTransactions = nTransactions;
	}
	
	@Override
	public void computeManagementFees(int usrID) {
		double feeAmout = computeFee(this.balance);
		if(this.usrID==usrID && isWithDrawAllowed(feeAmout)) {
			this.balance-=feeAmout;
		}
	}

	@Override
	public void deposit(int usrID, double amount) {
		if(this.usrID==usrID) {
			this.balance+=amount;
			this.NTransactions++;
		}
	}

	@Override
	public void depositFromATM(int usrID, double amount) {
		this.deposit(usrID, amount-AbstractBankAccount.ATM_TRANSACTION_FEE);
	}

	@Override
	public double getBalance() {
		return this.balance;
	}

	@Override
	public int getNTransactions() {
		return this.NTransactions;
	}

	@Override
	public void withdraw(int usrID, double amount) {
		if(this.usrID==usrID && isWithDrawAllowed(amount)) {
			this.balance-=amount;
			this.NTransactions++;
		}
	}
	
	protected void reset() {
		this.NTransactions=0;
	}

	@Override
	public void withdrawFromATM(int usrID, double amount) {
		this.withdraw(usrID, amount + AbstractBankAccount.ATM_TRANSACTION_FEE);
	}
	
	protected abstract boolean isWithDrawAllowed(double amount);
	
	protected abstract double computeFee(double amount);

}
