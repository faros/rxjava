package rxjava._02.controlling.solution;

import java.util.UUID;

import rx.Observable;
import rx.Subscriber;

public class DataGenerator {

	public static Observable<String> getFeed() {
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