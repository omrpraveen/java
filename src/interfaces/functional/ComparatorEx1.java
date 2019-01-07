package interfaces.functional;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class ComparatorEx1 {

	public static class Employee implements Comparable<Employee> {

		private int id;

		private String name;

		private String age;

		public Employee(int id, String name, String age) {
			this.id = id;
			this.name = name;
			this.age = age;
		}

		@Override
		public int compareTo(Employee obj) {
			return this.id - obj.id;
		}

		public int getId() {
			return id;
		}

		public void setId(int id) {
			this.id = id;
		}

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

		@Override
		public String toString() {
			return "[id => " + this.id + "; name => " + this.name + "]";
		}

	}

	public static void main(String args[]) {
		Employee emp1 = new Employee(10, "Praveen", "22");
		Employee emp2 = new Employee(2, "Aravind", "12");
		Employee emp3 = new Employee(12, "Kannan", "11");
		System.out.println(emp1.compareTo(emp2));
		System.out.println(emp2.compareTo(emp3));

		List<Employee> list = new ArrayList<>();
		list.add(emp1);
		list.add(emp2);
		list.add(emp3);
		list.stream().forEach(x -> System.out.println(x.toString()));
		Collections.sort(list);
		list.stream().forEach(x -> System.out.println(x.toString()));

		Comparator<Employee> sortBasedOnAge = new Comparator<ComparatorEx1.Employee>() {

			@Override
			public int compare(Employee arg0, Employee arg1) {
				return Integer.parseInt(arg0.getAge()) - Integer.parseInt(arg1.getAge());
			}
		};
		System.out.println("Age based sorting");
		Collections.sort(list,sortBasedOnAge);
		list.stream().forEach(x -> System.out.println(x.toString()));

		Comparator<Employee> sortBasedOnName = new Comparator<ComparatorEx1.Employee>() {

			@Override
			public int compare(Employee arg0, Employee arg1) {
				return arg0.getName().compareTo(arg1.getName());
			}
		};
		
		System.out.println("Name based sorting");
		Collections.sort(list,sortBasedOnName);
		list.stream().forEach(x -> System.out.println(x.toString()));

		int age = sortBasedOnAge.compare(emp1, emp2);
		System.out.println(age);
		

	}

}
