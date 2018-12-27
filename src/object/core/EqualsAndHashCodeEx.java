package object.core;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

public class EqualsAndHashCodeEx {

	class EmployeeDto {

		public EmployeeDto(int id, String name) {
			this.id = id;
			this.name = name;
		}

		private int id;

		private String name;

		@Override
		public int hashCode() {
			return Objects.hashCode(this.id);
		}

		@Override
		public boolean equals(Object obj) {
			if (this == obj)
				return true;
			else if (obj == null && getClass() != obj.getClass())
				return false;
			EmployeeDto emp = (EmployeeDto) obj;
			if (obj.hashCode() == emp.hashCode()) {
				return id == emp.getId() && name == emp.getName();
			} else
				return false;

		}

		public int getId() {
			return id;
		}

		public String getName() {
			return name;
		}

		public void setId(int id) {
			this.id = id;
		}

		public void setName(String name) {
			this.name = name;
		}

	}

	public static void main(String args[]) {
		EmployeeDto emp = new EqualsAndHashCodeEx().new EmployeeDto(1, "Kannan");
		System.out.println(emp.hashCode());
		EmployeeDto emp1 = new EqualsAndHashCodeEx().new EmployeeDto(1, "Kannan");
		System.out.println(emp1.hashCode());
		EmployeeDto emp2 = new EqualsAndHashCodeEx().new EmployeeDto(2, "Kannan2");
		System.out.println(emp2.hashCode());
		try {
			Set<EmployeeDto> set = new HashSet<>();
			set.add(emp);
			set.add(emp1);
			set.add(emp2);
			System.out.println(set.size());
		} catch (Exception e) {
			e.printStackTrace();
		}

		if (emp.equals(emp1)) {
			System.out.println("Same");
		} else {
			System.out.println("Not Same");
		}

		if (emp.equals(emp2)) {
			System.out.println("Same");
		} else {
			System.out.println("Not Same");
		}
	}

}
