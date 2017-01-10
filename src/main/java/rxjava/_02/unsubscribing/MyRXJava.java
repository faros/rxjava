package rxjava._02.unsubscribing;

import rx.Observable;
import rx.Subscriber;

public class MyRXJava {

	public static void main (String args[]) {
		Observable<String> feed = DataGenerator.getFeed();
		System.out.println("got observable");
		
		feed.subscribe();
	}
}
