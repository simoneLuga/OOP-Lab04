package it.unibo.oop.lab04.bank2;

public class RestrictedBankAccout extends AbstractBankAccount {

	public RestrictedBankAccout(int usrID, double balance, int nTransactions) {
		super(usrID, balance, nTransactions);
		// TODO Auto-generated constructor stub
	}

	@Override
	protected boolean isWithDrawAllowed(double amount) {
		if(this.getBalance()>=amount) {
			return true;
		}else {
			return false;
		}
	}

	@Override
	protected double computeFee(double amount) {
		final double feeAmount = MANAGEMENT_FEE + (this.getNTransactions() * AbstractBankAccount.TRANSACTION_FEE);
		super.reset();
		return feeAmount;
	}

}
