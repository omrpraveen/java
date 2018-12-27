package iterator;

import java.util.ArrayList;
import java.util.Spliterator;
import java.util.stream.Stream;

public class SpliteratorEx {

	public static void main(String args[]) {

		ArrayList<Integer> al = new ArrayList<>();
		al.add(1);
		al.add(2);
		al.add(-3);
		al.add(-4);
		al.add(5);

		Stream<Integer> str = al.stream();

		Spliterator<Integer> splitr1 = str.spliterator();

		System.out.println("characteristics : " + splitr1.characteristics());

		System.out.println("estimate size : " + splitr1.estimateSize());

		System.out.println("getExactSizeIfKnown " + splitr1.getExactSizeIfKnown());

		System.out.println("CONCURRENT " + splitr1.hasCharacteristics(Spliterator.CONCURRENT));

		System.out.println("DISTINCT " + splitr1.hasCharacteristics(Spliterator.DISTINCT));

		System.out.println("IMMUTABLE " + splitr1.hasCharacteristics(Spliterator.IMMUTABLE));

		System.out.println("NONNULL " + splitr1.hasCharacteristics(Spliterator.NONNULL));

		System.out.println("ORDERED " + splitr1.hasCharacteristics(Spliterator.ORDERED));

		System.out.println("SIZED " + splitr1.hasCharacteristics(Spliterator.SIZED));

		System.out.println("SORTED " + splitr1.hasCharacteristics(Spliterator.SORTED));

		System.out.println("SUBSIZED " + splitr1.hasCharacteristics(Spliterator.SUBSIZED));

		System.out.println("CONCURRENT " + splitr1.hasCharacteristics(Spliterator.CONCURRENT));

		System.out.println("Content of arraylist :");

		splitr1.forEachRemaining((n) -> System.out.println(n));

		Stream<Integer> str1 = al.stream();

		splitr1 = str1.spliterator();

		Spliterator<Integer> splitr2 = splitr1.trySplit();

		if (splitr2 != null) {
			System.out.println("Output from splitr2: ");
			splitr2.forEachRemaining((n) -> System.out.println(n));
		}

		System.out.println(splitr1.tryAdvance((n) -> System.out.println(n)));

		if (splitr2 != null) {
			System.out.println("Output from splitr2: ");
			splitr2.forEachRemaining((n) -> System.out.println(n));
		}


		// Now, use the splitr
		System.out.println("\nOutput from splitr1: ");
		splitr1.forEachRemaining((n) -> System.out.println(n));

	}
}
