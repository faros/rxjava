package rxjava1._06coldorhot.solution;

import rx.Observable;
import rx.Subscriber;

public class MyObservable {

	public static Observable<String> getFeed() {
		return Observable.create(subscriber -> processRequest(subscriber));
	}

	private static void processRequest(Subscriber<? super String> subscriber) {
		int count = 0;
		while(true) {
			subscriber.onNext(""+count++);
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
			}
		}
	}
}