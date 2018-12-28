package concurrency.threadpkg;

import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.ScheduledThreadPoolExecutor;

public class ExcecutorServiceEx1 {

	public static void main(String args[]) throws InterruptedException, ExecutionException {

		Runnable r = () -> {
			System.out.println("Thread " + Thread.currentThread().getName());
		};

		/**
		 * This creates a thread pool with 10 threads executing a tasks.
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

		/**
		 * Execute Runable
		 * 
		 */
		ex.execute(new Runnable() {
			@Override
			public void run() {
				System.out.println("Asynchronous Task");
			}
		});

		/**
		 * Submit Runable
		 */

		Future<?> future = ex.submit(new Runnable() {
			@Override
			public void run() {
				System.out.println("Trhead Executed");
			}
		});
		System.out.println(future.get());
		System.out.println(future.isDone());
		System.out.println(future.isCancelled());

		ex.shutdown();

		/**
		 * Example of invoke any
		 */

		ExecutorService executorService = Executors.newSingleThreadExecutor();

		Set<Callable<String>> callables = new HashSet<Callable<String>>();

		callables.add(new Callable<String>() {
			public String call() throws Exception {
				return "Task 1";
			}
		});
		callables.add(new Callable<String>() {
			public String call() throws Exception {
				return "Task 2";
			}
		});
		callables.add(new Callable<String>() {
			public String call() throws Exception {
				return "Task 3";
			}
		});

		String result = executorService.invokeAny(callables);

		System.out.println("result = " + result);

		executorService.shutdown();

	}

}
