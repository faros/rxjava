package rxjava1._02controlling.solution1;

import java.util.UUID;

import rx.Observable;
import rx.Subscriber;

public class MyObservable {


	public static Observable<String> getFeed() {
		/*
		 * TOODO 11 : In the previous exercise we used one of the Observables convenience methods (just, from) to create an observable.
		 * If you want to have full control, you can also create your own observable using the create() method. 
		 * 
		 * Ex. for asynchronous i/o, computational operations, or even "infinite" streams of data 
		 * 
		 * Create and return an Observable using the Observable's create() method. 
		 * 
		 * The Observable should, when subscribed to, return 10 String elements 
		 * (hint: use createString() provided). When the stream is done, send the complete signal.
		 */
		return Observable.create(subscriber -> processRequest(subscriber));
	}

	private static void processRequest(Subscriber<? super String> subscriber) {
		System.out.println("processing ...");

		int count = 0;
		while (count++ < 10) {
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