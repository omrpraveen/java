package serializor;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOError;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

public class SerializorEx implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private class StudentDetails {

		/**
		 * 
		 */
		private static final long serialVersionUID = 1L;

		private String name;

		private String age;

		public StudentDetails() {
			this.name = "Kannan";
			this.age = "12";
			System.out.println("Constructor is invoked");
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

	}

	private static final String filename = "/home/praveen/eclipse-workspace/java/src/serializor/file.ser";

	public static void serilzation(Object obj) {
		try {
			FileOutputStream fout = new FileOutputStream(filename);
			ObjectOutputStream out = new ObjectOutputStream(fout);
			out.writeObject(obj);
			out.close();
			out.flush();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static Object deserilization() {
		try {
			FileInputStream fin = new FileInputStream(filename);
			ObjectInputStream in = new ObjectInputStream(fin);
			return in.readObject();
		} catch (ClassNotFoundException | IOException e) {
			e.printStackTrace();
		}
		return null;
	}

	public static void main(String args[]) {
		System.out.println("Serialization Started");
		StudentDetails stud = new SerializorEx().new StudentDetails();
		serilzation(stud);

		System.out.println("Deserialization started");
		StudentDetails studDes = (StudentDetails) deserilization();
		System.out.println(studDes.getName());
		System.out.println(studDes.getAge());

	}

}
