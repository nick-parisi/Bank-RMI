package parisi.rmi;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;


public class BankController {
	
	private RemoteBank bs;
	private RemoteAccount ba;
	private BankView view;
	
	private String current;
	
	public BankController() throws MalformedURLException, RemoteException, NotBoundException {
		bs = (RemoteBank) Naming.lookup("rmi://localhost/bankservice");
		ba = (RemoteAccount) Naming.lookup("rmi://localhost/bankaccount");
	}
	
	public void join(BankView view) {
		this.view = view;
	}
	
	public void newAccount() throws RemoteException {
		String username = view.getUserName();
		bs.newAccount(username);
		current = username;
		ba.set(0.0);
		view.setBalance("");
		view.setAmount("");
	}
	
	public void getAccount() throws RemoteException {
		String username = view.getUserName();
		Double amt = bs.getAccount(username);
		current = username;
		ba.set(amt);
		view.setBalance("");
		view.setAmount("");
	}
	
	public void deposit() throws RemoteException {
		String amount = view.getAmount();
		Double amt = Double.parseDouble(amount);
		ba.deposit(amt);
		bs.update(current, ba.getAmt());
	}
	
	public void withdraw() throws RemoteException {
		String amount = view.getAmount();
		Double amt = Double.parseDouble(amount);
		ba.withdraw(amt);
		bs.update(current, ba.getAmt());
	}
	
	public void showBalance() throws RemoteException {
		String balance = ba.getAmt().toString();
		view.setBalance(balance);
	}

}
