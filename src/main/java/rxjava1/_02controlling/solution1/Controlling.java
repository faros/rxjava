package rxjava1._02controlling.solution1;

import rx.Observable;

/*
 * TOODO 10 : In this exercise we'll learn to control 
 * 
 */
public class Controlling {

	
	public static void main(String args[]) {
		/*
		 * TOODO 12: get The observable and subscribe to it, you should see the 10 elements coming through (hint: print them out)
		 * Make sure that when when the complete signal is send, you print out "DONE"
		 */
		Observable<String> feed = MyObservable.getFeed();

		feed.subscribe(System.out::println,
						System.out::println,
						() -> System.out.println("done"));

	}
}
