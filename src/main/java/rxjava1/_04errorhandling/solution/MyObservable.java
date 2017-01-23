package rxjava1._04errorhandling.solution;

import java.util.UUID;

import rx.Observable;
import rx.Subscriber;

public class MyObservable {

	public static Observable<String> getFeed() {
		return Observable.create(subscriber -> processRequest(subscriber));
	}

	private static void processRequest(Subscriber<? super String> subscriber) {
		System.out.println("processing ...");
		
		while(true) {
			subscriber.onNext(createString());

			try {
				Thread.sleep(500);
			} catch (InterruptedException e) {
			}
		}
	}

	/*
	 * TOODO 31 : some nifty code here ... Want to guess when this goes wrong? 
	 * Hope you have some fine error handling! Continue ...
	 */
	private static String createString() {
		if (Math.random() > 0.85) throw new RuntimeException();
		return UUID.randomUUID().toString();
	}
}