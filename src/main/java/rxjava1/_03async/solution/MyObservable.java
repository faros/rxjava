package rxjava1._03async.solution;

import java.util.UUID;

import rx.Observable;
import rx.Subscriber;

public class MyObservable {

	public static Observable<String> getFeed() {
		return Observable.create(subscriber -> processRequest(subscriber));
	}

	private static void processRequest(Subscriber<? super String> subscriber) {
		System.out.println("processing ...");
		
		int count = 0;
		while (count++ < 3) {
			subscriber.onNext(createString()+" / subscriber id : "+subscriber.hashCode());

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