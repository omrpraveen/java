package iterator;

import java.util.ArrayList;

public class ListIterator {

	public static void main(String args[]) {
		ArrayList<Integer> al = new ArrayList<>();
		for (int i = 0; i < 10; i++)
			al.add(i);

		java.util.ListIterator<Integer> ltr = al.listIterator();
		while(ltr.hasNext()) {
			int i = (Integer) ltr.next();
			System.out.println(i);
			if(i%2==0) {
				i++;
				ltr.set(i);
				ltr.add(i);
			}
		}
		
		
		for (Integer integer : al) {
			System.out.println(integer);
		}
	}

}
