package rxjava._03.unsubscribing;

import java.util.UUID;

import rx.Observable;
import rx.Subscriber;

public class DataGenerator {

	public static Observable<String> getFeed() {
		return Observable.create(subscriber -> processRequest(subscriber));
	}

	private static void processRequest(Subscriber<? super String> subscriber) {
		System.out.println("processing ...");
		
//		while(!subscriber.isUnsubscribed()) {
		while(true) {
			subscriber.onNext(createString());

			try {
				Thread.sleep(500);
			} catch (InterruptedException e) {
			}
		}
		
	}

	private static String createString() {
		return UUID.randomUUID().toString();
	}
}