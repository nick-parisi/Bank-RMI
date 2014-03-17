package parisi.rmi;

import java.rmi.*;

public interface RemoteAccount extends Remote {
   public void deposit(Double amt) throws RemoteException;
   public void withdraw(Double amt) throws RemoteException;
   public Double getAmt() throws RemoteException;
   public void set(Double amt) throws RemoteException;
}