package java8.functional.interfaces;

public class AccountServiceImpl implements AccountService {

	@Override
	public double calculateInterest(float a, float b) {
		return a * b * 0.1;
	}

}
