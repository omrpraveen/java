package concurrency.threadpkg;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.ThreadPoolExecutor;

public class ExcecutorServiceEx1 {

	public static void main(String args[]) {

		Runnable r = () -> {
			System.out.println("Thread " + Thread.currentThread().getName());
		};
		
		/**
		 *This creates a thread pool with 10 threads executing a tasks.
		 * 
		 */
		ExecutorService ex = Executors.newFixedThreadPool(10);
		for (int i = 0; i < 200; i++) {
			ex.execute(r);
		}
		ex.shutdown();
		
		ex = new ScheduledThreadPoolExecutor(10);
		ex.execute(r);
		for (int i = 0; i < 200; i++) {
			ex.execute(r);
		}
		ex.shutdown();
	}

}
