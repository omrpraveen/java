package java8;

/**
 * Hello world!
 *
 */
public class App {
	public static void main(String[] args) {
		System.out.println("Hello World!");
		Formula a = new FormulaImpl();
		System.out.print(a.calculate(100));
	}
}
