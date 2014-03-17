package parisi.rmi;

import java.net.MalformedURLException;
import java.rmi.*;
import java.rmi.registry.*;


public class StartServer {

	public static void main(String[] args) throws RemoteException, MalformedURLException {
		Registry reg = LocateRegistry.createRegistry(1099);
		
		BankService serv = new BankService();
		BankAccount act = new BankAccount();
		
		Naming.rebind("bankservice", serv);
		Naming.rebind("bankaccount", act);

	}

}
