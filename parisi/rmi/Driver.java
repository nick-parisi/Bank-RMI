package parisi.rmi;

import java.net.MalformedURLException;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;


public class Driver {

	public static void main(String[] args) throws MalformedURLException, RemoteException, NotBoundException {
		BankController controller = new BankController();
		BankView view = new BankView(controller);
		controller.join(view);
		

	}

}
