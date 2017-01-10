package _01.threads;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class ThreadCallable implements Callable<Integer> {

	public static void main(String args[]) throws InterruptedException, ExecutionException {
		ExecutorService threadPool = Executors.newFixedThreadPool(5);
		Future<Integer> future = threadPool.submit(new ThreadCallable());
		
		System.out.println("return value : "+future.get());
	}

	@Override
	public Integer call() throws Exception {
		System.out.println("Hello i'm in a seperate thread : "+Thread.currentThread().getName());
		return 4;
	}
}