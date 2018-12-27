package java8.functional.interfaces;

public class Account {

	private AccountService accountService;

	public AccountService getAccountService() {
		return accountService;
	}

	public void setAccountService(AccountService accountService) {
		this.accountService = accountService;
	}

	public static void main(String args[]) {

		float a = 100f;
		float b = 10f;

		System.out.println(new AccountServiceImpl().calculateInterest(a, b));

		System.out.println(new AccountService() {
			@Override
			public double calculateInterest(float a, float b) {
				return a * b * 0.01;
			}
		}.calculateInterest(a, b));

		Account account = new Account();
		//Lambda expression's parameter a cannot redeclare another local variable defined in an enclosing scope.
		// this one is not allowed
		//account.setAccountService((a, b) -> amount1 * amount2*0.001);
		account.setAccountService((amount1, amount2) -> amount1 * amount2*0.001);
		System.out.println(account.getAccountService().calculateInterest(a, b));

	}

}
