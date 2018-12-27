package concurrency.threadpkg;

public class ThreadEx1 {

	public class MyThread extends Thread {
		public void run() {
			System.out.println("My thread");
		}
	}
	
	public static void main(String args[]) {
		
		MyThread thread1 = new ThreadEx1().new MyThread();
		thread1.start();
		
		System.out.println(thread1.hashCode());
		System.out.println(System.identityHashCode(thread1));

	/*	Thread thread = new Thread() {
			public void run() {
				System.out.println("Thread Running");
			}
		};
		thread.start();*/
		
		Runnable r = () -> {System.out.println("Runable interface");};
	
		System.out.println(System.identityHashCode(r));
		Thread thread2 = new Thread(r);
		thread2.start();
		System.out.println(r.hashCode());
		System.out.println(":"+Integer.toHexString(r.hashCode()));
		
		System.out.print(Runtime.getRuntime());
		
		
		
		thread2 = new Thread(r);
		thread2.start();
		
		thread2 = new Thread(r);
		thread2.start();
		

	}

}
