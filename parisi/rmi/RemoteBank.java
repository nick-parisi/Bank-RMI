package parisi.rmi;

import java.rmi.*;

public interface RemoteBank extends Remote {
   public void newAccount(String username) throws RemoteException;
   public Double getAccount(String username) throws RemoteException;
   public void update(String username, Double amt) throws RemoteException;
}