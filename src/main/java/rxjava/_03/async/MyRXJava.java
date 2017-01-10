package rxjava._03.async;

import rx.Observable;
import rx.schedulers.Schedulers;

public class MyRXJava {

	/*
	 * How many threads?
	 * 	Computation intensive (#threads = # cores)
	 *  IO intensive (#threads > #cores) : depending on blocking percentage
	 */
	public static void main (String args[]) throws InterruptedException {
		Observable<String> feed = DataGenerator.getFeed();
		System.out.println("got observable");
		
		feed.subscribe(System.out::println);

		Thread.sleep(10000); 
	}
}
