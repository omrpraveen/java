package concurrency.threadpkg;

public class ThreadEx1 {

	public class MyThread extends Thread {
		private int counter = 0;

		public void run() {
			counter++;
			System.out.println("My thread => " + counter);
		}
	}

	public class RunnableEx implements Runnable {

		private int counter = 0;
		
		@Override
		public void run() {
			counter++;
			System.out.println("My RunnableEx => " + counter);
			System.out.println(Thread.currentThread().getName());
		}

	}

	public static void main(String args[]) throws InterruptedException {
		/**
		 * each of the threads creates unique object and associate with it.
		 */
		MyThread thread1 = new ThreadEx1().new MyThread();
		thread1.start();

		thread1 = new ThreadEx1().new MyThread();
		thread1.start();

		/**
		 * each of the threads share same objects to the multiple threads.
		 * 
		 * 
		 */
		Runnable r = new ThreadEx1().new RunnableEx();
		/**
		 * r - runable interface
		 * "myThread" is the thread name
		 */
		Thread thread2 = new Thread(r,"myThread");
		thread2.start();
		System.out.println(thread2.getName());

		/**
		 * this method help us to get current thread name
		 */
		System.out.println(Thread.currentThread().getName());
		thread1.sleep(3000L);
		
		thread2 = new Thread(r);
		thread2.start();

		thread2 = new Thread(r);
		thread2.start();

	}

}
