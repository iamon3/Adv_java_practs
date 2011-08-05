package com.threads.withoutSynchronization;

public class AccountDanger implements Runnable {
	private Account acct = new Account();

	public static void main (String [] args) {
		AccountDanger r = new AccountDanger();
		Thread one = new Thread(r);
		Thread two = new Thread(r);
		one.setName("Fred");
		two.setName("Lucy");
		one.start();
		two.start();
	}
	public void run() {
		for (int x = 0; x < 5; x++) {
			makeWithdrawal(10);
			if (acct.getBalance() < 0) {
				System.out.println("account is overdrawn!");
			}
		}
	}
	private synchronized void makeWithdrawal(int amt) {
		if (acct.getBalance() >= amt) {
			System.out.println(Thread.currentThread().getName()
					+ " is going to withdraw &  Balance = "+ acct.getBalance());
			try {
				Thread.sleep(500);
			} catch(InterruptedException ex) { }
			acct.withdraw(amt);
			System.out.println(Thread.currentThread().getName()
					+ " completes the withdrawal &  Balance = "+ acct.getBalance());
		} else {
			System.out.println("Not enough in account for "
					+ Thread.currentThread().getName()
					+ " to withdraw " + acct.getBalance());
		}
	}
}
