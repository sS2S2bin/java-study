package prob05;

public class Account {
	private String accountNo;
	private int balance;
	
	public String getAccountNo() {
		return accountNo;
	}

	public void setAccountNo(String accountNo) {
		this.accountNo = accountNo;
	}

	public int getBalance() {
		return balance;
	}

	public void setBalance(int balance) {
		this.balance = balance;
	}
	
	//생성자
	public Account(String accountnum){
		this.accountNo = accountnum;
		System.out.println(accountnum+" 계좌가 생성되었습니다. ");
	}
	public void save(int money) {
		System.out.println(this.accountNo+" 계좌에 "+money+"만원이 입금되었습니다. ");
		this.balance += money;
		
	}
	public void deposit(int money) {
		System.out.println(this.accountNo+" 계좌에 "+money+"만원이 출금되었습니다. ");
		this.balance -= money;
		
	}
}
