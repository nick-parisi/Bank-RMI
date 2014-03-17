package parisi.rmi;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;


public class BankAccount extends UnicastRemoteObject implements RemoteAccount {

	private Double sum = 0.0;
	
	protected BankAccount() throws RemoteException {
		super();
	}

	@Override
	public void deposit(Double amt) throws RemoteException {
		sum = sum + amt;
	}

	@Override
	public void withdraw(Double amt) throws RemoteException {
		sum = sum - amt;
	}

	@Override
	public Double getAmt() throws RemoteException {
		return sum;
	}

	@Override
	public void set(Double amt) throws RemoteException {
		sum = amt;
	}

	
	

}
