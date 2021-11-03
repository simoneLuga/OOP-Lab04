package it.unibo.oop.lab04.bank2;

public class ClassicBankAccount extends AbstractBankAccount {

	public ClassicBankAccount(int usrID, double balance, int nTransactions) {
		super(usrID, balance, nTransactions);
	}

	@Override
	protected boolean isWithDrawAllowed(double amount) {
		return true;
	}

	@Override
	protected double computeFee(double amount) {
		return MANAGEMENT_FEE;
	}

}
