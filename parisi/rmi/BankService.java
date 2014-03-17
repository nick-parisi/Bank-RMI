package parisi.rmi;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.*;


public class BankService extends UnicastRemoteObject implements RemoteBank {
	
	Map<String, Double> accts = new HashMap<String, Double>();
	
	protected BankService() throws RemoteException {
		super();
	}

	@Override
	public void newAccount(String username) throws RemoteException {
		accts.put(username, 0.0);
		
	}

	@Override
	public Double getAccount(String username) throws RemoteException {
		return accts.get(username);
	}

	@Override
	public void update(String username, Double amt) throws RemoteException {
		accts.put(username, amt);
	}
	
	
	
	

	

}
