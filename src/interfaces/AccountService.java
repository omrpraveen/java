package interfaces;

@FunctionalInterface
public interface AccountService {

	public double calculateInterest(float a, float b);

	public default double getInterest() {
		return 0.01;
	}

}
