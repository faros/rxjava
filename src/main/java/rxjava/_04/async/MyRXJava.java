package rxjava._04.async;

import rx.Observable;
import rx.schedulers.Schedulers;

public class MyRXJava {

	/*
	 * How many threads?
	 * 	Computation intensive (#threads = # cores)
	 *  IO intensive (#threads > #cores) : depending on blocking percentage
	 *   
	 */
	public static void main (String args[]) throws InterruptedException {
		Observable<String> feed = DataGenerator.getFeed();
		System.out.println("got observable");
		
		feed.subscribeOn(Schedulers.io()).subscribe(MyRXJava::handle);
//		feed.subscribe(MyRXJava::handle);

		Thread.sleep(10000);
	}

	public static void handle(String s) {
		System.out.println(s+" / thread "+ Thread.currentThread());
	}
	
}
