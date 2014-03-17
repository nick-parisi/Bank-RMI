package parisi.rmi;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.rmi.RemoteException;

import javax.swing.*;
import javax.swing.border.TitledBorder;


public class BankView extends JFrame {
	private BankController controller;
	
	private JPanel topPanel;
	private JPanel bottomPanel;
	
	private JLabel nameLabel;
	private JTextField username;
	private JButton newAct;
	private JButton getAct;
	
	private JLabel amountLabel;
	private JTextField amount;
	private JButton deposit;
	private JButton withdraw;
	private JButton show;
	private JTextField balance;
	
	public BankView(BankController control) {
		this.controller = control;
		setLayout(new FlowLayout());
		
		topPanel = new JPanel();
		topPanel.setBorder(new TitledBorder("Select Account"));
		
		nameLabel = new JLabel("UserName");
		username = new JTextField(10);
		newAct = new JButton("New Account");
		newAct.addActionListener(new ActionListener() {
		    public void actionPerformed(ActionEvent e)
		    {
		       try {
				controller.newAccount();
			} catch (RemoteException e1) {
				System.out.println("Something went wrong");
			}
		    }
		});
		getAct = new JButton("Get Account");
		getAct.addActionListener(new ActionListener() {
		    public void actionPerformed(ActionEvent e)
		    {
		       try {
				controller.getAccount();
			} catch (RemoteException e1) {
				System.out.println("Something went wrong");
			}
		    }
		});
		topPanel.add(nameLabel); topPanel.add(username);
		topPanel.add(newAct); topPanel.add(getAct);
		add(topPanel);
		
		bottomPanel = new JPanel();
		bottomPanel.setBorder(new TitledBorder("Access Account"));
		
		amountLabel = new JLabel("Amount");
		amount = new JTextField(10);
		deposit = new JButton("Deposit");
		deposit.addActionListener(new ActionListener() {
		    public void actionPerformed(ActionEvent e)
		    {
		       try {
				controller.deposit();
			} catch (RemoteException e1) {
				System.out.println("Something went wrong");
			}
		    }
		});
		withdraw = new JButton("Withdraw");
		withdraw.addActionListener(new ActionListener() {
		    public void actionPerformed(ActionEvent e)
		    {
		       try {
				controller.withdraw();
			} catch (RemoteException e1) {
				System.out.println("Something went wrong");
			}
		    }
		});
		show = new JButton("Show Balance");
		show.addActionListener(new ActionListener() {
		    public void actionPerformed(ActionEvent e)
		    {
		       try {
				controller.showBalance();
			} catch (RemoteException e1) {
				System.out.println("Something went wrong");
			}
		    }
		});
		balance = new JTextField(10);
		
		bottomPanel.add(amountLabel); bottomPanel.add(amount); bottomPanel.add(deposit);
		bottomPanel.add(withdraw); bottomPanel.add(show); bottomPanel.add(balance);
		
		add(bottomPanel);
		
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setVisible(true);
		
	}
	
	public String getUserName() { return username.getText(); }
	public String getAmount() { return amount.getText(); }
	public void setBalance(String text) { balance.setText(text); }
	public void setAmount(String text) {amount.setText(text); }
	
}
