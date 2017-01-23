package rxjava1._07backpressure.solution;

import java.util.Random;

import rx.Observable;
import rx.Subscriber;

public class MyObservable {

	public static Observable<String> getFeed1() {
		return Observable.create(subscriber -> processFirst(subscriber));
	}
	
	public static Observable<String> getFeed2() {
		return Observable.create(subscriber -> processSecond(subscriber));
	}

	private static void processFirst(Subscriber<? super String> subscriber) {
		int count = 1;

		while(true) {
			subscriber.onNext(""+count++);
//			System.out.println("-obs 1: "+count+" ("+Thread.currentThread());
			try {
				/*
				 * TOODO 63 : until now both Observables generate output every 20 ms, so no backpressure issues.
				 * Now let's make the second Observable a slow producer, change the sleep of this one to 10ms and 
				 * run your code again for a while. What happens? Continue ...
				 */
				Thread.sleep(10); //20
			} catch (InterruptedException e) {
			}
			
		}
	}

	private static void processSecond(Subscriber<? super String> subscriber) {
		String[] alphabet = new String[]{"a", "b", "c", "d", "e", "f", "g", "h", "i", "j", "k", "l", "m", "n", "o", "p", "q", "r", "s", "t", "u", "v", "w", "x", "y", "z"};
		
		while(true) {
			String value = alphabet[new Random().nextInt(alphabet.length)];
			subscriber.onNext(value);
//			System.out.println("-obs 2: "+next+" ("+Thread.currentThread());
			try {

				Thread.sleep(20);
			} catch (InterruptedException e) {
			}
		}
	}

}