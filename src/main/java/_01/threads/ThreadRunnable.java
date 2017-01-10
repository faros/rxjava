package _01.threads;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ThreadRunnable implements Runnable {

	public static void main(String args[]) throws InterruptedException {
		Thread thread = new Thread(new ThreadRunnable());
		thread.start();

		ExecutorService threadPool = Executors.newFixedThreadPool(5);
		threadPool.execute(new ThreadRunnable());
	}

	@Override
	public void run() {
		System.out.println("Hello i'm in a seperate thread : "+Thread.currentThread().getName());
	}
}