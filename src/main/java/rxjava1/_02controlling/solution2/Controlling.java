package rxjava1._02controlling.solution2;

import rx.Observable;
import rx.Subscriber;

/*
 * TOODO 10 : In this exercise we'll learn to control 
 * 
 */
public class Controlling {

	
	public static void main(String args[]) {
	
		Observable<String> feed = MyObservable.getFeed();

		/*
		 * TOODO 13: maybe after a while we're no longer interested in receiving data from our Observable. 
		 * 
		 * Subscribe to the feed (change the Observable to return an endless stream of String elements) and 
		 * randomly unsubscribe from it (hint: Math.random() > 0.85).
		 *  
		 * Make sure the stream doesn't continue to return elements!
		 */
		
		feed.subscribe(new Subscriber<String>() {
			public void onCompleted() {
				System.out.println("DONE");
			};
			public void onError(Throwable t) {
				System.out.println("OEPS : "+ t);
			};
			public void onNext(String arg) {
				System.out.println(arg);
				double random = Math.random();
				if (random > 0.85) {
					System.out.println("unsubscribing");
					unsubscribe();
				}
			};
		});
	}
}
