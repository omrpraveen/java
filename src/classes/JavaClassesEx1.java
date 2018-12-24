package classes;

import java.util.HashMap;
import java.util.Map;

public class JavaClassesEx1 {

	public static class SUCCESS<T> {

		public T t;

		private String status;

		SUCCESS(T t, String status) {
			this.t = t;
			this.status = status;
		}

		public Map<String, Object> build() {
			Map<String, Object> result = new HashMap<String, Object>();
			result.put("status", this.status);
			result.put("result", this.t);
			return result;
		}

		public T getT() {
			return t;
		}

		public void setT(T t) {
			this.t = t;
			System.out.println();
		}

		public String getStatus() {
			return status;
		}

		public void setStatus(String status) {
			this.status = status;
		}

	}

	public class ERROR<T> {

		public T t;

		ERROR(T t) {
			this.t = t;
		}

		public void build() {

		}

		public T getT() {
			return t;
		}

		public void setT(T t) {
			this.t = t;
		}

	}

	public static void main(String args[]) {

		String s = new String("sdfasdfasd");

		SUCCESS<Object> s1 = new SUCCESS<Object>(s,"OK");
		System.out.println(s1.build());

	}

}
