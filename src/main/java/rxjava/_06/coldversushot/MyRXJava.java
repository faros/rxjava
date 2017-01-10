package rxjava._06.coldversushot;

import rx.Observable;
import rx.schedulers.Schedulers;

public class MyRXJava {

	public static void main (String args[]) throws InterruptedException {
		Observable<String> feed = DataGenerator.getFeed().subscribeOn(Schedulers.computation());

		feed.subscribe(System.out::println);
		
		Thread.sleep(30000);
	}
}
