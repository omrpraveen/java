package class_loaders;

import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;

import com.sun.javafx.util.Logging;

public class ClassLoaderEx1 {
	
	
	public void show() {
		System.out.println("show");
	}

	public static void main(String args[])
			throws ClassNotFoundException, InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException, NoSuchMethodException, SecurityException {
		System.out.println("Classloader of this class:" + ClassLoaderEx1.class.getClassLoader());

		System.out.println("Classloader of Logging:" + Logging.class.getClassLoader());

		System.out.println("Classloader of ArrayList:" + ArrayList.class.getClassLoader());

		
		/**
		 * this is an example of custom class loader
		 */
		CustomClassLoader loader = new CustomClassLoader();
		Class<?> c = loader.findClass("class_loaders.ClassLoaderEx1");
		Object ob = c.newInstance();
		c.getMethod("show", null).invoke(ob);
		
		
		try {
			ClassLoader cls = new ClassLoader(ClassLoader.getSystemClassLoader()) {};
			c = cls.loadClass("java.util.ArrayList");
			System.out.println(cls.toString());
			System.out.println(cls.getParent().toString());
			
			
			
		}catch (Exception e) {
			e.printStackTrace();
		}
		
		
		
	}

}
