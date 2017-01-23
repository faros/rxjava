package rxjava1._02controlling.solution1;

import java.util.UUID;

import rx.Observable;
import rx.Subscriber;

public class MyObservable {


	public static Observable<String> getFeed() {
		/*
		 * TOODO 11 : You can implement asynchronous i/o, computational operations, or even “infinite” streams of data 
		 * by designing your own Observable and implementing it with the create( ) method
		 * 
		 * Create and return an Observable using the create method. The Observable should, when subscribed return 10 String elements 
		 * (hint: use createString() provided). When the stream is done, send the complete signal.
		 */
		return Observable.create(subscriber -> processRequest(subscriber));
	}

	private static void processRequest(Subscriber<? super String> subscriber) {
		System.out.println("processing ...");

		int count = 0;
		while (count++ < 3) {
			subscriber.onNext(createString());

			try {
				Thread.sleep(500);
			} catch (InterruptedException e) {} 
		}

		subscriber.onCompleted();
		subscriber.onNext("next");
	}

	private static String createString() {
		return UUID.randomUUID().toString();
	}
}