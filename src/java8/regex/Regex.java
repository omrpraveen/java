package java8.regex;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Regex {

	public static void main(String[] args) {

		while(true) {
			Scanner scanner = new Scanner(System.in);
			System.out.println("%nEnter your regex: ");
			Pattern pattern = Pattern.compile(scanner.nextLine());
			System.out.println("Enter input string to search: ");
			Matcher matcher = pattern.matcher(scanner.nextLine());
			boolean found = false;
			while (matcher.find()) {
				System.out.println(
						String.format("I found the text" + " \"%s\" starting at " + "index %d and ending at index %d.%n",
								matcher.group(), matcher.start(), matcher.end()));
				found = true;
			}
			if (!found) {
				System.out.println(String.format("No match found.%n"));
			}
		}
		

//		Console console = System.console();r
//			
//		
//		
//		if (console == null) {
//			System.err.println("No console.");
//			System.exit(1);
//		}
//		while (true) {
//
//			Pattern pattern = Pattern.compile(console.readLine("%nEnter your regex: "));
//
//			Matcher matcher = pattern.matcher(console.readLine("Enter input string to search: "));
//
//			boolean found = false;
//			while (matcher.find()) {
//				console.format("I found the text" + " \"%s\" starting at " + "index %d and ending at index %d.%n",
//						matcher.group(), matcher.start(), matcher.end());
//				found = true;
//			}
//			if (!found) {
//				console.format("No match found.%n");
//			}
//		}
	}
}