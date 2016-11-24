package rxjava._07.coldversushot;

import rx.Observable;
import rx.schedulers.Schedulers;

public class MyRXJava {

	public static void main (String args[]) throws InterruptedException {
		Observable<String> feed = DataGenerator.getFeed().subscribeOn(Schedulers.io()); //make it async

//		Observable<String> feed = DataGenerator.getFeed().subscribeOn(Schedulers.io()).share(); //hot observable
		
		feed.subscribe(System.out::println);
		Thread.sleep(5000);
		feed.subscribe(System.out::println);
		
		Thread.sleep(30000);
	}

}
