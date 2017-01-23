package rxjava1._01intro;

import java.util.Arrays;
import java.util.List;

/*
 * TODO 1 introduction
 * 
 * To use RxJava you create Observables (which emit data items), transform those Observables in various ways 
 * to get the precise data items that interest you (by using Observable operators), and then observe and react 
 * to these sequences of interesting items (by implementing Observers or Subscribers and then subscribing them 
 * to the resulting transformed Observables).
 */
public class IntroObservable {

	/*
	 * TODO 2 Creating an Observable from Existing Data Structures
	 *
	 * You use the Observable just() and from() methods to convert objects,
	 * lists, or arrays of objects into Observables that emit those objects.
	 */
	public static void main(String args[]) {
		List<String> list = Arrays.asList("a", "b", "c", "d");

		// TODO 3 : create an observable from the list above

		/*
		 * TODO 4 : subscribe to observer you created, printing out all the
		 * items (using method reference : System.out::println)
		 *
		 * These converted Observables will synchronously invoke the onNext()
		 * method of any subscriber that subscribes to them, for each item to be
		 * emitted by the Observable, and will then invoke the subscriber’s
		 * onCompleted( ) method.
		 */

		/*
		 * TODO 5 : If your platform doesn't support Java 8 lambdas, no problem!
		 * RXJava support java 6+ so you can still use inner classes. Subscribe
		 * to your observable using an inner class instead of using a method
		 * reference for printing the elements
		 */
	}
}
