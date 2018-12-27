package iterator;

import java.util.ArrayList;
import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class IteratorDemo1 {

	public class Employee {
		
		public Employee(String name,String age) {
			this.name = name;
			this.age = age;
		}

		private String name;

		private String age;

		public String getName() {
			return name;
		}

		public void setName(String name) {
			this.name = name;
		}

		public String getAge() {
			return age;
		}

		public void setAge(String age) {
			this.age = age;
		}

	}

	/**
	 * 
	 * Custom collection for employee
	 *
	 */
	public class Employees implements Iterable {
		List<Employee> list = null;

		public Employees() {
			list = new ArrayList<>();
			list.add(new Employee("Kannan","11"));
			list.add(new Employee("Kannan1","111"));
			list.add(new Employee("Kannan2","111"));
			list.add(new Employee("Kannan3","111"));
		}

		@Override
		public Iterator iterator() {
			return list.iterator();
		}
	}

	public static void main(String args[]) {
		List<String> names = new LinkedList<>();
		names.add("Ram");
		names.add("kumar");
		names.add("kannan");

		for (String string : names) {
			try {
				System.out.println(string);
				// names.add("Test");// it throws on an Exception
				// names.remove("kannan");
			} catch (ConcurrentModificationException e1) {
				e1.printStackTrace();
			}
		}

		Iterator<String> iterator = names.iterator();
		while (iterator.hasNext()) {
			System.out.println(iterator.next());
			iterator.remove();
		}
		System.out.println("After Remove -- " + iterator.hasNext());
		for (String string : names) {
			try {
				System.out.println(string);
				// names.add("Test");// it throws on an Exception
				// names.remove("kannan");
			} catch (ConcurrentModificationException e1) {
				e1.printStackTrace();
			}
		}
		
		
		System.out.println("Custom Collections ");
		IteratorDemo1 iteratorDemo1 = new IteratorDemo1();
		
		Employees emps = iteratorDemo1.new Employees();
		Iterator<Employee> iterator1 = emps.iterator();
		while (iterator1.hasNext()) {
			Employee emp = iterator1.next();
			System.out.println(emp.getName());
			System.out.println(emp.getAge());
		}

	}

}
